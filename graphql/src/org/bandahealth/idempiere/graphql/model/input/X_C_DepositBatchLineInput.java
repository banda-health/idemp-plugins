package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MDepositBatchLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DepositBatchLineInput extends MDepositBatchLine implements I_C_DepositBatchLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_DepositBatch;
	private ForeignEntityInput mC_Payment;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_DepositBatchLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDepositBatchLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Deposit Batch.
	 *
	 * @param C_DepositBatch Deposit Batch
	 */
	@JsonProperty("C_DepositBatch")
	public void setC_DepositBatchInput(ForeignEntityInput C_DepositBatch) {
		this.mC_DepositBatch = C_DepositBatch;
		MDepositBatch foreignEntity;
		if (get_ID() == 0 && C_DepositBatch != null &&
				(foreignEntity = new Query(getCtx(), "C_DepositBatch", "C_DepositBatch_UU=?", get_TrxName())
						.setParameters(C_DepositBatch.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DepositBatch_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Deposit Batch.
	 *
	 * @return Deposit Batch
	 */
	@JsonProperty("C_DepositBatch")
	public ForeignEntityInput C_DepositBatch() {
		return mC_DepositBatch;
	}
	/**
	 * Set Deposit Batch Line.
	 *
	 * @param C_DepositBatchLine_ID Deposit Batch Line
	 */

	public void setC_DepositBatchLine_ID(int C_DepositBatchLine_ID) {
		if (get_ID() == 0) {
			super.setC_DepositBatchLine_ID(C_DepositBatchLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_DepositBatchLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_DepositBatchLine_UU();
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
