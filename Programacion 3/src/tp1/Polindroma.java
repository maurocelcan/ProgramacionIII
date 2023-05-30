package tp1;

public class Polindroma {
	
    public static boolean isPalindrome(String s) {
        return isPalindromeRecursive(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeRecursive(String s, int left, int right) {
        if (left >= right) {
            return true;
        }else if(s.charAt(left) == s.charAt(right)){
        	return isPalindromeRecursive(s, left + 1, right - 1);
        }
		return false;
     }
}

