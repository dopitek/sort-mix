package sortmix.model;

import sortmix.collections.SwapingList;
import java.util.Random;
import sortmix.common.SortingMode;

/**
 * Class for arranging text in specified mode
 *
 * @author Dariusz Opitek
 * @version 1.1
 */
public class TextSorterModel {

    /**
     * stores text to be processed
     */
    private String text;

    private final SwapingList<Character> letters;

    /**
     * stores sorting mode to which should be used to process text
     */
    private final SortingMode sortingMode;

    /**
     * Default constructor
     *
     * @param text text to be sorted
     * @param sortingMode sorting method
     */
    public TextSorterModel(String text, SortingMode sortingMode) {
        this.text = text;
        this.sortingMode = sortingMode;
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
     */
    public String process() throws NonSortingModeException {
        String result = "";

        if (sortingMode == null) {
            throw new NonSortingModeException("Sorting mode not present");
        }
        
        if (text == null || text.isEmpty())
            return "";
        
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
