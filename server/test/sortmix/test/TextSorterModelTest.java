package sortmix.test;

import org.junit.*;
import static org.junit.Assert.*;
import sortmix.common.SortingMode;
import sortmix.model.NoTextInputException;
import sortmix.model.NonSortingModeException;
import sortmix.model.TextSorterModel;

/**
 * Test class for TextSorterModel
 *
 * @author Dariusz Opitek
 * @version 1.1
 */
public class TextSorterModelTest {

    /**
     * Model should throw an NonSortingModeException
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test(expected = NonSortingModeException.class)
    public void testNullValues() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.process();
        } catch (NoTextInputException ex) {
            fail("Wrong exception thrown");
        }
    }

    /**
     * Model should throw an NonSortingModeException
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test(expected = NonSortingModeException.class)
    public void testNullSortingMode() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.setText("sample text");
            String result = model.process();
        } catch (NoTextInputException ex) {
            fail("Wrong exception thrown");
        }

    }

    /**
     * Model should produce an empty string
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test(expected = NoTextInputException.class)
    public void testNullText() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.setSortingMode(SortingMode.SORT);
            String result = model.process();
        } catch (NonSortingModeException ex) {
            fail("Wrong exception thrown");
        }
    }

    /**
     * Model should sort string without spaces
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testSortingWithoutSpaces() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.setText("alamakota");
            model.setSortingMode(SortingMode.SORT);
            String result = model.process();
            assertEquals("Result string should be empty", "aaaaklmot", result);
        } catch (NonSortingModeException | NoTextInputException ex) {
            fail("Exception thrown");
        }

    }

    /**
     * Model should remove whitespaces and sort the text
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testSortingWithSpaces() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.setText("ala ma kota");
            model.setSortingMode(SortingMode.SORT);
            String result = model.process();
            assertEquals("Result string should be empty", "aaaaklmot", result);
        } catch (NonSortingModeException | NoTextInputException ex) {
            fail("Exception thrown");
        }
    }

    /**
     * Model should remove all whitespaces and produce empty string
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testOnlyWhiteSpaces() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.setText("          ");
            model.setSortingMode(SortingMode.SORT);
            String result = model.process();
            assertEquals("Result string should be empty", "", result);
        } catch (NonSortingModeException | NoTextInputException ex) {
            fail("Exception thrown");
        }
    }

    /**
     * Model should produce the same result running twice
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testSortingTwice() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.setText("ala ma kota");
            model.setSortingMode(SortingMode.SORT);
            String result = model.process();
            String secondResult = model.process();
            assertEquals("Result string should be empty", result, secondResult);
        } catch (NonSortingModeException | NoTextInputException ex) {
            fail("Exception thrown");
        }
    }

    /**
     * Model should produce different string to given sorted text
     *
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testMixing() throws NonSortingModeException, NoTextInputException {
        try {
            TextSorterModel model = new TextSorterModel();
            model.setText("aaaaklmot");
            model.setSortingMode(SortingMode.MIX);
            String result = model.process();
            assertNotEquals("Result string should be empty", "aaaaklmot", result);
        } catch (NonSortingModeException | NoTextInputException ex) {
            fail("Exception thrown");
        }
    }
}
