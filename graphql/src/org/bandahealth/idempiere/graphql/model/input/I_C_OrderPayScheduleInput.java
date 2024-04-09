package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_OrderPaySchedule;

/**
 * Generated Interface for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_OrderPayScheduleInput extends I_C_OrderPaySchedule {

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
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

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
	 * Set C_PaySchedule.
	 *
	 * @param C_PaySchedule Payment Schedule Template
	 */
	void setC_PayScheduleInput(ForeignEntityInput C_PaySchedule);

	/**
	 * Get C_PaySchedule.
	 *
	 * @return Payment Schedule Template
	 */
	ForeignEntityInput C_PaySchedule();
}
