package edu.escuelaing.arem.designprimer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import static java.lang.System.out;

public class ReflexionPrimer{
    public static void main (String[] args) throws ClassNotFoundException {
        Class c = Class.forName(args[0]);
        printMembers(c.getFields(), "Fields");
        printMembers(c.getMethods(), "Methods");
        printMembers(c.getConstructors(), "Constructors");
    }

    private static void printMembers(Member[] mbrs, String s) {
        out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field)
                out.format(" %s%n", ((Field) mbr).toGenericString());
            else if (mbr instanceof Constructor)
                out.format(" %s%n", ((Constructor) mbr).toGenericString());
            else if (mbr instanceof Method)
                out.format(" %s%n", ((Method) mbr).toGenericString());
        }
        if (mbrs.length == 0)
            out.format(" -- No %s --%n", s);
        out.format("%n");
    }
}