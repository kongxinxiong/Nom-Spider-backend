package com.hackathon.Repository;

import com.hackathon.Pojo.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PreferenceRepository extends JpaRepository<Preference,Integer> {
    @Transactional
    void deleteByName(String name);
    List<Preference> findByName(String name);
}
