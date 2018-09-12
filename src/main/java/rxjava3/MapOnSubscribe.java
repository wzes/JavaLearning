package rxjava3;

/**
 * @author Create by xuantang
 * @date on 7/30/18
 */
public class MapOnSubscribe<T, R> implements Observable.OnSubscribe {

    final Observable<T> source;
    final Observable.Transformer<? super T, ? extends R> transformer;


    public MapOnSubscribe(Observable<T> source, Observable.Transformer<? super T, ? extends R> transformer) {
        this.source = source;
        this.transformer = transformer;
    }

    @Override
    public void call(Subscriber subscriber) {
        source.subscribe(new MapSubscriber<R, T>(subscriber, transformer));
    }
}
