package customvalidation;

import customvalidation.customannotation.CaseMode;
import customvalidation.customannotation.CheckCase;

import javax.validation.constraints.NotNull;

/**
 * Created by shaikjb on 2/1/2017.
 */
public class ContactDetails {

    @CheckCase(CaseMode.UPPER)
    @NotNull(message = "Name is mandatory", payload = Severity.Error.class)
    private String name;


    @NotNull(message = "Phone number not specified, but not mandatory",
            payload = Severity.Info.class)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
