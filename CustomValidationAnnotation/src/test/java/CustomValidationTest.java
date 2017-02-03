import customvalidation.Car;
import customvalidation.ContactDetails;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by shaikjb on 2/2/2017.
 */
public class CustomValidationTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private static Car car;
    private static ContactDetails contactDetails;

    @BeforeClass
    public static void setup() {

        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();

        car = new Car( "Morris", "dd-ab-123", 4 );
        contactDetails = new ContactDetails();
    }

    @Test
    public void testCarDetails() {
        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        for(ConstraintViolation<Car> violation : violations) {
            System.out.println(violation.getMessage());
        }
        int size = violations.size();
        Assert.assertTrue(size > 0);

        contactDetails.setName("johny");
        contactDetails.setPhoneNumber(null);

        Set<ConstraintViolation<ContactDetails>> ContactViolations = validator.validate(contactDetails);

        for(ConstraintViolation<ContactDetails> violation : ContactViolations) {
            System.out.println(violation.getMessage());
        }
        size = violations.size();
        Assert.assertTrue(size > 0);

    }
}
