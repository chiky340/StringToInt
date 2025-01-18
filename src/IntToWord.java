import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class IntToWord {

    private final HashMap<String,Integer> intNumber = new HashMap<>();
    private final HashMap<String,Integer> multiplier = new HashMap<>();

    IntToWord() {
        intNumber.put("one",1);
        intNumber.put("two",2);
        intNumber.put("three",3);
        intNumber.put("four",4);
        intNumber.put("five",5);
        intNumber.put("six",6);
        intNumber.put("seven",7);
        intNumber.put("eight",8);
        intNumber.put("nine",9);
        intNumber.put("ten",10);
        intNumber.put("eleven",11);
        intNumber.put("twelve",12);
        intNumber.put("thirteen",13);
        intNumber.put("fourteen",14);
        intNumber.put("fifteen",15);
        intNumber.put("sixteen",16);
        intNumber.put("seventeen",17);
        intNumber.put("eighteen",18);
        intNumber.put("nineteen",19);
        intNumber.put("twenty",20);
        intNumber.put("thirty",30);
        intNumber.put("forty",40);
        intNumber.put("fifty",50);
        intNumber.put("sixty",60);
        intNumber.put("seventy",70);
        intNumber.put("eighty",80);
        intNumber.put("ninety",90);

        multiplier.put("hundred",100);
        multiplier.put("thousand",1_000);
        multiplier.put("million",1_000_000);

    }

    public void calc() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter an input: ");
        String input = scanner.nextLine();
        int result = wordsToNumber(input);
        System.out.println(input + " is: " + NumberFormat.getCurrencyInstance().format(result));
    }

    private int wordsToNumber(String words) {
        String[] tokens = words.toLowerCase().split("\\s+");
        int current = 0;
        int total = 0;

        for (String token : tokens) {
            if (intNumber.containsKey(token)) {
                current += intNumber.get(token);
            } else if (multiplier.containsKey(token)) {
                current *= multiplier.get(token);
                if (multiplier.get(token) > 100) {
                    total += current;
                    current = 0;
                }
            }
        }
        return total + current;
    }

}

