package sortmix.test;

import org.junit.*;
import static org.junit.Assert.*;
import sortmix.common.SortingMode;
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
     */
    @Test(expected = NonSortingModeException.class)
    public void testNullValues() throws NonSortingModeException {
        TextSorterModel model = new TextSorterModel(null, null);
        String result = model.process();
    }
    
    /**
     * Model should throw an NonSortingModeException
     * @throws sortmix.model.NonSortingModeException
     */
    @Test(expected = NonSortingModeException.class)
    public void testNullSortingMode() throws NonSortingModeException {
        TextSorterModel model = new TextSorterModel("sample text", null);
        String result = model.process();
    }
    
    /**
     * Model should produce an empty string
     * @throws sortmix.model.NonSortingModeException
     */
    @Test
    public void testNullText() throws NonSortingModeException {
        TextSorterModel model = new TextSorterModel(null, SortingMode.Mix);
        String result = model.process();
        assertEquals("Result string should be empty", "", result);
    }
    
    /**
     * Model should sort string without spaces
     * @throws sortmix.model.NonSortingModeException
     */
    @Test
    public void testSortingWithoutSpaces() throws NonSortingModeException{
        TextSorterModel model = new TextSorterModel("alamakota", SortingMode.Sort);
        String result = model.process();
        assertEquals("Result string should be empty", "aaaaklmot", result);
    }
    
    /**
     * Model should remove whitespaces and sort the text
     * @throws sortmix.model.NonSortingModeException
     */
    @Test
    public void testSortingWithSpaces() throws NonSortingModeException{
        TextSorterModel model = new TextSorterModel("ala ma kota", SortingMode.Sort);
        String result = model.process();
        assertEquals("Result string should be empty", "aaaaklmot", result);
    }
    
    /**
     * Model should remove all whitespaces and produce empty string
     * @throws sortmix.model.NonSortingModeException
     */
    @Test
    public void testOnlyWhiteSpaces() throws NonSortingModeException{
        TextSorterModel model = new TextSorterModel("          ", SortingMode.Sort);
        String result = model.process();
        assertEquals("Result string should be empty", "", result);
    }
    
    /**
     * Model should produce the same result running twice
     * @throws sortmix.model.NonSortingModeException
     */
    @Test
    public void testSortingTwice() throws NonSortingModeException{
        TextSorterModel model = new TextSorterModel("ala ma kota", SortingMode.Sort);
        String result = model.process();
        String secondResult = model.process();
        assertEquals("Result string should be empty", result, secondResult);
    }
    
    /**
     * Model should produce different string to given sorted text
     * @throws sortmix.model.NonSortingModeException
     */
    @Test
    public void testMixing() throws NonSortingModeException{
        TextSorterModel model = new TextSorterModel("aaaaklmot", SortingMode.Mix);
        String result = model.process();
        assertNotEquals("Result string should be empty", "aaaaklmot", result);
    }
    
    
    
}
