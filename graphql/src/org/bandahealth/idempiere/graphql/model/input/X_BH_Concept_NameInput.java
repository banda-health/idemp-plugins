package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Concept_Name - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Concept_NameInput extends MBHConceptName implements I_BH_Concept_NameInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Concept;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Concept_Name_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Concept_NameInput(@JsonProperty("UU") String UU) {
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
	 * Set Concept.
	 *
	 * @param BH_Concept Concept
	 */
	@JsonProperty("BH_Concept")
	public void setBH_ConceptInput(ForeignEntityInput BH_Concept) {
		this.mBH_Concept = BH_Concept;
		if (!is_new()) {
			return;
		}
		if (BH_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHConcept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Concept", "BH_Concept_UU=?", get_TrxName())
							.setParameters(BH_Concept.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Concept with UU " + BH_Concept.getUU());
			}
		} else {
			this.setBH_Concept_ID(0);
		}
	}

	/**
	 * Get Concept.
	 *
	 * @return Concept
	 */
	@JsonProperty("BH_Concept")
	public ForeignEntityInput BH_Concept() {
		return mBH_Concept;
	}
	/**
	 * Set Concept Name.
	 *
	 * @param BH_Concept_Name_ID Concept Name
	 */
	@JsonProperty("BH_Concept_Name_ID")
	public void setBH_Concept_Name_IDFromJson(int BH_Concept_Name_ID) {
		if (get_ID() == 0) {
			super.setBH_Concept_Name_ID(BH_Concept_Name_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Concept_Name_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Concept_Name_UU();
	}
}
