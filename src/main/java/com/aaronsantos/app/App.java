package com.aaronsantos.app;
import com.aaronsantos.app.menu.Menu;
import java.util.Scanner;

//TODO: Implement to_break flag
//TODO - Migrate handling the exit command to Menu

public class App {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      Menu.splash_screen();
      while(true)
      {
        String user_input = s.nextLine().trim();
        String tokens[] = user_input.split("[\\s]");

        System.out.println("[+] Input logged " + user_input);

        if(tokens[0].equalsIgnoreCase("exit"))
        {
          if(tokens.length != 1)
          {
            System.out.println("[-] Invalid command: Too many arguments");
            continue;
          }
          System.out.println("[+] Executing exit command.");
          break;
        }

        Menu.handle_user_input(tokens);
      }
      s.close();
    }
}
