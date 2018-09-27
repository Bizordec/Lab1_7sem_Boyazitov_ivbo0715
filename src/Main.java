import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        File file = new File("text.txt");
//        String myText = new String(Files.readAllBytes(Paths.get(file.getPath())));
//
//        String cryptedText = (new CryptDecrypt(myText.toLowerCase(), 2)).crypt();
//        System.out.println(cryptedText);
//
//        System.out.println();
//
//        String decryptedText = (new CryptDecrypt(cryptedText, 2)).decrypt();
//        System.out.println(decryptedText);
//
//        System.out.println();
//
//        File file2 = new File("lt1.txt");
//        String vnm = new String(Files.readAllBytes(Paths.get(file.getPath())));

//        Scanner myText2 = new Scanner(new File("text.txt"));
//        (new CryptDecrypt(myText2)).showFrequency();

        new CryptDecrypt("атестяеё", 3);
    }
    }

class CryptDecrypt {
    private char[] textArr;
    private final String alphabet1 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final char[] alphabet = alphabet1.toCharArray();
    private final int firstLetter = alphabet[0];
    private final int size = alphabet.length;
    private int countAL[] = new int[size];
    private double countTL;

    CryptDecrypt(Scanner file) {
        while (file.hasNextLine()) {
            textArr = file.nextLine().toCharArray();
            countTL += textArr.length;
            frequency();
        }
    }

    CryptDecrypt(String text) {
        textArr = text.toCharArray();
    }

    CryptDecrypt(String text, int shift) {
        textArr = text.toCharArray();

        for (int i = 0; i < textArr.length; i++) {
            //ниже костыль для ё
            int index_element = (textArr[i] == 'ё'? textArr[i] - ('ё'-'е') : textArr[i]) - firstLetter;
            int if_e = (int) textArr[i] > 'е'? 1 : 0;
            int offset = (index_element + if_e + shift) % size;
//            int offset = (alphabet1.indexOf(textArr[i]) + shift) % size;
            textArr[i] = alphabet[offset];
        }
        System.out.println(textArr);
//        for (int i = shift, j = 0; i < size; i++, j++) {
//            cryptAlphabet[j] = srcAlphabet[i];
//        }
//
//        for (int i = 0, j = size - shift; j < size; i++, j++) {
//            cryptAlphabet[j] = srcAlphabet[i];
//        }
    }


//    String crypt() {
//        for (int i = 0; i < textArr.length; i++) {
//            for (int j = 0; j < size; j++) {
//                if (textArr[i] == srcAlphabet[j]) {
//                    textArr[i] = cryptAlphabet[j];
//                    break;
//                }
//            }
//        }
//        System.out.println(srcAlphabet);
//        System.out.println(cryptAlphabet);
//        return String.valueOf(textArr);
//    }
//
//    String decrypt() {
//        for (int i = 0; i < textArr.length; i++) {
//            for (int j = 0; j < size; j++) {
//                if (textArr[i] == cryptAlphabet[j]) {
//                    textArr[i] = srcAlphabet[j];
//                    break;
//                }
//            }
//        }
//        System.out.println(cryptAlphabet);
//        System.out.println(srcAlphabet);
//        return String.valueOf(textArr);
//    }

    void frequency() {
        for (char letter : textArr) {
            switch (letter) {
                case 'а':
                    countAL[0]++;
                    break;
                case 'б':
                    countAL[1]++;
                    break;
                case 'в':
                    countAL[2]++;
                    break;
                case 'г':
                    countAL[3]++;
                    break;
                case 'д':
                    countAL[4]++;
                    break;
                case 'е':
                    countAL[5]++;
                    break;
                case 'ё':
                    countAL[6]++;
                    break;
                case 'ж':
                    countAL[7]++;
                    break;
                case 'з':
                    countAL[8]++;
                    break;
                case 'и':
                    countAL[9]++;
                    break;
                case 'й':
                    countAL[10]++;
                    break;
                case 'к':
                    countAL[11]++;
                    break;
                case 'л':
                    countAL[12]++;
                    break;
                case 'м':
                    countAL[13]++;
                    break;
                case 'н':
                    countAL[14]++;
                    break;
                case 'о':
                    countAL[15]++;
                    break;
                case 'п':
                    countAL[16]++;
                    break;
                case 'р':
                    countAL[17]++;
                    break;
                case 'с':
                    countAL[18]++;
                    break;
                case 'т':
                    countAL[19]++;
                    break;
                case 'у':
                    countAL[20]++;
                    break;
                case 'ф':
                    countAL[21]++;
                    break;
                case 'х':
                    countAL[22]++;
                    break;
                case 'ц':
                    countAL[23]++;
                    break;
                case 'ч':
                    countAL[24]++;
                    break;
                case 'ш':
                    countAL[25]++;
                    break;
                case 'щ':
                    countAL[26]++;
                    break;
                case 'ъ':
                    countAL[27]++;
                    break;
                case 'ы':
                    countAL[28]++;
                    break;
                case 'ь':
                    countAL[29]++;
                    break;
                case 'э':
                    countAL[30]++;
                    break;
                case 'ю':
                    countAL[31]++;
                    break;
                case 'я':
                    countAL[32]++;
                    break;
            }
        }

    }

//    void showFrequency() {
//        double freqL;
//        for (int i = 0; i < size; i++) {
//            freqL = (countAL[i]/countTL)*100;
//            System.out.println(srcAlphabet[i] + ": " + freqL);
//        }
//    }
}
