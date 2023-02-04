package Task4;

import java.lang.reflect.Field;

public class Main {
    public static class Cat {
        public int age = 2;
        protected String name = "Marcel";
        private boolean fluffyTail = true;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isFluffyTail() {
            return fluffyTail;
        }

        public void setFluffyTail(boolean fluffyTail) {
            this.fluffyTail = fluffyTail;
        }


    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Class<?> cl = Cat.class;
        Cat cat = new Cat();
        System.out.println("Cat " + cat.getName() + " is " + cat.getAge() + " years old and " + (((cat.isFluffyTail()) ? "has fluffy tail" : "doesn't have fluffy tail")));
        Field field1 = cl.getDeclaredField("age");
        Field field2 = cl.getDeclaredField("name");
        Field field3 = cl.getDeclaredField("fluffyTail");
        field1.setAccessible(true);
        field2.setAccessible(true);
        field3.setAccessible(true);
        field1.set(cat, 4);
        field2.set(cat, "Tom");
        field3.set(cat, false);
        System.out.println("Cat " + cat.getName() + " is " + cat.getAge() + " years old and " + (((cat.isFluffyTail()) ? "has fluffy tail" : "doesn't have fluffy tail")));


    }
}
