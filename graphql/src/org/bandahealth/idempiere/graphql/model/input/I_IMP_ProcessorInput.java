package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_IMP_Processor;

/**
 * Generated Interface for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_IMP_ProcessorInput extends I_IMP_Processor {

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
	 * Set FrequencyType.
	 *
	 * @param FrequencyType Frequency of event
	 */
	void setFrequencyTypeInput(ForeignEntityInput FrequencyType);

	/**
	 * Get FrequencyType.
	 *
	 * @return Frequency of event
	 */
	ForeignEntityInput FrequencyType();

	/**
	 * Set IMP_Processor_Type.
	 *
	 * @param IMP_Processor_Type IMP_Processor_Type
	 */
	void setIMP_Processor_TypeInput(ForeignEntityInput IMP_Processor_Type);

	/**
	 * Get IMP_Processor_Type.
	 *
	 * @return IMP_Processor_Type
	 */
	ForeignEntityInput IMP_Processor_Type();

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
