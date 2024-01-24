package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.model.X_AD_AllUsers_V;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AllUsers_VInput extends X_AD_AllUsers_V implements I_AD_AllUsers_VInput {

	private ForeignEntityInput mAD_AllClients_V;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_AllUsers_VInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_AllUsers_V(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Client (All).
	 *
	 * @param AD_AllClients_V Client (All)
	 */
	@JsonProperty("AD_AllClients_V")
	public void setAD_AllClients_VInput(ForeignEntityInput AD_AllClients_V) {
		this.mAD_AllClients_V = AD_AllClients_V;
		X_AD_AllClients_V foreignEntity;
		if (get_ID() == 0 && AD_AllClients_V != null &&
				(foreignEntity = new Query(getCtx(), "AD_AllClients_V", "AD_AllClients_V_UU=?", get_TrxName())
						.setParameters(AD_AllClients_V.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_AllClients_V_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Client (All).
	 *
	 * @return Client (All)
	 */
	@JsonProperty("AD_AllClients_V")
	public ForeignEntityInput AD_AllClients_V() {
		return mAD_AllClients_V;
	}
	/**
	 * Set User (All).
	 *
	 * @param AD_AllUsers_V_ID User (All)
	 */

	public void setAD_AllUsers_V_ID(int AD_AllUsers_V_ID) {
		if (get_ID() == 0) {
			super.setAD_AllUsers_V_ID(AD_AllUsers_V_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_AllUsers_V_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_AllUsers_V_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Date Last Login.
	 *
	 * @param DateLastLogin Date Last Login
	 */

	public void setDateLastLogin(Timestamp DateLastLogin) {
		if (get_ID() == 0) {
			super.setDateLastLogin(DateLastLogin);
		}
	}
	/**
	 * Set Date Password Changed.
	 *
	 * @param DatePasswordChanged Date Password Changed
	 */

	public void setDatePasswordChanged(Timestamp DatePasswordChanged) {
		if (get_ID() == 0) {
			super.setDatePasswordChanged(DatePasswordChanged);
		}
	}
	/**
	 * Set Description.
	 *
	 * @param Description Optional short description of the record
	 */

	public void setDescription(String Description) {
		if (get_ID() == 0) {
			super.setDescription(Description);
		}
	}
	/**
	 * Set EMail Address.
	 *
	 * @param EMail Electronic Mail Address
	 */

	public void setEMail(String EMail) {
		if (get_ID() == 0) {
			super.setEMail(EMail);
		}
	}
	/**
	 * Set Failed Login Count.
	 *
	 * @param FailedLoginCount Failed Login Count
	 */

	public void setFailedLoginCount(int FailedLoginCount) {
		if (get_ID() == 0) {
			super.setFailedLoginCount(FailedLoginCount);
		}
	}
	/**
	 * Set Expired.
	 *
	 * @param IsExpired Expired
	 */

	public void setIsExpired(boolean IsExpired) {
		if (get_ID() == 0) {
			super.setIsExpired(IsExpired);
		}
	}
	/**
	 * Set Locked.
	 *
	 * @param IsLocked Locked
	 */

	public void setIsLocked(boolean IsLocked) {
		if (get_ID() == 0) {
			super.setIsLocked(IsLocked);
		}
	}
	/**
	 * Set No Password Reset.
	 *
	 * @param IsNoPasswordReset No Password Reset
	 */

	public void setIsNoPasswordReset(boolean IsNoPasswordReset) {
		if (get_ID() == 0) {
			super.setIsNoPasswordReset(IsNoPasswordReset);
		}
	}
	/**
	 * Set LDAP User Name.
	 *
	 * @param LDAPUser User Name used for authorization via LDAP (directory) services
	 */

	public void setLDAPUser(String LDAPUser) {
		if (get_ID() == 0) {
			super.setLDAPUser(LDAPUser);
		}
	}
	/**
	 * Set Name.
	 *
	 * @param Name Alphanumeric identifier of the entity
	 */

	public void setName(String Name) {
		if (get_ID() == 0) {
			super.setName(Name);
		}
	}
	/**
	 * Set Password.
	 *
	 * @param Password Password of any length (case sensitive)
	 */

	public void setPassword(String Password) {
		if (get_ID() == 0) {
			super.setPassword(Password);
		}
	}
	/**
	 * Set Salt.
	 *
	 * @param Salt Random data added to improve password hash effectiveness
	 */

	public void setSalt(String Salt) {
		if (get_ID() == 0) {
			super.setSalt(Salt);
		}
	}
	/**
	 * Set User PIN.
	 *
	 * @param UserPIN User PIN
	 */

	public void setUserPIN(String UserPIN) {
		if (get_ID() == 0) {
			super.setUserPIN(UserPIN);
		}
	}
	/**
	 * Set Search Key.
	 *
	 * @param Value Search key for the record in the format required - must be unique
	 */

	public void setValue(String Value) {
		if (get_ID() == 0) {
			super.setValue(Value);
		}
	}
}
