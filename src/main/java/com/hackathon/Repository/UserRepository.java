package com.hackathon.Repository;

import com.hackathon.PO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName (String name);
    @Transactional
    void deleteByName(String name);

    User findByUsernameAndPassword(String username, String password);
}
