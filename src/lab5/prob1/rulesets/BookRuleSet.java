package lab5.prob1.rulesets;

import java.awt.Component;

import lab5.prob1.gui.*;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

    private BookWindow bookWin;

    @Override
    public void applyRules(Component ob) throws RuleException {
        bookWin = (BookWindow) ob;
        checkEmpty();
        isbnCheck();
        priceRules();
    }

    private void checkEmpty() throws RuleException {
        if (bookWin.getIsbnValue().trim().isEmpty() ||
                bookWin.getTitleValue().trim().isEmpty() ||
                bookWin.getPriceValue().trim().isEmpty()) {
            throw new RuleException("All fields must be nonempty");
        }
    }

    private void isbnCheck() throws RuleException {
        String val = bookWin.getIsbnValue().trim();

        for (char c : val.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new RuleException("ISBN must be numeric");
            }
        }
        if (val.length() != 10 || val.length() != 13)
            throw new RuleException("ISBN must have 10 or 13 digits");

        if (val.length() == 10 && !(val.charAt(0) == '0' || val.charAt(0) == '1')) {
            throw new RuleException("First digit of ISBN must be 0 or 1");
        }
        if (val.length() == 13 && !(val.startsWith("978") || val.startsWith("979"))) {
            throw new RuleException("First 3 digits must be either 978 or 979");
        }
    }

    private void priceRules() throws RuleException {
        String val = bookWin.getPriceValue().trim();
        double doubleVal = 0.00;

        if (!val.matches("^\\d+\\.\\d{2}$"))
            throw new RuleException("Price must be a floating point number with two decimal places.");

        try {
            doubleVal = Double.parseDouble(val);
            if (doubleVal <= 0.49)
                throw new RuleException("Price must be a number greater than 0.49");
        } catch (NumberFormatException exception) {
            throw new RuleException("Price must be a floating point number.");
        }
    }
}
