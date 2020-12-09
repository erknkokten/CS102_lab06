import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class lab06 {
    static ArrayList<String> binary;

    public static void main (String args[]){

        File file = new File("D:\\EEE\\EE3.2\\ENG 401");

        Scanner scanner = new Scanner(System.in);
        String str;
        int n;

        do {
            System.out.println("Menu: \n" +
                    "1- Length\n" +
                    "2- Non-Vowel Count\n" +
                    "3- Binary\n" +
                    "4- File");
            n = scanner.nextInt();
            scanner.nextLine();
            if (n == 1) {
                System.out.print("Length will be counted:");
                str = scanner.nextLine();
                System.out.println(countLength(str));
            } else if (n == 2) {
                System.out.print("Non-Vowels will be counted:");
                str = scanner.nextLine();
                System.out.println(findNonVowels(str));
            }
            else if(n == 3){
                binary = new ArrayList<String>();
                System.out.print("Enter the length of the binary string:");
                int length = scanner.nextInt();
                scanner.nextLine();
                binaryString(length,"");

            }
            else if(n==4)
                System.out.println(findNumberOfFiles(file, 0, 0,0));
        }while (n != 0);
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


    public static void binaryString(int length, String str ){


        if(str.length() == length){

            System.out.println(str);
        }
        else if(!str.equals("")){
            if(str.charAt(str.length()-1) == '1'){
                binaryString(length, str + "0");
            }
            else if(str.charAt(str.length()-1) == '0' ){
                binaryString(length, str + "1");
                binaryString(length, str + "0");
            }
        }
        else{
            binaryString(length, str + "1");
            binaryString(length, str + "0");
        }

    }

    public static int findNumberOfFiles(File file, int numOfFiles, int totalNumOfFiles, int notFileIndex){
        if(file.listFiles().length == numOfFiles){
                return totalNumOfFiles;
        }
        else if(file.listFiles()[numOfFiles].isFile())
            return findNumberOfFiles(file, numOfFiles+1, totalNumOfFiles+1,notFileIndex);

        else {

            return findNumberOfFiles(new File(file.listFiles()[numOfFiles].toString()),0,0,0) + findNumberOfFiles(file, numOfFiles + 1, totalNumOfFiles, notFileIndex);
        }
    }



}
