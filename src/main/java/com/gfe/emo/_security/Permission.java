package com.gfe.emo._security;
/**
 * Clase de modelo para los permisos
 * @author BICUGUAL
 */
public class Permission  {
	
	private int idPermission;
	private String permissionname;
	private String description;
	@Override
	public String toString() {
		return "Permission [idPermission=" + idPermission + ", permissionname=" + permissionname + ", description="
				+ description + "]";
	}
	public int getIdPermission() {
		return idPermission;
	}
	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}
	public String getPermissionname() {
		return permissionname;
	}
	public void setPermissionname(String permissionname) {
		this.permissionname = permissionname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
