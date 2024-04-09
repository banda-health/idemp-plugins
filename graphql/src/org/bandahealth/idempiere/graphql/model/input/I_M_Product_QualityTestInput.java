package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product_QualityTest;

/**
 * Generated Interface for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_Product_QualityTestInput extends I_M_Product_QualityTest {

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
	 * Set M_QualityTest.
	 *
	 * @param M_QualityTest M_QualityTest
	 */
	void setM_QualityTestInput(ForeignEntityInput M_QualityTest);

	/**
	 * Get M_QualityTest.
	 *
	 * @return M_QualityTest
	 */
	ForeignEntityInput M_QualityTest();
}
