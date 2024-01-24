package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_IMP_Processor_Type;

/**
 * Generated Interface for IMP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_IMP_Processor_TypeInput extends I_IMP_Processor_Type {

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
