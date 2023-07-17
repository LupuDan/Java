import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) throws Exception { 
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
    }
    static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
        {
            return false;
        }
        if(s.equals(t))
        {
            return true;
        }
        Map<Character, Character> symbols = new HashMap<>();
        for (int i = 0; i<s.length(); i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i);
            if(!symbols.containsKey(ch1))
            {
                symbols.put(ch1, ch2);
            }
            else
            {
                if(!symbols.get(ch1).equals(ch2))
                {
                    return false;
                }
            }
        }
    }
}
