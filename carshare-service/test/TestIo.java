
import com.carshare.domain.dto.*;
import com.neptuo.service.io.*;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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

    @Test
    public void complex() throws Exception {
        List<TripStop> stops = new ArrayList<TripStop>();
        stops.add(new TripStop("3", new Date()));
        stops.add(new TripStop("4", new Date()));
        stops.add(new TripStop("5", new Date()));
        NewTrip trip = new NewTrip("1", "2", new Date(), new Date(), 5000, 4, 5, stops);

        XmlSerializer serializer = new XmlSerializer("carshare");
        AutoSerializer.factory("new-trip1", trip, serializer).serialize();
        String output = serializer.getResult();
        System.out.println(output);
    }

    @Test
    public void collection() throws Exception {
        String output = "<carshare generated=\"1324500349244\"><trips><trip-row><to>Praha</to><id>d995eabd5e0e6d1095a4be5b5438dc0db66fa72a</id><driver-rating>0</driver-rating><total-seats>5</total-seats><total-price>500</total-price><departure>2011-12-23 00:00:00.0</departure><arrival>2011-12-23 00:00:00.0</arrival><from>Louny</from><available-seats>4</available-seats><driver-id>fbfa8f60085a5fcb5a46d1fb0dae00a7d5ce6453</driver-id></trip-row><trip-row><to>Praha</to><id>5f45841f4f825a994cc066df167ccc126798ff49</id><driver-rating>0</driver-rating><total-seats>5</total-seats><total-price>500</total-price><departure>2011-12-24 00:00:00.0</departure><arrival>2011-12-28 00:00:00.0</arrival><from>Louny</from><available-seats>4</available-seats><driver-id>fbfa8f60085a5fcb5a46d1fb0dae00a7d5ce6453</driver-id></trip-row><trip-row><to>Praha</to><id>6df4f7a67a6cca3946edd77e37835d86ce833b26</id><driver-rating>0</driver-rating><total-seats>5</total-seats><total-price>500</total-price><departure>2011-12-24 00:00:00.0</departure><arrival>2011-12-28 00:00:00.0</arrival><from>Louny</from><available-seats>4</available-seats><driver-id>fbfa8f60085a5fcb5a46d1fb0dae00a7d5ce6453</driver-id></trip-row><trip-row><to>Praha</to><id>a80c26367a63ef8c686ab2bff32bc82c7cb39ea1</id><driver-rating>0</driver-rating><total-seats>5</total-seats><total-price>500</total-price><departure>2011-12-24 00:00:00.0</departure><arrival>2011-12-24 00:00:00.0</arrival><from>Louny</from><available-seats>4</available-seats><driver-id>fbfa8f60085a5fcb5a46d1fb0dae00a7d5ce6453</driver-id></trip-row></trips></carshare>";

        XmlDeserializer deserializer = new XmlDeserializer();
        AutoDeserializerItem tripItem = new AutoDeserializerItem("trips", Collection.class, TripRow.class);
        AutoDeserializer.factory(deserializer, new ByteArrayInputStream(output.getBytes()), tripItem).deserialize();
        Collection<TripRow> items = tripItem.getCollection();
        System.out.println(items.size());
    }
}
