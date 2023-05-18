package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    private static final String KEY1 = "clave1";
    private static final String KEY2 = "clave2";
    private static final String KEY3 = "clave3";

    public static void main(final String[] args) {

        callMethodDependingOnKey(KEY1);
    }

    private static void callMethodDependingOnKey(final String key) {
        final HashMap<String, Consumer<List<Object>>> hashMap = new HashMap<>();

        hashMap.put(KEY1, list -> method1((String) list.get(0), (int) list.get(1)));
        hashMap.put(KEY2, list -> method2((String) list.get(0)));
        hashMap.put(KEY3, list -> method3((String) list.get(2), (int) list.get(1)));

        final Consumer<List<Object>> accion = hashMap.get(key);

        final List<Object> listaObjetos = List.of("objeto1", 2, "objeto3");

        if (accion != null) {
            accion.accept(listaObjetos);
        } else {
            System.out.println("Key is not present in the HashMap");
        }
    }

    public static void method1(final String paramA, final int paramB) {
        System.out.println("Method 1 with params: " + paramA + ", " + paramB);
    }

    public static void method2(final String paramA) {
        System.out.println("Method 2 with param: " + paramA);
    }

    public static void method3(final String paramA, final int paramB) {
        System.out.println("Method 3 with params: " + paramA + ", " + paramB);
    }
}
