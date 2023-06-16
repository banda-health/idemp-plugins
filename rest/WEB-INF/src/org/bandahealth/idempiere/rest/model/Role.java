package org.bandahealth.idempiere.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MRole;

@XmlRootElement(name = "role")
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private List<Role> includedRoles;
	private boolean masterRole;

	public Role() {
	}

	public Role(MRole entity) {
		super(entity, entity.getName(), entity.getDescription(), null);
	}

	public Role(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String value) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, null);

		setValue(value);
	}

	public List<Role> getIncludedRoles() {
		return includedRoles;
	}

	public void setIncludedRoles(List<Role> includedRoles) {
		this.includedRoles = includedRoles;
	}

	public boolean isMasterRole() {
		return masterRole;
	}

	public void setMasterRole(boolean masterRole) {
		this.masterRole = masterRole;
	}
}
