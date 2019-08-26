package Service;

import com.hackathon.Main;
import com.hackathon.Service.PreferenceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class PreferenceServiceTest {
    @Autowired
    private PreferenceService preferenceService;
    @Test
    public void save () {

    }

    @Test
    public void findAll() {
        Assert.assertTrue(this.preferenceService.findAll().size()>0);
    }
}
