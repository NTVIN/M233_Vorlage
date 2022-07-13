package ch.zli.m223.ksh19a.as.CRM.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "AppUser")
public class AppUserImpl implements AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<RoleImpl> roles;

    public String passwordHash;


    protected AppUserImpl() {
        /* for JPA only*/
        roles = new ArrayList<>();
    }

    public AppUserImpl(String name, String password) {
        this();
        this.name = name;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.passwordHash = encoder.encode(password);
        roles = new ArrayList<>();
    }


    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getEmail() {
        return name;
    }

    @Override
    public List<Role> getRoles() {
        return new ArrayList<>(roles);
    }

    @Override
    public void addRoleToList(RoleImpl role) {
        roles.add(role);
    }

    //neue MEthoden


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {

        return passwordHash;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
