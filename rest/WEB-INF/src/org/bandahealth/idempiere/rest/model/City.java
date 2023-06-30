package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MCity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class City extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private String name;
	private String postal;
	private String areaCode;
	private Country country;

	public City() {
	}

	public City(MCity instance) {
		super(instance);

		this.name = instance.getName();
		this.postal = instance.getPostal();
		this.areaCode = instance.getAreaCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
