package org.example.view;

import lombok.Data;
import lombok.NonNull;


@Data
public class ValidateBracketsResult {
    private String validBrackets;
    private Integer countOfBrackets;

    private ValidateBracketsResult(String validBrackets, Integer countOfBrackets) {
        this.validBrackets = validBrackets;
        this.countOfBrackets = countOfBrackets;
    }

    public static ValidateBracketsResult fromValidString(@NonNull String validString) {
        return new ValidateBracketsResult(validString, validString.length());
    }

    @Override
    public String toString() {
        if (countOfBrackets != 0) {
            return countOfBrackets + " - " + validBrackets;
        } else {
            return countOfBrackets.toString();
        }
    }
}
