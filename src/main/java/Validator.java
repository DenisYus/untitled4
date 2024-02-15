import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.Map;

public interface Validator {
    void validatorURI(URI address) throws MalformedURLException;
    void validatorName(String serviceName);
    void validatorSize(Map<String, List<URI>> list);

}
