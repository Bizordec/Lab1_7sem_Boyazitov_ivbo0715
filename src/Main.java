import java.io.IOException;
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
        String srcText = "вчера";
        System.out.println(srcText);
        String newText = new CryptDecrypt(srcText).crypt(2);
        System.out.println(newText);
        System.out.println(new CryptDecrypt(newText).decrypt(2));
    }
    }

class CryptDecrypt {
    private char[] textArr;
    private final char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    private int firstL = alphabet[0];
    private final int size = alphabet.length;
    private int countAL[] = new int[size];
    private double countTL;

    CryptDecrypt(Scanner file) {
        while (file.hasNextLine()) {
            textArr = file.nextLine().toCharArray();
            countTL += textArr.length;
        }
    }

    CryptDecrypt(String text) {
        textArr = text.toCharArray();
    }

    private int indexL (char letter) {
        int if_e2 = (letter == 'ё' ? letter - ('ё'-'е') : letter);
        int if_after_e = (letter > 'е'? 1 : 0);
        return (if_e2 + if_after_e) - firstL;
    }

    String crypt(int shift) {
        for (int i = 0; i < textArr.length; i++) {
            int offset = (indexL(textArr[i]) + shift) % size;
            textArr[i] = alphabet[offset];
        }
        return String.valueOf(textArr);
    }

    String decrypt(int shift) {
        for (int i = 0; i < textArr.length; i++) {
            int offset = (indexL(textArr[i]) - shift) % size;
            textArr[i] = alphabet[offset];
        }
        return String.valueOf(textArr);
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
