class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String str :  strs){
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(map.get(s) != null){
                List<String> l = map.get(s);
                l.add(str);
                map.put(s, l);
            }else{
                List<String> list= new ArrayList();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
