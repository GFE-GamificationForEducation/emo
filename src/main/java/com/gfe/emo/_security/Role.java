package com.gfe.emo._security;

import java.util.List;

/**
 * Clase de modelo para los roles del usuario
 * @author BICUGUAL
 */
public class Role  {
 
    private int idRole;
	private String rolename;
    private String description;
 
    private List<Permission> permissions;
 
    
 
    public List<Permission> getPrivileges() {
        return permissions;
    }
 
    public void setPrivileges(List<Permission> privileges) {
        this.permissions = privileges;
    }

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", rolename=" + rolename + ", description=" + description + ", permissions="
				+ permissions + "]";
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
 
	

	
}