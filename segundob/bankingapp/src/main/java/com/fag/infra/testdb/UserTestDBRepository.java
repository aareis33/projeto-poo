package com.fag.infra.testdb;

import java.util.List;

import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserRepository;

public class UserTestDBRepository implements IUserRepository {

    List<UserAccountDTO> userAccounts;

    @Override
    public UserAccountDTO createUser(UserAccountDTO dto) {
        userAccounts.add(dto);

        return dto;
    }

    @Override
    public UserAccountDTO findUserBy(String document) {
        if (userAccounts != null) {
            return userAccounts.stream()
                    .filter(user -> user.getDocument().equals(document))
                    .findFirst()
                    .orElse(null);
        }

        return null;
    }

}
