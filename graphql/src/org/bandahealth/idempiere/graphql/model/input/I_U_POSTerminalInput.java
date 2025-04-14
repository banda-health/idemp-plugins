package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_U_POSTerminal;

/**
 * Generated Interface for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_U_POSTerminalInput extends I_U_POSTerminal {

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
	 * Set C_CashBPartner.
	 *
	 * @param C_CashBPartner BPartner to be used for Cash transactions
	 */
	void setC_CashBPartnerInput(ForeignEntityInput C_CashBPartner);

	/**
	 * Get C_CashBPartner.
	 *
	 * @return BPartner to be used for Cash transactions
	 */
	ForeignEntityInput C_CashBPartner();

	/**
	 * Set C_TemplateBPartner.
	 *
	 * @param C_TemplateBPartner BPartner that is to be used as template when new customers are created
	 */
	void setC_TemplateBPartnerInput(ForeignEntityInput C_TemplateBPartner);

	/**
	 * Get C_TemplateBPartner.
	 *
	 * @return BPartner that is to be used as template when new customers are created
	 */
	ForeignEntityInput C_TemplateBPartner();

	/**
	 * Set Card_BankAccount.
	 *
	 * @param Card_BankAccount Bank Account on which card transactions will be processed
	 */
	void setCard_BankAccountInput(ForeignEntityInput Card_BankAccount);

	/**
	 * Get Card_BankAccount.
	 *
	 * @return Bank Account on which card transactions will be processed
	 */
	ForeignEntityInput Card_BankAccount();

	/**
	 * Set CardTransferBankAccount.
	 *
	 * @param CardTransferBankAccount Bank account on which to transfer Card transactions
	 */
	void setCardTransferBankAccountInput(ForeignEntityInput CardTransferBankAccount);

	/**
	 * Get CardTransferBankAccount.
	 *
	 * @return Bank account on which to transfer Card transactions
	 */
	ForeignEntityInput CardTransferBankAccount();

	/**
	 * Set CardTransferCashBook.
	 *
	 * @param CardTransferCashBook Cash Book on which to transfer all Card transactions
	 */
	void setCardTransferCashBookInput(ForeignEntityInput CardTransferCashBook);

	/**
	 * Get CardTransferCashBook.
	 *
	 * @return Cash Book on which to transfer all Card transactions
	 */
	ForeignEntityInput CardTransferCashBook();

	/**
	 * Set CardTransferType.
	 *
	 * @param CardTransferType CardTransferType
	 */
	void setCardTransferTypeInput(ForeignEntityInput CardTransferType);

	/**
	 * Get CardTransferType.
	 *
	 * @return CardTransferType
	 */
	ForeignEntityInput CardTransferType();

	/**
	 * Set CashBookTransferType.
	 *
	 * @param CashBookTransferType Where the money in the cash book should be transferred to. Either a Bank Account or another Cash Book
	 */
	void setCashBookTransferTypeInput(ForeignEntityInput CashBookTransferType);

	/**
	 * Get CashBookTransferType.
	 *
	 * @return Where the money in the cash book should be transferred to. Either a Bank Account or another Cash Book
	 */
	ForeignEntityInput CashBookTransferType();

	/**
	 * Set CashTransferBankAccount.
	 *
	 * @param CashTransferBankAccount Bank Account on which to transfer all Cash transactions
	 */
	void setCashTransferBankAccountInput(ForeignEntityInput CashTransferBankAccount);

	/**
	 * Get CashTransferBankAccount.
	 *
	 * @return Bank Account on which to transfer all Cash transactions
	 */
	ForeignEntityInput CashTransferBankAccount();

	/**
	 * Set CashTransferCashBook.
	 *
	 * @param CashTransferCashBook Cash Book on which to transfer all Cash transactions
	 */
	void setCashTransferCashBookInput(ForeignEntityInput CashTransferCashBook);

	/**
	 * Get CashTransferCashBook.
	 *
	 * @return Cash Book on which to transfer all Cash transactions
	 */
	ForeignEntityInput CashTransferCashBook();

	/**
	 * Set Check_BankAccount.
	 *
	 * @param Check_BankAccount Bank Account to be used for processing Check transactions
	 */
	void setCheck_BankAccountInput(ForeignEntityInput Check_BankAccount);

	/**
	 * Get Check_BankAccount.
	 *
	 * @return Bank Account to be used for processing Check transactions
	 */
	ForeignEntityInput Check_BankAccount();

	/**
	 * Set CheckTransferBankAccount.
	 *
	 * @param CheckTransferBankAccount Bank account on which to transfer Check transactions
	 */
	void setCheckTransferBankAccountInput(ForeignEntityInput CheckTransferBankAccount);

	/**
	 * Get CheckTransferBankAccount.
	 *
	 * @return Bank account on which to transfer Check transactions
	 */
	ForeignEntityInput CheckTransferBankAccount();

	/**
	 * Set CheckTransferCashBook.
	 *
	 * @param CheckTransferCashBook Cash Book on which to transfer all Check transactions
	 */
	void setCheckTransferCashBookInput(ForeignEntityInput CheckTransferCashBook);

	/**
	 * Get CheckTransferCashBook.
	 *
	 * @return Cash Book on which to transfer all Check transactions
	 */
	ForeignEntityInput CheckTransferCashBook();

	/**
	 * Set CheckTransferType.
	 *
	 * @param CheckTransferType CheckTransferType
	 */
	void setCheckTransferTypeInput(ForeignEntityInput CheckTransferType);

	/**
	 * Get CheckTransferType.
	 *
	 * @return CheckTransferType
	 */
	ForeignEntityInput CheckTransferType();

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
	 * Set PO_PriceList.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	void setPO_PriceListInput(ForeignEntityInput PO_PriceList);

	/**
	 * Get PO_PriceList.
	 *
	 * @return Price List used by this Business Partner
	 */
	ForeignEntityInput PO_PriceList();

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

	/**
	 * Set SO_PriceList.
	 *
	 * @param SO_PriceList SO_PriceList
	 */
	void setSO_PriceListInput(ForeignEntityInput SO_PriceList);

	/**
	 * Get SO_PriceList.
	 *
	 * @return SO_PriceList
	 */
	ForeignEntityInput SO_PriceList();

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
