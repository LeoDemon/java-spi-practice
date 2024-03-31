package tech.demonlee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Demon.Lee
 * @date 2024-03-31 09:19
 */
class ClassLoaderTest {

    /**
     * App ClassLoader
     */
    @Test
    void should_validate_app_class_loader() {
        ClassLoader thisClassLoader = this.getClass().getClassLoader();
        System.out.println("this classLoader.className: " + thisClassLoader.getClass().getCanonicalName());
        Assertions.assertEquals("app", thisClassLoader.getName());
    }

    /**
     * Boot ClassLoader for `java.base`, `java.xml`, etc.
     */
    @Test
    void should_validate_boot_class_loader() {
        String hello = "Hello";
        ClassLoader stringClassLoader = hello.getClass().getClassLoader();
        Assertions.assertNull(stringClassLoader);
        System.out.println("String class loader is: BootClassLoader");

        Class<?> xmlResolverClass = javax.xml.stream.XMLResolver.class;
        Module xmlModule = xmlResolverClass.getModule();
        System.out.println("java.xml module class loader is: " + xmlModule.getClassLoader());
        Assertions.assertNull(xmlResolverClass.getClassLoader());
    }

    /**
     * Platform ClassLoader
     */
    @Test
    void should_validate_platform_class_loader() {
        Class<?> driverClass = java.sql.Driver.class;
        Module module = driverClass.getModule();
        System.out.println("module class loader is: " + module.getClassLoader().getClass().getCanonicalName());
        ClassLoader driverClassLoader = driverClass.getClassLoader();
        System.out.println("java.sql.Driver class loader is: " + driverClassLoader.getClass().getCanonicalName());
        Assertions.assertEquals("platform", driverClassLoader.getName());
    }

    /**
     * Parent ClassLoader
     */
    @Test
    void should_validate_parent_class_loader() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Assertions.assertEquals("app", classLoader.getName());
        ClassLoader parentClassLoader = classLoader.getParent();
        Assertions.assertEquals("platform", parentClassLoader.getName());
        ClassLoader grandpaClassLoader = parentClassLoader.getParent();
        Assertions.assertNull(grandpaClassLoader);
    }
}
