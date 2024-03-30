package tech.demonlee.greeter.english;

import tech.demonlee.greeter.Greeter;

/**
 * @author Demon.Lee
 * @date 2024-03-30 16:05
 */
public class EnglishGreeter implements Greeter {

    @Override
    public void greet(String name) {
        System.out.println("Hi, " + name);
    }
}
