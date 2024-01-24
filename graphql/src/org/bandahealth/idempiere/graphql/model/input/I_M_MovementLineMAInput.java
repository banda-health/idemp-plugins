package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_MovementLineMA;

/**
 * Generated Interface for M_MovementLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_MovementLineMAInput extends I_M_MovementLineMA {

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
	 * Set M_MovementLine.
	 *
	 * @param M_MovementLine Inventory Move document Line
	 */
	void setM_MovementLineInput(ForeignEntityInput M_MovementLine);

	/**
	 * Get M_MovementLine.
	 *
	 * @return Inventory Move document Line
	 */
	ForeignEntityInput M_MovementLine();

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
