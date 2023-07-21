package BFS_DFS;

import java.util.Arrays;

// 01 정답
public class prog_타겟넘버 {
    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3; // 5
        // int[] numbers = {4, 1, 2, 1};
        // int target = 4; // 2
        int answer = sol.solution(numbers, target);
        System.out.println(answer);

    }
}
class Solution01 {
    public int solution(int[] numbers, int target) {
        int[] cases = dfs(numbers);
        int answer = 0;

        for (int n : cases) {
            if (n == target) {
                answer++;
            }
        }
        return answer;
    }

    public int[] dfs(int[] arr) {
        int[] ints = {arr[0], (-1) * arr[0]};
        if (arr.length == 1) {
            return ints;
        }

        int[] dfs_arr = dfs(Arrays.copyOfRange(arr, 1, arr.length));

        int[] return_arr = new int[2 * dfs_arr.length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < dfs_arr.length; j++) {
                return_arr[j + (dfs_arr.length * i)] = ints[i] + dfs_arr[j];
            }
        }
        return return_arr;
    }
}

// [참고함] (Java) 특정 인덱스에서 배열 자르기 https://hianna.tistory.com/619
// [참고] 다른사람 풀이 https://tang25.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-Lv2-JAVA-DFS%EC%97%84%ED%83%B1
// [참고] (Java) 알고리즘 - BFS, DFS 구현하기 https://velog.io/@smallcherry/Java-AlgorithmBFSAndDFS

// [+] (알고리즘) 순열, 중복순열, 조합, 중복조합 총정리 https://velog.io/@cgw0519/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%9C%EC%97%B4-%EC%A4%91%EB%B3%B5%EC%88%9C%EC%97%B4-%EC%A1%B0%ED%95%A9-%EC%A4%91%EB%B3%B5%EC%A1%B0%ED%95%A9-%EC%B4%9D%EC%A0%95%EB%A6%AC