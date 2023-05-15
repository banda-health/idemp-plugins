package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "patient")
@JsonInclude(value = Include.NON_NULL)
public class Patient extends BusinessPartner {

	private static final long serialVersionUID = 1L;

	public Patient() {
	}

	public Patient(MBPartner_BH model) {
		super(model);
	}

	public Patient(String name, String uuid) {
		setName(name);
		setUuid(uuid);
	}

	public Patient(String uuid, String name, BigDecimal totalOpenBalance) {
		setUuid(uuid);
		setName(name);
		setTotalOpenBalance(totalOpenBalance);
	}
}