package sortmix.model;

import java.util.Random;
import sortmix.common.SortingMode;
import sortmix.exceptions.ErrorReadingFileException;
import sortmix.exceptions.NonSortingModeException;

/**
 * Class for arranging text in specified mode
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class TextSorterModel {

    /**
     * stores text to be processed
     */
    private final String text;

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
    }

    /**
     * Gets sorted text retrieved from file
     *
     * @return returns sorted text
     * @throws ErrorReadingFileException throws custom exception caught while
     * processing file
     */
    private String getSortedText() throws ErrorReadingFileException {

        StringBuilder textBuilder = new StringBuilder(this.text);

        for (int i = 0; i < textBuilder.length(); i++) {
            for (int j = i + 1; j < textBuilder.length(); j++) {
                if (textBuilder.charAt(j) < textBuilder.charAt(i)) {
                    char t = textBuilder.charAt(j);
                    textBuilder.setCharAt(j, textBuilder.charAt(i));
                    textBuilder.setCharAt(i, t);
                }
            }
        }

        return textBuilder.toString();
    }

    /**
     * Gets mixed text retrieved from file
     *
     * @return returns mixed text
     * @throws ErrorReadingFileException throws custom exception caught while
     * processing file
     */
    private String getMixedText() throws ErrorReadingFileException {

        StringBuilder textBuilder = new StringBuilder(this.text);

        Random rand = new Random();
        int a, b;

        for (int i = 0; i < textBuilder.length(); i++) {
            a = rand.nextInt(textBuilder.length());
            b = rand.nextInt(textBuilder.length());
            char t = textBuilder.charAt(a);
            textBuilder.setCharAt(a, textBuilder.charAt(b));
            textBuilder.setCharAt(b, t);
        }

        return textBuilder.toString();
    }

    /**
     * Gets text arranged in the specified sorting mode
     *
     * @return returns arranged text
     * @throws ErrorReadingFileException throws custom exception caught while
     * processing file
     * @throws NonSortingModeException throws custom exception caught when
     * sorting mode not supported
     */
    public String getResultText() throws ErrorReadingFileException, NonSortingModeException {
        String text;

        if (sortingMode == null) {
            throw new NonSortingModeException("Sorting mode not present");
        }

        switch (sortingMode) {
            case Sort:
                text = getSortedText();
                break;
            case Mix:
                text = getMixedText();
                break;
            default:
                throw new NonSortingModeException("Sorting mode not supported: " + sortingMode.name());
        }
        return text;
    }
}
