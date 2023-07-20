package 완전탐색;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class prog_소수찾기 {
    public static void main(String[] args) {
        Solution03 sol3 = new Solution03();
        int answer = sol3.solution("123"); // 17, 011
        System.out.println(answer);
    }
}

// 1 정답 [참고함] 다른사람 풀이 https://school.programmers.co.kr/questions/48569
// [참고] 소수찾기 https://ko.wikipedia.org/wiki/%EC%86%8C%EC%88%98_(%EC%88%98%EB%A1%A0)#%EC%86%8C%EC%88%98_%EC%B0%BE%EA%B8%B0
// [참고] 배열 복사 https://coding-factory.tistory.com/548
// [참고] 순열 구현 https://gyuwon95.tistory.com/136

class Solution03 {
    public int solution(String numbers) {
        int answer = 0;

        String[] nums = numbers.split("");
        int[] arr = new int[10];
        for (String s : nums) {
            arr[Integer.parseInt(s)]++;
        }

        int size = (int) Math.pow(10,nums.length);
        for (int i = 2; i < size; i++) {
            if (isPrime(i) && isContain(arr, i)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isContain(int[] arr, int num) {
        String[] split = Integer.toString(num).split(""); // num=111, split= ["1", "1", "1"]
        int[] ints = arr.clone(); // arr = [1, 2, 0, 0, 0 0 0 0..] (011일경우)
        for (String s : split) {
            if (ints[Integer.parseInt(s)] > 0) {
                ints[Integer.parseInt(s)]--;
            } else {
                return false;
            }
        }
        return true;
    }
}

// 0.1 삼중 for 문에서 꼬여서 중단
//class Solution03 {
//    public int solution(String numbers) {
//
//        // 1. 문자열(numbers)을 문자열 배열(arr)로 변환
//        String[] arr = numbers.split("");
////        int[] nums = new int[arr.length];
////        for (int i = 0; i < arr.length; i++) {
////            nums[i] = Integer.parseInt(arr[i]);
////        }
//
//        // arr = {"1", "2", "3"}
//        // 2. arr 의 요소로 만들 수 있는 모든 숫자 구하기 (단, 맨앞 0 제외)
//        // ㄴ 로직 : 2자리수 구할때 1자리수+나머지숫자, 3자리수 구할 때 2자리수+나머지숫자 ...
//        // ㄴ 1) 경우의 수를 저장할 리스트(cases) 과 반복문에서 사용할 리스트(test) 생성
//
//        ArrayList<Integer> cases = new ArrayList<>();    // 경우의 수 저장용
//        ArrayList<String> case_list = new ArrayList<>(); // 자리별 경우의 수 자리별 저장용 (계속 갱신)
//        ArrayList<String> add_list = new ArrayList<>();  // 경우의 수에 덧붙일 숫자 저장용 (몇개 삭제 후 계속 갱신 반복)
//        ArrayList<String> list = new ArrayList<>();  // 자리별 경우의 수 임시저장용
//
//        // 2-1. 1자리 수
//        for (String s : arr) {
//            cases.add(Integer.parseInt(s));
//            case_list.add(s);
//        }
//
//        // 2-2. 2자리 수
//        // case_list = ["0","1", "1"], add_list = [],
//        // 2-3. 3자리 수
//        // case_list = ["12", "13", "21", "23", "31", "32"], add_list = ["1", "2"]
//
//        for (int k = 0; k < arr.length; k++) {
//            for (String s : case_list) { // i = 1
//                if (s.equals("0")) { // 맨 앞이 0인 경우 제외
//                    continue;
//                }
//
//                add_list.clear(); // add_list 내용삭제
//                add_list.addAll(Arrays.asList(arr)); // add_list = ["0", "1", "1"]
//                String[] same_check = s.split(""); // same_check = {"1"}
//                //add_list.removeAll(Arrays.asList(same_check)); // add_list = ["0", "1"]
//                for (String same : same_check) {
//                    add_list.remove(same);
//                }
//
//                for (String value : add_list) {
//                    String new_case = s + value; // new case = "123"
//                    list.add(new_case); // (임시 저장) list = ["123"]
//                    cases.add(Integer.parseInt(new_case)); // (경우의 수에 저장) cases = [1, 2, 3, 12..., 123]
//                }
//            }
//            case_list = list; // case_list = ["12", "13", "21", "23", "31", "32"]
//        } // cases = [1, 2, 3, 12, 13, ..., 321]
//
//        // 3. 위에서 구한 숫자들 중 소수 찾기 : 자신보다 작은 모든 숫자로 나눠보기 (나머지 0 이면 소수 아님) + 0, 1 제외
//        HashSet<Integer> set = new HashSet<>(cases); // (중복제거) set = {1, 2, 3, 12, 13, ..., 321}
//        int count = 0;
//        boolean isSosu = true;
//        for (int item :set) { // 0, 1 제외
//            if (item == 2) {
//                count++;
//            } else if (item > 2) {
//                for (int i = 2; i < item; i++) {
//                    int extra = item % i;
//                    if (extra == 0) {
//                        isSosu = false;
//                        break;
//                    }
//                    isSosu = true;
//                }
//                if (isSosu) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//}
