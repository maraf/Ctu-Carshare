
import com.carshare.service.util.HashHelper;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mara
 */
public class TestHash {

    @Test
    public void testPassword() {
        String username = "606111222";
        String password = "doe";
        String hash = HashHelper.SHA1(username + password);
        System.out.println(password + ":" + hash);
    }
}
