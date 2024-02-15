import java.net.MalformedURLException;
import java.net.URI;

public interface ServiceRegistration {
    void register(String serviceName, URI address) throws MalformedURLException;
    URI getAddress(String serviceName);
}
