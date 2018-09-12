package learn;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * @author Create by xuantang
 * @date on 7/30/18
 */
public class RxJava {
    long start = System.currentTimeMillis();
    public static void main(String[] args) throws InterruptedException {
        zip();



        Flowable.just("Hello world").subscribe(System.out::println);


        //1、观察者创建一个Observer
        Observer observer = new Observer() {

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(o.toString());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("com");
            }
        };

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("hello");
                e.onNext("world");
                e.onComplete();

            }
        }).map(u ->new URL(u).getHost())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String o) {
                System.out.println(o.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        test();

        Thread.sleep(1000);
    }


    private static void test() {
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observable.create((new ObservableOnSubscribe<String> () {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                System.out.println(Thread.currentThread());
                emitter.onNext("12");
            }
        })).map(Integer::valueOf).map(String::valueOf).map(e -> e + "hello").subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String o) {
                System.out.println(o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        String url = "http://www.baidu.com";
        Observable.fromArray(url)
                .map(u ->new URL(u).getHost())
                .flatMap(new Function<String, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(String s) throws Exception {
                        return null;
                    }
                })
                .map(new Function<Object, String>() {
                    @Override
                    public String apply(Object o) {
                        return null;
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private static void zip() {
        RxJava rxJava = new RxJava();
        rxJava.addItems();
    }
    private void addItems() {
        DisposableObserver disposableObserver = new DisposableObserver<DataObject>() {
            @Override
            public void onNext(@NonNull DataObject object) {
                System.out.println("#####开始#####");
                System.out.println( "数据" + String.valueOf(object.A));
                System.out.println( "数据" + String.valueOf(object.B));
                System.out.println("#####结束#####");
                System.out.println(System.currentTimeMillis() - start);
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.toString() + e);
            }
        };

        mCompositeDisposable.add(
                Observable.zip(getObservableA(null), getObservableB(null),
                        new BiFunction<String, String, DataObject>() {
                            @Override
                            public DataObject apply(String a, String b)
                                    throws Exception {

                                DataObject object = new DataObject();
                                object.A = a;
                                object.B = b;

                                return object;
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .subscribeWith(disposableObserver));
    }


    private Observable<String> getObservableA(@NonNull
                                              final TempObject tempObject) {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return "A";
            }
        });
    }

    private Observable<String> getObservableB(@NonNull
                                              final TempObject tempObject) {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return "B";
            }
        });
    }

    private class DataObject {
        public String A = null;
        public String B = null;
    }

    /**
     * 这是一个废弃无用的数据结构，用以演示如何在请求之间传递参数
     */
    private class TempObject {
        public String temp;
    }
}
