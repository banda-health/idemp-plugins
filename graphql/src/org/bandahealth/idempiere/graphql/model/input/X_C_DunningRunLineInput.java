package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunningRunEntry;
import org.compiere.model.MDunningRunLine;
import org.compiere.model.MInvoicePaySchedule;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_DunningRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningRunLineInput extends MDunningRunLine implements I_C_DunningRunLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_DunningRunEntry;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_InvoicePaySchedule;
	private ForeignEntityInput mC_Payment;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_DunningRunLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDunningRunLine(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Dunning Run Entry.
	 *
	 * @param C_DunningRunEntry Dunning Run Entry
	 */
	@JsonProperty("C_DunningRunEntry")
	public void setC_DunningRunEntryInput(ForeignEntityInput C_DunningRunEntry) {
		this.mC_DunningRunEntry = C_DunningRunEntry;
		MDunningRunEntry foreignEntity;
		if (get_ID() == 0 && C_DunningRunEntry != null &&
				(foreignEntity = new Query(getCtx(), "C_DunningRunEntry", "C_DunningRunEntry_UU=?", get_TrxName())
						.setParameters(C_DunningRunEntry.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DunningRunEntry_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Dunning Run Entry.
	 *
	 * @return Dunning Run Entry
	 */
	@JsonProperty("C_DunningRunEntry")
	public ForeignEntityInput C_DunningRunEntry() {
		return mC_DunningRunEntry;
	}
	/**
	 * Set Dunning Run Line.
	 *
	 * @param C_DunningRunLine_ID Dunning Run Line
	 */

	public void setC_DunningRunLine_ID(int C_DunningRunLine_ID) {
		if (get_ID() == 0) {
			super.setC_DunningRunLine_ID(C_DunningRunLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_DunningRunLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_DunningRunLine_UU();
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
		} else {
			super.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public ForeignEntityInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set Invoice Payment Schedule.
	 *
	 * @param C_InvoicePaySchedule Invoice Payment Schedule
	 */
	@JsonProperty("C_InvoicePaySchedule")
	public void setC_InvoicePayScheduleInput(ForeignEntityInput C_InvoicePaySchedule) {
		this.mC_InvoicePaySchedule = C_InvoicePaySchedule;
		MInvoicePaySchedule foreignEntity;
		if (C_InvoicePaySchedule != null &&
				(foreignEntity = new Query(getCtx(), "C_InvoicePaySchedule", "C_InvoicePaySchedule_UU=?", get_TrxName())
						.setParameters(C_InvoicePaySchedule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_InvoicePaySchedule_ID(foreignEntity.get_ID());
		} else {
			super.setC_InvoicePaySchedule_ID(0);
		}
	}

	/**
	 * Get Invoice Payment Schedule.
	 *
	 * @return Invoice Payment Schedule
	 */
	@JsonProperty("C_InvoicePaySchedule")
	public ForeignEntityInput C_InvoicePaySchedule() {
		return mC_InvoicePaySchedule;
	}

	/**
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(ForeignEntityInput C_Payment) {
		this.mC_Payment = C_Payment;
		MPayment_BH foreignEntity;
		if (C_Payment != null &&
				(foreignEntity = new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
						.setParameters(C_Payment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Payment_ID(foreignEntity.get_ID());
		} else {
			super.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	@JsonProperty("C_Payment")
	public ForeignEntityInput C_Payment() {
		return mC_Payment;
	}
}
