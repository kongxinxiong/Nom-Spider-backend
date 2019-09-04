package com.hackathon.Service;


import com.hackathon.PO.User;
import com.hackathon.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    public User save(User user){
        return this.userRepository.save(user);
    }
    public void deleteById (Integer id) {
        this.userRepository.deleteById(id);
    }

    public User findByUsernameAndPassword(String username, String password){
        return this.userRepository.findByUsernameAndPassword(username,password);
    }

    public Optional<User> findById(Integer id) {
        return this.userRepository.findById(id);
    }

}
