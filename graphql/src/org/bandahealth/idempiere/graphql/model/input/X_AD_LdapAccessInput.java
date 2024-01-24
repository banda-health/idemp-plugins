package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInterestArea;
import org.compiere.model.MLdapAccess;
import org.compiere.model.MLdapProcessor;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_LdapAccessInput extends MLdapAccess implements I_AD_LdapAccessInput {

	private ForeignEntityInput mAD_LdapProcessor;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_InterestArea;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_LdapAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_LdapAccessInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MLdapAccess(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Ldap Access.
	 *
	 * @param AD_LdapAccess_ID Ldap Access Log
	 */

	public void setAD_LdapAccess_ID(int AD_LdapAccess_ID) {
		if (get_ID() == 0) {
			super.setAD_LdapAccess_ID(AD_LdapAccess_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_LdapAccess_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_LdapAccess_UU();
	}

	/**
	 * Set Ldap Processor.
	 *
	 * @param AD_LdapProcessor LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	@JsonProperty("AD_LdapProcessor")
	public void setAD_LdapProcessorInput(ForeignEntityInput AD_LdapProcessor) {
		this.mAD_LdapProcessor = AD_LdapProcessor;
		MLdapProcessor foreignEntity;
		if (get_ID() == 0 && AD_LdapProcessor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_LdapProcessor", "AD_LdapProcessor_UU=?", get_TrxName())
							.setParameters(AD_LdapProcessor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_LdapProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_LdapProcessor with UUID " + AD_LdapProcessor.getUUID());
			}
		}
	}

	/**
	 * Get Ldap Processor.
	 *
	 * @return LDAP Server to authenticate and authorize external systems based on iDempiere
	 */
	@JsonProperty("AD_LdapProcessor")
	public ForeignEntityInput AD_LdapProcessor() {
		return mAD_LdapProcessor;
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
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
	/**
	 * Set Error.
	 *
	 * @param IsError An Error occurred in the execution
	 */

	public void setIsError(boolean IsError) {
		if (get_ID() == 0) {
			super.setIsError(IsError);
		}
	}

	/**
	 * Set Interest Area.
	 *
	 * @param R_InterestArea Interest Area or Topic
	 */
	@JsonProperty("R_InterestArea")
	public void setR_InterestAreaInput(ForeignEntityInput R_InterestArea) {
		this.mR_InterestArea = R_InterestArea;
		MInterestArea foreignEntity;
		if (get_ID() == 0 && R_InterestArea != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_InterestArea", "R_InterestArea_UU=?", get_TrxName())
							.setParameters(R_InterestArea.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_InterestArea_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_InterestArea with UUID " + R_InterestArea.getUUID());
			}
		}
	}

	/**
	 * Get Interest Area.
	 *
	 * @return Interest Area or Topic
	 */
	@JsonProperty("R_InterestArea")
	public ForeignEntityInput R_InterestArea() {
		return mR_InterestArea;
	}
	/**
	 * Set Summary.
	 *
	 * @param Summary Textual summary of this request
	 */

	public void setSummary(String Summary) {
		if (get_ID() == 0) {
			super.setSummary(Summary);
		}
	}
}
