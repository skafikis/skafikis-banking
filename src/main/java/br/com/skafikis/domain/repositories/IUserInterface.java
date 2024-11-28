package br.com.skafikis.domain.repositories;

import br.com.skafikis.dto.LoginDTO;
import br.com.skafikis.dto.UserAccountDTO;

public interface IUserInterface {

    Integer showInitialScreenMenu();
    Integer showHomeMenu(String userName);
    LoginDTO getLoginData();
    UserAccountDTO getCreateUserData();

    void showErrorMessage(String message);
    void showExitMessage();
}
