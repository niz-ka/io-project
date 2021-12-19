package pl.put.poznan.checker.logic;

/**
 * Keyword counter data transfer object.
 */
public class KeywordsCountDTO implements DTO{
    /**
     * Number of keywords.
     */
    public Integer keywords;

    /**
     * Default constructor to set keywords value.
     * @param k number of keywords.
     */
    public KeywordsCountDTO(Integer k) {
        this.keywords = k;
    }
}
