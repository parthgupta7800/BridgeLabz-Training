class Ocurrence {
    public int strStr(String haystack, String needle) {
        int strlen=haystack.length();
        int nlen=needle.length();
            for (int i = 0; i <=strlen-nlen; i++) {
            if (haystack.substring(i, i + nlen).equals(needle)) {
                return i;
            }
        
    }
    return -1;
}
}