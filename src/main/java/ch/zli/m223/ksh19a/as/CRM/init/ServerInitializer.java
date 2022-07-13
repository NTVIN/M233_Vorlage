package ch.zli.m223.ksh19a.as.CRM.init;

import ch.zli.m223.ksh19a.as.CRM.model.AppUser;
import ch.zli.m223.ksh19a.as.CRM.repository.RoleRepository;
import ch.zli.m223.ksh19a.as.CRM.repository.UserRepository;
import ch.zli.m223.ksh19a.as.CRM.roles.ApppRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ServerInitializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        AppUser hans = userRepository.insert("Hans", "1234");
        roleRepository.insert(ApppRoles.ADMIN, hans);
        roleRepository.insert(ApppRoles.USER, hans);

        AppUser peter = userRepository.insert("Peter", "1234");
        roleRepository.insert(ApppRoles.USER, peter);
    }
}
