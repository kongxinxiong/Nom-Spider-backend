package Service;

import com.hackathon.Main;
import com.hackathon.Service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void findAll() {
        Assert.assertTrue(this.userService.findAll().size()>0);
    }
}
