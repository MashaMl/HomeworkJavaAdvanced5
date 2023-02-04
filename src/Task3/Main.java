package Task3;

import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Member;

public class Main {
    public static class Ref {
        public int num = 1;
        private final String str = "String";
        protected long l = 6;

        public Ref() {
        }

        public Ref(int num) {
            this.num = num;
        }

        public Ref(int num, String str, long l) {
            this.num = num;
            this.l = l;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getStr() {
            return str;
        }

        public long getL() {
            return l;
        }

        public void setL(long l) {
            this.l = l;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> r = Ref.class;
        printMembers(r.getFields());
        System.out.println();
        printMembers(r.getConstructors());
        System.out.println();
        printMembers(r.getMethods());

    }
    private static void printMembers(Member[] members) {
        for(int i = 0; i < members.length; ++i) {
            if(members[i].getDeclaringClass() == Object.class)
                continue;
            String decl = members[i].toString();
            System.out.println("   ");
            System.out.println(decl);
        }
    }
}
