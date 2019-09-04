package com.hackathon.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathon.PO.Preference;
import com.hackathon.PO.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SplittableRandom;

public class EventVO {
    private Integer id;
    private String title;
    private Integer eventCreator;
    private String startDate;
    private String location;
    private String description;
    private String maxNumber;
    private String photoURL;
    private Set<String> eventJointUsers= new HashSet<>();
    private Set<String> preferences= new HashSet<>();
    private Set<String> interestedUsers = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(Integer eventCreator) {
        this.eventCreator = eventCreator;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Set<String> getEventJointUsers() {
        return eventJointUsers;
    }

    public void setEventJointUsers(Set<String> eventJointUsers) {
        this.eventJointUsers = eventJointUsers;
    }

    public Set<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<String> preferences) {
        this.preferences = preferences;
    }

    public Set<String> getInterestedUsers() {
        return interestedUsers;
    }

    public void setInterestedUsers(Set<String> interestedUsers) {
        this.interestedUsers = interestedUsers;
    }

    @Override
    public String toString() {
        return "EventVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventCreator=" + eventCreator +
                ", startDate='" + startDate + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", maxNumber='" + maxNumber + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", eventJointUsers=" + eventJointUsers +
                ", preferences=" + preferences +
                ", interestedUsers=" + interestedUsers +
                '}';
    }
}
