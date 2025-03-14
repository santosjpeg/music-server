package com.aaronsantos.app.menu;
import com.aaronsantos.app.commands.Commands;

public class Menu {
  public static void splash_screen()
  {
    System.out.println("Welcome to music-server");
    System.out.println();
  }
  public static void handle_user_input(String[] tokens)
  {
    if(tokens[0].equalsIgnoreCase("login"))
    {
      if(tokens.length != 3)
      {
        System.out.println("[-] Usage: login <username> <password>");
        return;
      }
      System.out.println("[+] Executing login command");
    }
    else if(tokens[0].equalsIgnoreCase("register"))
    {
      if(tokens.length != 3)
      {
        System.out.println("[-] Usage: register <username> <password>");
        return;
      }
      System.out.println("[+] Executing register command");
      Commands.register(tokens[1], tokens[2]);

    }
    else if(tokens[0].equalsIgnoreCase("upload"))
    {
      if(tokens.length != 2)
      {
        System.out.println("[-] Usage: upload <filepath>");
        return;
      }
      System.out.println("[+] Executing upload command");
    }
    else if(tokens[0].equalsIgnoreCase("view"))
    {
      if(tokens.length != 2)
      {
        System.out.println("[-] Usage: view <song_id>");
        return;
      }
      System.out.println("[+] Executing view command");
    }
    else
    {
      valid_commands();
    }
  }
  public static void valid_commands()
  {
    System.out.println("Valid Commands:");
    System.out.println("Login: <username> <password> => Log user into the server");
    System.out.println("Register: <username> <password> = Creates new account and logs user in with new credentials");
    System.out.println("Upload: <path> => Uploads new song and updates database");
    System.out.println("View: <song_id> => View metadata of a song by their ID in the DB.");
    System.out.println();
  }
}
