package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "account")
@JsonInclude(value = Include.NON_NULL)
public class Account extends BaseEntity {

	public Account(String uuid, String name, String description, String value) {
		setUuid(uuid);
		setName(name);
		setDescription(description);
		setValue(value);
	}
}
