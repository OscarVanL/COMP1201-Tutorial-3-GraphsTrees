import java.util.Arrays;
import java.util.Random;

public class AverageDepthFinder {

    public static void main(String args[]) {
        Random rand = new Random();

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

        double[] depths = new double[10];

        BinarySearchTree<Integer> bst;

        for (int repeats=0; repeats<10; repeats++) {
            bst = new BinarySearchTree<>();
            for (int i=0; i<inputAmount; i++) {
                bst.add(rand.nextInt(1000000000));
            }
            System.out.println("Average depth: " + bst.getAverageDepth());
            depths[repeats] = bst.getAverageDepth();
        }

        System.out.println("Median value: " + median(depths));
    }

    public static double median(double[] a) {
        Arrays.sort(a);
        return a[a.length/2];
    }

    public static boolean isInteger(String str) {
        try {
            int test = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
