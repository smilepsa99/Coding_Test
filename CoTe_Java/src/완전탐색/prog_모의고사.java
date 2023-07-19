package 완전탐색;

import java.util.*;

public class prog_모의고사 {
    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        // int[] input = {1,3,2,4,2,1,3,2,4,2,1,3,2,4,2,1,3,2,4,2};
        int[] input = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i : solution.solution(input)) {
            System.out.print(i + " ");
        }
    }
}

// 1 오답(런타임 에러)
//class Solution02 {
//    public int[] solution(int[] answers) {
//
//        int[] student_1 = {1, 2, 3, 4, 5};
//        int[] student_2 = {2, 1, 2, 3, 2, 4, 2, 5};
//        int[] student_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
//
//        int[] scores = {0, 0, 0};
//        for (int i = 0; i < answers.length; i++) {
//            if (student_1[i - 5 * (i/5)] == answers[i]) {
//                scores[0]++;
//            }
//            if (student_2[i - 8 * (i/8)] == answers[i]) {
//                scores[1]++;
//            }
//            if (student_3[i - 10 * (i/10)] == answers[i]) {
//                scores[2]++;
//            }
//        }
//
//        int[] arr = new int[3];
//        int size = 0;
//        int max_score = Math.max(scores[0], Math.max(scores[1], scores[2]));
//        for (int i = 0; i < scores.length; i++) {
//            if (scores[i] == max_score) {
//                size++;
//                arr[i] = i + 1;
//            }
//        }
//
//        int[] answer = new int[size];
//        for (int i = 0; i < scores.length; i++) {
//            if (arr[i] != 0) {
//                answer[i] = arr[i];
//            }
//        }
//        return answer;

// 2 정답
// + 모범답안 https://school.programmers.co.kr/learn/courses/30/lessons/42840/solution_groups?language=java
class Solution02 {
    public int[] solution(int[] answers) {

        int[] student_1 = {1, 2, 3, 4, 5};
        int[] student_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = {0, 0, 0}; // int[] scores =  new int[3] 도 가능
        for (int i = 0; i < answers.length; i++) {
            if (student_1[i - 5 * (i/5)] == answers[i]) { // student_1[i % 5] 도 가능
                scores[0]++;
            }
            if (student_2[i - 8 * (i/8)] == answers[i]) {
                scores[1]++;
            }
            if (student_3[i - 10 * (i/10)] == answers[i]) {
                scores[2]++;
            }
        }

        int[] sorted = {scores[0], scores[1], scores[2]};
        Arrays.sort(sorted);
        int max_score = sorted[sorted.length - 1];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max_score) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}