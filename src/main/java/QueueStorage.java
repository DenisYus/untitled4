import java.net.URI;
import java.util.*;

public class QueueStorage implements StorageService{
    private final Map<String, List<URI>> storage= new HashMap<>();
    private int i = 0;
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
        uriList.sort(Comparator.comparing(URI::toString));
        if(i<=uriList.size()) {
            i++;
        }else { i = 0;}
        return uriList.get(i);
    }
}
