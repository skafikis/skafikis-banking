package br.com.skafikis.service;

import br.com.skafikis.domain.repositories.IUserInterface;
import br.com.skafikis.domain.repositories.IUserRepository;
import br.com.skafikis.dto.UserAccountDTO;

public class Application {

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
