package com.fr.projetjee.service.impl;

import com.fr.projetjee.persistence.entities.User;
import com.fr.projetjee.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  private UserRepository userRepo;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
      User user = userRepo.getUserByUserName(username);
      if(user != null ){
        return user;
      }else {
        throw new UsernameNotFoundException(username);
      }
      
  }

  public void save(User user) {
    User userEncode = new User();
    userEncode.setUsername(user.getUsername());
    userEncode.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(userEncode);
  }
}
