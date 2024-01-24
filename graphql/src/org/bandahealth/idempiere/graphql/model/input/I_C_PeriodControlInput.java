package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PeriodControl;

/**
 * Generated Interface for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_PeriodControlInput extends I_C_PeriodControl {

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
	 * Set DocBaseType.
	 *
	 * @param DocBaseType Logical type of document
	 */
	void setDocBaseTypeInput(I_AD_Ref_ListInput DocBaseType);

	/**
	 * Get DocBaseType.
	 *
	 * @return Logical type of document
	 */
	I_AD_Ref_ListInput DocBaseType();

	/**
	 * Set PeriodAction.
	 *
	 * @param PeriodAction Action taken for this period
	 */
	void setPeriodActionInput(I_AD_Ref_ListInput PeriodAction);

	/**
	 * Get PeriodAction.
	 *
	 * @return Action taken for this period
	 */
	I_AD_Ref_ListInput PeriodAction();

	/**
	 * Set PeriodStatus.
	 *
	 * @param PeriodStatus Current state of this period
	 */
	void setPeriodStatusInput(I_AD_Ref_ListInput PeriodStatus);

	/**
	 * Get PeriodStatus.
	 *
	 * @return Current state of this period
	 */
	I_AD_Ref_ListInput PeriodStatus();
}
