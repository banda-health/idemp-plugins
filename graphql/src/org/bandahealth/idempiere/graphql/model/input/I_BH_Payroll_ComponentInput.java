package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payroll_Component;

/**
 * Generated Interface for BH_Payroll_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Payroll_ComponentInput extends I_BH_Payroll_Component {

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Set Calculation Method.
	 *
	 * @param BH_CalcMethod Calculation Method
	 */
	void setBH_CalcMethodInput(ForeignEntityInput BH_CalcMethod);

	/**
	 * Get Calculation Method.
	 *
	 * @return Calculation Method
	 */
	ForeignEntityInput BH_CalcMethod();

	/**
	 * Set Category.
	 *
	 * @param BH_Category Category
	 */
	void setBH_CategoryInput(ForeignEntityInput BH_Category);

	/**
	 * Get Category.
	 *
	 * @return Category
	 */
	ForeignEntityInput BH_Category();

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

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
