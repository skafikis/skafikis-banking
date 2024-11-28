package br.com.skafikis.service;

import br.com.skafikis.domain.entities.UserAccount;
import br.com.skafikis.dto.UserAccountDTO;

public class UserAccountConverts {
    public static UserAccountDTO toDTO(UserAccount userAccount) {
        return new UserAccountDTO(

                userAccount.getId(),
                userAccount.getName(),
                userAccount.getEmail(),
                userAccount.getDocument(),
                userAccount.getAccountNumber(),
                null,
                userAccount.getCreatedAt(),
                userAccount.getDisabledAt()
        );
    }

    public static UserAccount toEntity(UserAccountDTO userAccountDTO) {
        return new UserAccount(

                userAccountDTO.getName(),
                userAccountDTO.getEmail(),
                userAccountDTO.getDocument(),
                userAccountDTO.getAccountNumber(),
                userAccountDTO.getPassword(),
                userAccountDTO.getCreatedAt(),
                userAccountDTO.getDisabledAt()
        );
    }
}
