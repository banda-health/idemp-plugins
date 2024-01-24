package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Warehouse_Acct;

/**
 * Generated Interface for M_Warehouse_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_Warehouse_AcctInput extends I_M_Warehouse_Acct {

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(ForeignEntityInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_Warehouse();

	/**
	 * Set W_Differences_A.
	 *
	 * @param W_Differences_A Warehouse Differences Account
	 */
	void setW_Differences_AInput(ForeignEntityInput W_Differences_A);

	/**
	 * Get W_Differences_A.
	 *
	 * @return Warehouse Differences Account
	 */
	ForeignEntityInput W_Differences_A();
}
