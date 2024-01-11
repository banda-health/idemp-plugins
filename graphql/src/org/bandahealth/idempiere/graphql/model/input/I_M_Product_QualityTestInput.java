package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product_QualityTest;

/**
 * Generated Interface for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_Product_QualityTestInput extends I_M_Product_QualityTest {

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
