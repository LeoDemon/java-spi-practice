package tech.demonlee.greeter.chinese;

import tech.demonlee.greeter.Greeter;

/**
 * @author Demon.Lee
 * @date 2024-03-30 12:18
 */
public class ChineseGreeter implements Greeter {

    @Override
    public void greet(String name) {
        System.out.println("你好，" + name);
    }
}
