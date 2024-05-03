package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BankTransfer;

/**
 * Generated Interface for C_BankTransfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_BankTransferInput extends I_C_BankTransfer {

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
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	ForeignEntityInput C_ConversionType();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(ForeignEntityInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	ForeignEntityInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(ForeignEntityInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	ForeignEntityInput DocStatus();

	/**
	 * Set From_C_BankAccount.
	 *
	 * @param From_C_BankAccount From_C_BankAccount
	 */
	void setFrom_C_BankAccountInput(ForeignEntityInput From_C_BankAccount);

	/**
	 * Get From_C_BankAccount.
	 *
	 * @return From_C_BankAccount
	 */
	ForeignEntityInput From_C_BankAccount();

	/**
	 * Set From_C_BPartner.
	 *
	 * @param From_C_BPartner Identifies a Business Partner
	 */
	void setFrom_C_BPartnerInput(ForeignEntityInput From_C_BPartner);

	/**
	 * Get From_C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput From_C_BPartner();

	/**
	 * Set From_C_Charge.
	 *
	 * @param From_C_Charge From_C_Charge
	 */
	void setFrom_C_ChargeInput(ForeignEntityInput From_C_Charge);

	/**
	 * Get From_C_Charge.
	 *
	 * @return From_C_Charge
	 */
	ForeignEntityInput From_C_Charge();

	/**
	 * Set From_C_Currency.
	 *
	 * @param From_C_Currency From_C_Currency
	 */
	void setFrom_C_CurrencyInput(ForeignEntityInput From_C_Currency);

	/**
	 * Get From_C_Currency.
	 *
	 * @return From_C_Currency
	 */
	ForeignEntityInput From_C_Currency();

	/**
	 * Set From_TenderType.
	 *
	 * @param From_TenderType From_TenderType
	 */
	void setFrom_TenderTypeInput(ForeignEntityInput From_TenderType);

	/**
	 * Get From_TenderType.
	 *
	 * @return From_TenderType
	 */
	ForeignEntityInput From_TenderType();

	/**
	 * Set To_C_BankAccount.
	 *
	 * @param To_C_BankAccount To_C_BankAccount
	 */
	void setTo_C_BankAccountInput(ForeignEntityInput To_C_BankAccount);

	/**
	 * Get To_C_BankAccount.
	 *
	 * @return To_C_BankAccount
	 */
	ForeignEntityInput To_C_BankAccount();

	/**
	 * Set To_C_BPartner.
	 *
	 * @param To_C_BPartner Identifies a Business Partner
	 */
	void setTo_C_BPartnerInput(ForeignEntityInput To_C_BPartner);

	/**
	 * Get To_C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput To_C_BPartner();

	/**
	 * Set To_C_Charge.
	 *
	 * @param To_C_Charge To_C_Charge
	 */
	void setTo_C_ChargeInput(ForeignEntityInput To_C_Charge);

	/**
	 * Get To_C_Charge.
	 *
	 * @return To_C_Charge
	 */
	ForeignEntityInput To_C_Charge();

	/**
	 * Set To_C_Currency.
	 *
	 * @param To_C_Currency To_C_Currency
	 */
	void setTo_C_CurrencyInput(ForeignEntityInput To_C_Currency);

	/**
	 * Get To_C_Currency.
	 *
	 * @return To_C_Currency
	 */
	ForeignEntityInput To_C_Currency();

	/**
	 * Set To_TenderType.
	 *
	 * @param To_TenderType To_TenderType
	 */
	void setTo_TenderTypeInput(ForeignEntityInput To_TenderType);

	/**
	 * Get To_TenderType.
	 *
	 * @return To_TenderType
	 */
	ForeignEntityInput To_TenderType();
}
