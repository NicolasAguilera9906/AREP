package edu.escuelaing.arem.designprimer;

public class TestingTests {

    @Test
    public static void A(){
        System.out.println("Executing A");
    }

    public static void B(){
        System.out.println("Executing B");
    }

    @Test
    public static void C() throws Exception {
        System.out.println("Executing C");
        throw(new Exception("Mi error"));
    }
}
