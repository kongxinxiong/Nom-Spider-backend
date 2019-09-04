package com.hackathon.VO;
import java.util.HashSet;
import java.util.Set;

public class UserVO {

    private Integer id;
    private String name;
    private String birthday;
    private String location;
    private String username;
    private String password;
    private String email;
    private String photoURL;
    private Set<String> userCreatedEvents = new HashSet<>();
    private Set<String> userJointEvents = new HashSet<>();
    private Set<String> preferences = new HashSet<String>();
    private Set<String> userInterestEvents = new HashSet<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Set<String> getUserCreatedEvents() {
        return userCreatedEvents;
    }

    public void setUserCreatedEvents(Set<String> userCreatedEvents) {
        this.userCreatedEvents = userCreatedEvents;
    }

    public Set<String> getUserJointEvents() {
        return userJointEvents;
    }

    public void setUserJointEvents(Set<String> userJointEvents) {
        this.userJointEvents = userJointEvents;
    }

    public Set<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<String> preferences) {
        this.preferences = preferences;
    }

    public Set<String> getUserInterestEvents() {
        return userInterestEvents;
    }

    public void setUserInterestEvents(Set<String> userInterestEvents) {
        this.userInterestEvents = userInterestEvents;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", location='" + location + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", userCreatedEvents=" + userCreatedEvents +
                ", userJointEvents=" + userJointEvents +
                ", preferences=" + preferences +
                ", userInterestEvents=" + userInterestEvents +
                '}';
    }
}
