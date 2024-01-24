package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRegistration;
import org.compiere.model.MRegistrationAttribute;
import org.compiere.model.MRegistrationValue;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_RegistrationValueInput extends MRegistrationValue implements I_A_RegistrationValueInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Registration;
	private ForeignEntityInput mA_RegistrationAttribute;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_RegistrationValueInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRegistrationValue(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Registration.
	 *
	 * @param A_Registration User Asset Registration
	 */
	@JsonProperty("A_Registration")
	public void setA_RegistrationInput(ForeignEntityInput A_Registration) {
		this.mA_Registration = A_Registration;
		MRegistration foreignEntity;
		if (get_ID() == 0 && A_Registration != null &&
				(foreignEntity = new Query(getCtx(), "A_Registration", "A_Registration_UU=?", get_TrxName())
						.setParameters(A_Registration.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Registration_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Registration.
	 *
	 * @return User Asset Registration
	 */
	@JsonProperty("A_Registration")
	public ForeignEntityInput A_Registration() {
		return mA_Registration;
	}

	/**
	 * Set Registration Attribute.
	 *
	 * @param A_RegistrationAttribute Asset Registration Attribute
	 */
	@JsonProperty("A_RegistrationAttribute")
	public void setA_RegistrationAttributeInput(ForeignEntityInput A_RegistrationAttribute) {
		this.mA_RegistrationAttribute = A_RegistrationAttribute;
		MRegistrationAttribute foreignEntity;
		if (get_ID() == 0 && A_RegistrationAttribute != null &&
				(foreignEntity = new Query(getCtx(), "A_RegistrationAttribute", "A_RegistrationAttribute_UU=?", get_TrxName())
						.setParameters(A_RegistrationAttribute.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_RegistrationAttribute_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Registration Attribute.
	 *
	 * @return Asset Registration Attribute
	 */
	@JsonProperty("A_RegistrationAttribute")
	public ForeignEntityInput A_RegistrationAttribute() {
		return mA_RegistrationAttribute;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_RegistrationValue_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_RegistrationValue_UU();
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
}
