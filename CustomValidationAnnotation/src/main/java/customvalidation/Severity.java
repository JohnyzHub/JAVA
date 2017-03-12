package customvalidation;

import javax.validation.Payload;

/**
 * Created by shaikjb on 2/1/2017.
 */
public class Severity {
    public interface Info extends Payload {
    }

    public interface Error extends Payload {
    }
}
