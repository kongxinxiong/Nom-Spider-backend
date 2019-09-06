package Repository;

import com.hackathon.Main;
import com.hackathon.PO.Event;
import com.hackathon.PO.User;
import com.hackathon.Repository.EventRepository;
import com.hackathon.Repository.PreferenceRepository;
import com.hackathon.PO.Preference;
import com.hackathon.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class InitialData {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PreferenceRepository preferenceRepository;
    DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void save() throws ParseException {
        Preference preference1 = new Preference();
        preference1.setName("Party");
        Preference preference2 = new Preference();
        preference2.setName("Reading");
        Preference preference3 = new Preference();
        preference3.setName("Skiing");
        Preference preference4 = new Preference();
        preference4.setName("Badminton");
        Preference preference5 = new Preference();
        preference5.setName("Hiking");
        Preference preference6 = new Preference();
        preference6.setName("Climbing");
        Preference preference7 = new Preference();
        preference7.setName("Video Game");
        Preference preference8 = new Preference();
        preference8.setName("Basket Ball");
        Preference preference9 = new Preference();
        preference9.setName("Family Event");
        Preference preference10 = new Preference();
        preference10.setName("Pet");


        Event event1 = new Event();
        event1.setTitle("IT Christmas Party");
        event1.setStartDate(format1.parse("2019-12-25"));
        event1.setDescription("Make your 2019 Christmas party in London, Bristol, Manchester, Brighton or almost anyhwere in the UK truly memorable. Our Christmas parties are a handpicked selection of the very best events, party venues, club nights and balls. Our event planners have scoured the country to bring you the top Christmas party venues in the UK. We bring you options from affordable to amazing Christmas party ideas for 2019.");
        event1.setMaxNumber("30");
        event1.setLocation("London");
        event1.setPhotoURL("event1.png");

//        event1.getPreferences().add(preference1);

        Event event2 = new Event();
        event2.setTitle("Birthday Party in Sep");
        event2.setStartDate(format1.parse("2019-09-01"));
        event2.setDescription("We will have the monthly birthday party in Shanghai office,31F.And this time, we will celebrate for all the staff who was born in October.Food and drinks will be provided, hope all you enjoy the time.");
        event2.setMaxNumber("30");
        event2.setLocation("Shanghai");
        event2.setPhotoURL("event2.png");
//        event2.getPreferences().add(preference1);

        Event event3 = new Event();
        event3.setTitle("Read A Good Book");
        event3.setStartDate(format1.parse("2019-10-25"));
        event3.setDescription("This event will let all the attendees to share the books they read and people of all ages are encouraged to make time to enjoy the simple pleasure of reading. encourages people everywhere to organise their own events to promote reading. Be this a school having a class where pupils take it in turns to read a page from their favourite book, a workplace where an after work book club is held or a retirement home where people are encouraged to rediscover the books that helped shape their lives.");
        event3.setMaxNumber("15");
        event3.setLocation("Hong Kong");
        event3.setPhotoURL("event3.png");
//        event3.getPreferences().add(preference2);

        Event event4 = new Event();
        event4.setTitle("Reading Day in Nomura");
        event4.setStartDate(format1.parse("2019-08-14"));
        event4.setDescription("Every day is a great reading day, and snow days can be extra special. We encourage all our patients to be avid readers and participate in a program call Reach Out and Read. There was supposed to be a legislative hearing today about funding for Reach Out and Read");
        event4.setMaxNumber("20");
        event4.setLocation("Shanghai");
        event4.setPhotoURL("event4.png");
//        event4.getPreferences().add(preference2);

        Event event5 = new Event();
        event5.setTitle("Cross City Skiing Event");
        event5.setStartDate(format1.parse("2020-01-13"));
//        event5.setStartDate(format1.parse("2019-09-10"));
        event5.setDescription("First Timers and Beginners Ski Lessons are designed for those with little or no XC skiing experience. Prior experience isn't required; they're even suitable for those who have never seen snow before. The aim of these lessons is to give every club member the chance to try XC skiing and gain the basic skills needed to take part in other club trips. Because these trips are for first time skiers and beginners, they stay on gentle slopes without any pressure to keep up with more experienced skiers. The lessons cover the basic skills of XC skiing and are taught by fully qualified instructors.");
        event5.setMaxNumber("12");
        event5.setLocation("Shanghai");
        event5.setPhotoURL("event5.png");
//        event5.getPreferences().add(preference2);

        Event event6 = new Event();
        event6.setTitle("Skiing Party");
        event6.setStartDate(format1.parse("2018-01-13"));
        event6.setDescription("It’s that magical time of year when some lucky people are planning a trip to the mountains, so here is some advice on how to manage diabetes during the trip.We have some amazing content from a young English woman who went to the Turin 2006 games to enter the Super G! The first thing to do before you go is to check with your doctor whether you have and damage to the nerve to your feet (peripheral neuropathy) of reduced circulation to the feet. If you have neuropathy, the bane of skiers’ lives, ill-fitting and uncomfortable boots can lead to unrecognised foot damage and foot ulceration. If you have neuropathy, you can still ski, but have to be very careful about your foot care and footwear, and stop skiing if you develop any sore patches on your feet. Get properly fitted boots, and don’t hire. If the circulation to your feet is reduced, you will need to have a specific consultation with your doctor, to be sure that you are not at risk of loss of blood supply to the foot an frostbite or other damage");
        event6.setMaxNumber("18");
        event6.setLocation("Hong Kong");
        event6.setPhotoURL("event6.png");
//        event6.getPreferences().add(preference3);

        Event event7 = new Event();
        event7.setTitle("Fun badminton");
        event7.setStartDate(format1.parse("2019-11-12"));
        event7.setDescription("Badminton sees an annual participation rate of over 7 million players in the United States in 2012. More than half of these participants also take part in bowling. The origin of badminton dates back to the ancient civilizations of Europe and Asia more than 2,000 years ago. Originally referred to as shuttlecock, this game was renamed Poon in India and introduced in the 1800’s. The International Badminton Federation was created in 1934 as an organization that joined global nations together as a participating affiliate to compete in world championships.");
        event7.setMaxNumber("25");
        event7.setLocation("New York");
        event7.setPhotoURL("event7.png");
//        event7.getPreferences().add(preference4);

        Event event8 = new Event();
        event8.setTitle("NTSH Badminton Competition");
        event8.setStartDate(format1.parse("2019-06-30"));
        event8.setDescription("To strength up all the employees' healthy and build up good relationship betweem employees, we have this event to help build up good relationships and  Our event planners have set up a few prize for winners.");
        event8.setMaxNumber("30");
        event8.setLocation("Shanghai");
        event8.setPhotoURL("event8.png");
//        event8.getPreferences().add(preference4);

        Event event9 = new Event();
        event9.setTitle("Lantau Peak - East Trail");
        event9.setStartDate(format1.parse("2020-02-01"));
        event9.setDescription("Begin the hike at the MTR (Hong Kong subway) Tung Chung Station; it's the terminus of the orange line. \n" +
                "Take subway exit A and proceed north to the bus station near Tung Chung community garden. Board bus 23 or 11, cost 17.5 HKD~2€. \n" +
                "Ride the bus for about 7 minutes, 3.9 miles.to Pak Kung Au bus stop. NOTE you must tell the bus driver to stop or they will blow right by without slowing down. Sit near the front of the bus to be sure. \n" +
                "Get off the bus and proceed east up the stairs and then follow the trail to the peak. \n" +
                "There is a shelter at the peak to escape the elements.");
        event9.setMaxNumber("6");
        event9.setLocation("Hong Kong");
        event9.setPhotoURL("event9.png");
//        event9.getPreferences().add(preference5);

        Event event10 = new Event();
        event10.setTitle("Dragon's Back");
        event10.setStartDate(format1.parse("2019-05-09"));
        event10.setDescription("Starting point: Shek O Road near to To Tei Wan Village\n" +
                "End point: Big Wave Bay\n" +
                "Most of the route is on dirt paths. The first half has very little shade, and there is also a steep 200-metre-long uphill stretch. The flight of descending stone steps in the last section is quite steep, too\n" +
                "How to get there: From MTR Shau Kei Wan Station Exit A, walk to the Shau Kei Wan Bus Terminus. Take bus 9 or the red minibus with the sign “Shek O” to the To Tei Wan stop on Shek O Road.");
        event10.setMaxNumber("8");
        event10.setLocation("Hong Kong");
        event10.setPhotoURL("event10.png");
//        event10.getPreferences().add(preference5);

        Event event11 = new Event();
        event11.setTitle("Indoor Rock Climbing");
        event11.setStartDate(format1.parse("2019-11-06"));
        event11.setDescription("It's you versus 28-feet of sheer indoor climbing wall at Main Event! Suitable for everyone from kids to adults, our rock climbing facilities offer a challenge for all skill levels – and an absolute rush. Join us at the summit for the very peak of adventure.ll climbers must be at least 42 inches tall to climb the walls. For climbers under the age of 18, a parent or guardian must complete an Under 18 waiver. All climbers 18 and older must complete an Adult waiver. ");
        event11.setMaxNumber("7");
        event11.setLocation("Shanghai");
        event11.setPhotoURL("event11.png");
//        event11.getPreferences().add(preference6);

        Event event12 = new Event();
        event12.setTitle("2019 NTSH Climbing Cup");
        event12.setStartDate(format1.parse("2019-12-11"));
        event12.setDescription("Hailed as the premier climbing competition in the world, the event will gather more than 300 elite Bouldering and Speed climbing athletes to vie for positioning in the season rankings.");
        event12.setMaxNumber("15");
        event12.setLocation("Hong Kong");
        event12.setPhotoURL("event12.png");
//        event12.getPreferences().add(preference6);

        Event event13 = new Event();
        event13.setTitle("PlayStation 4 VR");
        event13.setStartDate(format1.parse("2019-07-01"));
        event13.setDescription("Host an exciting, all-inclusive birthday video game party.Our video game parties are perfect for kids of all ages.Immerse yourself in extraordinary new worlds of virtual reality, put yourself at the center of an incredible gaming universe and experience a new way to play with PlayStation Virtual Reality.");
        event13.setMaxNumber("4");
        event13.setLocation("Shanghai");
        event13.setPhotoURL("event13.png");
//        event1.getPreferences().add(preference7);

        Event event14 = new Event();
        event14.setTitle("NTSH Game Party");
        event14.setStartDate(format1.parse("2019-08-01"));
        event14.setDescription("Play What You Want When You Want Test out the latest video games, change games as many times as you want. choose a game and we'll take care of the rest! Every party is an exciting 2 hour private party! Your child and guests will play for 1 hour and 30 minutes in the gaming lounge. Your party will then eat and celebrate for 30 minutes! ");
        event14.setMaxNumber("10");
        event14.setLocation("Shanghai");
        event14.setPhotoURL("event14.png");
//        event14.getPreferences().add(preference7);

        Event event15 = new Event();
        event15.setTitle("Men's Basketball competition");
        event15.setStartDate(format1.parse("2019-09-12"));
        event15.setDescription("Recently, the Men's Basketball competition was opened, attracting 30 participants. Compared with ordinary basketball games, highlights of this competition are basketball skills and 5 creative team-branded clothing. These clothing combined with elements like Chinese chess and graffiti are hung along roadsides from the park to the entrance of a CRT station.");
        event15.setMaxNumber("30");
        event15.setLocation("Shanghai");
        event15.setPhotoURL("event15.png");
//        event15.getPreferences().add(preference8);

        Event event16 = new Event();
        event16.setTitle("Girls' Basketball competition");
        event16.setStartDate(format1.parse("2019-09-12"));
        event16.setDescription("Recently, the Girls's Basketball competition was opened, attracting 10 participants. Compared with ordinary basketball games, highlights of this competition are basketball skills and 5 creative team-branded clothing. These clothing combined with elements like Chinese chess and graffiti are hung along roadsides from the park to the entrance of a CRT station.");
        event16.setMaxNumber("30");
        event16.setLocation("Shanghai");
        event16.setPhotoURL("event16.png");
//        event16.getPreferences().add(preference8);

        Event event17 = new Event();
        event17.setTitle("Children's Day");
        event17.setStartDate(format1.parse("2019-11-08"));
        event17.setDescription("Bring your child to the company and we organize to made toys.");
        event17.setMaxNumber("50");
        event17.setLocation("Shanghai");
        event17.setPhotoURL("event17.png");
//        event17.getPreferences().add(preference9);

        Event event18 = new Event();
        event18.setTitle("Cook Day");
        event18.setStartDate(format1.parse("2019-09-08"));
        event18.setDescription("Share your dishes and teach other staff to cook, we also get a coach ");
        event18.setMaxNumber("30");
        event18.setLocation("Shanghai");
        event18.setPhotoURL("event18.png");
//        event18.getPreferences().add(preference9);

        Event event19 = new Event();
        event19.setTitle("Pet Fashion Day");
        event19.setStartDate(format1.parse("2019-05-10"));
        event19.setDescription("We have this event to build relationship with colleges with the help of your pets.Pets nowadays are more and more popular, espicially for those young person who live alone, pets give us a feeling of warmth and trust.Hope you can enjoy the time.And take your pets to the company and share with other staff ");
        event19.setMaxNumber("15");
        event19.setLocation("Hong Kong");
        event19.setPhotoURL("event19.png");
//        event19.getPreferences().add(preference10);

        Event event20 = new Event();
        event20.setTitle("World Cat Day");
        event20.setStartDate(format1.parse("2019-12-09"));
        event20.setDescription("We have this event to help cats. No matter where they are, how far we have to travel to get them, how much time it takes to rehabilitate them or how much care to heal them, we will help all cats.it's the day to celebrate all cats do to enrich our lives. To celebrate, we've put together a list of 7 amazing cats who exemplify cat greatness. So, cuddle up with your feline friends and enjoy!");
        event20.setMaxNumber("20");
        event20.setLocation("Shanghai");
        event20.setPhotoURL("event20.png");
//        event20.getPreferences().add(preference10);



        User user1 = new User();
        user1.setEmail("ellacheng@hackathon.com");
        user1.setUsername("ellacheng");
        user1.setPassword("ellacheng");
        user1.setBirthday(format1.parse("1993-08-08"));
        user1.setName("Ella Cheng");
        user1.setLocation("Hong Kong");
        user1.setPhotoURL("ellacheng.jpg");
//        user1.getPreferences().add(preference1);
//        user1.getPreferences().add(preference2);
//        user1.getPreferences().add(preference3);
//
//        user1.getUserCreatedEvents().add(event1);
//        user1.getUserCreatedEvents().add(event3);
//        user1.getUserCreatedEvents().add(event5);
//        user1.getUserCreatedEvents().add(event7);
//        user1.getUserCreatedEvents().add(event9);
//
//        user1.getUserInterestEvents().add(event2);
//        user1.getUserInterestEvents().add(event4);
//        user1.getUserInterestEvents().add(event6);
//        user1.getUserInterestEvents().add(event13);
//        user1.getUserInterestEvents().add(event14);
//        user1.getUserInterestEvents().add(event15);
////un coming
//        user1.getUserJointEvents().add(event1);
//        user1.getUserJointEvents().add(event3);
//        user1.getUserJointEvents().add(event5);
//        user1.getUserJointEvents().add(event7);
//        user1.getUserJointEvents().add(event9);
//        // finished
//        user1.getUserJointEvents().add(event10);
//        user1.getUserJointEvents().add(event11);
//        user1.getUserJointEvents().add(event12);
//        user1.getUserJointEvents().add(event13);
//        user1.getUserJointEvents().add(event14);
//        user1.getUserJointEvents().add(event15);
//        user1.getUserJointEvents().add(event16);
//        user1.getUserJointEvents().add(event17);
//        user1.getUserJointEvents().add(event18);
//        user1.getUserJointEvents().add(event19);
//        user1.getUserJointEvents().add(event20);

        User user2 = new User();
        user2.setEmail("kelvinmok@hackathon.com");
        user2.setUsername("kelvinmok");
        user2.setPassword("kelvinmok");
        user2.setBirthday(format1.parse("1991-03-08"));
        user2.setName("Kelvin Mok");
        user2.setLocation("Hong Kong");
        user2.setPhotoURL("kelvinmok.jpg");
//        user2.getPreferences().add(preference3);
//        user2.getPreferences().add(preference4);
//        user2.getPreferences().add(preference5);
//        user2.getUserCreatedEvents().add(event2);
//        user2.getUserCreatedEvents().add(event4);
//
//        //un coming
//        user2.getUserJointEvents().add(event1);
//        user2.getUserJointEvents().add(event3);
//        user2.getUserJointEvents().add(event5);
//        user2.getUserJointEvents().add(event7);
//        user2.getUserJointEvents().add(event9);
//        // finished
//        user2.getUserJointEvents().add(event10);
//        user2.getUserJointEvents().add(event11);
//        user2.getUserJointEvents().add(event12);
//        user2.getUserJointEvents().add(event13);
//        user2.getUserJointEvents().add(event14);
//        user2.getUserJointEvents().add(event15);
//        user2.getUserJointEvents().add(event16);
//        user2.getUserJointEvents().add(event17);
//        user2.getUserJointEvents().add(event18);


        User user3 = new User();
        user3.setEmail("rogertam@hackathon.com");
        user3.setUsername("rogertam");
        user3.setPassword("rogertam");
        user3.setBirthday(format1.parse("1992-08-08"));
        user3.setName("Roger Tam");
        user3.setLocation("Hong Kong");
        user3.setPhotoURL("rogertam.jpg");
//        user3.getPreferences().add(preference6);
//        user3.getPreferences().add(preference7);
//        user3.getPreferences().add(preference8);
//        //create
//        user3.getUserCreatedEvents().add(event6);
//        user3.getUserCreatedEvents().add(event8);
//        //un coming
//        user3.getUserJointEvents().add(event1);
//        user3.getUserJointEvents().add(event3);
//        user3.getUserJointEvents().add(event5);
//        user3.getUserJointEvents().add(event7);
//        user3.getUserJointEvents().add(event9);
//        // finished
//        user3.getUserJointEvents().add(event10);
//        user3.getUserJointEvents().add(event11);
//        user3.getUserJointEvents().add(event12);
//        user3.getUserJointEvents().add(event13);
//        user3.getUserJointEvents().add(event14);
//        user3.getUserJointEvents().add(event15);
//        user3.getUserJointEvents().add(event16);

        User user4 = new User();
        user4.setEmail("fionachow@hackathon.com");
        user4.setUsername("fionachow");
        user4.setPassword("fionachow");
        user4.setBirthday(format1.parse("1994-07-08"));
        user4.setName("Fiona Chow");
        user4.setLocation("Hong Kong");
        user4.setPhotoURL("fionachow.jpg");
//        user4.getPreferences().add(preference9);
//        user4.getPreferences().add(preference10);
//        user4.getPreferences().add(preference1);
//        user4.getUserCreatedEvents().add(event10);
//        user4.getUserCreatedEvents().add(event11);
//
//        //un coming
//        user4.getUserJointEvents().add(event1);
//        user4.getUserJointEvents().add(event3);
//        user4.getUserJointEvents().add(event5);
//        user4.getUserJointEvents().add(event7);
//        user4.getUserJointEvents().add(event9);
//        // finished
//        user4.getUserJointEvents().add(event10);
//        user4.getUserJointEvents().add(event11);
//        user4.getUserJointEvents().add(event12);
//        user4.getUserJointEvents().add(event13);


        User user5 = new User();
        user5.setEmail("danwu@hackathon.com");
        user5.setUsername("danwu");
        user5.setPassword("danwu");
        user5.setBirthday(format1.parse("2000-11-08"));
        user5.setName("Dan Wu");
        user5.setLocation("Shanghai");
        user5.setPhotoURL("danwu.jpg");
//        user5.getPreferences().add(preference2);
//        user5.getPreferences().add(preference3);
//        user5.getPreferences().add(preference4);
//        user5.getUserCreatedEvents().add(event12);
//        user5.getUserCreatedEvents().add(event13);
//        //un coming
//        user5.getUserJointEvents().add(event1);
//        user5.getUserJointEvents().add(event3);
//        user5.getUserJointEvents().add(event5);
//        user5.getUserJointEvents().add(event7);
//        user5.getUserJointEvents().add(event9);
//        // finished
//        user5.getUserJointEvents().add(event10);


        User user6 = new User();
        user6.setEmail("linichen@hackathon.com");
        user6.setUsername("linichen");
        user6.setPassword("linichen");
        user6.setBirthday(format1.parse("2000-09-27"));
        user6.setName("Lini Chen");
        user6.setLocation("Shanghai");
        user6.setPhotoURL("linichen.jpg");
//        user6.getPreferences().add(preference5);
//        user6.getPreferences().add(preference6);
//        user6.getPreferences().add(preference7);
//        user6.getUserCreatedEvents().add(event14);
//        user6.getUserCreatedEvents().add(event15);
//        //un coming
//        user6.getUserJointEvents().add(event1);
//        user6.getUserJointEvents().add(event3);
//        user6.getUserJointEvents().add(event5);
//        user6.getUserJointEvents().add(event9);
//        // finished
//        user6.getUserJointEvents().add(event10);

        User user7 = new User();
        user7.setEmail("meihanwan@hackathon.com");
        user7.setUsername("meihanwan");
        user7.setPassword("meihanwan");
        user7.setBirthday(format1.parse("2008-08-08"));
        user7.setName("Meihan Wan");
        user7.setLocation("Shanghai");
        user7.setPhotoURL("meihanwan.jpg");
//        user7.getPreferences().add(preference8);
//        user7.getPreferences().add(preference9);
//        user7.getPreferences().add(preference10);
//        user7.getUserCreatedEvents().add(event15);
//        user7.getUserCreatedEvents().add(event16);
////un coming
//        user7.getUserJointEvents().add(event1);
//        user7.getUserJointEvents().add(event3);
//
//        // finished
//        user7.getUserJointEvents().add(event10);

        User user8 = new User();
        user8.setEmail("xinxiongkong@hackathon.com");
        user8.setUsername("xinxiongkong");
        user8.setPassword("xinxiongkong");
        user8.setBirthday(format1.parse("1958-09-06"));
        user8.setName("Xinxiong Kong");
        user8.setLocation("Shanghai");
        user8.setPhotoURL("xinxiongkong.jpg");
//        user8.getPreferences().add(preference1);
//        user8.getPreferences().add(preference2);
//        user8.getPreferences().add(preference3);
//        user8.getUserCreatedEvents().add(event17);
//        user8.getUserCreatedEvents().add(event18);
//
//        user8.getUserJointEvents().add(event3);
//
//        // finished
//        user8.getUserJointEvents().add(event10);

        User user9 = new User();
        user9.setEmail("yoyoho@hackathon.com");
        user9.setUsername("yoyoho");
        user9.setPassword("yoyoho");
        user9.setBirthday(new Date());
        user9.setName("Yoyo Ho");
        user9.setLocation("Shanghai");
        user9.setPhotoURL("yoyoho.jpg");
//        user9.getPreferences().add(preference4);
//        user9.getPreferences().add(preference5);
//        user9.getPreferences().add(preference6);
//        user9.getUserCreatedEvents().add(event19);
//        user9.getUserCreatedEvents().add(event15);


        User user10 = new User();
        user10.setEmail("jojochan@hackathon.com");
        user10.setUsername("jojochan");
        user10.setPassword("jojochan");
        user10.setBirthday(new Date());
        user10.setName("Jojo Chan");
        user10.setLocation("Shanghai");
        user10.setPhotoURL("jojochan.jpg");
//        user10.getPreferences().add(preference7);
//        user10.getPreferences().add(preference8);
//        user10.getPreferences().add(preference9);
//        user10.getUserCreatedEvents().add(event20);

//        event1.setEventCreator(user1);
//        event3.setEventCreator(user1);
//        event5.setEventCreator(user1);
//        event7.setEventCreator(user1);
//        event9.setEventCreator(user1);
//        event2.setEventCreator(user2);
//        event4.setEventCreator(user2);
//        event6.setEventCreator(user3);
//        event8.setEventCreator(user3);
//        event10.setEventCreator(user4);
//        event11.setEventCreator(user4);
//        event12.setEventCreator(user5);
//        event13.setEventCreator(user5);
//        event14.setEventCreator(user6);
//        event15.setEventCreator(user6);
//        event16.setEventCreator(user7);
//        event17.setEventCreator(user8);
//        event18.setEventCreator(user8);
//        event19.setEventCreator(user9);
//        event20.setEventCreator(user10);
        this.preferenceRepository.save(preference1);
        this.preferenceRepository.save(preference2);
        this.preferenceRepository.save(preference3);
        this.preferenceRepository.save(preference4);
        this.preferenceRepository.save(preference5);
        this.preferenceRepository.save(preference6);
        this.preferenceRepository.save(preference7);
        this.preferenceRepository.save(preference8);
        this.preferenceRepository.save(preference9);
        this.preferenceRepository.save(preference10);
        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.save(user4);
        this.userRepository.save(user5);
        this.userRepository.save(user6);
        this.userRepository.save(user7);
        this.userRepository.save(user8);
        this.userRepository.save(user9);
        this.userRepository.save(user10);
        this.eventRepository.save(event1);
        this.eventRepository.save(event2);
        this.eventRepository.save(event3);
        this.eventRepository.save(event4);
        this.eventRepository.save(event5);
        this.eventRepository.save(event6);
        this.eventRepository.save(event7);
        this.eventRepository.save(event8);
        this.eventRepository.save(event9);
        this.eventRepository.save(event10);
        this.eventRepository.save(event11);
        this.eventRepository.save(event12);
        this.eventRepository.save(event13);
        this.eventRepository.save(event14);
        this.eventRepository.save(event15);
        this.eventRepository.save(event16);
        this.eventRepository.save(event17);
        this.eventRepository.save(event18);
        this.eventRepository.save(event19);
        this.eventRepository.save(event20);
    }



}
