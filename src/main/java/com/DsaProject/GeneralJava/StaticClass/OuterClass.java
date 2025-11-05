package com.DsaProject.GeneralJava.StaticClass;

public class OuterClass {
    private String outerField = "Outer";

    // 1. NON-STATIC INNER CLASS - Needs outer instance
    class InnerClass {
        void display() {
            System.out.println("Accessing: " + outerField); // Can access private
        }
    }

    // 2. STATIC NESTED CLASS - Independent
    static class StaticNested {
        void show() {
            // System.out.println(outerField); // ERROR - no outer instance
            System.out.println("Static nested");
        }
    }

    // 3. LOCAL CLASS - Inside method
    void method() {
        final String localVar = "Local";

        class LocalClass {
            void print() {
                System.out.println(outerField + " " + localVar);
            }
        }

        new LocalClass().print();
    }

    // 4. ANONYMOUS CLASS - No name, one-time use
    Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous: " + outerField);
            }
        };
    }
}

// Usage
class Demo {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        // Inner class requires outer instance
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        // Static nested - no outer instance needed
        OuterClass.StaticNested nested = new OuterClass.StaticNested();
        nested.show();

        // Local and anonymous
        outer.method();
        outer.getRunnable().run();
    }
}