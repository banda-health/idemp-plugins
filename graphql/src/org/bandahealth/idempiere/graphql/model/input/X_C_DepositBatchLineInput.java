package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MDepositBatchLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_DepositBatchLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_DepositBatchLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDepositBatchLine(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (get_ID() == 0 && C_DepositBatch != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DepositBatch", "C_DepositBatch_UU=?", get_TrxName())
							.setParameters(C_DepositBatch.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DepositBatch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DepositBatch with UUID " + C_DepositBatch.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_DepositBatchLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (C_Payment != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + C_Payment.getUUID());
			}
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
