package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ServiceLevelLine;

/**
 * Generated Interface for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_ServiceLevelLineInput extends I_C_ServiceLevelLine {

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
