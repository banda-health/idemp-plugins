package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MRole;

@XmlRootElement(name = "role")
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public Role() {
	}
	
	public Role(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public Role(MRole entity) {
		this.setClientId(entity.getAD_Client_ID());
		this.setName(entity.getName());
		this.setClientId(entity.getAD_Client_ID());
	}
	
	public Role(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String value) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, null);

		setValue(value);
	}
}
