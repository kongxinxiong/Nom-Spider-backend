package com.hackathon.Repository;
import com.hackathon.Pojo.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
