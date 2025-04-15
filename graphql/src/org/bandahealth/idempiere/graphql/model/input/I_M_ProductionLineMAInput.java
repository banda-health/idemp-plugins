package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ProductionLineMA;

/**
 * Generated Interface for M_ProductionLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_ProductionLineMAInput extends I_M_ProductionLineMA {

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
	 * Set M_ProductionLine.
	 *
	 * @param M_ProductionLine Document Line representing a production
	 */
	void setM_ProductionLineInput(ForeignEntityInput M_ProductionLine);

	/**
	 * Get M_ProductionLine.
	 *
	 * @return Document Line representing a production
	 */
	ForeignEntityInput M_ProductionLine();

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
