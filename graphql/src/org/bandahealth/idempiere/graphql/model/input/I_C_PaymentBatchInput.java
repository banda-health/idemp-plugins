package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaymentBatch;

/**
 * Generated Interface for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_PaymentBatchInput extends I_C_PaymentBatch {

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
	 * Set C_PaymentProcessor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	void setC_PaymentProcessorInput(ForeignEntityInput C_PaymentProcessor);

	/**
	 * Get C_PaymentProcessor.
	 *
	 * @return Payment processor for electronic payments
	 */
	ForeignEntityInput C_PaymentProcessor();
}
