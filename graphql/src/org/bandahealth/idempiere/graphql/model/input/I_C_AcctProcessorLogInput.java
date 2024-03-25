package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AcctProcessorLog;

/**
 * Generated Interface for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_AcctProcessorLogInput extends I_C_AcctProcessorLog {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set C_AcctProcessor.
	 *
	 * @param C_AcctProcessor Accounting Processor/Server Parameters
	 */
	void setC_AcctProcessorInput(ForeignEntityInput C_AcctProcessor);

	/**
	 * Get C_AcctProcessor.
	 *
	 * @return Accounting Processor/Server Parameters
	 */
	ForeignEntityInput C_AcctProcessor();

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
}
