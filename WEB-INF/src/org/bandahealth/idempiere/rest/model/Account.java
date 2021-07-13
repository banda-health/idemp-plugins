package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.compiere.model.MElementValue;

@XmlRootElement(name = "account")
@JsonInclude(value = Include.NON_NULL)
public class Account extends BaseEntity {
	/**
	 * Empty constructor needed for deserialization
	 */
	public Account() {}

	public Account(MElementValue entity) {
		super(entity, entity.getName(), entity.getDescription(), entity.getValue());
	}

	public Account(String uuid, String name, String description, String value) {
		setUuid(uuid);
		setName(name);
		setDescription(description);
		setValue(value);
	}
}
