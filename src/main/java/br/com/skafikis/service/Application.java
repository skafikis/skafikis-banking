package br.com.skafikis.service;

import br.com.skafikis.domain.repositories.IUserInterface;
import br.com.skafikis.domain.repositories.IUserRepository;
import br.com.skafikis.dto.UserAccountDTO;
import br.com.skafikis.infra.console.ConsoleUI;
import br.com.skafikis.infra.swing.SwingUI;
import br.com.skafikis.infra.testdb.UserTestDBRepository;

import java.util.Scanner;

public class Application {

    public void execute(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Interface: ");
        System.out.println("[1] Console");
        System.out.println("[2] Swing");

        Integer choice = null;

        while (choice == null || (choice != 1 && choice != 2)) {

                System.out.println("Enter choice: ");
                choice = scanner.nextInt();

                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2!");
                }
        }

        IUserInterface userInterface = (choice == 1) ? new ConsoleUI() : new SwingUI();
        IUserRepository userRepository = new UserTestDBRepository();

        //TODO: Need configuration to Supabase
        // Here!

        execute(userInterface, userRepository);
    }

    public void execute(IUserInterface userInterface, IUserRepository userRepository) {

        UserService userService = new UserService(userInterface, userRepository);
        BankingService bankingService = new BankingService(userInterface);

        while (true) {
            Integer option = userInterface.showInitialScreenMenu();

            switch (option) {
                case 1:
                    UserAccountDTO userAccount = userService.handleLogin();

                    if (userAccount != null) {
                        bankingService.execute(userAccount);
                    }
                    break;
                case 2:
                    UserAccountDTO createNewAccount = userService.handleOnboardingAccount();

                    if (createNewAccount != null) {
                        bankingService.execute(createNewAccount);
                    }
                    break;
                case 3:
                    userInterface.showExitMessage();
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
