package upskill;

public class CompositionExample {

    static class A {

    }

    static class B extends A {

    }

    static class C {
        void m(A a) {
            System.out.println("a");
        }
        void m(B b) {
            System.out.println("b");
        }
    }

    static class D extends C {
        void m(A a) {
            System.out.println("da");
        }
        void m(B a) {
            System.out.println("db");
        }
    }

    public static void main(String[] args) {
        C c = new C();
        C d = new D();

        B b = new B();
        A a = b;

        c.m(a);
        c.m(b);
        d.m(a);
        d.m(b);
    }
}
