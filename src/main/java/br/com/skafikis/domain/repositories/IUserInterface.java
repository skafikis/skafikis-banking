package br.com.skafikis.domain.repositories;

import br.com.skafikis.dto.LoginDTO;
import br.com.skafikis.dto.UserAccountDTO;

public interface IUserInterface {

    Integer showInitialScreenMenu();
    Integer showHomeMenu();
    LoginDTO getLoginData();
    UserAccountDTO getUserData();

    void showErrorMessage(String message);
    void showExitMessage();
}
