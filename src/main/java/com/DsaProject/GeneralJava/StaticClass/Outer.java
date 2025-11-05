package com.DsaProject.GeneralJava.StaticClass;

public class Outer {
private static int outerStatic = 10;
private int outerInstance = 20;

// NON-STATIC INNER CLASS
class Inner {
    static final int CONSTANT = 100;  // OK - compile-time constant
    // static int value = 5;          // ERROR - non-static inner can't have static
    // static void method() {}        // ERROR - no static methods

    void display() {
        System.out.println(outerStatic);   // Access outer static
        System.out.println(outerInstance); // Access outer instance
    }
}

// STATIC NESTED CLASS
static class StaticNested {
    static int staticField = 50;           // OK - all static allowed
    int instanceField = 60;

    static void staticMethod() {           // OK
        System.out.println(outerStatic);   // Access outer static only
        // System.out.println(outerInstance); // ERROR - no outer instance
    }

    void instanceMethod() {
        System.out.println(staticField);
        System.out.println(instanceField);
    }
}
}

// Usage
class Test {
    public static void main(String[] args) {
        // Non-static inner needs outer instance
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        System.out.println(Outer.Inner.CONSTANT); // Static constant access

        // Static nested - independent
        Outer.StaticNested.staticMethod();        // Static method
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.instanceMethod();
    }
}