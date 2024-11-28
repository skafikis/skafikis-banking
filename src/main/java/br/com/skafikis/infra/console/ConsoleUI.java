package br.com.skafikis.infra.console;

import br.com.skafikis.domain.repositories.IUserInterface;
import br.com.skafikis.dto.LoginDTO;
import br.com.skafikis.dto.UserAccountDTO;

import java.util.Scanner;

public class ConsoleUI implements IUserInterface {

    public Scanner scanner = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        Integer menu = null;

        while (menu == null) {
            try {
                System.out.println("Welcome to Skafikis Bank Console!");
                System.out.println("[1] Login");
                System.out.println("[2] Create Account");
                System.out.println("[3] Logout");

                menu = Integer.parseInt(scanner.nextLine());

            } catch (Exception exception) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return menu;
    }

    @Override
    public Integer showHomeMenu(String document) {
        Integer menu = null;

        while (menu == null) {
            try {
                System.out.println("Hello, " + document + " !");
                System.out.println("[1] Generate QR Code Pix");
                System.out.println("[2] Consult Bill");
                System.out.println("[3] Make Bill Payment");

                menu = Integer.parseInt(scanner.nextLine());

            } catch (Exception exception) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return menu;
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
        System.out.println("Enter Your Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Your Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Your Document:");
        String document = scanner.nextLine();

        System.out.println("Enter Your Account Number:");
        String number = scanner.nextLine();

        System.out.println("Enter Your Created At:");
        String createAt = scanner.nextLine();

        System.out.println("Enter Your Disabled At:");
        String disabledAt = scanner.nextLine();

        return new UserAccountDTO(null, String email, String document);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showExitMessage() {

    }
}
