package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRegistration;
import org.compiere.model.MRegistrationAttribute;
import org.compiere.model.MRegistrationValue;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationValueInput extends MRegistrationValue implements I_A_RegistrationValueInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Registration;
	private ForeignEntityInput mA_RegistrationAttribute;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_RegistrationValue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_RegistrationValueInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRegistrationValue(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && A_Registration != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Registration", "A_Registration_UU=?", get_TrxName())
							.setParameters(A_Registration.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Registration_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Registration with UUID " + A_Registration.getUUID());
			}
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
		if (get_ID() == 0 && A_RegistrationAttribute != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_RegistrationAttribute", "A_RegistrationAttribute_UU=?", get_TrxName())
							.setParameters(A_RegistrationAttribute.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_RegistrationAttribute_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_RegistrationAttribute with UUID " + A_RegistrationAttribute.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_RegistrationValue_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
}
