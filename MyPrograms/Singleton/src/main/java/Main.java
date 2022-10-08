import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        EagerInitializedSingleton inst = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton inst1 = EagerInitializedSingleton.getInstance();

        if(inst == inst1){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        LazyInitializedSingleton inst2 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton inst4 = LazyInitializedSingleton.getInstance();

        if(inst2 == inst4){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        ThreadSafeSingleton inst21 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton inst41 = ThreadSafeSingleton.getInstance();

        if(inst21 == inst41){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        StaticInnerClassSingleton inst31 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton inst32 = StaticInnerClassSingleton.getInstance();

        if(inst31 == inst32){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        ThreadSafeSingleton l1 = ThreadSafeSingleton.getInstance();
        //ThreadSafeSingleton l2 = (ThreadSafeSingleton) l1.clone();//exception will be thrown as clone is overridden

        ThreadSafeSingleton reflectionInstance = null;
        Constructor[] constructors = ThreadSafeSingleton.class.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            constructor.setAccessible(true);
            //reflectionInstance = (ThreadSafeSingleton) constructor.newInstance(); //reflection API
        }

        System.out.println(l1.hashCode());
        //System.out.println(reflectionInstance.hashCode());

        //Serialize l1
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        output.writeObject(l1);
        output.close();

        //Deserialize and create new instance
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("singleton.ser"));
        ThreadSafeSingleton desInst = (ThreadSafeSingleton) objectInput.readObject();
        objectInput.close();

        System.out.println(l1.hashCode());
        System.out.println(desInst.hashCode());


    }
}
