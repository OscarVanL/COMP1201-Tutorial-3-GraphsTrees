import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Tests functionality of adding, removing and contains as well as Iterator functions.
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
            fail("Incorrectly threw IllegalStateException");
        }
    }

    /**
     * Tests removal functionality of BST.
     * First adds 100 elements to the tree like in the testAdd() test, then iteratively removes these.
     * If .remove() returns false when we try to remove an element contained in the tree, it is not working properly.
     */
    @Test
    public void testRemove() {
        BinarySearchTree<Integer> tree = addElements();
        boolean success = false;

        //Tests ability to remove from the tree, by removing every element previously added.
        try {
            for (Integer number : tree) {
                success = tree.remove(number);
                if (!success) {
                    fail("remove() method returned false for removing a node contained in BST");
                }

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
     * Tests .contains() functionality by checking for a node not present in the tree.
     */
    public void testNonContained() {
        BinarySearchTree<Integer> tree = addElements();
        if (tree.contains("Apples")) {
            fail(".contains() method returns true for an element not contained in BST");
        }
    }

    /**
     * Test BST's .remove() function by trying to remove a node that is not in the tree.
     */
    public void testRemoveNonContained() {
        BinarySearchTree tree = addElements();
        boolean success = tree.remove("Apples");
        if (success) {
            fail(".remove() returns true when trying to remove an element not contained in the tree");
        }
    }

    /**
     * Tests the Iterator's .hasNext() method works by filling a BST with numbers, then repeatedly running .hasNext()
     * and ensuring the function works as intended.
     */
    @Test
    public void testIteratorHasNext() {
        BinarySearchTree<Integer> tree = addElements();
        Iterator<Integer> iterator = tree.iterator();

        for (int i=0; i<101; i++) {
            if (i<=100) {
                if(!iterator.hasNext()) {
                    fail("Iterator returned false for hasNext() when it did have next node");
                }
            }
            if (i==101) {
                if (iterator.hasNext()) {
                    fail("Iterator returned true for hasNext() when it did not have a next node");
                }
            }
        }
    }

    /**
     * Tests the functionality of the Iterator's .next() method by filling a BST with numbers then iterating through
     * and checking .next() returns the expected numbers.
     */
    @Test
    public void testIteratorNext() {
        BinarySearchTree<Integer> tree = addElements();
        Iterator<Integer> iterator = tree.iterator();

        for (int i=0; i<100; i++) {
            if (iterator.next() != i) {
                fail("Iterator .next() does not match expected value");
            }
        }
    }

    /**
     * Tests the Iterator's .next() method will correctly throw an exception when we iterate past the size of the BST.
     * We fill the BST with 100 elements but run .next() 101 times. It should throw an exception on the 101st execution.
     */
    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextException() {
        BinarySearchTree<Integer> tree = addElements();
        Iterator<Integer> iterator = tree.iterator();

        for (int i=0; i<101; i++)
            iterator.next();
    }

    /**
     * We test the Iterator's .remove() method will correctly throw an exception if we run .remove() without having ever
     * ran .next()
     */
    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveException() {
        BinarySearchTree<Integer> tree = addElements();
        Iterator<Integer> iterator = tree.iterator();

        iterator.remove();
    }

    /**
     * Initialises a tree with 100 nodes, with integer values from 0 to 100. This is used in later tests
     * @return BinarySearchTree containing integers 0 to 100.
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