class A{
    public A(){
        this("Overloaded constructer called from default one");
    }

    public A(String s){
        System.out.println(s);
    }

    public static void main(String args[]){
        new A();
    }

}