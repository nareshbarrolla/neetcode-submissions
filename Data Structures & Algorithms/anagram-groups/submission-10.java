class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();                
        }
        HashMap<String,List<String>> trackingMap = new HashMap<>();
        for(int i = 0; i < strs.length; i ++){
            String currentStringHashValue = getStringHash(strs[i]);
            if(trackingMap.containsKey(currentStringHashValue)){
                trackingMap.get(currentStringHashValue).add(strs[i]);
            }else{
                List<String> groupedAnagrams = new ArrayList<>();
                groupedAnagrams.add(strs[i]);
                trackingMap.put(currentStringHashValue, groupedAnagrams);
            }
        }
        List<List<String>> output = new ArrayList<>();        
        for(Map.Entry<String,List<String>> entry: trackingMap.entrySet()){
            output.add(entry.getValue());                
        }
        return output;         
    }

    private String getStringHash(String input){
        int[] stringHash = new int[26];
        for(int i = 0; i < input.length(); i++){
              stringHash[(input.charAt(i)-'a')]++;
        }
        return Arrays.toString(stringHash);
    }
}
