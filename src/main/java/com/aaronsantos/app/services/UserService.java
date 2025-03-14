package com.aaronsantos.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public void register(String username, String password)
  {
    System.out.println("[+] Running register() function...");
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
