package com.hackathon.Service;

import com.hackathon.PO.Preference;
import com.hackathon.Repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
    public void deleteById (Integer id) {
        this.preferenceRepository.deleteById(id);
    }

    public Optional<Preference> findById(Integer id){
        return this.preferenceRepository.findById(id);
    }
}
