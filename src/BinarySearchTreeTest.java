import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Tests functionality of adding, removing and contains as well as Iterator functions.
 * All tests make use of advanced for-loops, which themselves utilise TreeIterators. So no test will pass
 * if the iterator functionality is not working.
 */
public class BinarySearchTreeTest {

    /**
     * Tests iteration through the tree by adding 100 elements (0-99) to the tree and then using an enhanced for-loop.
     * Checks that all numbers retrieved from the iteration are correct, and that no erroneous exceptions are thrown.
     */
    @Test
    public void testAdd() {
        //Test ability to get from the tree by adding number 0-99 to the tree and checking each time a number is added
        //that everything is as intended.
        try {
            addElements();
        } catch (NoSuchElementException e) {
            fail("Incorrectly threw NoSuchElementException when iterating through tree despite using valid enhanced for-loop");
        } catch (IllegalStateException e) {
            fail("Incorrectly threw IllegalStateException ");
        }
    }

    /**
     * Tests removal functionality of BST.
     * First adds 100 elements to the tree like in the testAdd() test, then iteratively removes these.
     */
    @Test
    public void testRemove() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree = addElements();

        //Tests ability to remove from the tree, by removing every element previously added.
        try {
            for (Integer number : tree) {
                tree.remove(number);
            }
        } catch (NoSuchElementException e) {
            fail("Incorrectly threw NoSuchElementException when iteratively removing from tree despite using valid enhanced for-loop");
        } catch (IllegalStateException e) {
            fail("Incorrectly threw IllegalStateException when removing elements iteratively");
        }
    }

    /**
     * Tests functionality of .contains() function of BinarySearchTree.
     * Adds 100 objects to the tree, and also adds these same objects to a List. Then iterates through the
     * List and checks that the tree's .contains() function can find all the values in the list.
     */
    @Test
    public void testContains() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        List<Integer> valuesAdded = new ArrayList<>();
        for (int i=0; i<100; i++) {
            Integer element = new Integer(i);
            tree.add(element);
            valuesAdded.add(element);
        }

        //Now look for the elements we added to the tree using contains().
        for (Integer number : valuesAdded) {
            if (!tree.contains(number)) {
                fail("contains() method did not return true for known values in the tree");
            }
        }
    }

    /**
     * Initialises a tree with 100 nodes, with integer values from 0 to 99. This is used in later tests
     * @return BinarySearchTree containing integers 0 to 99.
     */
    public BinarySearchTree<Integer> addElements() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        for (int i=0; i<100; i++) {
            tree.add(i);
            int j = 0;
            for (Integer number : tree) {
                assertEquals("Numbers added to tree do not match those retrieved from tree", j, (int) number);
                j++;
            }
        }
        return tree;
    }
}