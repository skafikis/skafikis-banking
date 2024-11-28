package br.com.skafikis.infra.testdb;

import br.com.skafikis.domain.repositories.IUserRepository;
import br.com.skafikis.dto.UserAccountDTO;

import java.util.List;

public class UserTestDBRepository implements IUserRepository {
    List<UserAccountDTO> userAccounts;

    @Override
    public UserAccountDTO createUserAccount(UserAccountDTO userAccountDTO) {
        userAccounts.add(userAccountDTO);

        return userAccountDTO;
    }

    @Override
    public UserAccountDTO findBy(String document) {
        if (userAccounts != null) {
            for (UserAccountDTO userAccountDTO : userAccounts) {
                if (userAccountDTO.getDocument().equals(document)) {
                    return userAccountDTO;
                }
            }
        }

        return null;
    }
}
