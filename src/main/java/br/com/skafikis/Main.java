package br.com.skafikis;

import br.com.skafikis.infra.console.ConsoleUI;
import br.com.skafikis.infra.testdb.UserTestDBRepository;
import br.com.skafikis.service.Application;

import java.io.Console;

public class Main {
    public static void main(String[] args) {

        Application app = new Application();

        ConsoleUI consoleUI = new ConsoleUI();
        UserTestDBRepository userTestDBRepository = new UserTestDBRepository();

        app.execute(consoleUI, userTestDBRepository);
    }
}