package com.hackathon.Repository;

import com.hackathon.Pojo.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference,Integer> {
}
