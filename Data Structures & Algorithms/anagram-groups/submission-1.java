class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
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
        for(Map.Entry<String, List<String>> m : map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}
