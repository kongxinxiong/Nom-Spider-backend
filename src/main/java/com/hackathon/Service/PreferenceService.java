package com.hackathon.Service;

import com.hackathon.PO.Preference;
import com.hackathon.Repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {
    @Autowired
    private PreferenceRepository preferenceRepository;

    public Preference save(Preference preference) {
        return this.preferenceRepository.save(preference);
    }

    public List<Preference> findAll () {
        return this.preferenceRepository.findAll();
    }
}
