package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ServiceLevelLine;

/**
 * Generated Interface for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ServiceLevelLineInput extends I_C_ServiceLevelLine {

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
	 * Set C_ServiceLevel.
	 *
	 * @param C_ServiceLevel Product Revenue Recognition Service Level 
	 */
	void setC_ServiceLevelInput(ForeignEntityInput C_ServiceLevel);

	/**
	 * Get C_ServiceLevel.
	 *
	 * @return Product Revenue Recognition Service Level 
	 */
	ForeignEntityInput C_ServiceLevel();

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
