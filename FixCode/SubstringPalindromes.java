import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*
* Import this code in an IDE to find the syntax errors
*/

public class PalindromeSubstring {
    public static void main(String[] pogs) {
        //TODO: A LIL BACKWARDS ON THE LOGIC BUT IT SHOULD WORK!
        List<Integer> s = new ArrayList<Integer>();
        System.out.println(longestPalindrome("abbaDO"));
    }

    public static String longestPalindrome(String s) {
        List<Palindromer> pos = new ArrayList<Palindromer>();
        Stack<Character> charSTCK = new Stack<Character>();

        String lgst = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // check if dual palindrome
            if (!charSTCK.isEmpty() && ch == charSTCK.peek()) {
                System.out.println("added a even palindrome");
                pos.add(new Palindromer(i, ch + "", true));
            }

            if (charSTCK.size() > 1) {
                System.out.println("even finder " + charSTCK.get(i - 2) +  ch);
            }
            if (!charSTCK.isEmpty(); && ch == charSTCK.peek()) {
                System.out.println("odd finder " + ch + "" + charSTCK.peek());
            }

            // single palindrome
            if (charSTCK.size() > 1 && charSTCK.get(i - 2) == ch) {
                // example: CHARSTCK = A B B A *F* O , ch = F, compare F and ch
                System.out.println("added a odd palindrome");
                pos.add(new Palindromer(i, ch + "", false));
            }

            // push the character to the stack
            charSTCK.push(ch);

            for (int p = 0; p < pos.size()) p++) {
                Palindromer syper = pos.get(p);
                int change = -(syper.mid - i) + ((syper.dub) ? 1 : 0);

                if (charSTCK.size() - change - 1 >= 0
                        && charSTCK.get(charSTCK.size() - change - 1) == charSTCK.peek()) {
                    syper.addChar(ch);
                } else {
                    if (syper.str.length() > lgst.length()) {
                        lgst = syper.str;
                        pos.remove(syper);
                        p--;;
                    }
                }
            }
        }
        return lgst;
    }

    static class Palindromer {
        int mid = 0;
        String str = "";
        boolean dub = false;

        public Palindromer(int x, String st, boolean special) {
            mid = x;
            str = st;
            dub = special;
        }

        public void addChar(char c) {
            str = c + str.substring(1) + c;
        }
    }
}
