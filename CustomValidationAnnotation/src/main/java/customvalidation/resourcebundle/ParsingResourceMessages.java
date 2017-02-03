package customvalidation.resourcebundle;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Created by shaikjb on 2/3/2017.
 */
public class ParsingResourceMessages {

    private static class LoadResourceMessages {
        private static final ResourceBundle resource = ResourceBundle.getBundle("ErrorMessages");
    }

    public String parseMessage(String msg, String value) {
        String parsedMessage = LoadResourceMessages.resource.getString(msg);
        if (StringUtils.isNotEmpty(parsedMessage)) {
            String resultedMessage = MessageFormat.format(parsedMessage, value);
            return resultedMessage;
        }
        return "Parse Failed";
    }
}
