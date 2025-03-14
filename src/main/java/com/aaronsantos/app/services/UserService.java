package com.aaronsantos.app.services;

import com.aaronsantos.app.entities.User;
import com.aaronsantos.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  public void register(String username, String password)
  {
    System.out.println("[+] Running register() function...");
    System.out.println("[+] Username: " + username);
    System.out.println("[+] Password: " + password);

    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPasswordHash(password);

    userRepository.save(newUser);

    User retrieved = userRepository.findById(newUser.getId()).orElse(null);
    System.out.println("Retrieved user: " + retrieved);
  }

  public void login(String username, String password)
  {
    System.out.println("[+] Running login() function...");
  }

  public void upload(String path)
  {
    System.out.println("[+] Running upload() function...");
  }

  public void view(String song_id)
  {
    System.out.println("[+] Running view() function...");
  }

}
