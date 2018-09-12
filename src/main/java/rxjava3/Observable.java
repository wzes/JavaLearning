package rxjava3;

/**
 * @author Create by xuantang
 * @date on 7/30/18
 */
public class Observable<T> {

    OnSubscribe<T> onSubscribe;
    T[] arr;

    private Observable(OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    private Observable(T... arr) {
        this.arr = arr;
    }

    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable<T>(onSubscribe);
    }

    public static <T> Observable<T> from(T... arr) {
        return new Observable<T>(arr);
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        //subscriber.onStart();
        if (onSubscribe != null) {
            onSubscribe.call(subscriber);
        } else {
            for (T o : arr) {
                subscriber.onNext(o);
            }
        }
        //subscriber.onCompleted();
    }

    public <R> Observable<R> map(Transformer<? super T, ? extends R> transformer) {
        return create(new MapOnSubscribe<T, R>(this, transformer));
    }

//    public <R> Observable<R> map(Transformer<? super T, ? extends R> transformer) {
//        return create(new OnSubscribe<R>() {
//            @Override
//            public void call(Subscriber<? super R> subscriber) {
//                Observable.this.subscribe(new Subscriber<T>() {
//                    @Override
//                    public void onComplete() {
//                        subscriber.onComplete();
//                    }
//
//                    @Override
//                    public void onNext(T object) {
//                        subscriber.onNext(transformer.call(object));
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        subscriber.onError(t);
//                    }
//                });
//            }
//        });
//    }
    public Observable<T> subscribeOn(Scheduler scheduler) {
        return Observable.create(new OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                // subscriber.onStart();
                // 将事件生产切换到新的线程
                scheduler.createWorker().schedule(new Runnable() {
                    @Override
                    public void run() {
                        Observable.this.onSubscribe.call(subscriber);
                    }
                });
            }
        });
    }

    public Observable<T> observeOn(Scheduler scheduler) {
        return Observable.create(new OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                subscriber.onStart();
                Scheduler.Worker worker = scheduler.createWorker();
                Observable.this.onSubscribe.call(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                        worker.schedule(new Runnable() {
                            @Override
                            public void run() {
                                subscriber.onCompleted();
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable t) {
                        worker.schedule(new Runnable() {
                            @Override
                            public void run() {
                                subscriber.onError(t);
                            }
                        });
                    }

                    @Override
                    public void onNext(T var1) {
                        worker.schedule(new Runnable() {
                            @Override
                            public void run() {
                                subscriber.onNext(var1);
                            }
                        });
                    }
                });
            }
        });
    }

    interface Transformer<T, R> {
        R call(T from);
    }

    interface OnSubscribe<T> {
        void call(Subscriber<? super T> subscriber);
    }
}
