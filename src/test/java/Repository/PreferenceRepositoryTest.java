package Repository;

import com.hackathon.Main;
import com.hackathon.PO.Preference;
import com.hackathon.Repository.PreferenceRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class PreferenceRepositoryTest {
    @Autowired
    PreferenceRepository preferenceRepository;

    @Test
//    @Ignore
    public void save() {
        Optional<Preference> preference1 = preferenceRepository.findById(Integer.valueOf(1));
        preference1.get().setName("Party");
        this.preferenceRepository.save(preference1.get());
//        Preference preference2 = new Preference();
//        preference2.setName("Reading");
//        this.preferenceRepository.save(preference2);
//        Preference preference3 = new Preference();
//        preference3.setName("Skiing");
//        this.preferenceRepository.save(preference3);
//        Preference preference4 = new Preference();
//        preference4.setName("Badminton");
//        this.preferenceRepository.save(preference4);
//        Preference preference5 = new Preference();
//        preference5.setName("Hiking");
//        this.preferenceRepository.save(preference5);
//        Preference preference6 = new Preference();
//        preference6.setName("Climbing");
//        this.preferenceRepository.save(preference6);
//        Preference preference7 = new Preference();
//        preference7.setName("Video Game");
//        this.preferenceRepository.save(preference7);
//        Preference preference8 = new Preference();
//        preference8.setName("Basket Ball");
//        this.preferenceRepository.save(preference8);
//        Preference preference9 = new Preference();
//        preference9.setName("Family Event");
//        this.preferenceRepository.save(preference9);
//        Preference preference10 = new Preference();
//        preference10.setName("Pet");
//        this.preferenceRepository.save(preference10);
    }

    @Test
    @Ignore
    public void deleteByName () {
        this.preferenceRepository.deleteByName("Test Preference");
    }
}
