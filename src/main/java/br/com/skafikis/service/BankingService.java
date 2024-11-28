package br.com.skafikis.service;

import br.com.skafikis.domain.repositories.IUserInterface;
import br.com.skafikis.dto.UserAccountDTO;

public class BankingService {

    private IUserInterface userInterface;

    public BankingService(IUserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void execute(UserAccountDTO userAccount) {
        Integer option = userInterface.showHomeMenu(userAccount.getName());

        System.out.println(option);
    }
}
