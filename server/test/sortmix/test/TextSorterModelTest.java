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
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test(expected = NonSortingModeException.class)
    public void testNullValues() throws NonSortingModeException, NoTextInputException {
        TextSorterModel model = new TextSorterModel();
        String result = model.process();
    }
    
    /**
     * Model should throw an NonSortingModeException
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test(expected = NonSortingModeException.class)
    public void testNullSortingMode() throws NonSortingModeException, NoTextInputException {
        TextSorterModel model = new TextSorterModel();
        model.setText("sample text");
        String result = model.process();
    }
    
    /**
     * Model should produce an empty string
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test(expected = NoTextInputException.class)
    public void testNullText() throws NonSortingModeException, NoTextInputException {
        TextSorterModel model = new TextSorterModel();
        model.setSortingMode(SortingMode.Sort);
        String result = model.process();
    }
    
    /**
     * Model should sort string without spaces
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testSortingWithoutSpaces() throws NonSortingModeException, NoTextInputException{
        TextSorterModel model = new TextSorterModel();
        model.setText("alamakota");
        model.setSortingMode(SortingMode.Sort);
        String result = model.process();
        assertEquals("Result string should be empty", "aaaaklmot", result);
    }
    
    /**
     * Model should remove whitespaces and sort the text
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testSortingWithSpaces() throws NonSortingModeException, NoTextInputException{
        TextSorterModel model = new TextSorterModel();
        model.setText("ala ma kota");
        model.setSortingMode(SortingMode.Sort);
        String result = model.process();
        assertEquals("Result string should be empty", "aaaaklmot", result);
    }
    
    /**
     * Model should remove all whitespaces and produce empty string
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testOnlyWhiteSpaces() throws NonSortingModeException, NoTextInputException{
        TextSorterModel model = new TextSorterModel();
        model.setText("          ");
        model.setSortingMode(SortingMode.Sort);
        String result = model.process();
        assertEquals("Result string should be empty", "", result);
    }
    
    /**
     * Model should produce the same result running twice
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testSortingTwice() throws NonSortingModeException, NoTextInputException{
        TextSorterModel model = new TextSorterModel();
        model.setText("ala ma kota");
        model.setSortingMode(SortingMode.Sort);
        String result = model.process();
        String secondResult = model.process();
        assertEquals("Result string should be empty", result, secondResult);
    }
    
    /**
     * Model should produce different string to given sorted text
     * @throws sortmix.model.NonSortingModeException
     * @throws sortmix.model.NoTextInputException
     */
    @Test
    public void testMixing() throws NonSortingModeException, NoTextInputException{
        TextSorterModel model = new TextSorterModel();
        model.setText("aaaaklmot");
        model.setSortingMode(SortingMode.Mix);
        String result = model.process();
        assertNotEquals("Result string should be empty", "aaaaklmot", result);
    }
}
