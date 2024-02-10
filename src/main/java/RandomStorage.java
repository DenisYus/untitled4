import java.net.URI;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RandomStorage implements StorageService{

    private final Map<String, List<URI>> storage= new HashMap<>();

    private final SecureRandom random;
    public RandomStorage( SecureRandom random) {
        this.random = random;
    }

    @Override
    public void save(String serviceName, URI address) {
        if (storage.containsKey(serviceName)){
           storage.get(serviceName).add(address);
       } else {
           List<URI> uriList = new ArrayList<>();
           uriList.add(address);
           storage.put(serviceName,uriList);
       }

    }

    @Override
    public URI getByName(String serviceName) {
        List<URI> uriList = storage.get(serviceName);
        var index = random.nextInt(0, uriList.size());
        return uriList.get(index);
    }
}
