package br.com.skafikis.infra.swing;

import br.com.skafikis.domain.repositories.IUserInterface;
import br.com.skafikis.dto.LoginDTO;
import br.com.skafikis.dto.UserAccountDTO;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SwingUI implements IUserInterface {
    @Override
    public Integer showInitialScreenMenu() {

        String[] options = new String[] {"Login", "Create Account", "Logout"};

        Integer choice = JOptionPane.showOptionDialog(
                null,
                "Welcome to Skafikis Bank Swing!",
                "Main Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );


        return choice + 1; // remember + 1
    }

    @Override
    public Integer showHomeMenu(String userName) {

        String[] options = new String[] {"Generate QR Code Pix", "Consult Bill", "Pay Bill"};

        Integer choice = JOptionPane.showOptionDialog(
                null,
                "Hello " + userName + "! What do you want to do?",
                "General Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        return choice + 1; // remember + 1
    }

    @Override
    public LoginDTO getLoginData() {

        String document = JOptionPane.showInputDialog("Enter Your Document:");
        String password = JOptionPane.showInputDialog("Enter Your Password:");

        return new LoginDTO(document, password);
    }

    @Override
    public UserAccountDTO getCreateUserData() {

        String name = JOptionPane.showInputDialog("Enter Your Name:");
        String email = JOptionPane.showInputDialog("Enter Your Email:");
        String document = JOptionPane.showInputDialog("Enter Your Document:");
        String accountNumber = JOptionPane.showInputDialog("Enter Your Account Number:");
        String password = JOptionPane.showInputDialog("Enter Your Password:");
        String inputCreatedAt = JOptionPane.showInputDialog("Enter Your Created At (format dd/MM/yyyy HH:mm):");
        String inputDisabledAt = JOptionPane.showInputDialog("Enter Your Disabled At (format dd/MM/yyyy HH:mm):");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime createdAt = LocalDateTime.parse(inputCreatedAt, formatter);
        LocalDateTime disabledAt = LocalDateTime.parse(inputDisabledAt, formatter);

        return new UserAccountDTO(null, name, email, document, accountNumber, password, createdAt, disabledAt);
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
                null,
                "Error" + message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

    }

    @Override
    public void showExitMessage() {
        JOptionPane.showMessageDialog(
                null,
                "Thank you for using Skafikis Bank! Goodbye."
        );
    }
}
