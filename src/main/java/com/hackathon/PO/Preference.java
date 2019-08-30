package com.hackathon.PO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PREFERENCE")
public class Preference {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    @NotBlank(message="name cannot be empty")
    private String name;
    @ManyToMany(mappedBy="preferences", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users = new HashSet<User>();
    @ManyToMany(mappedBy="preferences", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Event> events = new HashSet<Event>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Preference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
