package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_SchedulerRecipient;

/**
 * Generated Interface for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_SchedulerRecipientInput extends I_AD_SchedulerRecipient {

	/**
	 * Set AD_AuthorizationAccount.
	 *
	 * @param AD_AuthorizationAccount AD_AuthorizationAccount
	 */
	void setAD_AuthorizationAccountInput(ForeignEntityInput AD_AuthorizationAccount);

	/**
	 * Get AD_AuthorizationAccount.
	 *
	 * @return AD_AuthorizationAccount
	 */
	ForeignEntityInput AD_AuthorizationAccount();

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
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set AD_Scheduler.
	 *
	 * @param AD_Scheduler Schedule Processes
	 */
	void setAD_SchedulerInput(ForeignEntityInput AD_Scheduler);

	/**
	 * Get AD_Scheduler.
	 *
	 * @return Schedule Processes
	 */
	ForeignEntityInput AD_Scheduler();

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();
}
