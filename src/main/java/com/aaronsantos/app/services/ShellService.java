package com.aaronsantos.app.services;

import java.io.File;

import org.springframework.stereotype.Service;

@Service 
public class ShellService {
  public void init_music_lib(String username) {
    String PATH = "/home/aaronsantos/repos/music-server/music-library/" + username + "/";

    System.out.println("[+] Initializing music library...");
    System.out.println("[+] Path of library: " + PATH);

    File userLib = new File(PATH);
    if(!userLib.exists()) {
      userLib.mkdirs();
      System.out.println("[+] User library directory created successfully.");
    }
  }
}
