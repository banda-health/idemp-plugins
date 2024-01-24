package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_PaySchedule;

/**
 * Generated Interface for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_PayScheduleInput extends I_C_PaySchedule {

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
	 * Set C_PaymentTerm.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm);

	/**
	 * Get C_PaymentTerm.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	ForeignEntityInput C_PaymentTerm();

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
	 * Set NetDay.
	 *
	 * @param NetDay Day when payment is due net
	 */
	void setNetDayInput(I_AD_Ref_ListInput NetDay);

	/**
	 * Get NetDay.
	 *
	 * @return Day when payment is due net
	 */
	I_AD_Ref_ListInput NetDay();
}
