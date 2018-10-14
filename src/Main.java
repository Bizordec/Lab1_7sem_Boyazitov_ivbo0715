import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

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
//
        Scanner myText2 = new Scanner(new File("text.txt"));
//        (new CryptDecrypt(myText2)).showFrequency();
        String srcText = "вчера";
//        System.out.println(srcText);
//        String newText = new CryptDecrypt(srcText).crypt(2);
//        System.out.println(newText);
//        System.out.println(new CryptDecrypt(newText).decrypt(2));

        new CryptDecrypt(srcText).freq2();
    }
}

class CryptDecrypt {
    //    private char[] textArr;
    private List<char[]> textList = new ArrayList<>();
    private final char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    private final int alphSize = alphabet.length;
    private final int countAlph[] = new int[alphSize];

    CryptDecrypt(Scanner file) {
        while (file.hasNextLine()) {
            String string = file.nextLine().toLowerCase();
            textList.add(string.toCharArray());
        }
    }

    CryptDecrypt(String text) {
        textList.add(text.toCharArray());
    }

    List<char[]> crypt(int shift) {
        final int firstLetter = alphabet[0];
        for (char[] string : textList) {
            for (int i = 0; i < string.length; i++) {
                int if_e2 = (string[i] == 'ё' ? string[i] - ('ё' - 'е') : string[i]);
                int if_after_e = (string[i] > 'е' ? 1 : 0);
                int indexL = (if_e2 + if_after_e) - firstLetter;

                int offset = (indexL + shift) % alphSize;
                string[i] = alphabet[offset];
            }
        }
        return textList;
    }

    List<char[]> decrypt(int shift) {
        return crypt(-shift);
    }

    void freq2() {
        List<String> bigramList = new ArrayList<>();
        for (char[] string : textList) {
            StringBuilder bigram = new StringBuilder();
            for (int i = 0; i < string.length; i++) {
                if (string[i] == ' ')
                    bigram = new StringBuilder();
                for (int b = 0, e = alphSize - 1; b < alphSize || e > 0; b++, e--) {
                    if (string[i] == alphabet[b] || string[i] == alphabet[e]) {
                        bigram.append(string[i]);
                        if (bigram.length() > 1) {
                            //StringBuilder в HashMap повторяется, поэтому используется String
                            String bigramString = bigram.toString();
                            bigramList.add(bigramString);
                            bigram = new StringBuilder();
                            i--;
                        }
                        break;
                    }
                }
            }
            bigram = new StringBuilder();
        }
        HashMap<String, Integer> bigramMap = new HashMap<>();
        HashSet<String> bigramKeys = new HashSet<>();
        for (String bigram : bigramList) {
            if(!bigramMap.containsKey(bigram)) {
                bigramMap.put(bigram, 0);
                bigramKeys.add(bigram);
            }
        }
        for (String bigram : bigramList) {
            for (int i = 0; i < bigramMap.size(); i++) {
                if(bigramMap.containsKey(bigram)) {
                    bigramMap.replace(bigram, bigramMap.get(bigram) + 1);
                    break;
                }
            }
        }
        for (String bigramKey : bigramKeys)
            System.out.println(bigramKey + ": " + bigramMap.get(bigramKey));
    }

    void freq() {
        int countRus = 0;
        for (char[] string : textList) {
            for (char letter : string) {
                for (int b = 0, e = alphSize - 1; b < alphSize || e > 0; b++, e--) {
                    if (letter == alphabet[b]) {
                        countRus++;
                        countAlph[b]++;
                        break;
                    } else if(letter == alphabet[e]) {
                        countRus++;
                        countAlph[e]++;
                        break;
                    }
                }
            }
        }


        System.out.println("Количество русских букв в тексте: " + countRus);
        for (int i = 0; i < alphSize; i++) {
            double freq = 100.0 * countAlph[i] / countRus;
            String formattedFreq = new DecimalFormat("#0.00").format(freq);
            System.out.println(alphabet[i] + ": " + formattedFreq + " %");
        }
    }
}
