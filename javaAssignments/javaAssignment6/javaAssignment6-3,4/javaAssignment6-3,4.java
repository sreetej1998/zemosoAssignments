class B{
    private String name;
    public B(String s){
        this.name=s;
        System.out.println(s);
    }

    public static void main(String args[]){
        //constructers wont be invoked as we are creating an array object not B.
        B b[]= new B[10];
        //constructors are invoked
        for(int i=0;i<10;i++)
            b[i]= new B("constructer invoked");

    }
}