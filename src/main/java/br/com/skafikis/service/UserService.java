package br.com.skafikis.service;

import br.com.skafikis.domain.entities.UserAccount;
import br.com.skafikis.domain.repositories.IUserInterface;
import br.com.skafikis.domain.repositories.IUserRepository;
import br.com.skafikis.dto.LoginDTO;
import br.com.skafikis.dto.UserAccountDTO;

public class UserService {

    private IUserInterface userInterface;
    private IUserRepository userRepository;

    public UserService(IUserInterface userInterface, IUserRepository userRepository) {
        this.userInterface = userInterface;
        this.userRepository = userRepository;
    }

    public UserAccountDTO handleLogin() {

        LoginDTO login = userInterface.getLoginData();
        UserAccountDTO userAccount = userRepository.findBy(login.getDocument());

        if (userAccount == null) {
            userInterface.showErrorMessage("Invalid document or password");
        }

        return userAccount;
    }

    public UserAccountDTO handleOnboardingAccount() {

        UserAccountDTO userAccount = userInterface.getCreateUserData();
        UserAccount account = UserAccountConverts.toEntity(userAccount);

        UserAccountDTO savedUser = userRepository.createUserAccount(UserAccountConverts.toDTO(account));

        return savedUser;
    }
}
