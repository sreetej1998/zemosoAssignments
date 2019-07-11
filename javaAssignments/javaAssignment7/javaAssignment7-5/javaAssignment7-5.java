class A
{
    class B{
        B(String a){
            System.out.print(a);
        }
    }
}

class C{
    public C(String s){
        new D(s);
    }

    class D extends A.B{
        public D(String s){
        new A().super(s);
        }
    }
}

class InnerMain{
    public static void main(String args[]){
            new C("sreetej");
    }
}