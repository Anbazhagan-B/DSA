package com.DsaProject.Basic;

public class MyStrings {
    public String toggelCase(String A) {
        char[] chr = A.toCharArray();
        int n = A.length();
        for(int i = 0; i < n; i++)
        {
            if(Character.isUpperCase(chr[i]))
            {
                chr[i] = Character.toLowerCase(chr[i]);
            }
            else
            {
                chr[i] = Character.toUpperCase(chr[i]);
            }
        }

        return new String(chr);
    }

    public String longestPalindrome(String A) {
        int n = A.length(), start = 0, maxlength = 1;
        for(int k = 1; k < n; k++) {

            int i = k - 1, j = k;
            while (i >= 0 && j < n && A.charAt(i) == A.charAt(j)) {
                if (maxlength < j - i + 1) {
                    start = i;
                    maxlength = j - i + 1;
                }
                i--;
                j++;
            }

            i = k - 1;
            j = k + 1;
            while (i >= 0 && j < n && A.charAt(i) == A.charAt(j)) {
                if (maxlength < j - i + 1) {
                    start = i;
                    maxlength = j - i + 1;
                }
                i--;
                j++;
            }

        }
        return A.substring(start , start + maxlength);
    }

    public String reverse(String A) {
        int n = A.length(), i = 0, j = n- 1;
        char[] ch = new char[n];
        while (i < n && j >= 0)
        {
            ch[i] = A.charAt(j);
            i++;
            j--;
        }

        return new String(ch);
    }
}
