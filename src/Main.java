import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int[] myArray = new int[7];

        int suggestion1 = sc.nextInt();
        int suggestion2 = sc.nextInt();
        int suggestion3 = sc.nextInt();

        int indexCount = 0;
        int index;

        while(indexCount <3) {
            index = rand.nextInt(7);
            if(myArray[index] == 0) {
                myArray[index] = 1;
            }
            indexCount++;
        }

        for(int i=0; i<myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }




    }
}