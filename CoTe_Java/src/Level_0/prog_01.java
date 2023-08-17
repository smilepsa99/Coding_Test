package Level_0;

public class prog_01 {
}

// [프로그래머스] 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기
class Solution1 {
    public String solution(String myString, String pat) {
        int firstIndex = myString.lastIndexOf(pat);
        int lastIndex = firstIndex + pat.length() - 1;
        String answer = myString.substring(0,lastIndex + 1);
        return answer;
    }
}

// [프로그래머스] ad 제거하기
class Solution2_1 {
    public String[] solution(String[] strArr) {
        int count = 0;
        for (String str : strArr) {
            if (str.contains("ad")) {
                count++;
            }
        }

        if (count == 0) {
            return strArr;
        }

        String[] answer = new String[strArr.length - count];
        int i = 0;
        for (String str : strArr) {
            if (!str.contains("ad")) {
                answer[i] = str;
                i++;
            }
        }
        return answer;
    }
}

// import java.util.*;
//class Solution2_2 {
//         List<String> list = new ArrayList<>();
//         for (String str : strArr) {
//             if (!str.contains("ad")) {
//                 list.add(str);
//             }
//         }
//         String[] answer = list.toArray(new String[list.size()]);
//         return answer;
//    }
//}

//class Solution2_3 {
//    public String[] solution(String[] strArr) {
//        return Arrays.stream(strArr)
//                .filter(x -> !x.contains("ad"))
//                .toArray(String[]::new);
//                // [참고] :: 의 의미 https://wakestand.tistory.com/646
//    }
//}

// [프로그래머스] 공백 제거하기1
class Solution3 {
    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");
        return answer;
    }
}

// [프로그래머스] x 사이의 개수
class Solution4_1 {
    public int[] solution(String myString) {
        int xCount = myString.length()
                - myString.replace("x", "").length();
        String[] strArr = myString.split("x", xCount + 1);
        int[] answer = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            answer[i] = strArr[i].length();
        }
        return answer;
    }
}

//class Solution4_2 {
//    public int[] solution(String myString) {
//        String[] strArr = myString.split("x", -1);
//        // [참고] split 함수에서 limit 음수 의미 https://codingstudytrace.tistory.com/57
//        int[] answer = new int[strArr.length];
//        for (int i = 0; i < strArr.length; i++) {
//            answer[i] = strArr[i].length();
//        }
//        return answer;
//    }
//}
