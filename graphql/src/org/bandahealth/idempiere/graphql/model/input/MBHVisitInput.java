package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MBHVisitInput extends X_BH_VisitInput {
	private List<MBHEncounterInput> BH_Encounters = new ArrayList<>();
	private List<MInvoiceInput> C_Invoices = new ArrayList<>();
	private List<MOrderInput> C_Orders = new ArrayList<>();
	private List<MPaymentInput> C_Payments = new ArrayList<>();
	private List<MInOutInput> M_InOuts = new ArrayList<>();

	@JsonCreator
	public MBHVisitInput(@JsonProperty("ID") String ID) {
		super(ID);
	}

	public List<MBHEncounterInput> getBH_Encounters() {
		return BH_Encounters;
	}

	public void setBH_Encounters(List<MBHEncounterInput> BH_Encounters) {
		this.BH_Encounters = BH_Encounters;
	}

	public List<MInvoiceInput> getC_Invoices() {
		return C_Invoices;
	}

	public void setC_Invoices(List<MInvoiceInput> c_Invoices) {
		C_Invoices = c_Invoices;
	}

	public List<MOrderInput> getC_Orders() {
		return C_Orders;
	}

	public void setC_Orders(List<MOrderInput> c_Orders) {
		C_Orders = c_Orders;
	}

	public List<MPaymentInput> getC_Payments() {
		return C_Payments;
	}

	public void setC_Payments(List<MPaymentInput> c_Payments) {
		C_Payments = c_Payments;
	}

	public List<MInOutInput> getM_InOuts() {
		return M_InOuts;
	}

	public void setM_InOuts(List<MInOutInput> m_InOuts) {
		M_InOuts = m_InOuts;
	}
}
