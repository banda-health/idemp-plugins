package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PeriodControl;

/**
 * Generated Interface for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_PeriodControlInput extends I_C_PeriodControl {

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
	 * Set DocBaseType.
	 *
	 * @param DocBaseType Logical type of document
	 */
	void setDocBaseTypeInput(ForeignEntityInput DocBaseType);

	/**
	 * Get DocBaseType.
	 *
	 * @return Logical type of document
	 */
	ForeignEntityInput DocBaseType();

	/**
	 * Set PeriodAction.
	 *
	 * @param PeriodAction Action taken for this period
	 */
	void setPeriodActionInput(ForeignEntityInput PeriodAction);

	/**
	 * Get PeriodAction.
	 *
	 * @return Action taken for this period
	 */
	ForeignEntityInput PeriodAction();

	/**
	 * Set PeriodStatus.
	 *
	 * @param PeriodStatus Current state of this period
	 */
	void setPeriodStatusInput(ForeignEntityInput PeriodStatus);

	/**
	 * Get PeriodStatus.
	 *
	 * @return Current state of this period
	 */
	ForeignEntityInput PeriodStatus();
}
