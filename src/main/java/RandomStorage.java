import java.net.URI;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RandomStorage extends AbstractStorage implements StorageService{
    private final SecureRandom random;
    public RandomStorage( SecureRandom random) {
        this.random = random;
    }
    @Override
    public URI getByName(String serviceName) {
        List<URI> uriList = storage.get(serviceName);
        var index = random.nextInt(0, uriList.size());
        return uriList.get(index);
    }
}
