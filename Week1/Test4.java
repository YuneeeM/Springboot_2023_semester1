package Week1;

class Test4 {
  public int solution(String s) {
    int count = s.length();

    for (int i = 1; i < count / 2; i++) {

      int zipLevel = 1;
      String zipStr = s.substring(0, i);
      StringBuilder result = new StringBuilder();

      for (int j = i; j <= count; j += i) {
        String next = s.substring(j, j + i > count ? count : i + j);

        if (zipStr.equals(next))
          zipLevel++;

        else {
          result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
          zipStr = next;
          zipLevel = 1;
        }
      }
      result.append(zipStr);
      count = Math.min(count, result.length());

    }
    return count;
  }
}

// i개의 갯수만큼 문자열을 잘라 현재 문자열과 전 문자열을 비교하여 압축함
// 문자열 길이가 /2를 넘으면 압축이 불가함- 당연함

// 모든 숫자 단위로 쪼개보고 가장 짧은 값을 찾는 완전탐색임
// 압축과정에서 스택을 이용할 수 있음
