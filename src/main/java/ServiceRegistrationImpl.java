import java.net.URI;

public class ServiceRegistrationImpl implements ServiceRegistration{
    private final StorageService  storageService;
    private final ValidatorImpl validator;

    public ServiceRegistrationImpl(StorageService storageService, ValidatorImpl validator) {
        this.storageService = storageService;
        this.validator = validator;
    }

    @Override
    public void register(String serviceName, URI address) {
        validator.validatorName(serviceName);
        validator.validatorURI(address);
        storageService.save(serviceName, address);
    }

    @Override
    public URI getAddress(String serviceName) {
        validator.validatorName(serviceName);
        return storageService.getByName(serviceName);
    }
}
