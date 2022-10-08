public class EagerInitializedSingleton {

    private static EagerInitializedSingleton instance ;

    static {
        try{
            instance = new EagerInitializedSingleton();
        }catch (Exception e){
            System.out.println("Exception");
        }
    }

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton() {};

    static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
