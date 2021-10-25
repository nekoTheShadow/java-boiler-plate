public class StringUtils {
    public String lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int x = n;
        int y = m;
        StringBuilder u = new StringBuilder();
        while(x > 0 && y > 0) {
            if (dp[x][y] == dp[x-1][y]) {
                x--;
            } else if (dp[x][y] == dp[x][y-1]) {
                y--;
            } else {
                x--;
                y--;
                u.append(s.charAt(x));
            }
        }

        return u.reverse().toString();
    }
    
    /**
     * 最長の回文を探索する。計算量はO(N)。
     * https://en.wikipedia.org/wiki/Longest_palindromic_substring
     */
    public String longestPalindrome(String s, char dummy) {
        char[] t = new char[s.length()*2+1];
        for (int i = 0; i < s.length(); i++) {
            t[i*2] = dummy;
            t[i*2+1] = s.charAt(i);
        }
        t[t.length-1] = dummy;
        int[] palindromeRadii = new int[t.length];
        
        int center = 0;
        int radius = 0;
        while (center < t.length) {
            while (center-(radius+1) >= 0 && center+(radius+1) < t.length && t[center-(radius+1)] == t[center+(radius+1)]) {
                radius++;
            } 
            
            palindromeRadii[center] = radius;
            
            int oldCenter = center;
            int oldRadius = radius;
            center++;
            radius = 0;
            while (center <= oldCenter + oldRadius) {
                int mirroredCenter = oldCenter - (center - oldCenter);
                int maxMirroredRadius = oldCenter + oldRadius - center;
                if (palindromeRadii[mirroredCenter] < maxMirroredRadius) {
                    palindromeRadii[center] = palindromeRadii[mirroredCenter];
                    center++;
                } else if (palindromeRadii[mirroredCenter] > maxMirroredRadius) {
                    palindromeRadii[center] = maxMirroredRadius;
                    center++;
                } else {
                    radius = maxMirroredRadius;
                    break;
                }
            }
        }
        
        int pivot = 0;
        for (int i = 1; i < palindromeRadii.length; i++) {
            if (palindromeRadii[pivot] < palindromeRadii[i]) {
                pivot = i;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = pivot-palindromeRadii[pivot]+1; i < pivot+palindromeRadii[pivot]; i++) {
            if (t[i] != dummy) {
                ans.append(t[i]);
            }
        }
        
        return ans.toString();
    }
}

