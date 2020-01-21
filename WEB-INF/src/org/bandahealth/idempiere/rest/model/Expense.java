package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "expense")
@JsonInclude(value = Include.NON_NULL)
public class Expense extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal amount;

	public Expense(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description, BigDecimal amount) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.amount = amount;
	}

	@XmlElement
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
