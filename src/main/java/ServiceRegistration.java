import java.net.URI;

public interface ServiceRegistration {
    void register(String serviceName, URI address);
    URI getAddress(String serviceName);
}
