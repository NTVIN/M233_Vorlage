package ch.zli.m223.ksh19a.as.CRM.service;

import ch.zli.m223.ksh19a.as.CRM.model.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> getAllUsers();

    AppUser getUser(Long id);

    AppUser insertUser(String name);

    Long deleteUser(String name);
}
