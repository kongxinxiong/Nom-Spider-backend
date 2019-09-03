package com.hackathon.PO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    @NotBlank(message="name cannot be empty")
    private String name;
    @Column(name="birthday")
    @NotNull(message="birthday cannot be empty")
    private Date birthday;
    @Column(name="location")
    private String location;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    @NotBlank(message="email cannot be empty")
    @Email(message="you must input a valid email address")
    @Pattern(regexp = "[a-zA-Z]*@hackathon.com", message="you must input hackathon email address")
    private String email;
    @Column(name="photoURL")
    private String photoURL;
    @JsonIgnore
    @OneToMany(mappedBy="eventCreator",fetch = FetchType.LAZY)
    private Set<Event> userCreatedEvents = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy="eventJointUsers", fetch = FetchType.LAZY)
    private Set<Event> jointEvents = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(name="user_preference_mapping",joinColumns=@JoinColumn(name="userID"),inverseJoinColumns=@JoinColumn(name="preferenceID"))
    private Set<Preference> preferences = new HashSet<Preference>();
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(name="user_interest_events_mapping",joinColumns=@JoinColumn(name="userID"),inverseJoinColumns=@JoinColumn(name="eventID"))
    private Set<Event> userInterestEvents = new HashSet<Event>();

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Event> getUserCreatedEvents() {
        return userCreatedEvents;
    }

    public void setUserCreatedEvents(Set<Event> userCreatedEvents) {
        this.userCreatedEvents = userCreatedEvents;
    }

    public Set<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Preference> preferences) {
        this.preferences = preferences;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Event> getJointEvents() {
        return jointEvents;
    }

    public void setJointEvents(Set<Event> jointEvents) {
        this.jointEvents = jointEvents;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Event> getUserInterestEvents() {
        return userInterestEvents;
    }

    public void setUserInterestEvents(Set<Event> userInterestEvents) {
        this.userInterestEvents = userInterestEvents;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
