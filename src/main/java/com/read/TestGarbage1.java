package com.read;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestGarbage1 {
    @Override
    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String args[]) {
        TestGarbage1 s1 = new TestGarbage1();
        TestGarbage1 s2 = new TestGarbage1();
        s1 = null;
        s2 = null;
        new TestGarbage1();
        TestGarbage1 s3 = new TestGarbage1();
        TestGarbage1 s4 = new TestGarbage1();
        s3 = s4;
        System.gc();
        ArrayList<Long> longs = new ArrayList<>();
        List<String> names = new ArrayList<>();
        names.add("ALI");
        longs.add(1l);
        s3.calculate(longs);
        s3.calculate(names);
        s3.containsAll(names);
        A b = new A();
        List<A> bb = new ArrayList<>();
        bb.add(b);
        s3.calculate2(bb);
    }

    public void calculate(List<?> list) {
        list.forEach(System.out::println);
    }

    public void calculate2(List<? super B> list) {
        System.out.println("calculate2");
    }

    public <T> boolean containsAll(Collection<T> c) {
        System.out.println("executed containsAll");
        return true;
    }

    public static class A {
        public A() {
            System.out.println("THIS IS A");
        }
    }

    public static class B extends A {
        public B() {
            System.out.println("THIS IS B");
        }
    }

    public static class C extends B {
        public C() {
            System.out.println("THIS IS C");
        }
    }

    public static class D extends A {
        public D() {
            System.out.println("THIS IS D");
        }
    }

    public static class F extends C {
        public F() {
            System.out.println("THIS IS F");
        }
    }
}

