package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class M_BH_VisitInput extends X_BH_VisitInput {
	private List<M_BH_EncounterInput> BH_Encounters = new ArrayList<>();
	private List<M_C_InvoiceInput> C_Invoices = new ArrayList<>();
	private List<M_C_OrderInput> C_Orders = new ArrayList<>();
	private List<M_C_PaymentInput> C_Payments = new ArrayList<>();
	private List<M_M_InOutInput> M_InOuts = new ArrayList<>();

	@JsonCreator
	public M_BH_VisitInput(@JsonProperty("ID") String ID) {
		super(ID);
	}

	public List<M_BH_EncounterInput> getBH_Encounters() {
		return BH_Encounters;
	}

	public void setBH_Encounters(List<M_BH_EncounterInput> BH_Encounters) {
		this.BH_Encounters = BH_Encounters;
	}

	public List<M_C_InvoiceInput> getC_Invoices() {
		return C_Invoices;
	}

	public void setC_Invoices(List<M_C_InvoiceInput> c_Invoices) {
		C_Invoices = c_Invoices;
	}

	public List<M_C_OrderInput> getC_Orders() {
		return C_Orders;
	}

	public void setC_Orders(List<M_C_OrderInput> c_Orders) {
		C_Orders = c_Orders;
	}

	public List<M_C_PaymentInput> getC_Payments() {
		return C_Payments;
	}

	public void setC_Payments(List<M_C_PaymentInput> c_Payments) {
		C_Payments = c_Payments;
	}

	public List<M_M_InOutInput> getM_InOuts() {
		return M_InOuts;
	}

	public void setM_InOuts(List<M_M_InOutInput> m_InOuts) {
		M_InOuts = m_InOuts;
	}

	@Override
	public M_AD_OrgInput getAD_Org() {
		return (M_AD_OrgInput) super.getAD_Org();
	}

	@Override
	public M_AD_Ref_ListInput getBH_PatientType_RL() {
		return (M_AD_Ref_ListInput) super.getBH_PatientType_RL();
	}

	@Override
	public M_AD_Ref_ListInput getBH_Process_Stage_RL() {
		return (M_AD_Ref_ListInput) super.getBH_Process_Stage_RL();
	}

	@Override
	public M_AD_Ref_ListInput getBh_referral_RL() {
		return (M_AD_Ref_ListInput) super.getBh_referral_RL();
	}

	@Override
	public M_BH_Voided_ReasonInput getBH_Voided_Reason() {
		return (M_BH_Voided_ReasonInput) super.getBH_Voided_Reason();
	}

	@Override
	public M_C_BPartnerInput getPatient() {
		return (M_C_BPartnerInput) super.getPatient();
	}
}
