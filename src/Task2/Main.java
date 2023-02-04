package Task2;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String red = (char) 27 + "[31m";
        String black = (char) 27 + "[39m";
        String blue = (char) 27 + "[34m";
        System.out.println("Enter the name of class to see information about it:");
        Scanner scanner = new Scanner(System.in);
        String nameOfClass = scanner.next();
        try {
            Class<?> cl = Class.forName(nameOfClass);
            System.out.println();
            System.out.println(red + "Name of class: " + blue + cl.getName() + black);
            int mod = cl.getModifiers();
            System.out.print(red + "Modifier: " + black + Modifier.toString(mod));
            System.out.println();
            System.out.println();
            System.out.println(red + "Fields: ");
            Field[] fields = cl.getDeclaredFields();
            for(Field field : fields){
                System.out.println(red +"Field name: " + black + field.getName());
                mod = field.getModifiers();
                System.out.println(blue + "\tModifier: " + black + Modifier.toString(mod));
                System.out.println(blue + "\tType: " + black + field.getType());
            }
            System.out.println();
            System.out.println(red + "Constructors: ");
            Constructor[] constructors = cl.getConstructors();
            int i = 0;
            for(Constructor constructor : constructors) {
                System.out.println(red + "Constructor " + (++i) + ": ");
                Class<?>[] paramTypes = constructor.getParameterTypes();
                System.out.print(black + "\t( ");
                for(Class<?> paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.print(")");
                System.out.println();
            }
            System.out.println();
            System.out.println(red + "Methods: ");
            Method[] methods = cl.getMethods();
            for(Method method : methods) {
                System.out.println(red + "\tName of method: " + black + method.getName());
                mod = method.getModifiers();
                System.out.println(blue + "\tModifier: " + black + Modifier.toString(mod));
                System.out.println(blue + "\tType: " + black + method.getGenericReturnType());
                Class<?>[] paramTypes = method.getParameterTypes();
                System.out.print(black + "\t( ");
                for(Class<?> paramType: paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println(")");
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
