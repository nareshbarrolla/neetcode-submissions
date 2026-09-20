class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null){
            return null;
        }
        if(strs.length == 1){
            return List.of(List.of(strs[0]));
        }

        Map<String, List<String>> trackerMap = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){            
            final int[] countArray = new int[26];
            final String currentString = strs[i];
            for(int j = 0; j < currentString.length(); j ++){
                countArray[currentString.charAt(j)-'a']++;                   
            }
            final String key = Arrays.toString(countArray);
            List<String> currentList = trackerMap.get(key); 
            if(currentList == null){
                List<String> anagramList = new ArrayList<>();
                anagramList.add(currentString);
                trackerMap.put(key, anagramList);                
            }else{
                currentList.add(currentString);
            }
        }

        for(Map.Entry<String, List<String>> entry : trackerMap.entrySet()){
            final List<String> indexs = entry.getValue();
            output.add(indexs);
        } 
        return output;         
}
}
