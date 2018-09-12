package rxjava3;

/**
 * @author Create by xuantang
 * @date on 7/30/18
 */
public class Rxjava3Test {
    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(10);
            }
        }).map(new Observable.Transformer<Integer, String>() {
            @Override
            public String call(Integer from) {
                return String.valueOf(from);
            }
        }).map(new Observable.Transformer<String, String>() {
            @Override
            public String call(String from) {
                return String.valueOf(from + 10);
            }
        }).map(new Observable.Transformer<String, String>() {
            @Override
            public String call(String from) {
                return String.valueOf(from + 10);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Subscriber<String>() {
            @Override
            public void onStart() {
                System.out.println("onStart called"+ " " + Thread.currentThread());
            }

            @Override
            public void onCompleted() {
                System.out.println("onComplete called"+ " " + Thread.currentThread());
            }

            @Override
            public void onNext(String object) {
                System.out.println(object + " " + Thread.currentThread());
            }

            @Override
            public void onError(Throwable t) {
            }
        });

//        Observable.from(1, 2, 3).map(new Observable.Transformer<Integer, String>() {
//            @Override
//            public String call(Integer from) {
//                return String.valueOf(from);
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onStart() {
//                System.out.println("onStart called");
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("onComplete called");
//            }
//
//            @Override
//            public void onNext(String object) {
//                System.out.println(object);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//            }
//        });
    }
}
