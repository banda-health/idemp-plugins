package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Registration;
import org.compiere.model.X_A_RegistrationAttribute;
import org.compiere.model.X_A_RegistrationValue;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationValueInput extends X_A_RegistrationValue implements I_A_RegistrationValueInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Registration;
	private ForeignEntityInput mA_RegistrationAttribute;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_RegistrationValue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_RegistrationValueInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Registration.
	 *
	 * @param A_Registration User Asset Registration
	 */
	@JsonProperty("A_Registration")
	public void setA_RegistrationInput(ForeignEntityInput A_Registration) {
		this.mA_Registration = A_Registration;
		if (get_ID() != 0) {
			return;
		}
		if (A_Registration != null) {
			// Since an entity was passed, make sure it's in the DB
			X_A_Registration foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Registration", "A_Registration_UU=?", get_TrxName())
							.setParameters(A_Registration.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Registration_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Registration with UU " + A_Registration.getUU());
			}
		} else {
			this.setA_Registration_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (A_RegistrationAttribute != null) {
			// Since an entity was passed, make sure it's in the DB
			X_A_RegistrationAttribute foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_RegistrationAttribute", "A_RegistrationAttribute_UU=?", get_TrxName())
							.setParameters(A_RegistrationAttribute.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_RegistrationAttribute_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_RegistrationAttribute with UU " + A_RegistrationAttribute.getUU());
			}
		} else {
			this.setA_RegistrationAttribute_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_RegistrationValue_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_RegistrationValue_UU();
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
}
