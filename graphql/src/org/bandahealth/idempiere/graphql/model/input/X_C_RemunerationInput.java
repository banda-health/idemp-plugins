package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Remuneration;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RemunerationInput extends X_C_Remuneration implements I_C_RemunerationInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mRemunerationType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Remuneration_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RemunerationInput(@JsonProperty("UU") String UU) {
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
	 * Set Remuneration.
	 *
	 * @param C_Remuneration_ID Wage or Salary
	 */

	public void setC_Remuneration_ID(int C_Remuneration_ID) {
		if (get_ID() == 0) {
			super.setC_Remuneration_ID(C_Remuneration_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Remuneration_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_Remuneration_UU();
	}

	/**
	 * Set Remuneration Type.
	 *
	 * @param RemunerationType Type of Remuneration
	 */
	@JsonProperty("RemunerationType")
	public void setRemunerationTypeInput(I_AD_Ref_ListInput RemunerationType) {
		this.mRemunerationType = RemunerationType;
		if (RemunerationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RemunerationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRemunerationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + RemunerationType.getUU());
			}
		} else {
			this.setRemunerationType(null);
		}
	}

	/**
	 * Get Remuneration Type.
	 *
	 * @return Type of Remuneration
	 */
	@JsonProperty("RemunerationType")
	public I_AD_Ref_ListInput RemunerationType() {
		return mRemunerationType;
	}
}
