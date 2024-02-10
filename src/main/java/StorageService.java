import java.net.URI;

public interface StorageService {
    void save(String serviceName, URI address);
    URI getByName(String serviceName);
}
