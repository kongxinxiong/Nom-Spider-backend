package com.hackathon.Repository;
import com.hackathon.PO.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    @Transactional
    void deleteByTitle(String title);
    List<Event> findByTitle(String title);
}
