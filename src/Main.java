import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int[] myArray = new int[7];

        int indexCount = 0;
        int index;

        while (indexCount < 3) {
            index = rand.nextInt(7);
            if (myArray[index] == 0) {
                myArray[index] = 1;
                indexCount++;
            }
        }

        for(int i=0; i<myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }

        int numberOfTries = 0;
        int maxNumberOfTries = 5;

        boolean gameWon = false;

        while (!gameWon) {
            while (numberOfTries < maxNumberOfTries) {
                System.out.println("Enter three numbers between 1 and 7 where you think the boxes might be located");
                int suggestion1 = sc.nextInt() - 1;
                int suggestion2 = sc.nextInt() - 1;
                int suggestion3 = sc.nextInt() - 1;

                int correctGuesses = (myArray[suggestion1] == 1 ? 1:0) +
                                     (myArray[suggestion2] == 1 ? 1:0) +
                                     (myArray[suggestion3] == 1 ? 1:0);
                if (correctGuesses == 1) {
                    System.out.println("You found 1 box");
                } else if (correctGuesses == 2) {
                    System.out.println("You found 2 boxes");
                } else if (correctGuesses == 3) {
                    System.out.println("You found 3 boxes. Congratulations!");
                    gameWon = true;
                    break;
                } else{
                    System.out.println("You found nothing");
                }

                numberOfTries++;
            }
            if (gameWon == false && maxNumberOfTries == numberOfTries) {
                System.out.println("You have exceeded the maximum number of attempts, the boxes are shuffled again. ");
                while (indexCount < 3) {
                    indexCount = 0;
                    index = rand.nextInt(7);
                    if (myArray[index] == 0) {
                        myArray[index] = 1;
                        indexCount++;
                    }
                }

                for(int i=0; i<myArray.length; i++) {
                    System.out.print(myArray[i] + " ");
                }
                numberOfTries = 0;
            }
        }
    }
}
