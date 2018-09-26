import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        String myText = new String(Files.readAllBytes(Paths.get(file.getPath())));

        String cryptedText = (new CryptDecrypt(myText.toLowerCase(), 2)).crypt();
        System.out.println(cryptedText);

        System.out.println();

        String decryptedText = (new CryptDecrypt(cryptedText, 2)).decrypt();
        System.out.println(decryptedText);

        System.out.println();

        File file2 = new File("lt1.txt");
        String vnm = new String(Files.readAllBytes(Paths.get(file.getPath())));

        (new CryptDecrypt(vnm.toLowerCase())).frequency();
        }
    }

class CryptDecrypt {
    private char[] textArr;
    private char[] srcAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    private int size = srcAlphabet.length;
    private char[] cryptAlphabet = new char[size];

    CryptDecrypt(String text) {
        textArr = text.toCharArray();
    }

    CryptDecrypt(String text, int shift) {
        textArr = text.toCharArray();
        for (int i = shift, j = 0; i < size; i++, j++) {
            cryptAlphabet[j] = srcAlphabet[i];
        }

        for (int i = 0, j = size - shift; j < size; i++, j++) {
            cryptAlphabet[j] = srcAlphabet[i];
        }
    }

    String crypt() {
        for (int i = 0; i < textArr.length; i++) {
            for (int j = 0; j < srcAlphabet.length; j++) {
                if (textArr[i] == srcAlphabet[j]) {
                    textArr[i] = cryptAlphabet[j];
                    break;
                }
            }
        }
        System.out.println(srcAlphabet);
        System.out.println(cryptAlphabet);
        return String.valueOf(textArr);
    }

    String decrypt() {
        for (int i = 0; i < textArr.length; i++) {
            for (int j = 0; j < cryptAlphabet.length; j++) {
                if (textArr[i] == cryptAlphabet[j]) {
                    textArr[i] = srcAlphabet[j];
                    break;
                }
            }
        }
        System.out.println(cryptAlphabet);
        System.out.println(srcAlphabet);
        return String.valueOf(textArr);
    }

    void frequency() {
        int counts[] = new int[srcAlphabet.length];
        for (char letter : textArr) {
            switch (letter) {
                case 'а':
                    counts[0]++;
                    break;
                case 'б':
                    counts[1]++;
                    break;
                case 'в':
                    counts[2]++;
                    break;
                case 'г':
                    counts[3]++;
                    break;
                case 'д':
                    counts[4]++;
                    break;
                case 'е':
                    counts[5]++;
                    break;
                case 'ё':
                    counts[6]++;
                    break;
                case 'ж':
                    counts[7]++;
                    break;
                case 'з':
                    counts[8]++;
                    break;
                case 'и':
                    counts[9]++;
                    break;
                case 'й':
                    counts[10]++;
                    break;
                case 'к':
                    counts[11]++;
                    break;
                case 'л':
                    counts[12]++;
                    break;
                case 'м':
                    counts[13]++;
                    break;
                case 'н':
                    counts[14]++;
                    break;
                case 'о':
                    counts[15]++;
                    break;
                case 'п':
                    counts[16]++;
                    break;
                case 'р':
                    counts[17]++;
                    break;
                case 'с':
                    counts[18]++;
                    break;
                case 'т':
                    counts[19]++;
                    break;
                case 'у':
                    counts[20]++;
                    break;
                case 'ф':
                    counts[21]++;
                    break;
                case 'х':
                    counts[22]++;
                    break;
                case 'ц':
                    counts[23]++;
                    break;
                case 'ч':
                    counts[24]++;
                    break;
                case 'ш':
                    counts[25]++;
                    break;
                case 'щ':
                    counts[26]++;
                    break;
                case 'ъ':
                    counts[27]++;
                    break;
                case 'ы':
                    counts[28]++;
                    break;
                case 'ь':
                    counts[29]++;
                    break;
                case 'э':
                    counts[30]++;
                    break;
                case 'ю':
                    counts[31]++;
                    break;
                case 'я':
                    counts[32]++;
                    break;
            }
        }
        for (int i = 0; i < srcAlphabet.length; i++) {
            System.out.println(srcAlphabet[i] + ": " + counts[i]);
        }

    }
}
