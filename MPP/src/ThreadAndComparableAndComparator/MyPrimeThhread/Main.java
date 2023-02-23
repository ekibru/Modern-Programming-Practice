package ThreadAndComparableAndComparator.MyPrimeThhread;
import javax.swing.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int start = 1;
        int end = 1000000;
//        int fiveTimes = end / 5;
        int fiveTimes = end / 10;
        int i = 0;
        while (i <= end) {
             Thread th = new Thread(new MyPrimeThread(i, i + fiveTimes));
             th.start();

            i = i + fiveTimes + 1;
        }
    }
}


class Ch9MatchJavaIdentifier {
    private static final String STOP    = "STOP";
    private static final String VALID   = "Valid Java identifier";
    private static final String INVALID = "Not a valid Java identifier";

    private static final String VALID_IDENTIFIER_PATTERN
            = "[a-zA-Z][a-zA-Z0-9_$]*";

    public static void main (String[] args) {
        String str, reply;
        while (true) {
            str = JOptionPane.showInputDialog(null, "Identifier:");

            if (str.equals(STOP)) break;
            if (str.matches(VALID_IDENTIFIER_PATTERN)) {
                reply = VALID;

            } else {
                reply = INVALID;
            }
            JOptionPane.showMessageDialog(null,
                    str + ":\n" + reply);
        }
    }
}





