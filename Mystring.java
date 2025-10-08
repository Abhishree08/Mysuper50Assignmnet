
import java.util.*;

public class Mystring {

     public static String append(String current, String extra) {
    if (current == null) {
        current = "";
    }
    if (extra == null) {
        extra = "";
    }

    int n1 = current.length();
    int n2 = extra.length();

    // +1 for the space
    char[] out = new char[n1 + 1 + n2];

   
    for (int i = 0; i < n1; i++) {
        out[i] = current.charAt(i);
    }

    // add space
    out[n1] = ' ';

   
    for (int j = 0; j < n2; j++) {
        out[n1 + 1 + j] = extra.charAt(j);
    }

    return new String(out);
}



    public static int countWords(String s) {
        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isSpace = (c == ' ' || c == '\t' || c == '\n' || c == '\r');

            if (isSpace) {
                inWord = false;
            } else if (!inWord) {
                count++;
                inWord = true;
            }
        }
        return count;
    }


    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        char[] out = new char[n];
        for (int i = 0; i < n; i++) {
            out[i] = s.charAt(n - 1 - i);
        }
        return new String(out);
    }

   
    static String replace(String text, String pattern, String replacement) {
        if (pattern == null || pattern.length() == 0) {
            return text;
        }
        if (replacement == null) {
            replacement = "";
        }

        String result = "";
        int i = 0, n = text.length(), m = pattern.length();

        while (i < n) {
            boolean found = false;
            if (i + m <= n) {
                found = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        found = false;
                        break;
                    }
                }
            }

            if (found) {
                result = result + replacement;
                i += m;
            } else {
                result = result + text.charAt(i);
                i++;
            }
        }
        return result;
    }

    
    public static boolean isPalindrome(String text) {
        int l = 0, r = text.length() - 1;
        while (l < r) {
            if (text.charAt(l) != text.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    static String splice(String s, int start, int length) {
        int n = s.length();
        if (start < 0) {
            start = 0;
        }
        if (length < 0) {
            length = 0;
        }
        if (start > n) {
            start = n;
        }
        if (start + length > n) {
            length = n - start;
        }

        char[] out = new char[n - length];
        int k = 0;
        for (int i = 0; i < start; i++) {
            out[k++] = s.charAt(i);
        }
        for (int i = start + length; i < n; i++) {
            out[k++] = s.charAt(i);
        }

        return new String(out);
    }

    
    public static char maxRepeat(String s) {
        if (s == null || s.length() == 0) {
            return '\0';
        }
        int n = s.length(), maxCount = 0;
        char maxChar = s.charAt(0);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == c) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = c;
            }
        }
        System.out.println("'" + maxChar + "' -> " + maxCount);
        return maxChar;
    }

  
    public static String sort(String s) {
        int n = s.length();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return new String(arr);
    }

  
    public static String[] split(String text) {
        if (text == null || text.length() == 0) {
            return new String[0];
        }

        int n = countWords(text);
        String[] arr = new String[n];

        String word = "";
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isSpace = (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r');

            if (isSpace) {
                if (!word.isEmpty()) {
                    arr[index++] = word;
                    word = "";
                }
            } else {
                word += ch;
            }
        }
        if (!word.isEmpty()) {
            arr[index++] = word;
        }

        return arr;
    }
 public static String shift(String s, int n) {
    int len = s.length();
    if (len == 0) return s;
    if (n == 0 || n == len) return s; // assuming 0 <= n <= len

    String result = "";
    // take s[n..len-1]
    for (int i = n; i < len; i++) {
        result += s.charAt(i);
    }
    // then s[0..n-1]
    for (int i = 0; i < n; i++) {
        result += s.charAt(i);
    }
    return result;
}



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your string: ");
        String current = sc.nextLine();

        while (true) {
            System.out.println("\nCurrent String: " + current);
            System.out.println(" 1) Append");
            System.out.println(" 2) CountWords");
            System.out.println(" 3) Replace (all)");
            System.out.println(" 4) isPalindrome");
            System.out.println(" 5) Splice (delete part)");
            System.out.println(" 6) Split into words");
            System.out.println(" 7) MaxRepeatingCharacter");
            System.out.println(" 8) Sort characters");
            System.out.println(" 9) Shift RIGHT by n");
            System.out.println("10) Reverse");
            System.out.println(" 0) Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1: {
                    System.out.print("Enter text to append: ");
                    String extra = sc.nextLine();
                    current = append(current, extra);
                    System.out.println("Result: " + current);
                    break;
                }
                case 2: {
                    int words = countWords(current);
                    System.out.println("Word count: " + words);
                    break;
                }
                case 3: {
                    System.out.print("Find what (pattern): ");
                    String pat = sc.nextLine();
                    System.out.print("Replace with: ");
                    String rep = sc.nextLine();
                    current = replace(current, pat, rep);
                    System.out.println("Result: " + current);
                    break;
                }
                case 4: {
                    System.out.println("isPalindrome: " + isPalindrome(current));
                    break;
                }
                case 5: {
                    System.out.print("Start index: ");
                    int start = sc.nextInt();
                    System.out.print("How many characters to delete: ");
                    int cnt = sc.nextInt();
                    current = splice(current, start, cnt);
                    System.out.println("Result: " + current);
                    break;
                }
                case 6: {
                    String[] words = split(current);
                    System.out.println("Words:");
                    for (int i = 0; i < words.length; i++) {
                        System.out.println("[" + (i + 1) + "] " + words[i]);
                    }
                    break;
                }
                case 7: {
                    System.out.println("Max repeating character: '" + maxRepeat(current) + "'");
                    break;
                }
                case 8: {
                    current = sort(current);
                    System.out.println("Result: " + current);
                    break;
                }
                case 9: {
                    System.out.print("Enter n");
                    int n = sc.nextInt();
                    current = shift(current, n);
                    System.out.println("Result: " + current);
                    break;
                }
                case 10: {
                    current = reverse(current);
                    System.out.println("Result: " + current);
                    break;
                }
                case 0: {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
