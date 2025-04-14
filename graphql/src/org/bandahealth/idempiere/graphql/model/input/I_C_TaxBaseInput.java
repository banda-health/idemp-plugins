package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_C_TaxBase;

/**
 * Generated Interface for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_TaxBaseInput extends I_C_TaxBase {

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
	 * Set Base.
	 *
	 * @param Base Calculation Base
	 */
	void setBaseInput(ForeignEntityInput Base);

	/**
	 * Get Base.
	 *
	 * @return Calculation Base
	 */
	ForeignEntityInput Base();

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
