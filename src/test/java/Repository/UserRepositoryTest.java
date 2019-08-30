package Repository;

import com.hackathon.Main;
import com.hackathon.PO.Event;
import com.hackathon.PO.Preference;
import com.hackathon.PO.User;
import com.hackathon.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Date;
//import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    @Ignore
    public void save() {
        User user = new User();
        user.setEmail("ffff@hackathon.com");
        user.setBirthday(new Date());
        user.setName("mark");
        Event event = new Event();
        event.setTitle("hackathon event");
        user.getEvents().add(event);
//        event.setUser(user);
        Preference preference = new Preference();
        preference.setName("party");
        event.getPreferences().add(preference);
        user.getPreferences().add(preference);

        this.userRepository.save(user);
    }
    @Test
    @Ignore
    public void findByName() {
        Assert.assertTrue(this.userRepository.findByName("mark").size()>0);
    }
//    @Test
//    @Transactional
//    public void findById() {
//        Optional<User> user = this.userRepository.findById(Integer.valueOf(31));
//        System.out.println("user found:"+user.get().getName());
////        System.out.println("user event size:"+user.get().getEvents());
////        for (Event e:user.get().getEvents()) {
////            System.out.println(e.getTitle());
////        }
//        Assert.assertTrue(user.get().getName().length()>0);
//    }
    @Test
    @Ignore
    public void deleteByName() {
        this.userRepository.deleteByName("mark");
    }
}
