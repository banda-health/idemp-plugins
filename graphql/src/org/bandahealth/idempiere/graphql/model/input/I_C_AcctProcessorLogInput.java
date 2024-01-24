package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AcctProcessorLog;

/**
 * Generated Interface for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_AcctProcessorLogInput extends I_C_AcctProcessorLog {

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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();
}
