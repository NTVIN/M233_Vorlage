package ch.zli.m223.ksh19a.as.CRM.service;

import ch.zli.m223.ksh19a.as.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.as.CRM.exception.UserNotFoundException;
import ch.zli.m223.ksh19a.as.CRM.model.AppUser;
import ch.zli.m223.ksh19a.as.CRM.repository.UserRepository;
import ch.zli.m223.ksh19a.as.CRM.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public AppUser getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException("There was no user with the id given.");
        });
    }

    @Override
    public AppUser insertUser(String name) {
        return null;
    }

    public AppUser insertUser(String name, String password) {
        if (name == null) {
            throw new InvalidArgumentException("Name must no be null");
        }
        if (userRepository.findUserByName(name).isPresent()) {
            throw new UserAlreadyExistsException("User with name " + name + " already exists.");
        }

        return userRepository.insert(name,password);
    }

    @Override
    @Transactional
    public Long deleteUser(String name) {
        if (name == null) {
            throw new InvalidArgumentException("Name must no be null");
        }
        if (userRepository.findUserByName(name).isPresent()) {
            return userRepository.deleteByName(name);
        }
        return -1L;
    }


}
