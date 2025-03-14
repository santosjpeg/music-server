package com.aaronsantos.app;

import com.aaronsantos.app.services.MenuService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

//TODO: Implement to_break flag
//TODO - Migrate handling the exit command to Menu

@SpringBootApplication
public class App {
    public static void main(String[] args) {
      SpringApplication.run(App.class, args);
    }
}
