package ch.zli.m223.ksh19a.as.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import ch.zli.m223.ksh19a.as.CRM.controller.Dto.RoleDTO;
import ch.zli.m223.ksh19a.as.CRM.controller.Dto.UserInputDTO;
import ch.zli.m223.ksh19a.as.CRM.controller.Dto.UserDTO;
import ch.zli.m223.ksh19a.as.CRM.model.AppUser;
import ch.zli.m223.ksh19a.as.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return new UserDTO(userService.getUser(id));
    }

    @PostMapping("/users")
    public UserDTO insertUser(@RequestBody UserInputDTO userData) {
        return new UserDTO(userService.insertUser(userData.name));
    }

    @DeleteMapping("/users/{name}")
    public Long deleteUser(@PathVariable("name") String name) {
        return userService.deleteUser(name);
    }


    @GetMapping("/users/{id}/roles")
    public List<RoleDTO> getRolesFromUser(@PathVariable("id") Long id) {
        AppUser appUser = userService.getUser(id);
        return appUser.getRoles().stream()
                .map(role -> new RoleDTO(role))
                .collect(Collectors.toList());
    }


}
