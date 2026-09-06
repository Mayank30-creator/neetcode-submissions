class Solution {

    //Intuition is to use the 2 things as delimiter as there can be word length greater 9 in which the logic of the demlimiter of 1 will fail so we have to use the 2 delimiter so that we can decode it correctly.


    public String encode(List<String> strs) {
        String res = "";
        for(int i=0;i<strs.size();i++){
            int len = strs.get(i).length();
            res += len + "#" + strs.get(i);
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        int length = str.length();

        while(i<length){
            int j = i;

            while(str.charAt(j)!= '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            j++;

            String word = str.substring(j,j+len);
            result.add(word);
            i=j+len;
        }
         return result;
    }
}
