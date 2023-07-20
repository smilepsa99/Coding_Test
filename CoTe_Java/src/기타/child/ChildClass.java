package 기타.child;

import 기타.parent.ParentClass;

public class ChildClass extends ParentClass{
    void parentName() {
        System.out.println(name);
    }
    protected void method() {
        System.out.println("자식클래스 메소드");
    }

    void a() {
        super.method();
        this.method();
    }
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
        c.method();
        c.a();
    }
}