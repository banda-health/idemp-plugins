package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Remuneration;
import org.compiere.model.X_C_UserRemuneration;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_UserRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UserRemunerationInput extends X_C_UserRemuneration implements I_C_UserRemunerationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_Remuneration;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_UserRemuneration_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_UserRemunerationInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_UserRemuneration(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
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
	 * Set Remuneration.
	 *
	 * @param C_Remuneration Wage or Salary
	 */
	@JsonProperty("C_Remuneration")
	public void setC_RemunerationInput(ForeignEntityInput C_Remuneration) {
		this.mC_Remuneration = C_Remuneration;
		if (get_ID() != 0) {
			return;
		}
		if (C_Remuneration != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Remuneration foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Remuneration", "C_Remuneration_UU=?", get_TrxName())
							.setParameters(C_Remuneration.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Remuneration_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Remuneration with UUID " + C_Remuneration.getUUID());
			}
		} else {
			this.setC_Remuneration_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_UserRemuneration_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_UserRemuneration_UU();
	}
}
