package customvalidation;

import customvalidation.customannotation.CaseMode;
import customvalidation.customannotation.CheckCase;
import customvalidation.resourcebundle.ParsingResourceMessages;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by shaikjb on 2/1/2017.
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;

    public void initialize(CheckCase checkCase) {
        this.caseMode = checkCase.value();
    }

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = isValid(s);

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    new ParsingResourceMessages().parseMessage("UpperCaseMessage", s)
            ).addConstraintViolation();
        }
        return isValid;
    }

    private boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        boolean isValid;
        if (caseMode == CaseMode.UPPER) {
            isValid = s.equals(s.toUpperCase());
        } else {
            isValid = s.equals(s.toLowerCase());
        }
        return isValid;
    }
}