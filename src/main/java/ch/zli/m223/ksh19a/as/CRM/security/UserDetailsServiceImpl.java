package ch.zli.m223.ksh19a.as.CRM.security;

import ch.zli.m223.ksh19a.as.CRM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       return userRepository.findUserByName(name)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Error");
                });
    }
}
