package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_QualityTestResult;

/**
 * Generated Interface for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_QualityTestResultInput extends I_M_QualityTestResult {

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
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();

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
