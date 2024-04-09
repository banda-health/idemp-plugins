package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAuthorizationAccount;
import org.compiere.model.MOrg;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerRecipient;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SchedulerRecipientInput extends MSchedulerRecipient implements I_AD_SchedulerRecipientInput {

	private ForeignEntityInput mAD_AuthorizationAccount;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_Scheduler;
	private ForeignEntityInput mAD_User;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_SchedulerRecipient_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_SchedulerRecipientInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Authorization Account.
	 *
	 * @param AD_AuthorizationAccount Authorization Account
	 */
	@JsonProperty("AD_AuthorizationAccount")
	public void setAD_AuthorizationAccountInput(ForeignEntityInput AD_AuthorizationAccount) {
		this.mAD_AuthorizationAccount = AD_AuthorizationAccount;
		if (get_ID() != 0) {
			return;
		}
		if (AD_AuthorizationAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MAuthorizationAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AuthorizationAccount", "AD_AuthorizationAccount_UU=?", get_TrxName())
							.setParameters(AD_AuthorizationAccount.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_AuthorizationAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AuthorizationAccount with UU " + AD_AuthorizationAccount.getUU());
			}
		} else {
			this.setAD_AuthorizationAccount_ID(0);
		}
	}

	/**
	 * Get Authorization Account.
	 *
	 * @return Authorization Account
	 */
	@JsonProperty("AD_AuthorizationAccount")
	public ForeignEntityInput AD_AuthorizationAccount() {
		return mAD_AuthorizationAccount;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UU " + AD_Role.getUU());
			}
		} else {
			this.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set Scheduler.
	 *
	 * @param AD_Scheduler Schedule Processes
	 */
	@JsonProperty("AD_Scheduler")
	public void setAD_SchedulerInput(ForeignEntityInput AD_Scheduler) {
		this.mAD_Scheduler = AD_Scheduler;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Scheduler != null) {
			// Since an entity was passed, make sure it's in the DB
			MScheduler foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Scheduler", "AD_Scheduler_UU=?", get_TrxName())
							.setParameters(AD_Scheduler.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Scheduler_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Scheduler with UU " + AD_Scheduler.getUU());
			}
		} else {
			this.setAD_Scheduler_ID(0);
		}
	}

	/**
	 * Get Scheduler.
	 *
	 * @return Schedule Processes
	 */
	@JsonProperty("AD_Scheduler")
	public ForeignEntityInput AD_Scheduler() {
		return mAD_Scheduler;
	}
	/**
	 * Set Scheduler Recipient.
	 *
	 * @param AD_SchedulerRecipient_ID Recipient of the Scheduler Notification
	 */

	public void setAD_SchedulerRecipient_ID(int AD_SchedulerRecipient_ID) {
		if (get_ID() == 0) {
			super.setAD_SchedulerRecipient_ID(AD_SchedulerRecipient_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_SchedulerRecipient_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_SchedulerRecipient_UU();
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
}
