import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class baek_2309 {
    public static void main(String[] args) {
        // [참고] 자바로 입력받기 https://cocoon1787.tistory.com/38
        // [참고] 자바 리스트 https://velog.io/@sunnamgung8/%EC%9E%90%EB%B0%94List%EC%BB%AC%EB%A0%89%EC%85%98
        // [참고] 자바 ArrayList 정렬하기 https://hianna.tistory.com/569
        // [참고] 자바 return 과 break 차이  https://kkh0977.tistory.com/626

        // [참고] 백준 자바 제출 방법 https://velog.io/@nowij/%EB%B0%B1%EC%A4%80-%EC%9E%90%EB%B0%94-%EC%A0%9C%EC%B6%9C-%EB%B0%A9%EB%B2%95

        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        int input;

        for (int i = 0; i < 9; i++) {
            input = sc.nextInt();
            nums.add(input);
        }

        int total = 0;
        for (int i : nums) {
            total += i;
        }

        List<Integer> answer = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                sum = total - (nums.get(i) + nums.get(j));
                if (sum == 100) {
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            answer.add(nums.get(k));
                        }
                    }
                    answer.sort(Comparator.naturalOrder());
                    for (int item : answer) {
                        System.out.println(item);
                    }
                    return;
                }
            }
        }
    }
}
