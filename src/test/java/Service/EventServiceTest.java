package Service;

import com.hackathon.Main;
import com.hackathon.Service.EventService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class EventServiceTest {
    @Autowired
    private EventService eventService;
    @Test
    public void save () {

    }

    @Test
    @Ignore
    public void findAll() {
        Assert.assertTrue(this.eventService.findAll().size()>0);
    }
}
