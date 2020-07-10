package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "expense")
@JsonInclude(value = Include.NON_NULL)
public class Expense extends Invoice {

	private static final long serialVersionUID = 1L;

	private Vendor supplier;

	public Expense() {
		setIsSalesOrderTransaction(false);
		setIsExpense(true);
	}

	public Expense(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
								 Vendor supplier, String dateInvoiced, List<InvoiceLine> invoiceLines, String docStatus,
								 BigDecimal grandTotal) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateInvoiced, false, invoiceLines, docStatus);

		setIsExpense(true);
		this.supplier = supplier;
		setGrandTotal(grandTotal);
	}

	public Expense(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
								 Vendor supplier, String dateInvoiced, String docStatus, BigDecimal grandTotal) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateInvoiced, false, docStatus, grandTotal);

		setIsExpense(true);
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
