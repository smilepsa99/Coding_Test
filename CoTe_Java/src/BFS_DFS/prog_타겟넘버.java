package BFS_DFS;

import java.util.Arrays;
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