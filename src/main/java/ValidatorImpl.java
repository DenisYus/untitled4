import java.net.MalformedURLException;
import java.net.URI;

public class ValidatorImpl implements  Validator{
    @Override
    public void validatorURI(URI address) {
        try{
            address.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Неправильно введен адресс");
        }
    }

    @Override
    public void validatorName(String serviceName) {
        if(serviceName.matches(".*\\d.*") || serviceName.equals(null)){
            throw new IllegalArgumentException("Имя серивиса введено неверно");
        }
    }
}
