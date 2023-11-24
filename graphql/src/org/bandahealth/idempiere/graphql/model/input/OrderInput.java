package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MProject;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public class OrderInput extends MOrder_BH {

	private BusinessPartnerInput businessPartner;
	private List<OrderLineInput> orderLines;
	private List<PaymentInput> payments;
	private ReferenceListInput patientType;
	private ReferenceListInput referral;

	public OrderInput() {
		super(Env.getCtx(), 0, null);
	}

	public OrderInput(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
	}

	public OrderInput(MProject project, boolean IsSOTrx, String DocSubTypeSO) {
		super(project, IsSOTrx, DocSubTypeSO);
	}

	public OrderInput(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public void setId(String id) {
		this.set_Value(this.getUUIDColumnName(), id);
	}

	public void setBusinessPartner(BusinessPartnerInput businessPartner) {
		this.businessPartner = businessPartner;
	}

	public BusinessPartnerInput getBusinessPartner() {
		return businessPartner;
	}

	public void setOrderLines(List<OrderLineInput> orderLines) {
		this.orderLines = orderLines;
	}

	public List<OrderLineInput> getOrderLines() {
		return orderLines;
	}

	public void setPayments(List<PaymentInput> payments) {
		this.payments = payments;
	}

	public List<PaymentInput> getPayments() {
		return payments;
	}

	public ReferenceListInput getPatientType() {
		return patientType;
	}

	public ReferenceListInput getReferral() {
		return referral;
	}

	public void setIsSalesTransaction(Boolean isSalesTransaction) {
		this.setIsSOTrx(isSalesTransaction);
	}
}
