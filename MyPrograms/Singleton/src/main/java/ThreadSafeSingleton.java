import java.io.Serializable;

public class ThreadSafeSingleton extends MyClone implements Serializable {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){
        if(instance != null){
            throw new IllegalStateException("Object can't be created using reflection");
        }
    }

    protected Object readResolve(){
        if(instance == null){
            return new ThreadSafeSingleton();
        }else{
            return instance;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static ThreadSafeSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class){
                if(instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }

        }
        return instance;
    }
}
