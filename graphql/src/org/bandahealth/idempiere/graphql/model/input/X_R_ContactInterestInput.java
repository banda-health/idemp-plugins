package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MContactInterest;
import org.compiere.model.MInterestArea;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_ContactInterestInput extends MContactInterest implements I_R_ContactInterestInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_InterestArea;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_R_ContactInterestInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MContactInterest(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setR_ContactInterest_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getR_ContactInterest_UU();
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
		if (get_ID() == 0 && R_InterestArea != null &&
				(foreignEntity = new Query(getCtx(), "R_InterestArea", "R_InterestArea_UU=?", get_TrxName())
						.setParameters(R_InterestArea.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_InterestArea_ID(foreignEntity.get_ID());
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
}
