class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        StringBuilder newString = new StringBuilder(my_string);
        newString.replace(s, s + overwrite_string.length(), overwrite_string);
        return newString.toString();
    }
}