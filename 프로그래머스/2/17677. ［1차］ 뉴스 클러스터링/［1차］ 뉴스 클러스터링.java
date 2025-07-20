import java.util.*;

class Solution {
    String[] alpha = {
        "a","b","c","d","e","f","g","h","i","j","k","l","m",
        "n","o","p","q","r","s","t","u","v","w","x","y","z"
    };

    public boolean isAlpha(String a, String b) {
        if (a == null || b == null) return false;
        return Arrays.asList(alpha).contains(a.toLowerCase()) && Arrays.asList(alpha).contains(b.toLowerCase());
    }

    public int solution(String str1, String str2) {
        // 자카드 유사도 계산: 교집합 / 합집합 * 65536
        String[] str1List = str1.split("");
        String[] str2List = str2.split("");

        String[] s1 = new String[str1.length() - 1];
        String[] s2 = new String[str2.length() - 1];

        for (int i = 0; i < str1List.length - 1; i++) {
            if (isAlpha(str1List[i], str1List[i + 1])) {
                s1[i] = (str1List[i] + str1List[i + 1]).toLowerCase();
            }
        }

        for (int i = 0; i < str2List.length - 1; i++) {
            if (isAlpha(str2List[i], str2List[i + 1])) {
                s2[i] = (str2List[i] + str2List[i + 1]).toLowerCase();
            }
        }

        // 교집합 & 합집합 리스트
        ArrayList<String> gyo = new ArrayList<>();
        ArrayList<String> hab = new ArrayList<>();

        // 합집합 먼저 s1에서 넣기
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != null) hab.add(s1[i]);
        }

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == null) continue;
            for (int j = 0; j < s2.length; j++) {
                if (s2[j] == null) continue;

                if (s1[i].equalsIgnoreCase(s2[j])) {
                    gyo.add(s1[i]);
                    s2[j] = null; // 교집합에 썼으면 제거
                    break;
                }
            }
        }

        // 남은 s2 값 합집합에 추가
        for (int i = 0; i < s2.length; i++) {
            if (s2[i] != null) hab.add(s2[i]);
        }

        // 자카드 예외 처리 (공집합인 경우)
        if (hab.size() == 0) return 65536;

        // 유사도 계산
        double jacard = ((double) gyo.size() / hab.size()) * 65536;
        return (int) jacard;
    }
}
