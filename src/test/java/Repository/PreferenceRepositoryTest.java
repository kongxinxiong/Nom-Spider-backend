package Repository;

import com.hackathon.Main;
import com.hackathon.PO.Preference;
import com.hackathon.Repository.PreferenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class PreferenceRepositoryTest {
    @Autowired
    PreferenceRepository preferenceRepository;

    @Test
    public void save() {
        Preference preference = new Preference();
        preference.setName("Test Preference");
        this.preferenceRepository.save(preference);
    }

    @Test
    public void deleteByName () {
        this.preferenceRepository.deleteByName("Test Preference");
    }
}
