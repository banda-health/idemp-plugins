package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_IMP_ProcessorParameter;

/**
 * Generated Interface for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_IMP_ProcessorParameterInput extends I_IMP_ProcessorParameter {

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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();
}
