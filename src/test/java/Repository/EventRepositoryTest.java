package Repository;

import com.hackathon.Main;
import com.hackathon.Pojo.Event;
import com.hackathon.Repository.EventRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class EventRepositoryTest {
    @Autowired
    EventRepository eventRepository;
    @Test
    public void save(){
        Event event = new Event();
        event.setTitle("Test Event");
        this.eventRepository.save(event);
    }
    @Test
    public void deleteByTitle() {
        this.eventRepository.deleteByTitle("Test Event");
    }
}
