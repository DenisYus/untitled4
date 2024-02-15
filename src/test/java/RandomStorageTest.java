import org.junit.jupiter.api.Test;

import java.net.URI;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class RandomStorageTest {

    @Test
    void getByName() {
        //given
        SecureRandom secureRandom = new SecureRandom();

        RandomStorage randomStorage = new RandomStorage(secureRandom);
        var serviceName = "user";
        var uri1 = URI.create("http://198.17.25.3");

        List<URI> uriList = new ArrayList<>();
        uriList.add(uri1);

        randomStorage.add(serviceName, uri1);

        //when
        URI result = randomStorage.getByName(serviceName);
        //then
        assertEquals(uri1, result);

    }

}