package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_POS;

/**
 * Generated Interface for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_POSInput extends I_C_POS {

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
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccountInput(ForeignEntityInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	ForeignEntityInput C_BankAccount();

	/**
	 * Set C_BPartnerCashTrx.
	 *
	 * @param C_BPartnerCashTrx Business Partner used for creating new Business Partners on the fly
	 */
	void setC_BPartnerCashTrxInput(ForeignEntityInput C_BPartnerCashTrx);

	/**
	 * Get C_BPartnerCashTrx.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	ForeignEntityInput C_BPartnerCashTrx();

	/**
	 * Set C_CashBook.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	void setC_CashBookInput(ForeignEntityInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	ForeignEntityInput C_CashBook();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(ForeignEntityInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	ForeignEntityInput C_DocType();

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
	 * Set C_POSKeyLayout.
	 *
	 * @param C_POSKeyLayout POS Function Key Layout
	 */
	void setC_POSKeyLayoutInput(ForeignEntityInput C_POSKeyLayout);

	/**
	 * Get C_POSKeyLayout.
	 *
	 * @return POS Function Key Layout
	 */
	ForeignEntityInput C_POSKeyLayout();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(ForeignEntityInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	ForeignEntityInput M_PriceList();

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
	 * Set OSK_KeyLayout.
	 *
	 * @param OSK_KeyLayout The key layout to use for on screen keyboard for text fields.
	 */
	void setOSK_KeyLayoutInput(ForeignEntityInput OSK_KeyLayout);

	/**
	 * Get OSK_KeyLayout.
	 *
	 * @return The key layout to use for on screen keyboard for text fields.
	 */
	ForeignEntityInput OSK_KeyLayout();

	/**
	 * Set OSNP_KeyLayout.
	 *
	 * @param OSNP_KeyLayout The key layout to use for on screen number pad for numeric fields.
	 */
	void setOSNP_KeyLayoutInput(ForeignEntityInput OSNP_KeyLayout);

	/**
	 * Get OSNP_KeyLayout.
	 *
	 * @return The key layout to use for on screen number pad for numeric fields.
	 */
	ForeignEntityInput OSNP_KeyLayout();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(ForeignEntityInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	ForeignEntityInput SalesRep();
}
