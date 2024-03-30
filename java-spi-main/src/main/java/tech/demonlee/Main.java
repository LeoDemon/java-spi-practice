package tech.demonlee;

import tech.demonlee.greeter.Greeter;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        greet();
    }

    private static void greet() {
        ServiceLoader<Greeter> greeterServiceLoader = ServiceLoader.load(Greeter.class);
        for (Greeter greeter : greeterServiceLoader) {
            System.out.println("greeter is: " + greeter.getClass().getCanonicalName());
            greeter.greet("Jack.Ma");
        }
    }
}