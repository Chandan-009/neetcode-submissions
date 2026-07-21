class Solution {
    public boolean isPalindrome(String s) {
        int orginal =s.length();
        s=s.replaceAll("[^a-zA-Z0-9]", "");
        s=s.toUpperCase();
        int i=0;
        int j=s.length()-1;
        //if(s.length()==1 && s.length()!=orginal)
          // return false;

        while (i<=j) {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
}
