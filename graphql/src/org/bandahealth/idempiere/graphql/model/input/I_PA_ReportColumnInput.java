package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ReportColumn;

/**
 * Generated Interface for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PA_ReportColumnInput extends I_PA_ReportColumn {

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
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_ActivityInput(ForeignEntityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	ForeignEntityInput C_Activity();

	/**
	 * Set CalculationType.
	 *
	 * @param CalculationType CalculationType
	 */
	void setCalculationTypeInput(ForeignEntityInput CalculationType);

	/**
	 * Get CalculationType.
	 *
	 * @return CalculationType
	 */
	ForeignEntityInput CalculationType();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(ForeignEntityInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	ForeignEntityInput C_Campaign();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_ElementValue.
	 *
	 * @param C_ElementValue Account Element
	 */
	void setC_ElementValueInput(ForeignEntityInput C_ElementValue);

	/**
	 * Get C_ElementValue.
	 *
	 * @return Account Element
	 */
	ForeignEntityInput C_ElementValue();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(ForeignEntityInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	ForeignEntityInput C_Location();

	/**
	 * Set ColumnType.
	 *
	 * @param ColumnType ColumnType
	 */
	void setColumnTypeInput(ForeignEntityInput ColumnType);

	/**
	 * Get ColumnType.
	 *
	 * @return ColumnType
	 */
	ForeignEntityInput ColumnType();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

	/**
	 * Set C_SalesRegion.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	void setC_SalesRegionInput(ForeignEntityInput C_SalesRegion);

	/**
	 * Get C_SalesRegion.
	 *
	 * @return Sales coverage region
	 */
	ForeignEntityInput C_SalesRegion();

	/**
	 * Set CurrencyType.
	 *
	 * @param CurrencyType CurrencyType
	 */
	void setCurrencyTypeInput(ForeignEntityInput CurrencyType);

	/**
	 * Get CurrencyType.
	 *
	 * @return CurrencyType
	 */
	ForeignEntityInput CurrencyType();

	/**
	 * Set ElementType.
	 *
	 * @param ElementType Element Type (account or user defined)
	 */
	void setElementTypeInput(ForeignEntityInput ElementType);

	/**
	 * Get ElementType.
	 *
	 * @return Element Type (account or user defined)
	 */
	ForeignEntityInput ElementType();

	/**
	 * Set Factor.
	 *
	 * @param Factor Scaling factor.
	 */
	void setFactorInput(ForeignEntityInput Factor);

	/**
	 * Get Factor.
	 *
	 * @return Scaling factor.
	 */
	ForeignEntityInput Factor();

	/**
	 * Set GL_Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	void setGL_BudgetInput(ForeignEntityInput GL_Budget);

	/**
	 * Get GL_Budget.
	 *
	 * @return General Ledger Budget
	 */
	ForeignEntityInput GL_Budget();

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
	 * Set Oper_1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	void setOper_1Input(ForeignEntityInput Oper_1);

	/**
	 * Get Oper_1.
	 *
	 * @return First operand for calculation
	 */
	ForeignEntityInput Oper_1();

	/**
	 * Set Oper_2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	void setOper_2Input(ForeignEntityInput Oper_2);

	/**
	 * Get Oper_2.
	 *
	 * @return Second operand for calculation
	 */
	ForeignEntityInput Oper_2();

	/**
	 * Set PAAmountType.
	 *
	 * @param PAAmountType PA Amount Type for reporting
	 */
	void setPAAmountTypeInput(ForeignEntityInput PAAmountType);

	/**
	 * Get PAAmountType.
	 *
	 * @return PA Amount Type for reporting
	 */
	ForeignEntityInput PAAmountType();

	/**
	 * Set PAPeriodType.
	 *
	 * @param PAPeriodType PA Period Type
	 */
	void setPAPeriodTypeInput(ForeignEntityInput PAPeriodType);

	/**
	 * Get PAPeriodType.
	 *
	 * @return PA Period Type
	 */
	ForeignEntityInput PAPeriodType();

	/**
	 * Set PA_ReportColumnSet.
	 *
	 * @param PA_ReportColumnSet Collection of Columns for Report
	 */
	void setPA_ReportColumnSetInput(ForeignEntityInput PA_ReportColumnSet);

	/**
	 * Get PA_ReportColumnSet.
	 *
	 * @return Collection of Columns for Report
	 */
	ForeignEntityInput PA_ReportColumnSet();

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
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	void setPostingTypeInput(ForeignEntityInput PostingType);

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	ForeignEntityInput PostingType();
}
