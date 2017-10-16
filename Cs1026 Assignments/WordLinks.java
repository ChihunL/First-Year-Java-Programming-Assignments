
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

public class WordLinks {
    public static void main(String[] args)
    {
        In in0 =new In("words.txt");
        String[] dictionary;
        dictionary= readDictionary(in0);
        boolean finished=false;
        Scanner userInput;
        while(!finished){
            System.out.println("Enter a comma separated list of words (or an empty list to " +
                    "quit):");
            userInput = new Scanner(System.in);

            String input = userInput.hasNextLine() ? userInput.nextLine() : "";
            if (!input.isEmpty()) {

                String[] wordChain = readWordList(input);
                if (isWordChain(wordChain, dictionary))
                    System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
                else
                    System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
            }
            else if(input.isEmpty()){
                finished=true;
                System.out.println("Goodbye.");

            }
            else {
                System.out.println("Invalid Input. Try again.");
            }
        }
    }


    public static String[] readDictionary(In dictionary) {
        return dictionary.readAllLines();
    }
    public static String[] readWordList(String userInput) {

        String [] s = userInput.split("\\s*,\\s*");
        for(int i = 0; i<s.length;i++)
        {
            s[i]= s[i].replaceAll("\\s", "");
        }

        return s;
    }
    public static boolean isUniqueList(String[] wordChain) {

        if(wordChain!=null) {
            boolean unique  = true;
            for (int index = 0; index < wordChain.length-1; index++) {
                for (int index2 = index+1; index2 < wordChain.length; index2++) {
                    unique = !wordChain[index].equals(wordChain[index2]);
                    if(unique==false)
                        return false;
                }
            }
            return unique;
        }
        return false;
    }
    public static boolean isEnglishWord(String word, String[] dictionary) {
        int d = binarySearch(dictionary, word);
        if(d>0)
            return true;
        return false;
    }
    public static boolean isDifferentByOne(String word1, String word2)
    {
        char[] first  = word1.toLowerCase().toCharArray();
        char[] second = word2.toLowerCase().toCharArray();
        if(first.length!=second.length)
            return false;
        int count =0;
        for(int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                count++;
            }
        }
        if(count==1)
            return true;
        return false;
    }

    public static boolean isWordChain(String[] wordChain, String[] dictionary) {
        if(isUniqueList(wordChain)){
            boolean isEnglish =true;
            for(int index=0; index<wordChain.length;index++)
            {
                isEnglish = isEnglishWord(wordChain[index], dictionary);
                if(isEnglish==false)
                     return false;
            }
            boolean differsByOne = true;
            for(int index=0; index<wordChain.length-1;index++){
                differsByOne = isDifferentByOne(wordChain[index], wordChain[index+1]);
                if(!differsByOne)
                    return false;
            }
            return true;
        }

        return false;
    }
}

