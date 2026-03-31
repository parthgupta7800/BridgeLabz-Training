class SubstringPattern {
    public boolean repeatedSubstringPattern(String s){
        String str=s+s;
        String str2=str.substring(1,str.length()-1);
        return str2.contains(s);
    }
}