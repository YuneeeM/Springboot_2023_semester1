package Week1;

public class Test6 {

  public int solution(String s) {
    int answer = s.length(); // 압축실패시 원래의 길이 출력

    // i는 문자열의 단위로 예를 들어 i=1 경우 2a, i=3일 경우 2abc를 의미함
    for (int i = 1; i <= (s.length() / 2); i++) {
      StringBuilder str = new StringBuilder(); // 문자열 변경시 조합을 담을 문자열
      String prev_str = s.substring(0, i); // 이전 문자열 저장
      int cnt = 1; // 문자열 횟수

      // 모든 숫자 단위로 쪼개보고 가장 짧은 값을 찾는 완전탐색임
      // ㄴ> 문자열 단위(=i)만큼 증가
      for (int k = i; i <= s.length(); k += i) {
        String next_str = "";
        // 만약, i+k가 문자열 크기보다 크다면
        if (i + k > s.length()) {
          next_str = s.substring(k, s.length()); // 모든 문자열 추가
          if (cnt > 1) {
            str.append(cnt);
          }
          str.append(prev_str);
          str.append(next_str);
        } else { // i+j가 문자열 크기 이내일 경우
          next_str = s.substring(k, k + i); // prev_str 다음요소부터 문자열 단위(i) 만큼
          if (prev_str.equals(next_str)) {
            cnt++; // 문자열 카운트 증가!
          } else { // 이전과 이후가 다르다묜
            if (cnt > 1) {
              str.append(cnt);
            }
            str.append(prev_str);

            prev_str = next_str; // 비교대상을 다음으로 넘김
            cnt = 1;
          }
        }
      }
      // 원래 문자열 길이보다 작으면 갱신
      if (answer > str.length()) {
        answer = str.length();
      }

      return answer;
    }
  }
}
