package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_EXP_ProcessorParameter;

/**
 * Generated Interface for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_EXP_ProcessorParameterInput extends I_EXP_ProcessorParameter {

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
	 * Set EXP_Processor.
	 *
	 * @param EXP_Processor EXP_Processor
	 */
	void setEXP_ProcessorInput(ForeignEntityInput EXP_Processor);

	/**
	 * Get EXP_Processor.
	 *
	 * @return EXP_Processor
	 */
	ForeignEntityInput EXP_Processor();

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
