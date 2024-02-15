import java.net.URI;
import java.util.*;

public class QueueStorage extends AbstractStorage  implements StorageService {
    private int i = 0;

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
//лимит по кол-во ссылок. 10. если 11, то самая стара заменится на новую. и тесты.
