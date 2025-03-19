package com.aaronsantos.app.components;

import com.aaronsantos.app.services.MenuService;
import com.aaronsantos.app.entities.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CLIApp implements CommandLineRunner {
  private final MenuService menuService;

  CLIApp(MenuService menuService)
  {
    this.menuService = menuService;
  }

  @Override
  public void run(String... args)
  {
    Scanner s = new Scanner(System.in);
    menuService.splash_screen();
    while(true)
    {
      String user_input = s.nextLine().trim();
      String tokens[] = user_input.split("\\s");

      if(tokens[0].equalsIgnoreCase("exit"))
      {
        System.out.println("[+] Handling exit command...");
        break;
      }
      menuService.handle_user_input(tokens);
    }

    System.out.println("[+] Successfully exited out of program...");
    s.close();
    System.exit(0);
  }
}
