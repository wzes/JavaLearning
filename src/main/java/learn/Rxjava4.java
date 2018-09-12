package learn;

/**
 * @author Create by xuantang
 * @date on 8/22/18
 */
public class Rxjava4 {


    class Observable<T> {

        OnSubscribe<T> onSubscribe;

        Observable(OnSubscribe<T> onSubscribe) {
            this.onSubscribe = onSubscribe;
        }

        <T>Observable <T> create(OnSubscribe<T> onSubscribe) {
            return new Observable<T>(onSubscribe);
        }

        void subscribe(Subscriber<T> subscriber) {
            subscriber.onStart();

            onSubscribe.call(subscriber);

            subscriber.onCompleted();
        }
    }

    interface Subscriber<T> {
        void onStart();
        void onNext(T next);
        void onCompleted();
    }

    interface OnSubscribe<T> {
        void call(Subscriber<? super T> subscriber);
    }

    public static void main(String[] args) {
        Rxjava4 rxjava4 = new Rxjava4();
    }
}
