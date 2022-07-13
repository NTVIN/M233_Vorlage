package ch.zli.m223.ksh19a.as.CRM.repository;

import ch.zli.m223.ksh19a.as.CRM.model.AppUser;
import ch.zli.m223.ksh19a.as.CRM.model.AppUserImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUserImpl, Long> {


    default AppUser insert(String userName, String password) {
        AppUserImpl user = new AppUserImpl(userName, password);
        return save(user);
    }

    Optional<AppUserImpl> findUserByName(String name);

    Long deleteByName(String name);
}
