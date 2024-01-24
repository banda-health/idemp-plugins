package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_EXP_Processor;

/**
 * Generated Interface for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_EXP_ProcessorInput extends I_EXP_Processor {

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
	 * Set EXP_Processor_Type.
	 *
	 * @param EXP_Processor_Type EXP_Processor_Type
	 */
	void setEXP_Processor_TypeInput(ForeignEntityInput EXP_Processor_Type);

	/**
	 * Get EXP_Processor_Type.
	 *
	 * @return EXP_Processor_Type
	 */
	ForeignEntityInput EXP_Processor_Type();

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
