import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ServiceRegistrationImplTest {

    @Test
    void register() throws URISyntaxException, MalformedURLException {
        //given
        var serviceName = "user";
        var uri = new URI("http://198.17.25.3");
        var validatorMock = mock(Validator.class);
        var storageServiceMock = mock(StorageService.class);
        var registration = new ServiceRegistrationImpl(storageServiceMock, validatorMock);
        //when
        registration.register(serviceName, uri);
        //then
        verify(validatorMock).validatorName(eq(serviceName));
        verify(validatorMock).validatorURI(eq(uri));
    }

    @Test
    void getAddress() throws URISyntaxException {
        //given
        var serviceName = "user";
        var uri = new URI("http://198.17.25.3");
        var validatorMock = mock(Validator.class);
        var storageServiceMock = mock(StorageService.class);
        var registration = new ServiceRegistrationImpl(storageServiceMock, validatorMock);
        doReturn(uri).when(storageServiceMock).getByName(serviceName);
        //when
        URI address = registration.getAddress(serviceName);
        //then
        verify(validatorMock).validatorName(eq(serviceName));
        assertEquals(uri, address);

    }
}