import java.util.Scanner;

public class lab06 {

    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.print("Length will be counted:");
        str = scanner.nextLine();
        System.out.println(countLength(str));

        System.out.print("Non-Vowels will be counted:");
        str = scanner.nextLine();
        System.out.println(findNonVowels(str));
    }

    public static int countLength(String str) {
        if(str.length() == 0){
            return 0;
        }
        else
            return 1 + countLength(str.substring(1));
    }
    public static int findNonVowels(String str) {
        str = str.toLowerCase();
        if(str.length() == 0){
            return 0;
        }
        else if(!(str.charAt(0) == 'a' ||str.charAt(0) == 'e'||
                str.charAt(0) == 'u'||  str.charAt(0) == 'ı'
                || str.charAt(0) == 'o'|| str.charAt(0) == 'ü'
                || str.charAt(0) == 'i'||  str.charAt(0) == 'ö'
                || str.charAt(0) == ' ' || Character.isDigit(str.charAt(0))))
            return 1 + findNonVowels(str.substring(1));
        else
            return 0 + findNonVowels(str.substring(1));
    }
}
