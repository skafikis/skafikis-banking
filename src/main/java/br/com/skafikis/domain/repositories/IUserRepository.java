package br.com.skafikis.domain.repositories;

import br.com.skafikis.dto.UserAccountDTO;

public interface IUserRepository {
    UserAccountDTO createUserAccount(UserAccountDTO userAccountDTO);
    UserAccountDTO findByDocument(String document);
}
