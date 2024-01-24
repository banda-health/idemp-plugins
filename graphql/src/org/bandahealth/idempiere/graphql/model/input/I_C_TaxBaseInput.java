package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_C_TaxBase;

/**
 * Generated Interface for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_TaxBaseInput extends I_C_TaxBase {

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
	 * Set Base.
	 *
	 * @param Base Calculation Base
	 */
	void setBaseInput(I_AD_Ref_ListInput Base);

	/**
	 * Get Base.
	 *
	 * @return Calculation Base
	 */
	I_AD_Ref_ListInput Base();

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
