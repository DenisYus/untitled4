import java.net.URI;

public interface StorageService {
    void add(String serviceName, URI address);
    URI getByName(String serviceName);
}
