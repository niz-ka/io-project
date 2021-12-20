package pl.put.poznan.checker.logic.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Keyword counter data transfer object.
 */
public class KeywordsCountDTO {
    /**
     * Class logger
     */
    static Logger logger = LoggerFactory.getLogger(KeywordsCountDTO.class);

    /**
     * Number of keywords.
     */
    public int keywords;

    /**
     * Default constructor to set keywords value.
     * @param k number of keywords.
     */
    public KeywordsCountDTO(int k) {
        this.keywords = k;
        logger.info("\tConverted number of keywords to DTO");
    }
}
