package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.Query;
import org.compiere.model.X_C_PaymentBatch;
import org.compiere.util.Env;

/**
 * Generated Model for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentBatchInput extends X_C_PaymentBatch implements I_C_PaymentBatchInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_PaymentProcessorInput C_PaymentProcessor;

	/**
	 * Standard constructor
	 */
	public X_C_PaymentBatchInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}
	/**
	 * Set Payment Batch.
	 *
	 * @param C_PaymentBatch_ID Payment batch for EFT
	 */

	public void setC_PaymentBatch_ID(int C_PaymentBatch_ID) {
		if (get_ID() == 0) {
			super.setC_PaymentBatch_ID(C_PaymentBatch_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_PaymentBatch_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_PaymentBatch_UU();
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	public void setC_PaymentProcessor(I_C_PaymentProcessorInput C_PaymentProcessor) {
		this.C_PaymentProcessor = C_PaymentProcessor;
		MPaymentProcessor foreignEntity;
		if (C_PaymentProcessor != null &&
				(foreignEntity = new Query(getCtx(), MPaymentProcessor.Table_Name, MPaymentProcessor.COLUMNNAME_C_PaymentProcessor_UU + "=?", get_TrxName())
						.setParameters(C_PaymentProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_PaymentProcessor_ID(foreignEntity.get_ID());
		} else {
			this.setC_PaymentProcessor_ID(0);
		}
	}

	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	public I_C_PaymentProcessorInput getC_PaymentProcessor() {
		return C_PaymentProcessor;
	}
}
