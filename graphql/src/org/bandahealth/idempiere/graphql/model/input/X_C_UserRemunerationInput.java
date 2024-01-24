package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Remuneration;
import org.compiere.model.X_C_UserRemuneration;

import java.sql.ResultSet;

/**
 * Generated Model for C_UserRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_UserRemunerationInput extends X_C_UserRemuneration implements I_C_UserRemunerationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_Remuneration;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_UserRemunerationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_UserRemuneration(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Remuneration.
	 *
	 * @param C_Remuneration Wage or Salary
	 */
	@JsonProperty("C_Remuneration")
	public void setC_RemunerationInput(ForeignEntityInput C_Remuneration) {
		this.mC_Remuneration = C_Remuneration;
		X_C_Remuneration foreignEntity;
		if (get_ID() == 0 && C_Remuneration != null &&
				(foreignEntity = new Query(getCtx(), "C_Remuneration", "C_Remuneration_UU=?", get_TrxName())
						.setParameters(C_Remuneration.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Remuneration_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Remuneration.
	 *
	 * @return Wage or Salary
	 */
	@JsonProperty("C_Remuneration")
	public ForeignEntityInput C_Remuneration() {
		return mC_Remuneration;
	}
	/**
	 * Set Employee Remuneration.
	 *
	 * @param C_UserRemuneration_ID Employee Wage or Salary Overwrite
	 */

	public void setC_UserRemuneration_ID(int C_UserRemuneration_ID) {
		if (get_ID() == 0) {
			super.setC_UserRemuneration_ID(C_UserRemuneration_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_UserRemuneration_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_UserRemuneration_UU();
	}
}
