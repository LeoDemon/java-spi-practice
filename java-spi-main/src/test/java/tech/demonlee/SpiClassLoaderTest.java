package tech.demonlee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * @author Demon.Lee
 * @date 2024-03-31 10:34
 */
class SpiClassLoaderTest {

    @Test
    void should_validate_spi_class_loader() {
        Class<java.sql.Driver> javaSqlDriverClass = java.sql.Driver.class;
        ClassLoader driverClassLoader = javaSqlDriverClass.getClassLoader();
        System.out.println("java.sql.Driver class loader is: " + driverClassLoader.getClass().getCanonicalName());

        ServiceLoader<java.sql.Driver> driverServiceLoader = ServiceLoader.load(javaSqlDriverClass);
        Assertions.assertTrue(driverServiceLoader.stream().findAny().isPresent());

        driverServiceLoader.stream().forEach(s -> {
            java.sql.Driver driver = s.get();
            printDriverInfo(driver);

            ClassLoader classLoader = driver.getClass().getClassLoader();
            System.out.println("driver class loader is: " + classLoader.getClass().getCanonicalName());
        });
    }

    private static void printDriverInfo(Driver driver) {
        System.out.println("driver: " + driver.getClass());
        System.out.println("driver.minorVersion: " + driver.getMinorVersion() +
                ", majorVersion: " + driver.getMajorVersion());
    }
}
