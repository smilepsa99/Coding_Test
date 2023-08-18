package Level_0;

import java.util.*;

public class prog_02 {
}

// 5. 간단한 식 계산하기
class Solution5_1 {
    public int solution(String binomial) {
        String[] bi = binomial.split(" ");
        int n1 = Integer.parseInt(bi[0]);
        int n2 = Integer.parseInt(bi[2]);

        switch (bi[1]) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            default:
                return n1 * n2;
        }
    }
}

//class Solution5_2 {
//    public int solution(String binomial) {
//        String[] bi = binomial.split(" ");
//        int n1 = Integer.parseInt(bi[0]);
//        int n2 = Integer.parseInt(bi[2]);
//
//        if (bi[1].equals("+")) {
//            return n1 + n2;
//        } else if (bi[1].equals("-")){
//            return n1 - n2;
//        } else {
//            return n1 * n2;
//        }
//    }
//}

// 6. 세 개의 구분자
class Solution6_1 {
    public String[] solution(String myStr) {
        String str = myStr.replaceAll("a", "_")
                .replaceAll("b", "_")
                .replaceAll("c", "_");
        String[] parts = str.split("_");
        int count = 0;
        for (String s : parts) {
            if (s.length() != 0) {
                count++;
            }
        }
        int i = 0;
        String[] answer = new String[count];
        for (String s : parts) {
            if (s.length() != 0) {
                answer[i] = s;
                i++;
            }
        }

        if (i == 0) {
            String[] empty = {"EMPTY"};
            return empty;
        } else {
            return answer;
        }
    }
}

//import java.util.Arrays;
//import java.util.ArrayList;
//
//class Solution6_2 {
//    public String[] solution(String myStr) {
//        String str = myStr.replaceAll("a", "_")
//                .replaceAll("b", "_")
//                .replaceAll("c", "_");
//        String[] parts = str.split("_");
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(parts));
//        list.removeAll(Arrays.asList(""));
//        // [참고] removeAll 함수 https://hianna.tistory.com/564
//        // [참고] 리스트, 배열 변환 https://hianna.tistory.com/551
//        if (list.size() == 0) {
//            String[] empty = {"EMPTY"};
//            return empty;
//        }
//        return list.toArray(new String[0]);
//    }
//}

// 7. 배열의 원소만큼 추가하기
class Solution7_1 {
    public int[] solution(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int[] answer = new int[sum];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                answer[index] = arr[i];
                index++;
            }
        }
        return answer;
    }
}

//import java.util.ArrayList;
//class Solution7_2 {
//    public ArrayList<Integer> solution(int[] arr) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        for (int n : arr) {
//            for (int j = 0; j < n; j++) {
//                answer.add(n);
//            }
//        }
//        return answer;
//    }
//}

// 8. 무작위로 K개의 수 뽑기
// import java.util.Arrays;
class Solution8 {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        // [참고] 배열 한꺼번에 채우기 https://lemonlemon.tistory.com/37
        arr = Arrays.stream(arr).distinct().toArray();
        // [참고] 배열 중복제거 https://adjh54.tistory.com/175
        for (int i = 0 ; i < k; i++) {
            if (i < arr.length) {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}

// 9. 뒤에서 5등까지
//import java.util.Arrays;

class Solution9 {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list); // [참고] 배열 정렬 https://codechacha.com/ko/java-sorting-array/
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = num_list[i];
        }
        return answer;
    }
}

// 10. 홀짝 구분하기
//import java.util.Scanner;
class Solution10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 != 0) {
            System.out.print(n + " is odd");
        } else {
            System.out.print(n + " is even");
        }
    }
}

// 11. a와 b 출력하기
//import java.util.Scanner;
class Solution11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

// 12. n의 배수
class Solution12 {
    public int solution(int num, int n) {
        return (num % n == 0) ? 1 : 0;
    }
}

// 13. flag에 따라 다른 값 반환하기
class Solution13 {
    public int solution(int a, int b, boolean flag) {
        return (flag == true) ? (a + b) : (a - b);
    }
}

// 14. 등차수열의 특정한 항만 더하기
class Solution14_1 {
    public int solution(int a, int d, boolean[] included) {
        int[] nums = new int[included.length];
        nums[0] = a;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + d;
        }
        int answer = 0;
        for (int j = 0; j < included.length; j++) {
            answer += included[j] ? nums[j] : 0;
        }
        return answer;
    }
}

//class Solution14_2 {
//    public int solution(int a, int d, boolean[] included) {
//        int answer = 0;
//        for (int i = 0; i < included.length; i++) {
//            if (included[i]) {
//                answer += a + d * i;
//            }
//        }
//        return answer;
//    }
//}