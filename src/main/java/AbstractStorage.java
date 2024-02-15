import java.net.URI;
import java.util.*;

public abstract class AbstractStorage    {
    protected Map<String, List<URI>> storage = new LinkedHashMap<>();
    ValidatorImpl validator = new ValidatorImpl();


    public void add(String serviceName, URI address) {

        if (storage.containsKey(serviceName)) {
            storage.get(serviceName).add(address);
        } else {
            validator.validatorSize(storage);
            List<URI> uriList = new ArrayList<>();
            uriList.add(address);
            storage.put(serviceName, uriList);
        }
    }
}
