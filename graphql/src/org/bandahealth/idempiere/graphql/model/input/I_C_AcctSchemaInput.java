package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AcctSchema;

/**
 * Generated Interface for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_AcctSchemaInput extends I_C_AcctSchema {

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
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_Period(I_C_PeriodInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	I_C_PeriodInput getC_Period();

	/**
	 * Set CommitmentType_RL.
	 *
	 * @param CommitmentType_RL Create Commitment and/or Reservations for Budget Control
	 */
	void setCommitmentType_RL(I_AD_Ref_ListInput CommitmentType_RL);

	/**
	 * Get CommitmentType_RL.
	 *
	 * @return Create Commitment and/or Reservations for Budget Control
	 */
	I_AD_Ref_ListInput getCommitmentType_RL();

	/**
	 * Set CostingLevel_RL.
	 *
	 * @param CostingLevel_RL The lowest level to accumulate Costing Information
	 */
	void setCostingLevel_RL(I_AD_Ref_ListInput CostingLevel_RL);

	/**
	 * Get CostingLevel_RL.
	 *
	 * @return The lowest level to accumulate Costing Information
	 */
	I_AD_Ref_ListInput getCostingLevel_RL();

	/**
	 * Set CostingMethod_RL.
	 *
	 * @param CostingMethod_RL Indicates how Costs will be calculated
	 */
	void setCostingMethod_RL(I_AD_Ref_ListInput CostingMethod_RL);

	/**
	 * Get CostingMethod_RL.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	I_AD_Ref_ListInput getCostingMethod_RL();

	/**
	 * Set GAAP_RL.
	 *
	 * @param GAAP_RL Generally Accepted Accounting Principles
	 */
	void setGAAP_RL(I_AD_Ref_ListInput GAAP_RL);

	/**
	 * Get GAAP_RL.
	 *
	 * @return Generally Accepted Accounting Principles
	 */
	I_AD_Ref_ListInput getGAAP_RL();

	/**
	 * Set M_CostType.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	void setM_CostType(I_M_CostTypeInput M_CostType);

	/**
	 * Get M_CostType.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	I_M_CostTypeInput getM_CostType();

	/**
	 * Set TaxCorrectionType_RL.
	 *
	 * @param TaxCorrectionType_RL Type of Tax Correction
	 */
	void setTaxCorrectionType_RL(I_AD_Ref_ListInput TaxCorrectionType_RL);

	/**
	 * Get TaxCorrectionType_RL.
	 *
	 * @return Type of Tax Correction
	 */
	I_AD_Ref_ListInput getTaxCorrectionType_RL();
}
