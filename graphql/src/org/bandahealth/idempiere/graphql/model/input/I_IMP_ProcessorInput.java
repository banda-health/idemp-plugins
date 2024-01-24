package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_IMP_Processor;

/**
 * Generated Interface for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_IMP_ProcessorInput extends I_IMP_Processor {

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
	 * Set FrequencyType.
	 *
	 * @param FrequencyType Frequency of event
	 */
	void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType);

	/**
	 * Get FrequencyType.
	 *
	 * @return Frequency of event
	 */
	I_AD_Ref_ListInput FrequencyType();

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
