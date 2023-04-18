package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MLocation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Location extends BaseMetadata {

	private static final long serialVersionUID = 1L;

	private String address1;
	private String address2;
	private String address3;
	private City city;
	private Country country;

	public Location() {
	}

	public Location(MLocation instance) {
		this.address1 = instance.getAddress1();
		this.address2 = instance.getAddress2();
		this.address3 = instance.getAddress3();
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
