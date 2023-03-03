package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MOrg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "org")
@JsonInclude(value = Include.NON_NULL)
public class Org extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private List<Role> roles = new ArrayList<>();

	private List<Warehouse> warehouses = new ArrayList<>();

	private OrgInfo orgInfo;

	public Org() {
	}

	public Org(MOrg org) {
		setId(org.get_ID());
		setName(org.getName());
		setUuid(getUuid());
	}

	@XmlElement
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@XmlElement
	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public OrgInfo getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}
}
