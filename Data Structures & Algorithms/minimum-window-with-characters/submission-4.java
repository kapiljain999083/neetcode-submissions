class Solution {
    public String minWindow(String s, String t) {
        if(t==null || s==null || t.isEmpty() || s.isEmpty() || t.length() > s.length()){
            return "";
        }
        Map<Character, Integer> req = new HashMap();
        Map<Character, Integer> freq = new HashMap();

        for(char ch : t.toCharArray()){
            req.put(ch, req.getOrDefault(ch,0) +1);
        }

        int n = s.length();
        int left=0, right=0, len=0, minLen=Integer.MAX_VALUE;
        int l=0,r=0;
        
        while(right < n){
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right),0) +1);
            while (isValid(req, freq) && left <= right){
                if((right - left) + 1 < minLen){
                    minLen = (right - left) + 1;
                    l= left;
                    r=right;
                }
                if(freq.get(s.charAt(left)) > 1 ){
                    freq.put(s.charAt(left), freq.get(s.charAt(left)) -1);
                }else{
                    freq.remove(s.charAt(left));
                }
                left++;
            }
            right++;
        }
        return minLen != Integer.MAX_VALUE ? s.substring(l,r+1) : "";
    }


    boolean isValid(Map<Character, Integer> req, Map<Character, Integer> freq){
        for(Map.Entry<Character, Integer> map : req.entrySet()){
            if(freq.get(map.getKey()) == null || map.getValue() > freq.get(map.getKey())){
                return false;
            }
        }
        return true;
    }
}
