package ch.zli.m223.ksh19a.as.CRM.model;

import javax.persistence.*;

@Entity(name = "Role")
public class RoleImpl implements Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @ManyToOne
    private AppUserImpl appUser;

    protected RoleImpl() { /* for JPA only*/}

    public RoleImpl(String role, AppUserImpl appUser) {
        super();
        this.role = role;
        this.appUser = appUser;
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getRole() {
        return role;
    }
}
