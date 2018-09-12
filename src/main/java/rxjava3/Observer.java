package rxjava3;

/**
 * @author Create by xuantang
 * @date on 7/30/18
 */
public interface Observer<T> {
    void onCompleted();
    void onNext(T object);
    void onError(Throwable t);
}
