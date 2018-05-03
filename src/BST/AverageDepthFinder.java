package bst;

import java.util.Arrays;
import java.util.Random;

public class AverageDepthFinder {

    public static void main(String args[]) {
        int inputAmount;
        if (args.length == 0 ) {
            System.out.println("You must give an integer amount of elements to add to the tree as argument");
            inputAmount = 0;
        } else if (isInteger(args[0])) {
            System.out.println("Running with " + args[0] + " nodes.");
            inputAmount = Integer.parseInt(args[0]);
        } else {
            System.out.println("Non integer argument given.");
            inputAmount = 0;
        }

        findAverageDepth(inputAmount);
    }

    /**
     * Generates a BST filled with a set amount of random numbers and calculates the mean depth. It does this multiple times
     * and finds the median value.
     * @param inputAmount : Number of random numbers to add to the BST.
     */
    public static void findAverageDepth(int inputAmount) {
        Random rand = new Random();
        double[] depths = new double[10];

        BinarySearchTree<Integer> bst;

        for (int repeats=0; repeats<10; repeats++) {
            bst = new BinarySearchTree<>();
            for (int i=0; i<inputAmount; i++) {
                bst.add(rand.nextInt(1000000000));
            }
            System.out.println("Average depth: " + bst.getMeanDepth());
            depths[repeats] = bst.getMeanDepth();
        }

        System.out.println("Median value: " + median(depths));
    }

    /**
     * Finds the median of an array of doubles
     * @param a : Array
     * @return : Median value of array.
     */
    public static double median(double[] a) {
        Arrays.sort(a);
        return a[a.length/2];
    }

    /**
     * Determines if string argument given when executing the program is a valid integer.
     * @param str : String argument
     * @return : True (if a valid Integer), False (if not valid)
     */
    public static boolean isInteger(String str) {
        try {
            int test = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
