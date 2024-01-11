package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRecurring;
import org.compiere.model.Query;
import org.compiere.model.X_C_RecurringGroup;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_Recurring - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RecurringInput extends MRecurring implements I_C_RecurringInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_Payment;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_RecurringGroup;
	private ForeignEntityInput mGL_JournalBatch;
	private I_AD_Ref_ListInput mFrequencyType;
	private I_AD_Ref_ListInput mRecurringType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RecurringInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRecurring(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (C_Order != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
		} else {
			super.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
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

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
		} else {
			super.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}
	/**
	 * Set Recurring.
	 *
	 * @param C_Recurring_ID Recurring Document
	 */

	public void setC_Recurring_ID(int C_Recurring_ID) {
		if (get_ID() == 0) {
			super.setC_Recurring_ID(C_Recurring_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Recurring_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Recurring_UU();
	}

	/**
	 * Set Recurring Group.
	 *
	 * @param C_RecurringGroup Recurring Group
	 */
	@JsonProperty("C_RecurringGroup")
	public void setC_RecurringGroupInput(ForeignEntityInput C_RecurringGroup) {
		this.mC_RecurringGroup = C_RecurringGroup;
		X_C_RecurringGroup foreignEntity;
		if (C_RecurringGroup != null &&
				(foreignEntity = new Query(getCtx(), "C_RecurringGroup", "C_RecurringGroup_UU=?", get_TrxName())
						.setParameters(C_RecurringGroup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_RecurringGroup_ID(foreignEntity.get_ID());
		} else {
			super.setC_RecurringGroup_ID(0);
		}
	}

	/**
	 * Get Recurring Group.
	 *
	 * @return Recurring Group
	 */
	@JsonProperty("C_RecurringGroup")
	public ForeignEntityInput C_RecurringGroup() {
		return mC_RecurringGroup;
	}
	/**
	 * Set Date last run.
	 *
	 * @param DateLastRun Date the process was last run.
	 */

	public void setDateLastRun(Timestamp DateLastRun) {
		if (get_ID() == 0) {
			super.setDateLastRun(DateLastRun);
		}
	}

	/**
	 * Set Frequency Type.
	 *
	 * @param FrequencyType Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType) {
		this.mFrequencyType = FrequencyType;
		MRefList_BH foreignEntity;
		if (FrequencyType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FrequencyType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFrequencyType(foreignEntity.getValue());
		} else {
			this.setFrequencyType(null);
		}
	}

	/**
	 * Get Frequency Type.
	 *
	 * @return Frequency of event
	 */
	@JsonProperty("FrequencyType")
	public I_AD_Ref_ListInput FrequencyType() {
		return mFrequencyType;
	}

	/**
	 * Set Journal Batch.
	 *
	 * @param GL_JournalBatch General Ledger Journal Batch
	 */
	@JsonProperty("GL_JournalBatch")
	public void setGL_JournalBatchInput(ForeignEntityInput GL_JournalBatch) {
		this.mGL_JournalBatch = GL_JournalBatch;
		MJournalBatch foreignEntity;
		if (GL_JournalBatch != null &&
				(foreignEntity = new Query(getCtx(), "GL_JournalBatch", "GL_JournalBatch_UU=?", get_TrxName())
						.setParameters(GL_JournalBatch.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_JournalBatch_ID(foreignEntity.get_ID());
		} else {
			super.setGL_JournalBatch_ID(0);
		}
	}

	/**
	 * Get Journal Batch.
	 *
	 * @return General Ledger Journal Batch
	 */
	@JsonProperty("GL_JournalBatch")
	public ForeignEntityInput GL_JournalBatch() {
		return mGL_JournalBatch;
	}

	/**
	 * Set Recurring Type.
	 *
	 * @param RecurringType Type of Recurring Document
	 */
	@JsonProperty("RecurringType")
	public void setRecurringTypeInput(I_AD_Ref_ListInput RecurringType) {
		this.mRecurringType = RecurringType;
		MRefList_BH foreignEntity;
		if (RecurringType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RecurringType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRecurringType(foreignEntity.getValue());
		} else {
			this.setRecurringType(null);
		}
	}

	/**
	 * Get Recurring Type.
	 *
	 * @return Type of Recurring Document
	 */
	@JsonProperty("RecurringType")
	public I_AD_Ref_ListInput RecurringType() {
		return mRecurringType;
	}
	/**
	 * Set Remaining Runs.
	 *
	 * @param RunsRemaining Number of recurring runs remaining
	 */

	public void setRunsRemaining(int RunsRemaining) {
		if (get_ID() == 0) {
			super.setRunsRemaining(RunsRemaining);
		}
	}
}
