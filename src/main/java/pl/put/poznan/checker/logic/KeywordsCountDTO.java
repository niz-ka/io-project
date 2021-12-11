package pl.put.poznan.checker.logic;

/**
 * Keyword counter data transfer object.
 */
public class KeywordsCountDTO {
    /**
     * Number of keywords.
     */
    public Integer keywords = 0;

    /**
     * Default constructor to set keywords value.
     * @param k Number of keywords.
     */
    public KeywordsCountDTO(Integer k) {
        this.keywords = k;
    }
}
