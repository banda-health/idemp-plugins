package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ReportColumn;

/**
 * Generated Interface for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_ReportColumnInput extends I_PA_ReportColumn {

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
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_Activity(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput getC_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_Campaign(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput getC_Campaign();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

	/**
	 * Set C_ElementValue.
	 *
	 * @param C_ElementValue Account Element
	 */
	void setC_ElementValue(I_C_ElementValueInput C_ElementValue);

	/**
	 * Get C_ElementValue.
	 *
	 * @return Account Element
	 */
	I_C_ElementValueInput getC_ElementValue();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_Location(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput getC_Location();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

	/**
	 * Set C_SalesRegion.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	void setC_SalesRegion(I_C_SalesRegionInput C_SalesRegion);

	/**
	 * Get C_SalesRegion.
	 *
	 * @return Sales coverage region
	 */
	I_C_SalesRegionInput getC_SalesRegion();

	/**
	 * Set CalculationType_RL.
	 *
	 * @param CalculationType_RL CalculationType_RL
	 */
	void setCalculationType_RL(I_AD_Ref_ListInput CalculationType_RL);

	/**
	 * Get CalculationType_RL.
	 *
	 * @return CalculationType_RL
	 */
	I_AD_Ref_ListInput getCalculationType_RL();

	/**
	 * Set ColumnType_RL.
	 *
	 * @param ColumnType_RL ColumnType_RL
	 */
	void setColumnType_RL(I_AD_Ref_ListInput ColumnType_RL);

	/**
	 * Get ColumnType_RL.
	 *
	 * @return ColumnType_RL
	 */
	I_AD_Ref_ListInput getColumnType_RL();

	/**
	 * Set CurrencyType_RL.
	 *
	 * @param CurrencyType_RL CurrencyType_RL
	 */
	void setCurrencyType_RL(I_AD_Ref_ListInput CurrencyType_RL);

	/**
	 * Get CurrencyType_RL.
	 *
	 * @return CurrencyType_RL
	 */
	I_AD_Ref_ListInput getCurrencyType_RL();

	/**
	 * Set ElementType_RL.
	 *
	 * @param ElementType_RL Element Type (account or user defined)
	 */
	void setElementType_RL(I_AD_Ref_ListInput ElementType_RL);

	/**
	 * Get ElementType_RL.
	 *
	 * @return Element Type (account or user defined)
	 */
	I_AD_Ref_ListInput getElementType_RL();

	/**
	 * Set Factor_RL.
	 *
	 * @param Factor_RL Scaling factor.
	 */
	void setFactor_RL(I_AD_Ref_ListInput Factor_RL);

	/**
	 * Get Factor_RL.
	 *
	 * @return Scaling factor.
	 */
	I_AD_Ref_ListInput getFactor_RL();

	/**
	 * Set GL_Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	void setGL_Budget(I_GL_BudgetInput GL_Budget);

	/**
	 * Get GL_Budget.
	 *
	 * @return General Ledger Budget
	 */
	I_GL_BudgetInput getGL_Budget();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_Product(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput getM_Product();

	/**
	 * Set Oper_1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	void setOper_1(I_PA_ReportColumnInput Oper_1);

	/**
	 * Get Oper_1.
	 *
	 * @return First operand for calculation
	 */
	I_PA_ReportColumnInput getOper_1();

	/**
	 * Set Oper_2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	void setOper_2(I_PA_ReportColumnInput Oper_2);

	/**
	 * Get Oper_2.
	 *
	 * @return Second operand for calculation
	 */
	I_PA_ReportColumnInput getOper_2();

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
	 * Set PA_ReportColumnSet.
	 *
	 * @param PA_ReportColumnSet Collection of Columns for Report
	 */
	void setPA_ReportColumnSet(I_PA_ReportColumnSetInput PA_ReportColumnSet);

	/**
	 * Get PA_ReportColumnSet.
	 *
	 * @return Collection of Columns for Report
	 */
	I_PA_ReportColumnSetInput getPA_ReportColumnSet();

	/**
	 * Set PAAmountType_RL.
	 *
	 * @param PAAmountType_RL PA Amount Type for reporting
	 */
	void setPAAmountType_RL(I_AD_Ref_ListInput PAAmountType_RL);

	/**
	 * Get PAAmountType_RL.
	 *
	 * @return PA Amount Type for reporting
	 */
	I_AD_Ref_ListInput getPAAmountType_RL();

	/**
	 * Set PAPeriodType_RL.
	 *
	 * @param PAPeriodType_RL PA Period Type
	 */
	void setPAPeriodType_RL(I_AD_Ref_ListInput PAPeriodType_RL);

	/**
	 * Get PAPeriodType_RL.
	 *
	 * @return PA Period Type
	 */
	I_AD_Ref_ListInput getPAPeriodType_RL();

	/**
	 * Set PostingType_RL.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL);

	/**
	 * Get PostingType_RL.
	 *
	 * @return The type of posted amount for the transaction
	 */
	I_AD_Ref_ListInput getPostingType_RL();
}
