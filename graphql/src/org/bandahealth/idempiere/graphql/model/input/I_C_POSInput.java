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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_BankAccount.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	void setC_BankAccount(I_C_BankAccountInput C_BankAccount);

	/**
	 * Get C_BankAccount.
	 *
	 * @return Account at the Bank
	 */
	I_C_BankAccountInput getC_BankAccount();

	/**
	 * Set C_BPartnerCashTrx.
	 *
	 * @param C_BPartnerCashTrx Business Partner used for creating new Business Partners on the fly
	 */
	void setC_BPartnerCashTrx(I_C_BPartnerInput C_BPartnerCashTrx);

	/**
	 * Get C_BPartnerCashTrx.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	I_C_BPartnerInput getC_BPartnerCashTrx();

	/**
	 * Set C_CashBook.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	void setC_CashBook(I_C_CashBookInput C_CashBook);

	/**
	 * Get C_CashBook.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	I_C_CashBookInput getC_CashBook();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocType(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput getC_DocType();

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
	 * Set C_POSKeyLayout.
	 *
	 * @param C_POSKeyLayout POS Function Key Layout
	 */
	void setC_POSKeyLayout(I_C_POSKeyLayoutInput C_POSKeyLayout);

	/**
	 * Get C_POSKeyLayout.
	 *
	 * @return POS Function Key Layout
	 */
	I_C_POSKeyLayoutInput getC_POSKeyLayout();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceList(I_M_PriceListInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	I_M_PriceListInput getM_PriceList();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_Warehouse(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput getM_Warehouse();

	/**
	 * Set OSK_KeyLayout.
	 *
	 * @param OSK_KeyLayout The key layout to use for on screen keyboard for text fields.
	 */
	void setOSK_KeyLayout(I_C_POSKeyLayoutInput OSK_KeyLayout);

	/**
	 * Get OSK_KeyLayout.
	 *
	 * @return The key layout to use for on screen keyboard for text fields.
	 */
	I_C_POSKeyLayoutInput getOSK_KeyLayout();

	/**
	 * Set OSNP_KeyLayout.
	 *
	 * @param OSNP_KeyLayout The key layout to use for on screen number pad for numeric fields.
	 */
	void setOSNP_KeyLayout(I_C_POSKeyLayoutInput OSNP_KeyLayout);

	/**
	 * Get OSNP_KeyLayout.
	 *
	 * @return The key layout to use for on screen number pad for numeric fields.
	 */
	I_C_POSKeyLayoutInput getOSNP_KeyLayout();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRep(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput getSalesRep();
}
