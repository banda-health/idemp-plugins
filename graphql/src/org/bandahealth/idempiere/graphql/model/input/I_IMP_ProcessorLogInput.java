package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_IMP_ProcessorLog;

/**
 * Generated Interface for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_IMP_ProcessorLogInput extends I_IMP_ProcessorLog {

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
	 * Set IMP_Processor.
	 *
	 * @param IMP_Processor IMP_Processor
	 */
	void setIMP_ProcessorInput(ForeignEntityInput IMP_Processor);

	/**
	 * Get IMP_Processor.
	 *
	 * @return IMP_Processor
	 */
	ForeignEntityInput IMP_Processor();

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
