package ch.zli.m223.ksh19a.as.CRM.controller.Dto;

import ch.zli.m223.ksh19a.as.CRM.model.Role;

public class RoleDTO {
    public String roleName;

    public RoleDTO(Role role) {
        this.roleName = role.getRole();
    }
}
