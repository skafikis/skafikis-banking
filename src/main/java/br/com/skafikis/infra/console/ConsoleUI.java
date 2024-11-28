package br.com.skafikis.infra.console;

import br.com.skafikis.domain.repositories.IUserInterface;
import br.com.skafikis.dto.LoginDTO;
import br.com.skafikis.dto.UserAccountDTO;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleUI implements IUserInterface {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        Integer option = 0;

        while (option < 1 || option > 3) {
            try {
                System.out.println("Welcome to Skafikis Bank Console!");
                System.out.println("[1] Login");
                System.out.println("[2] Create Account");
                System.out.println("[3] Logout");

                option = Integer.parseInt(scanner.nextLine());

                if (option < 1 || option > 3) {
                    System.out.println("Invalid option! Please try again.");
                }

            } catch (NumberFormatException exception) {
                System.out.println("Invalid option! Please try again.");
            }
        }

        return option;
    }

    @Override
    public Integer showHomeMenu(String userName) {
        Integer option = 0;

        while (option < 1 || option > 3) {
            try {
                System.out.println("Hello " + userName + "! What do you want to do?");
                System.out.println("[1] Generate QR Code Pix");
                System.out.println("[2] Consult Bill");
                System.out.println("[3] Pay Bill");

                option = Integer.parseInt(scanner.nextLine());

                if (option < 1 || option > 3) {
                    System.out.println("Invalid option! Please try again.");
                }

            } catch (NumberFormatException exception) {
                System.out.println("Invalid option! Please try again.");
            }
        }

        return option;
    }

    @Override
    public LoginDTO getLoginData() {
        System.out.println("Enter Your Document:");
        String document = scanner.nextLine();

        System.out.println("Enter Your Password:");
        String password = scanner.nextLine();

        return new LoginDTO(document, password);
    }

    @Override
    public UserAccountDTO getUserData() {
        System.out.println("Enter Your name:");
        String name = scanner.nextLine();

        System.out.println("Enter Your email:");
        String email = scanner.nextLine();

        System.out.println("Enter Your Account Number:");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter Your Crated At:");
        LocalDateTime createdAt = LocalDateTime.parse(scanner.nextLine());

        System.out.println("Enter Your Disabled At:");
        LocalDateTime disabledAt = LocalDateTime.parse(scanner.nextLine());

        return new UserAccountDTO(null, name, email, null, accountNumber, createdAt, disabledAt);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    @Override
    public void showExitMessage() {
        System.out.println("Thank you for using Skafikis Bank! Goodbye.");
    }
}
