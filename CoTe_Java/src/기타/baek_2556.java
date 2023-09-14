package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 최적화해보기 https://www.acmicpc.net/source/66477494
public class baek_2556 {
    public static void main(String[] args) throws IOException {
        // [1] 정답
        // 1. 입력 받기 (개수, 수열)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 네 개의 스택 만들기
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);

        // 3. 수열의 숫자들을 스택에 삽입하기
        boolean possible = true;
        for (int num : nums) {
            for (int j = 0; j < stacks.size(); j++) {
                if (stacks.get(j).isEmpty()) {
                    stacks.get(j).push(num);
                    break;
                }
                if (!stacks.get(j).isEmpty() && num < stacks.get(j).peek()) {
                    if (j + 1 == stacks.size()) {
                        possible = false;
                        break;
                    }
                } else {
                    stacks.get(j).push(num);
                    break;
                }
            }
            if (!possible) {
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
