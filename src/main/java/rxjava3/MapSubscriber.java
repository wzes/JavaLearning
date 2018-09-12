package rxjava3;

/**
 * @author Create by xuantang
 * @date on 7/30/18
 */
public class MapSubscriber<T, R> extends Subscriber<R> {
    final Subscriber<? super T> actual;
    final Observable.Transformer<? super R, ? extends T> transformer;

    public MapSubscriber(Subscriber<? super T> actual, Observable.Transformer<? super R, ? extends T> transformer) {
        this.actual = actual;
        this.transformer = transformer;
    }

    @Override
    public void onCompleted() {
        actual.onCompleted();
    }

    @Override
    public void onNext(R object) {
        actual.onNext(transformer.call(object));
    }

    @Override
    public void onError(Throwable t) {
        actual.onError(t);
    }
}
