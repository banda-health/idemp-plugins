package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MOrder_BH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "visit")
@JsonInclude(value = Include.NON_NULL)
public class Visit extends Order {

	private static final long serialVersionUID = 1L;
	private Boolean newVisit;
	private String visitNotes;
	private PatientType patientType;
	private String referral;
	private OrderStatus status;

	public Visit() {
		setIsSalesOrderTransaction(true);
	}

	public Visit(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			int businessPartnerId, String businessPartnerName, BigDecimal totalOpenBalance, String dateOrdered,
			BigDecimal grandTotal, Boolean newVisit, String visitNotes, String diagnosis, PatientType patientType,
			String referral, List<OrderLine> orderLines, List<Payment> payments, String documentStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy, businessPartnerId, businessPartnerName,
				totalOpenBalance, dateOrdered, grandTotal, true, diagnosis, orderLines, payments, documentStatus);

		this.newVisit = newVisit;
		this.visitNotes = visitNotes;
		this.patientType = patientType;
		this.referral = referral;

		setIsSalesOrderTransaction(true);
		setOrderStatus();
	}

	public Visit(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String businessPartnerName, PatientType patientType, String dateOrdered, BigDecimal grandTotal,
			String documentStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, businessPartnerName, null, dateOrdered,
				grandTotal, true, null, null, null, documentStatus);

		this.patientType = patientType;
		setIsSalesOrderTransaction(true);
	}

	public Visit getVisitQueue(String created, String uuid, String name, List<OrderLine> orderLines,
			List<Payment> payments) {

		setCreated(created);
		setUuid(uuid);
		setName(name);
		setOrderLines(orderLines);
		setPayments(payments);

		setOrderStatus();

		// don't return orderlines and payments.They are only used to check the order
		// status
		setOrderLines(null);
		setPayments(null);

		return this;
	}

	@XmlElement
	public Boolean isNewVisit() {
		return newVisit;
	}

	public void setNewVisit(Boolean newVisit) {
		this.newVisit = newVisit;
	}

	@XmlElement
	public String getDiagnosis() {
		return super.getDescription();
	}

	public void setDiagnosis(String diagnosis) {
		super.setDescription(diagnosis);
	}

	@XmlElement
	public String getVisitNotes() {
		return visitNotes;
	}

	public void setVisitNotes(String visitNotes) {
		this.visitNotes = visitNotes;
	}

	@XmlElement
	public PatientType getPatientType() {
		return patientType;
	}

	public void setPatientType(PatientType patientType) {
		this.patientType = patientType;
	}

	@XmlElement
	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	@XmlElement
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	/**
	 * WAITING - visit with no clinical, no line items, no payments DISPENSING -
	 * visit with clinical information, no line items, no payments PENDING - visit
	 * with clinical information, line items, no payments, PENDING_COMPLETION -
	 * visit yet to be processed, COMPLETED - completed visit
	 * 
	 * @param entity
	 */
	public void setOrderStatus() {
		if ((this.getOrderLines() == null || this.getOrderLines().size() == 0)
				&& (this.getPayments() == null || this.getPayments().size() == 0)) {
			if (this.getPatientType() == null && this.getReferral() == null && this.getDiagnosis() == null
					&& this.getVisitNotes() == null) {
				this.setStatus(OrderStatus.WAITING);
			} else {
				this.setStatus(OrderStatus.DISPENSING);
			}
		} else if ((this.getOrderLines() != null && this.getOrderLines().size() > 0)
				&& (this.getPayments() == null || this.getPayments().size() == 0)) {
			this.setStatus(OrderStatus.PENDING);
		} else {
			if (MOrder_BH.DOCSTATUS_Completed.equalsIgnoreCase(getDocStatus())) {
				this.setStatus(OrderStatus.COMPLETED);
			} else {
				this.setStatus(OrderStatus.PENDING_COMPLETION);
			}
		}
	}
}
