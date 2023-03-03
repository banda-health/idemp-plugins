package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "city")
@JsonInclude(value = Include.NON_NULL)
public class City extends BaseObject {

	private static final long serialVersionUID = 1L;

	private String name;
	private String postal;
	private String areadCode;
	private Country country;

	public City(int id, String name) {
		super(id, name);
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

	public String getAreadCode() {
		return areadCode;
	}

	public void setAreadCode(String areadCode) {
		this.areadCode = areadCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
