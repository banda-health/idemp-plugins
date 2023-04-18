package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.compiere.model.MOrg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "organization")
@JsonInclude(value = Include.NON_NULL)
public class Organization extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private List<Role> roles = new ArrayList<>();

	private List<Warehouse> warehouses = new ArrayList<>();

	private OrganizationInformation organizationInformation;

	public Organization() {
	}

	public Organization(MOrg org) {
		super(org, org.getName(), org.getDescription(), null);
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

	public OrganizationInformation getOrganizationInformation() {
		return organizationInformation;
	}

	public void setOrganizationInformation(OrganizationInformation organizationInformation) {
		this.organizationInformation = organizationInformation;
	}
}
