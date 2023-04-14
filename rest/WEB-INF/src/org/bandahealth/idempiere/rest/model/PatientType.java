package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "patientType")
@JsonInclude(value = Include.NON_NULL)
public class PatientType extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public PatientType() {
	}

	public PatientType(String value) {
		setValue(value);
	}

	public PatientType(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String name, String value) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, null);

		setValue(value);
	}
}
