package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_IMP_ProcessorParameter;

/**
 * Generated Interface for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_IMP_ProcessorParameterInput extends I_IMP_ProcessorParameter {

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
