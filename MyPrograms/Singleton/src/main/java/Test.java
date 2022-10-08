class Test {
     protected int x = 10;
}

class Test1 extends Test{
    void print(){
        System.out.println(x);
    }
}

class Driver{
    public static void main(String[] args) {
        Test1 t = new Test1();
        t.print();
    }
}
