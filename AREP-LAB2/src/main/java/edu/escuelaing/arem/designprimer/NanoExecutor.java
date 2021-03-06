package edu.escuelaing.arem.designprimer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class NanoExecutor {
    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Class[] argTypes = new Class[]{String[].class};
            Method main = c.getDeclaredMethod("main", argTypes);
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
            System.out.format("invoking %s.main()%n", c.getName());
            main.invoke(null, (Object) mainArgs);
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException x) {
            x.printStackTrace();
        }
    }
}
