package 완전탐색;

import java.util.Arrays;

public class prog_최소직사각형 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] size1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] size2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] size3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        int solution1 = solution.solution(size1);
        int solution2 = solution.solution(size2);
        int solution3 = solution.solution(size3);

        System.out.println(solution1);
        System.out.println(solution2);
        System.out.println(solution3);
    }
}

// 1 오답
//class Solution {
//    public int solution(int[][] sizes) {
//        int[] arr = new int[sizes.length * 2];
//        for (int i = 0; i < sizes.length; i++) {
//            for (int j = 0; j < 2; j++) {
//                arr[2 * i + j] = sizes[i][j];
//            }
//        }
//        Arrays.sort(arr);
//        int answer = arr[arr.length/2 - 1] * arr[arr.length-1];
//        return answer;
//    }
//}

// 2 정답
class Solution {
    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            swap(sizes[i]);
        }

        int max_w = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (max_w < sizes[i][0]) {
                max_w = sizes[i][0];
            }
        }

        int max_h = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (max_h < sizes[i][1]) {
                max_h = sizes[i][1];
            }
        }

        int answer = max_w * max_h;
        return answer;
    }

    public void swap(int[] a) {
        if (a[0] > a[1]) {
            int temp = a[0];
            a[0] = a[1];
            a[1] = temp;
        }
    }
}

// + 다른사람 풀이 (모범답안)
// https://school.programmers.co.kr/learn/courses/30/lessons/86491/solution_groups?language=java&type=all
//class Solution {
//    public int solution(int[][] sizes) {
//        int width = 0, height = 0;
//        for (int[] card : sizes) {
//            width = Math.max(width, Math.max(card[0], card[1]));
//            height = Math.max(height, Math.min(card[0], card[1]));
//        }
//        int answer = width * height;
//        return answer;
//    }
//}
// [참고] 자바 최대값/최소값 (Math.max/min) https://mine-it-record.tistory.com/140