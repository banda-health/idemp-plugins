package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "trackexpense")
@JsonInclude(value = Include.NON_NULL)
public class TrackExpense extends Invoice {

	private static final long serialVersionUID = 1L;

	private Vendor supplier;

	public TrackExpense() {
		setIsSalesOrderTransaction(false);
		setExpense(true);
	}

	public TrackExpense(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
											Vendor supplier, String dateOrdered, List<InvoiceLine> invoiceLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, false, invoiceLines, docStatus);

		setExpense(true);
		this.supplier = supplier;
	}

	public TrackExpense(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
											Vendor supplier, String dateOrdered, String docStatus, BigDecimal grandTotal) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, false, docStatus, grandTotal);

		setExpense(true);
		this.supplier = supplier;
	}

	@XmlElement
	public Vendor getSupplier() {
		return supplier;
	}

	public void setSupplier(Vendor supplier) {
		this.supplier = supplier;
	}
}
