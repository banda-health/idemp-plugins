package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInvoicePaySchedule;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySchedule;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_InvoicePaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoicePayScheduleInput extends MInvoicePaySchedule implements I_C_InvoicePayScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_PaySchedule;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_InvoicePayScheduleInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MInvoicePaySchedule(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 && C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
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
	 * @param C_InvoicePaySchedule_ID Invoice Payment Schedule
	 */

	public void setC_InvoicePaySchedule_ID(int C_InvoicePaySchedule_ID) {
		if (get_ID() == 0) {
			super.setC_InvoicePaySchedule_ID(C_InvoicePaySchedule_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_InvoicePaySchedule_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_InvoicePaySchedule_UU();
	}

	/**
	 * Set Payment Schedule.
	 *
	 * @param C_PaySchedule Payment Schedule Template
	 */
	@JsonProperty("C_PaySchedule")
	public void setC_PayScheduleInput(ForeignEntityInput C_PaySchedule) {
		this.mC_PaySchedule = C_PaySchedule;
		MPaySchedule foreignEntity;
		if (get_ID() == 0 && C_PaySchedule != null &&
				(foreignEntity = new Query(getCtx(), "C_PaySchedule", "C_PaySchedule_UU=?", get_TrxName())
						.setParameters(C_PaySchedule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaySchedule_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payment Schedule.
	 *
	 * @return Payment Schedule Template
	 */
	@JsonProperty("C_PaySchedule")
	public ForeignEntityInput C_PaySchedule() {
		return mC_PaySchedule;
	}
}
