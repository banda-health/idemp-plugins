package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_BroadcastMessage;

/**
 * Generated Interface for AD_BroadcastMessage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_BroadcastMessageInput extends I_AD_BroadcastMessage {

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

	/**
	 * Set BroadcastFrequency.
	 *
	 * @param BroadcastFrequency How Many Times Message Should be Broadcasted
	 */
	void setBroadcastFrequencyInput(ForeignEntityInput BroadcastFrequency);

	/**
	 * Get BroadcastFrequency.
	 *
	 * @return How Many Times Message Should be Broadcasted
	 */
	ForeignEntityInput BroadcastFrequency();

	/**
	 * Set BroadcastType.
	 *
	 * @param BroadcastType Type of Broadcast
	 */
	void setBroadcastTypeInput(ForeignEntityInput BroadcastType);

	/**
	 * Get BroadcastType.
	 *
	 * @return Type of Broadcast
	 */
	ForeignEntityInput BroadcastType();

	/**
	 * Set Target.
	 *
	 * @param Target Target tenant
	 */
	void setTargetInput(ForeignEntityInput Target);

	/**
	 * Get Target.
	 *
	 * @return Target tenant
	 */
	ForeignEntityInput Target();
}
