package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DepositBatchLine;

/**
 * Generated Interface for C_DepositBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_DepositBatchLineInput extends I_C_DepositBatchLine {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set C_DepositBatch.
	 *
	 * @param C_DepositBatch C_DepositBatch
	 */
	void setC_DepositBatchInput(ForeignEntityInput C_DepositBatch);

	/**
	 * Get C_DepositBatch.
	 *
	 * @return C_DepositBatch
	 */
	ForeignEntityInput C_DepositBatch();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set C_Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	void setC_PaymentInput(ForeignEntityInput C_Payment);

	/**
	 * Get C_Payment.
	 *
	 * @return Payment identifier
	 */
	ForeignEntityInput C_Payment();
}
