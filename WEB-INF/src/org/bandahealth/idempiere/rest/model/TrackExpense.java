package org.bandahealth.idempiere.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "trackexpense")
@JsonInclude(value = Include.NON_NULL)
public class TrackExpense extends Order {

	private static final long serialVersionUID = 1L;

	private Vendor provider;

	public TrackExpense() {
		setIsSalesOrderTransaction(false);
		setExpense(true);
	}

	public TrackExpense(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Vendor provider, String dateOrdered, List<OrderLine> orderLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, false, orderLines, docStatus);

		setExpense(true);
		this.provider = provider;
	}

	public TrackExpense(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Vendor provider, String dateOrdered, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, false, docStatus);

		setExpense(true);
		this.provider = provider;
	}

	@XmlElement
	public Vendor getProvider() {
		return provider;
	}

	public void setProvider(Vendor provider) {
		this.provider = provider;
	}
}
