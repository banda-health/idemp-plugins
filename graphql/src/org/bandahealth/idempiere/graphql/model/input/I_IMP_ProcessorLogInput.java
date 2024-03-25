package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_IMP_ProcessorLog;

/**
 * Generated Interface for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_IMP_ProcessorLogInput extends I_IMP_ProcessorLog {

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
