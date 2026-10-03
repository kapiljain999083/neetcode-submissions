class Solution {
    public String minWindow(String A, String B) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> input = new HashMap<>();
        if (A == null || B == null || A.length() == 0 || B.length() == 0 || A.length() < B.length()) {
            return "";
        }
        for (char ch : B.toCharArray()) {
            input.put(ch, input.getOrDefault(ch, 0) + 1);
        }
        int left = -1, right = -1, i = 0, j = 0, satisfiedCount = 0, currLen, len = Integer.MAX_VALUE;
        while (j < A.length()) {
            target.put(A.charAt(j), target.getOrDefault(A.charAt(j), 0) + 1);
            if (target.get(A.charAt(j)) != null && input.get(A.charAt(j)) != null &&
                    Objects.equals(target.get(A.charAt(j)), input.get(A.charAt(j)))) {
                satisfiedCount++;
            }
            while (i < j && target.getOrDefault(A.charAt(i), 0) > input.getOrDefault(A.charAt(i), 0)) {
                target.put(A.charAt(i), target.get(A.charAt(i)) - 1);
                i++;
            }
            if (satisfiedCount == input.size()) {
                currLen = j - i + 1;
                if (currLen < len) {
                    len = currLen;
                    left = i;
                    right = j;
                }
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? "" : A.substring(left, right + 1);
    }
}
