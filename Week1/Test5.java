package Week1;

public class Test5 {
  public int solution(String s) {

    int answer = 0;
    int count = s.length();

    // 입력문자열의 길이가 1일때,
    if (count == 1) {
      return 1;
    }

    // 완전 탐색으로 가장 작은 길이를 결과를 구하되, 탐색의 범위를 줄이는 것이 필요함
    // 최대 압축길이는 : 문자열 길이/2
    for (int i = 1; i <= count / 2; i++) {
      // substring을 이용해 압축시킬 문자열의 길이를 늘려감
      String compress = s.substring(0, i); // compress == 압축시킬 문자열 형태
      int num = 1; // 압축을 몇번 시켰는지 확인용
      String result = "";

      for (int k = i; k <= count - i; k += i) {
        // 문자열과 다음에 오는 문자열이 같은지를 확인함
        if (compress.equals(s.substring(k, k + 1))) {
          num++; // 압축성공 시 num 증가
        } else {
          if (num > 1) {
            // 압축된 횟수를 적어줌 abab=2ab
            result += num + "";
          }
          // 압축시킨 compress 붙임
          compress = s.substring(k, k + i);
          num = 1; // 압축 성공이 아닌 처음임으로 1로 초기화

        }
      }
      // 압축시키지 않은 문자열은 압축시킴
      if (num > 1) {
        result += num + "";
      }
      result += compress;

      // i개 단위로 자르고 남은 문자열 길이
      int other = s.length() % i;
      // 최솟값 갱신
      answer = Math.min(answer, s.length() + other);
    }
    return answer;
  }
}
