import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int[] myArray = new int[7];
        int numOfTries = 0;
        int maxNumOfTries = 5;
        boolean gameWon = false;

        shuffleBoxes(myArray, rand);
        System.out.println("Hello! Help me find the boxes,please.");

        while (!gameWon) {
            while (numOfTries < maxNumOfTries) {
                int[] suggestions = getGuesses(sc);
                gameWon = showResult(myArray, suggestions, numOfTries, maxNumOfTries, gameWon);
                numOfTries++;

                if(gameWon){
                    showBoxes(myArray);
                    break;
                }
            }

            if (!gameWon) {
                showBoxes(myArray);
                clearScreen();
                System.out.println("You have exceeded the maximum number of attempts, the boxes are shuffled again. ");
                shuffleBoxes(myArray, rand);
                numOfTries = 0;
            }
        }

        System.out.println("\nThanks for your help!");
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

    public static int[] getGuesses(Scanner sc) {
        int[] suggestions = new int[3];
        System.out.println("\nEnter three numbers between 1 and 7 where you think the boxes might be located");
        for (int i = 0; i < 3; i++) {
            suggestions[i] = sc.nextInt() - 1;
            while (suggestions[i] < 0 || suggestions[i] > 6) {
                System.out.println("Please enter numbers between 1 and 7.");
                suggestions[i] = sc.nextInt() - 1;
            }
        }
        return suggestions;
    }

    public static boolean showResult(int [] myArray, int[] suggestions, int numOfTries, int maxNumOfTries, boolean gameWon) {
        int correctGuesses = (myArray[suggestions[0]] == 1 ? 1:0) +
                (myArray[suggestions[1]] == 1 ? 1:0) +
                (myArray[suggestions[2]] == 1 ? 1:0);

        if (correctGuesses == 1) {
            System.out.println("You found 1 box");
        } else if (correctGuesses == 2) {
            System.out.println("You found 2 boxes");
        } else if (correctGuesses == 3) {
            System.out.println("You found 3 boxes. Congratulations!");
            return true;
        } else{
            System.out.println("You found nothing");
        }
        showTries(maxNumOfTries, numOfTries);
        return false;
    }

    public static void showTries(int maxNumOfTries, int numOfTries) {
        String result = (maxNumOfTries-numOfTries-1) == 1 ? "attempt" : "attempts";
        System.out.println("You have " + (maxNumOfTries-numOfTries-1) + " " + result + " left.");
    }

    public static void clearScreen() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the screen.");
        }
    }
}