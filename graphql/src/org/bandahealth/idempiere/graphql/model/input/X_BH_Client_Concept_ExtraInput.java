package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Client_Concept_Extra - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Client_Concept_ExtraInput extends MBHClientConceptExtra implements I_BH_Client_Concept_ExtraInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Concept_Extra;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Client_Concept_Extra_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Client_Concept_ExtraInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Client Concept Extra.
	 *
	 * @param BH_Client_Concept_Extra_ID Client Concept Extra
	 */
	@JsonProperty("BH_Client_Concept_Extra_ID")
	public void setBH_Client_Concept_Extra_IDFromJson(int BH_Client_Concept_Extra_ID) {
		if (get_ID() == 0) {
			super.setBH_Client_Concept_Extra_ID(BH_Client_Concept_Extra_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Client_Concept_Extra_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Client_Concept_Extra_UU();
	}

	/**
	 * Set Concept Extra.
	 *
	 * @param BH_Concept_Extra Concept Extra
	 */
	@JsonProperty("BH_Concept_Extra")
	public void setBH_Concept_ExtraInput(ForeignEntityInput BH_Concept_Extra) {
		this.mBH_Concept_Extra = BH_Concept_Extra;
		if (!is_new()) {
			return;
		}
		if (BH_Concept_Extra != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHConceptExtra foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Concept_Extra", "BH_Concept_Extra_UU=?", get_TrxName())
							.setParameters(BH_Concept_Extra.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Concept_Extra_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Concept_Extra with UU " + BH_Concept_Extra.getUU());
			}
		} else {
			this.setBH_Concept_Extra_ID(0);
		}
	}

	/**
	 * Get Concept Extra.
	 *
	 * @return Concept Extra
	 */
	@JsonProperty("BH_Concept_Extra")
	public ForeignEntityInput BH_Concept_Extra() {
		return mBH_Concept_Extra;
	}
}
