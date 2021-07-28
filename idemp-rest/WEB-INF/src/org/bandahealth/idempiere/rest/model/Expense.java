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

	public Expense(Integer clientId, Integer orgId, String uuid, boolean isActive, String created, Integer createdBy,
								 Vendor supplier, String dateInvoiced, List<InvoiceLine> invoiceLines, String docStatus,
								 BigDecimal grandTotal, String paymentType) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateInvoiced, false,
				invoiceLines, docStatus, paymentType);

		setIsExpense(true);
		this.supplier = supplier;
		setGrandTotal(grandTotal);
	}

	public Expense(Integer clientId, Integer orgId, String uuid, boolean isActive, String created, Integer createdBy,
								 Vendor supplier, String dateInvoiced, String docStatus, BigDecimal grandTotal, String paymentType) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateInvoiced, false,
				docStatus, grandTotal, paymentType);

		setIsExpense(true);
		this.supplier = supplier;
	}

	public Vendor getSupplier() {
		return supplier;
	}

	public void setSupplier(Vendor supplier) {
		this.supplier = supplier;
	}
}
