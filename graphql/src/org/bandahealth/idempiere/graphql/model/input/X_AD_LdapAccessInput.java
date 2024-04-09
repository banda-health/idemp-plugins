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
 * @version Release 11 - $Id$
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
	 * @param UU The AD_LdapAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_LdapAccessInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_LdapAccess_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_LdapProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MLdapProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_LdapProcessor", "AD_LdapProcessor_UU=?", get_TrxName())
							.setParameters(AD_LdapProcessor.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_LdapProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_LdapProcessor with UU " + AD_LdapProcessor.getUU());
			}
		} else {
			this.setAD_LdapProcessor_ID(0);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (get_ID() != 0) {
			return;
		}
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
		if (get_ID() != 0) {
			return;
		}
		if (R_InterestArea != null) {
			// Since an entity was passed, make sure it's in the DB
			MInterestArea foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_InterestArea", "R_InterestArea_UU=?", get_TrxName())
							.setParameters(R_InterestArea.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_InterestArea_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_InterestArea with UU " + R_InterestArea.getUU());
			}
		} else {
			this.setR_InterestArea_ID(0);
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
