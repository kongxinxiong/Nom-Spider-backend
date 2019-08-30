package com.hackathon.PO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    @NotBlank(message="title cannot be empty")
    private String title;
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userID")
    private User eventCreator;
    @Column(name = "startDate")
    @NotBlank(message="startDate cannot be empty")
    private Date startDate;
    @Column(name = "endDate")
    @NotBlank(message="end date cannot be empty")
    private Date endDate;
    @Column(name="location")
    private String location;
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(name="event_joint_user_mapping",joinColumns=@JoinColumn(name="eventID"),inverseJoinColumns=@JoinColumn(name="jointUserID"))
    private Set<User> eventJointUsers= new HashSet<User>();

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(name="event_preference_mapping",joinColumns=@JoinColumn(name="eventID"),inverseJoinColumns=@JoinColumn(name="preferenceID"))
    private Set<Preference> preferences= new HashSet<Preference>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(User eventCreator) {
        this.eventCreator = eventCreator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Preference> preferences) {
        this.preferences = preferences;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<User> getEventJointUsers() {
        return eventJointUsers;
    }

    public void setEventJointUsers(Set<User> eventJointUsers) {
        this.eventJointUsers = eventJointUsers;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
