package sortmix.model;

import sortmix.collections.SwapingList;
import java.util.Random;
import sortmix.common.SortingMode;

/**
 * Class for arranging text in specified mode
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class TextSorterModel {

    /**
     * stores text to be processed
     */
    private String text;

    /**
     * Sets text
     *
     * @param text text to be analysed
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets text
     *
     * @return returns text
     */
    public String getText() {
        return this.text;
    }

    /**
     * stores selected sorting mode
     */
    private SortingMode sortingMode;

    /**
     * Sets sorting mode
     *
     * @param sortingMode sorting mode
     */
    public void setSortingMode(SortingMode sortingMode) {
        this.sortingMode = sortingMode;
    }

    /**
     * Gets sorting mode
     *
     * @return returns sorting mode
     */
    public SortingMode getSortingMode() {
        return this.sortingMode;
    }

     /**
     * Stores container
     *
     */
    private final SwapingList<Character> letters;

    /**
     * Default constructor
     *
     */
    public TextSorterModel() {
        letters = new SwapingList<>();
    }

    /**
     * Sorting text
     *
     */
    private void sort() {

        for (int i = 0; i < letters.size(); i++) {
            for (int j = i + 1; j < letters.size(); j++) {
                if (letters.get(j) < letters.get(i)) {
                    letters.swap(i, j);
                }
            }
        }
    }

    /**
     * Mixing text
     */
    private void mix() {

        Random rand = new Random();
        int a, b;

        for (int i = 0; i < letters.size(); i++) {
            a = rand.nextInt(letters.size());
            b = rand.nextInt(letters.size());
            letters.swap(a, b);
        }
    }

    /**
     * Gets text arranged in the specified sorting mode
     *
     * @return returns arranged text
     * @throws NonSortingModeException throws custom exception caught when
     * sorting mode not supported
     * @throws sortmix.model.NoTextInputException
     */
    public String process() throws NonSortingModeException, NoTextInputException {
        String result = "";

        if (sortingMode == null) {
            throw new NonSortingModeException("Sorting mode not present");
        }
        
        if (text == null || text.isEmpty())
            throw new NoTextInputException("Text not present");
        
        text = text.replaceAll("\\s+","");

        letters.clear();
        for (char value : text.toCharArray()) {
            letters.add(value);
        }

        switch (sortingMode) {
            case Sort:
                sort();
                break;
            case Mix:
                mix();
                break;
            default:
                throw new NonSortingModeException("Sorting mode not supported: " + sortingMode.name());
        }

        for (Character letter : letters) {
            result += letter;
        }
        return result;
    }
}
