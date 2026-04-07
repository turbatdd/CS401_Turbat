package lab5.prob1.rulesets;

import java.awt.Component;

import lab5.prob1.gui.BookWindow;
import lab5.prob1.gui.CDWindow;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Price must be a floating point number with two decimal places
 * 3. Price must be a number greater than 0.49.
 */

public class CDRuleSet implements RuleSet {

    private CDWindow cdWin;

    @Override
    public void applyRules(Component ob) throws RuleException {
        cdWin = (CDWindow) ob;
        checkEmpty();
        priceRules();
    }

    private void checkEmpty() throws RuleException {
        if (cdWin.getTitleValue().trim().isEmpty() ||
                cdWin.getArtistValue().trim().isEmpty() ||
                cdWin.getPriceValue().trim().isEmpty()) {
            throw new RuleException("All fields must be nonempty");
        }
    }

    private void priceRules() throws RuleException {
        String val = cdWin.getPriceValue().trim();
        double doubleVal = 0.00;

        if (!val.matches("^\\d+\\.\\d{2}$"))
            throw new RuleException("Price must be a floating point number with two decimal places.");

        try {
            doubleVal = Double.parseDouble(val);
            if (doubleVal <= 0.49)
                throw new RuleException("Price must be a number greater than 0.49.");
        } catch (NumberFormatException exception) {
            throw new RuleException("Price must be a floating point number.");
        }
    }
}
