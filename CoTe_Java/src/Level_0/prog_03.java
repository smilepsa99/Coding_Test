package Level_0;

import java.util.Arrays;

public class prog_03 {
}

// 21. 접미사 배열
//import java.util.Arrays;
class Solution21 {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(i); // [참고] substring() https://jamesdreaming.tistory.com/81
        }
        Arrays.sort(answer); // [참고] 문자열배열 정렬 https://www.techiedelight.com/ko/sort-array-of-strings-java/
        return answer;
    }
}

// 22. 세로 읽기
class Solution22 {
    public String solution(String my_string, int m, int c) {
        String[] parts = my_string.split("");
        String answer = "";
        for (int i = c-1; i < parts.length; i += m) {
            answer += parts[i];
        }
        return answer;
    }
}

// 23. n 번째 원소부터
class Solution23 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - (n-1)];
        int index = 0;
        for (int i = n-1; i < num_list.length; i++) {
            answer[index] = num_list[i];
            index++;
        }
        return answer;
    }
}

// 24. 홀수 vs 짝수
class Solution24 {
    public int solution(int[] num_list) {
        int odd = 0, even = 0;
        for (int i = 0; i < num_list.length; i += 2) odd += num_list[i];
        for (int i = 1; i < num_list.length; i += 2) even += num_list[i];
        int answer = (odd > even) ? odd : even;
        return answer;
    }
}

// 25. 5명씩

//class Solution25_1 {
//    public String[] solution(String[] names) {
//        String[] answer = new String[names.length / 5 + 1];
//        for (int i = 0; i < names.length; i += 5) {
//            answer[i/5] = names[i];
//        }
//        return answer;
//    }
//}

class Solution25_2 {
    public String[] solution(String[] names) {
        int len = (int) Math.ceil((double) names.length / 5);
        // [참고] 자바 소수점 올림 https://blog.naver.com/geeyoming/220372803149
        String[] answer = new String[len];
        for (int i = 0; i < names.length; i += 5) {
            answer[i/5] = names[i];
        }
        return answer;
    }
}

// 26. n보다 커질 때까지 더하기
class Solution26 {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
            if (sum > n) break;
        }
        return sum;
    }
}

// 27. A 강조하기
class Solution27_1 {
    public String solution(String myString) {
        myString = myString.toLowerCase();
        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            if (c == 'a') {
                myString = myString.substring(0,i) + "A"
                        +  myString.substring(i + 1);
            }
        }
        return myString;
    }
}

//class Solution27_2 {
//    public String solution(String myString) {
//        myString = myString.toLowerCase();
//        myString = myString.replace("a", "A");
//        return myString;
//    }
//}

// 28. 전국 대회 선발 고사
class Solution28 {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0, index = 0, zeros = 10000;
        for (int i = 1; i <= rank.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                if (rank[j] == i) {index = j; break;}
            }
            if (attendance[index]) {
                answer += zeros * index;
                zeros /= 100;
                if (zeros == 0) break;
            }
        }
        return answer;
    }
}

// 29. 꼬리 문자열
class Solution29 {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for (String s : str_list) {
            if (!s.contains(ex)) answer += s;
        }
        return answer;
    }
}

// 30. 날짜 비교하기
class Solution30 {
    public int solution(int[] date1, int[] date2) {
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            if (date1[i] < date2[i]) { answer = 1; break; }
            else if (date1[i] > date2[i]) { break; }
        }
        return answer;
    }
}

// 31. 그림 확대
class Solution31 {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        // String xs = "x".repeat(k), dots = ".".repeat(k);
        for (int i = 0; i < picture.length; i++) {
            // picture[i] = picture[i].replace("x", xs);
            // picture[i] = picture[i].replace(".", dots);
        }
        for (int j = 0; j < answer.length; j++) {
            answer[j] = picture[j / k];
        }
        return answer;
    }
}

// 32. 커피 심부름
class Solution32 {
    public int solution(String[] order) {
        int sum = 0;
        for (String s : order) {
            if (s.contains("americano") || s.equals("anything")) {sum += 4500;}
            else if (s.contains("cafelatte")) {sum += 5000;}
        }
        return sum;
    }
}

// 33. 세균 증식
class Solution33 {
    public int solution(int n, int t) {
        int time = (int) Math.pow(2, t);
        int answer = n * time;
        return answer;
    }
}

// 34. OX 퀴즈
class Solution34 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            int n1 = Integer.parseInt(parts[0]);
            int n2 = Integer.parseInt(parts[2]);
            int ans = Integer.parseInt(parts[4]);

            if (parts[1].equals("+")) {
                if (n1 + n2 == ans) {
                    answer[i] = "O";
                } else {answer[i] = "X";}
            } else if (parts[1].equals("-")) {
                if (n1 - n2 == ans) {
                    answer[i] = "O";
                } else {answer[i] = "X";}
            }
        }
        return answer;
    }
}

// 35. 편지
class Solution35 {
    public int solution(String message) {
        int answer = message.length() * 2;
        return answer;
    }
}

// 36. 인덱스 바꾸기
class Solution36_1 {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] parts = my_string.split("");
        String temp = parts[num1];
        parts[num1] = parts[num2];
        parts[num2] = temp;
        for (String s : parts) {answer += s;}
        return answer;
    }
}

//class Solution36_2 {
//    public String solution(String my_string, int num1, int num2) {
//        char[] parts = my_string.toCharArray();
//        // [참고] <toCharArray() 사용법> https://velog.io/@uhan2/java-String.toCharArray-%EC%82%AC%EC%9A%A9%EB%B2%95
//        parts[num1] = my_string.charAt(num2);
//        parts[num2] = my_string.charAt(num1);
//        return new String(parts);
//    }
//}