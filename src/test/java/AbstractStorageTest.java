import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AbstractStorageTest {

    @Test
    void add() {
        // given
        AbstractStorage abstractStorage = new AbstractStorage() {};

        List<URI> existingList = new ArrayList<>();
        existingList.add(URI.create("http://198.17.25.3"));
        Map<String, List<URI>> storageMap = new LinkedHashMap<>();

        storageMap.put("existingService", existingList);
        abstractStorage.storage = storageMap;

        // when
        URI newUri = URI.create("http://198.17.25.4");
        abstractStorage.add("existingService", newUri);

        // then
        assertTrue(storageMap.containsKey("existingService")); // Проверяем, что сервис существует в хранилище
        List<URI> updatedList = storageMap.get("existingService"); // Получаем список адресов для этого сервиса
        assertNotNull(updatedList); // Проверяем, что список не является null
        assertTrue(updatedList.contains(newUri)); // Проверяем, что новый URI был добавлен в список адресов
        assertEquals(2, updatedList.size()); // Проверяем, что размер списка равен 2
    }

    @Test
    void add_newList() {
    //given
        AbstractStorage abstractStorage = new AbstractStorage() {};
        Map<String, List<URI>> storageMap = new LinkedHashMap<>();
        abstractStorage.storage = storageMap;
        // when
        URI newUri = URI.create("http://198.17.25.4");
        abstractStorage.add("newService", newUri);
        //then
        assertTrue(storageMap.containsKey("newService")); // Проверяем, что сервис добавлен
        List<URI> uriList = storageMap.get("newService"); // Получаем список адресов для этого сервиса
        assertNotNull(uriList); // Проверяем, что список не является null
        assertTrue(uriList.contains(newUri)); // Проверяем, что новый URI был добавлен в список адресов
        assertEquals(1, uriList.size()); // Проверяем, что размер списка равен 1
    }



    }
