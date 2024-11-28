package br.com.skafikis.infra.testdb;

import br.com.skafikis.domain.repositories.IUserRepository;
import br.com.skafikis.dto.UserAccountDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTestDBRepository implements IUserRepository {

    private Map<String, UserAccountDTO> dtoMap = new HashMap<>();

    @Override
    public UserAccountDTO createUserAccount(UserAccountDTO userAccountDTO) {
        dtoMap.put(userAccountDTO.getId(), userAccountDTO);

        return userAccountDTO;
    }

    @Override
    public UserAccountDTO findBy(String document) {
        return dtoMap.values()
                .stream()
                .filter(user -> user.getDocument().equals(document))
                .findFirst()
                .orElse(null);
    }
}
