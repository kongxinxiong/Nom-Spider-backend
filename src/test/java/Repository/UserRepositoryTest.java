package Repository;

import com.hackathon.Main;
import com.hackathon.PO.Event;
import com.hackathon.PO.Preference;
import com.hackathon.PO.User;
import com.hackathon.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void save() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("mark");
        Event event = new Event();
        event.setTitle("hackathon event");
        user.getEvents().add(event);
        Preference preference = new Preference();
        preference.setName("party");
        event.getPreferences().add(preference);
        user.getPreferences().add(preference);

        this.userRepository.save(user);
    }
    @Test
    public void findByName() {
        Assert.assertTrue(this.userRepository.findByName("mark").size()>0);
    }
    @Test
    public void deleteByName() {
        this.userRepository.deleteByName("mark");
    }
}