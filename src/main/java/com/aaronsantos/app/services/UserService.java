package com.aaronsantos.app.services;

import com.aaronsantos.app.entities.User;
import com.aaronsantos.app.repositories.UserRepository;
import com.aaronsantos.app.services.ShellService;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private final UserRepository userRepository;

  @Autowired
  private final ShellService shellService;

  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ShellService shellService)
  {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.shellService = shellService;
  }

  public void register(String username, String password)
  {
    System.out.println("[+] Running register() function...");
    System.out.println("[+] Registering " + username + "...");
    
    String hashedPass = passwordEncoder.encode(password);

    //Instantiate new user and fill in parameters
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPasswordHash(hashedPass);

    //TODO: Refactor code to first check if username exists
    //
    //if(userRepository.findByUsername(newUser.getUsername()) != null) {
    //  System.out.println("[-] Error: Username already exists.");
    //  return;
    //}
    //
    userRepository.save(newUser);
    shellService.init_music_lib(newUser.getUsername());
  }

  public void login(String username, String password)
  {
    System.out.println("[+] Running login() function...");
    System.out.println("[+] Username: " + username);

    Optional<User> optionalUser = userRepository.findByUsername(username);
    if(optionalUser.isPresent())
    {
        User user = optionalUser.get();
        if(passwordEncoder.matches(password, user.getPasswordHash()))
        {
          System.out.println("LOGIN SUCCESS");
        }
        else 
        {
          System.out.println("[-] LOGIN FAILED: Invalid Credentials");
        }
    }
    else 
    {
      System.out.println("[-] LOGIN FAILED: No user of name " + username + " was found.");
    }
  }

  public void upload(String path)
  {
    System.out.println("[+] Running upload() function...");
    System.out.println("[+] Given Path: " + path);
    System.out.println("[+] Validating Path parameter...");
  }

  public void view(String song_id)
  {
    System.out.println("[+] Running view() function...");
    System.out.println("[+] Given Song ID: " + song_id);
    System.out.println("[+] Validating song_id parameter...");
  }

}
