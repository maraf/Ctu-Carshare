
import com.carshare.domain.dto.UserLogin;
import com.neptuo.service.io.AutoDeserializer;
import com.neptuo.service.io.AutoDeserializerItem;
import com.neptuo.service.io.AutoSerializer;
import com.neptuo.service.io.XmlDeserializer;
import com.neptuo.service.io.XmlSerializer;
import java.io.ByteArrayInputStream;
import org.junit.Test;

public class TestIo {

    @Test
    public void base() throws Exception {
        UserLogin login = new UserLogin();
        login.setPhoneNumber("606111000");
        login.setPassword("12345");

        XmlSerializer serializer = new XmlSerializer("carshare");
        AutoSerializer.factory("user-login", login, serializer).serialize();
        String output = serializer.getResult();
        System.out.println(output);

        XmlDeserializer deserializer = new XmlDeserializer();
        AutoDeserializerItem loginItem = new AutoDeserializerItem("user-login", null, UserLogin.class);
        AutoDeserializer.factory(deserializer, new ByteArrayInputStream(output.getBytes()), loginItem).deserialize();
        UserLogin newLogin = (UserLogin) loginItem.getItem();

        assert newLogin != null : "Error";
        assert login.getPhoneNumber().equals(newLogin.getPhoneNumber()) : "Error";
        assert login.getPassword().equals(newLogin.getPassword()) : "Error";
    }
}
