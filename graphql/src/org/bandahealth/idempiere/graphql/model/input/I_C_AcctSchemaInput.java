package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AcctSchema;

/**
 * Generated Interface for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_AcctSchemaInput extends I_C_AcctSchema {

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
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_PeriodInput(ForeignEntityInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	ForeignEntityInput C_Period();

	/**
	 * Set CommitmentType.
	 *
	 * @param CommitmentType Create Commitment and/or Reservations for Budget Control
	 */
	void setCommitmentTypeInput(I_AD_Ref_ListInput CommitmentType);

	/**
	 * Get CommitmentType.
	 *
	 * @return Create Commitment and/or Reservations for Budget Control
	 */
	I_AD_Ref_ListInput CommitmentType();

	/**
	 * Set CostingLevel.
	 *
	 * @param CostingLevel The lowest level to accumulate Costing Information
	 */
	void setCostingLevelInput(I_AD_Ref_ListInput CostingLevel);

	/**
	 * Get CostingLevel.
	 *
	 * @return The lowest level to accumulate Costing Information
	 */
	I_AD_Ref_ListInput CostingLevel();

	/**
	 * Set CostingMethod.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	void setCostingMethodInput(I_AD_Ref_ListInput CostingMethod);

	/**
	 * Get CostingMethod.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	I_AD_Ref_ListInput CostingMethod();

	/**
	 * Set GAAP.
	 *
	 * @param GAAP Generally Accepted Accounting Principles
	 */
	void setGAAPInput(I_AD_Ref_ListInput GAAP);

	/**
	 * Get GAAP.
	 *
	 * @return Generally Accepted Accounting Principles
	 */
	I_AD_Ref_ListInput GAAP();

	/**
	 * Set M_CostType.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	void setM_CostTypeInput(ForeignEntityInput M_CostType);

	/**
	 * Get M_CostType.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	ForeignEntityInput M_CostType();

	/**
	 * Set TaxCorrectionType.
	 *
	 * @param TaxCorrectionType Type of Tax Correction
	 */
	void setTaxCorrectionTypeInput(I_AD_Ref_ListInput TaxCorrectionType);

	/**
	 * Get TaxCorrectionType.
	 *
	 * @return Type of Tax Correction
	 */
	I_AD_Ref_ListInput TaxCorrectionType();
}
