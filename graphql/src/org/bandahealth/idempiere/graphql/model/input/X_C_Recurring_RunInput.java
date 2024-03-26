package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRecurring;
import org.compiere.model.MRecurringRun;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Recurring_RunInput extends MRecurringRun implements I_C_Recurring_RunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_Payment;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_Recurring;
	private ForeignEntityInput mGL_JournalBatch;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Recurring_Run_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_Recurring_RunInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (get_ID() != 0) {
			return;
		}
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UUID " + C_Invoice.getUUID());
			}
		} else {
			this.setC_Invoice_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + C_Order.getUUID());
			}
		} else {
			this.setC_Order_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_Payment != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + C_Payment.getUUID());
			}
		} else {
			this.setC_Payment_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_Project != null) {
			// Since an entity was passed, make sure it's in the DB
			MProject foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
			}
		} else {
			this.setC_Project_ID(0);
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
	 * @param C_Recurring Recurring Document
	 */
	@JsonProperty("C_Recurring")
	public void setC_RecurringInput(ForeignEntityInput C_Recurring) {
		this.mC_Recurring = C_Recurring;
		if (get_ID() != 0) {
			return;
		}
		if (C_Recurring != null) {
			// Since an entity was passed, make sure it's in the DB
			MRecurring foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Recurring", "C_Recurring_UU=?", get_TrxName())
							.setParameters(C_Recurring.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Recurring_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Recurring with UUID " + C_Recurring.getUUID());
			}
		} else {
			this.setC_Recurring_ID(0);
		}
	}

	/**
	 * Get Recurring.
	 *
	 * @return Recurring Document
	 */
	@JsonProperty("C_Recurring")
	public ForeignEntityInput C_Recurring() {
		return mC_Recurring;
	}
	/**
	 * Set Recurring Run.
	 *
	 * @param C_Recurring_Run_ID Recurring Document Run
	 */

	public void setC_Recurring_Run_ID(int C_Recurring_Run_ID) {
		if (get_ID() == 0) {
			super.setC_Recurring_Run_ID(C_Recurring_Run_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Recurring_Run_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Recurring_Run_UU();
	}

	/**
	 * Set Journal Batch.
	 *
	 * @param GL_JournalBatch General Ledger Journal Batch
	 */
	@JsonProperty("GL_JournalBatch")
	public void setGL_JournalBatchInput(ForeignEntityInput GL_JournalBatch) {
		this.mGL_JournalBatch = GL_JournalBatch;
		if (get_ID() != 0) {
			return;
		}
		if (GL_JournalBatch != null) {
			// Since an entity was passed, make sure it's in the DB
			MJournalBatch foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_JournalBatch", "GL_JournalBatch_UU=?", get_TrxName())
							.setParameters(GL_JournalBatch.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGL_JournalBatch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_JournalBatch with UUID " + GL_JournalBatch.getUUID());
			}
		} else {
			this.setGL_JournalBatch_ID(0);
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
}
