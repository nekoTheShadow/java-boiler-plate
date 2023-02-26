import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
    
    /**
     * https://snuke.hatenablog.com/entry/2014/12/02/235837
     * すべてのiについて、S[i]を中心とする最長の回文を格納する (文字列長偶数と文字列長奇数両方に対応している)
     */
    public List<String> manachersAlgorithm(String s, char dummy) {
        int n = s.length();
        char[] c = new char[n*2-1];
        for (int i = 0; i < n; i++) {
            c[i*2] = s.charAt(i);
            if (i != n-1) {
                c[i*2+1] = dummy;
            }
        }
        
        int l = c.length;
        int[] r = new int[l];
        int i = 0;
        int j = 0;
        while (i < l) {
            while (i-j>=0 && i+j<l && c[i-j]==c[i+j]) {
                j++;
            }
            r[i] = j;
            int k = 1;
            while (i-k>=0 && k+r[i-k]<j) {
                r[i+k] = r[i-k];
                k++;
            }
            i += k;
            j -= k;
        }
        
        List<String> ans = new ArrayList<>();
        for (int x = 0; x < l; x++) {
            StringBuilder sb = new StringBuilder();
            for (int y = x-r[x]+1; y < x+r[x]; y++) {
                if (y%2==0) {
                    sb.append(c[y]);
                }
            }
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }
    
    public int levenshteinDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int c = word1.charAt(i-1)==word2.charAt(j-1) ? 0 : 1;
                dp[i][j] = IntStream.of(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+c).min().getAsInt();
            }
        }
        return dp[n1][n2];
    }
}

