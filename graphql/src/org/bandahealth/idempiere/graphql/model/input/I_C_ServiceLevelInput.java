package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ServiceLevel;

/**
 * Generated Interface for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_ServiceLevelInput extends I_C_ServiceLevel {

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
	 * Set C_RevenueRecognition_Plan.
	 *
	 * @param C_RevenueRecognition_Plan Plan for recognizing or recording revenue
	 */
	void setC_RevenueRecognition_PlanInput(ForeignEntityInput C_RevenueRecognition_Plan);

	/**
	 * Get C_RevenueRecognition_Plan.
	 *
	 * @return Plan for recognizing or recording revenue
	 */
	ForeignEntityInput C_RevenueRecognition_Plan();

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

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();
}
