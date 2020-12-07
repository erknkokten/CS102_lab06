import java.util.Scanner;

public class lab06 {

    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.print("Length will be counted:");
        str = scanner.nextLine();
        System.out.print(countLength(str));
    }

    public static int countLength(String str) {
        if(str.length() == 0){
            return 0;
        }
        else
            return 1 + countLength(str.substring(1));


    }
}
