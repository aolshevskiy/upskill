package upskill;

import java.util.Arrays;

class CompactifySpaces {
    public static void main(String[] args) {
        String s = "a   a  ";
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < chars.length) {
            sb.append(chars[i]);
            if(chars[i] == ' ') {
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
                continue;
            }
            i++;
        }

        if(sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }

        if(sb.charAt(sb.length()-1) == ' ') {
            sb.deleteCharAt(sb.length()-1);
        }

        System.out.println(Arrays.asList(sb));
    }
}
