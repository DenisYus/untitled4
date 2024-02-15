import java.net.MalformedURLException;
import java.net.URI;

public class ServiceRegistrationImpl implements ServiceRegistration{
    private final StorageService  storageService;
    private final Validator validator;

    public ServiceRegistrationImpl(StorageService storageService, Validator validator) {
        this.storageService = storageService;
        this.validator = validator;
    }

    @Override
    public void register(String serviceName, URI address) throws MalformedURLException {
        validator.validatorName(serviceName);
        validator.validatorURI(address);
        storageService.add(serviceName, address);
    }

    @Override
    public URI getAddress(String serviceName) {
        validator.validatorName(serviceName);
        return storageService.getByName(serviceName);
    }
}
