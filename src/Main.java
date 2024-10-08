import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int[] myArray = new int[7];

        shuffleBoxes(myArray, rand);

        int numOfTries = 0;
        int maxNumOfTries = 5;

        boolean gameWon = false;

        while (!gameWon) {
            while (numOfTries < maxNumOfTries) {
                System.out.println("\nEnter three numbers between 1 and 7 where you think the boxes might be located");
                int suggestion1 = sc.nextInt() - 1;
                int suggestion2 = sc.nextInt() - 1;
                int suggestion3 = sc.nextInt() - 1;

                int correctGuesses = (myArray[suggestion1] == 1 ? 1:0) +
                                     (myArray[suggestion2] == 1 ? 1:0) +
                                     (myArray[suggestion3] == 1 ? 1:0);

                if (correctGuesses == 1) {
                    System.out.println("You found 1 box");
                    showTries(maxNumOfTries, numOfTries);
                } else if (correctGuesses == 2) {
                    System.out.println("You found 2 boxes");
                    showTries(maxNumOfTries, numOfTries);
                } else if (correctGuesses == 3) {
                    System.out.println("You found 3 boxes. Congratulations!");
                    gameWon = true;
                    break;
                } else{
                    System.out.println("You found nothing");
                    showTries(maxNumOfTries, numOfTries);
                }
                numOfTries++;
            }

            if (maxNumOfTries == numOfTries) {
                int i = 0;
                showBoxes(myArray);
                System.out.println("\nYou have exceeded the maximum number of attempts, the boxes are shuffled again. ");
                shuffleBoxes(myArray, rand);
                numOfTries = 0;
            }
        }
    }

    public static void shuffleBoxes(int [] myArray, Random rand) {
            int indexCount = 0;
            int index;
            int k = 0;

            for(;k<7;k+=1){
                myArray[k] = 0;
            }

            while (indexCount < 3) {
                index = rand.nextInt(7);
                if (myArray[index] == 0) {
                    myArray[index] = 1;
                    indexCount++;
                }
            }
    }

    public static void showBoxes(int [] myArray) {
        int i = 0;
        System.out.println("\nThat's where the boxes were hidden:");
        for(; i<myArray.length; i+=1) {
            System.out.print(myArray[i] + " ");
        }
    }

    public static void showTries(int maxNumOfTries, int numOfTries) {
        String result = (maxNumOfTries-numOfTries-1) == 1 ? "attempt" : "attemps";
        System.out.println("You have " + (maxNumOfTries-numOfTries-1) + " " + result + " left.");
    }


}
