class Solution {
    static final int LENGTH_FIELD_SIZE = 10; // must be wide enough for max string length

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            String lengthField = String.format("%010d", s.length()); // always exactly 10 chars
            encoded.append(lengthField).append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> results = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            String lengthField = str.substring(i, i + LENGTH_FIELD_SIZE);
            int length = Integer.parseInt(lengthField);
            i += LENGTH_FIELD_SIZE;

            String content = str.substring(i, i + length);
            results.add(content);
            i += length;
        }
        return results;
    }
}