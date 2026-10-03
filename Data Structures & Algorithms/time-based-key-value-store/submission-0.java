class TimeMap {
    private Map<String, List<Data>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Data> dataList = map.get(key);
        return binarySearch(dataList, timestamp);
    }

    private String binarySearch(List<Data> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
class Data {
    String val;
    int timestamp;

    Data(String val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}
