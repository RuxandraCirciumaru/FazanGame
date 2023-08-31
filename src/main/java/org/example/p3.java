package org.example;


import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class p3 {
    public static void main(String[] args) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 1;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti un cuvant care sa inceapa cu litera " + generatedString );
        String cuvant = sc.nextLine();
        if (cuvant.startsWith(generatedString)){
            System.out.println("Jocul continua");
        }else {
            System.out.println("Introduceti un cuvant care sa inceapa cu litera " + generatedString );
        }

        while (true){
            String lastLetters = cuvant.substring(cuvant.length() - 2);
            System.out.println("Introduceti un cuvant care sa inceapa cu: " + lastLetters);
            cuvant = sc.nextLine();

            if(cuvant.isEmpty() || !cuvant.startsWith(lastLetters)){
                System.out.println("Joc terminat");
                break;
            }
        }




    }
}
