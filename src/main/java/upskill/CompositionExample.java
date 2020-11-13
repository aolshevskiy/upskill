package upskill;

public class CompositionExample {

    interface A {
        void a();
    }

    static class AImpl implements A {

        @Override
        public void a() {
            System.out.println("a");
        }
    }

    interface B {
        void b();
    }

    static class BImpl implements B {

        @Override
        public void b() {
            System.out.println("b");
        }
    }

    static class C implements A, B {
        private final A a;
        private final B b;

        C(A a, B b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public void a() {
            a.a();
        }

        @Override
        public void b() {
            b.b();
        }
    }

    public static void main(String[] args) {
        C c = new C(new AImpl(), new BImpl());

        c.a();
        c.b();
    }
}
