import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class ValidatorImpl implements  Validator{
    @Override
    public void validatorURI(URI address) throws MalformedURLException {
        try{
            address.toURL();
        } catch (MalformedURLException e) {
            throw new MalformedURLException("Неправильно введен адресс");
        }
    }

    @Override
    public void validatorName(String serviceName) {
        if(serviceName.matches(".*\\d.*") || serviceName.equals(null)){
            throw new IllegalArgumentException("Имя серивиса введено неверно");
        }
    }

    @Override
    public void validatorSize(Map<String, List<URI>> list) {
        if(list.size() == 10){
            list.remove(list.keySet().stream().findFirst().get());
        }

    }
}
