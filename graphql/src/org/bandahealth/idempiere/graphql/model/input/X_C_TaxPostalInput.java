package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTax;
import org.compiere.model.MTaxPostal;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_TaxPostal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_TaxPostalInput extends MTaxPostal implements I_C_TaxPostalInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Tax;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_TaxPostal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_TaxPostalInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		if (get_ID() != 0) {
			return;
		}
		if (C_Tax != null) {
			// Since an entity was passed, make sure it's in the DB
			MTax foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Tax", "C_Tax_UU=?", get_TrxName())
							.setParameters(C_Tax.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Tax_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Tax with UU " + C_Tax.getUU());
			}
		} else {
			this.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public ForeignEntityInput C_Tax() {
		return mC_Tax;
	}
	/**
	 * Set Tax ZIP.
	 *
	 * @param C_TaxPostal_ID Tax Postal/ZIP
	 */
	@JsonProperty("C_TaxPostal_ID")
	public void setC_TaxPostal_IDFromJson(int C_TaxPostal_ID) {
		if (get_ID() == 0) {
			super.setC_TaxPostal_ID(C_TaxPostal_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_TaxPostal_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_TaxPostal_UU();
	}
}
