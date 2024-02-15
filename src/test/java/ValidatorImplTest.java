import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ValidatorImplTest {

    @Test
    void validatorURI() throws MalformedURLException {
        //given
        ValidatorImpl validatorMock = mock(ValidatorImpl.class);
        URI validAddress = URI.create("http://198.17.25.3");
        // when
        validatorMock.validatorURI(validAddress);
        // then
        assertDoesNotThrow(() -> verify(validatorMock, times(1)).validatorURI(validAddress));
    }

    @Test
    void validatorURI_invalid() {
        //given
        ValidatorImpl validator = new ValidatorImpl();
        // when
        URI invalidAddress = URI.create("invalid");
        // then
        assertThrows(MalformedURLException.class, () -> new URL(invalidAddress.toString()));
    }

    @Test
    void validatorName() {
        //given
        ValidatorImpl validator = new ValidatorImpl();
        String validServiceName = "serviceName";
        // when, then
        assertDoesNotThrow(() -> validator.validatorName(validServiceName));
    }
    @Test
    void validatorName_invalidMatches() {
        //given
        ValidatorImpl validator = new ValidatorImpl();
        String invalidServiceName = "service123";
        // when, then
        assertThrows(IllegalArgumentException.class, () -> validator.validatorName(invalidServiceName));
    }
    @Test
    void validatorName_invalidNotNull() {
        //given
        ValidatorImpl validator = new ValidatorImpl();
        // when, then
        assertThrows(NullPointerException.class, () -> validator.validatorName(null));

    }

    @Test
    void validatorSize() {
        //given
        ValidatorImpl validator = new ValidatorImpl();
        Map<String, List<URI>> list = new LinkedHashMap<>();
        List<URI> uriList = new ArrayList<>();
        uriList.add(URI.create("http://198.17.25.3"));
        list.put("test", uriList);
        //when
        validator.validatorSize(list);
        //then
        assertEquals(1,list.size());
    }
    @Test
    void validatorSize_remove() {
        //given
        ValidatorImpl validator = new ValidatorImpl();
        Map<String, List<URI>> list = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            List<URI> uriList = new ArrayList<>();
            uriList.add(URI.create("http://198.17.25.3" + i));
            list.put("testService" + i, uriList);
        }
        //when
        validator.validatorSize(list);
        //then
        assertEquals(9, list.size());
        assertFalse(list.containsKey("testService0"));
    }
}