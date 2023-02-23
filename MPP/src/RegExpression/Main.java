package RegExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println(Pattern.matches("[ayz]?","amnta"));

//        //Q2
//        //[a-z]{2}[1-9]{4}[a-z]{3}
//        String str = "ab1234abc";
//        String str2 = "ab1c234abc";
//        String str3 = "abc12345abc";
//        String str4 = "ab1c234abcd";
//
//        System.out.println(str + " => Matches: "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+str.matches("[a-z]{2}[1-9]{4}[a-z]{3}"));
//        System.out.println(str2 + " => Matches: "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+str2.matches("[a-z]{2}[1-9]{4}[a-z]{3}"));
//        System.out.println(str3 + " => Matches: "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+str3.matches("[a-z]{2}[1-9]{4}[a-z]{3}"));
//        System.out.println(str4 + " => Matches: "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+str4.matches("[a-z]{2}[1-9]{4}[a-z]{3}"));
//        System.out.println();
//    //////
//        //Q3
//        String str5 = "my age is 8 , and i have 8 brothers";
//        str5 = str5.replaceAll("[8]","eight");
//        System.out.println(str5);
//        System.out.println();
//
//        /////////
//        //Q4 - Q2
//        Pattern pattern = Pattern.compile("[a-z]{2}[1-9]{4}[a-z]{3}");
//        Matcher matcher = pattern.matcher(str);
//        Matcher matcher2 = pattern.matcher(str2);
//        Matcher matcher3 = pattern.matcher(str3);
//        Matcher matcher4 = pattern.matcher(str4);
//
//        System.out.println(str + " => Pattern "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+matcher.matches());
//        System.out.println(str2 + " => Pattern: "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+matcher2.matches());
//        System.out.println(str3 + " => Pattern: "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+matcher3.matches());
//        System.out.println(str4 + " => Pattern: "+"[a-z]{2}[1-9]{4}[a-z]{3} => "+matcher4.matches());
//
//        System.out.println();
//
//        //Q4 - Q
//        Pattern pattern2 = Pattern.compile("[8]");
//        String replaced = pattern2.matcher(str5).replaceAll("eight");
//
//        System.out.println(replaced);
//        System.out.println();



    }
    public static String myReplaceAll(String original,  String replacement,String regex) {
        return Pattern.compile(regex).matcher(original).replaceAll(replacement);
    }

    public boolean myMatches(String original,String regex) {
        return Pattern.matches(regex, original);
    }
}
