package 기타;

public class test_36 {
    public static void main(String[] args) {
        // 인터페이스에서,
        // 변수를 정의하면, 자동으로 public static final 형태가 됨 (작성 생략가능)
        // 메소드를 정의하면, 자동으로 public abstract 형태가 됨 (작성 생략가능)

    }
}

interface Moveable {
    public abstract int move();
    public abstract int stop();
}

class Ball implements Moveable {
    public int move() {
        System.out.println("공이 움직인다.");
        return 1;
    }
    public int stop() {
        System.out.println("공이 멈춘다.");
        return 1;
    }
}
