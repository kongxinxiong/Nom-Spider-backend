package Repository;

import com.hackathon.Main;
import com.hackathon.PO.Event;
import com.hackathon.PO.User;
import com.hackathon.Repository.EventRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class EventRepositoryTest {
    @Autowired
    EventRepository eventRepository;
    @Test
    @Ignore
    public void save(){
        Event event = new Event();
        event.setTitle("Event ID2");
        event.setStartDate(new Date());
        User user = new User();
        user.setBirthday(new Date());
        user.setName("wudan");
        user.setEmail("asdasd@hackathon.com");
        event.getEventJointUsers().add(user);
//        event.setEventCreator(user);
        this.eventRepository.save(event);
    }
    @Test
    @Ignore
    public void deleteByTitle() {
        this.eventRepository.deleteByTitle("Test Event");
    }
}
