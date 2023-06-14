package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MUserRoles;

public class UserRoles extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private int userId;
	private int roleId;

	public UserRoles() {
	}

	public UserRoles(MUserRoles entity) {
		super(entity);

		this.userId = entity.getAD_User_ID();
		this.roleId = entity.getAD_Role_ID();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
