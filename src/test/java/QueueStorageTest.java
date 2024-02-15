import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueueStorageTest {

    @Test
    void getByName() {
        //given
        QueueStorage queueStorage = new QueueStorage();
        List<URI> uriList = new ArrayList<>();
        uriList.add(URI.create("http://198.17.25.3"));
        uriList.add(URI.create("http://198.17.25.4"));
        queueStorage.storage.put("testService", uriList);

        //when
        URI result = queueStorage.getByName("testService");

        //then
        assertNotNull(result);
        assertTrue(uriList.contains(result));
    }
}