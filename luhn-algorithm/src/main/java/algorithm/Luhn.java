package main.java.algorithm;

public class Luhn {
    private final Long cardNum;

    public Luhn(String cardNum) {
        try {
            this.cardNum = Long.parseLong(cardNum);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("el valor introducido no es válido.");
        }
    }


    public boolean luhnAlgorithm () {
        Long finalCardNum = sumEvenDigits(this.cardNum);
        return verifyCard(finalCardNum);
    }


    private Long sumEvenDigits (Long cardNum) {
        String cardNumIndexed = cardNum.toString();
        StringBuilder finalNum = new StringBuilder();

        for (int i = 0; i < cardNumIndexed.length(); i++) {
            int finalDigit = Character.getNumericValue(cardNumIndexed.charAt(i));

            if (i % 2 == 0) {
                finalDigit *= 2;

                if (finalDigit >= 10) {
                    finalDigit = sumDigits(finalDigit);
                }
            }
            finalNum.append(finalDigit);
        }

        return Long.parseLong(finalNum.toString());
    }


    private int sumDigits(int number) {
        return (number / 10) + (number % 10);
    }


    private boolean verifyCard(Long finalNumber) {
        String finalNumberString = finalNumber.toString();
        int finalSum = 0;

        for(int i = 0; i < finalNumberString.length(); i++) {
            finalSum += Character.getNumericValue(finalNumberString.charAt(i));
        }

        return finalSum % 10 == 0;
    }
}