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
	void setCommitmentTypeInput(ForeignEntityInput CommitmentType);

	/**
	 * Get CommitmentType.
	 *
	 * @return Create Commitment and/or Reservations for Budget Control
	 */
	ForeignEntityInput CommitmentType();

	/**
	 * Set CostingLevel.
	 *
	 * @param CostingLevel The lowest level to accumulate Costing Information
	 */
	void setCostingLevelInput(ForeignEntityInput CostingLevel);

	/**
	 * Get CostingLevel.
	 *
	 * @return The lowest level to accumulate Costing Information
	 */
	ForeignEntityInput CostingLevel();

	/**
	 * Set CostingMethod.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	void setCostingMethodInput(ForeignEntityInput CostingMethod);

	/**
	 * Get CostingMethod.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	ForeignEntityInput CostingMethod();

	/**
	 * Set GAAP.
	 *
	 * @param GAAP Generally Accepted Accounting Principles
	 */
	void setGAAPInput(ForeignEntityInput GAAP);

	/**
	 * Get GAAP.
	 *
	 * @return Generally Accepted Accounting Principles
	 */
	ForeignEntityInput GAAP();

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
	void setTaxCorrectionTypeInput(ForeignEntityInput TaxCorrectionType);

	/**
	 * Get TaxCorrectionType.
	 *
	 * @return Type of Tax Correction
	 */
	ForeignEntityInput TaxCorrectionType();
}
