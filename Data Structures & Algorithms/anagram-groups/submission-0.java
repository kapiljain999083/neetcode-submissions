class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean taken[] = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (taken[i]) continue;
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s1 = new String(ch);
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            taken[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                char[] ch2 = strs[j].toCharArray();
                Arrays.sort(ch2);
                String s2 = new String(ch2);
                if (s1.equals(s2)) {
                    list.add(strs[j]);
                    taken[j] = true;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
