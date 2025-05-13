package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.base.model.MBHAllergyReaction;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Allergy_Reaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Allergy_ReactionInput extends MBHAllergyReaction implements I_BH_Allergy_ReactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Allergy;
	private ForeignEntityInput mBH_Concept;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Allergy_Reaction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Allergy_ReactionInput(@JsonProperty("UU") String UU) {
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
	 * Set Allergy.
	 *
	 * @param BH_Allergy Allergy
	 */
	@JsonProperty("BH_Allergy")
	public void setBH_AllergyInput(ForeignEntityInput BH_Allergy) {
		this.mBH_Allergy = BH_Allergy;
		if (!is_new()) {
			return;
		}
		if (BH_Allergy != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHAllergy foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Allergy", "BH_Allergy_UU=?", get_TrxName())
							.setParameters(BH_Allergy.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Allergy_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Allergy with UU " + BH_Allergy.getUU());
			}
		} else {
			this.setBH_Allergy_ID(0);
		}
	}

	/**
	 * Get Allergy.
	 *
	 * @return Allergy
	 */
	@JsonProperty("BH_Allergy")
	public ForeignEntityInput BH_Allergy() {
		return mBH_Allergy;
	}
	/**
	 * Set Allergy Reaction.
	 *
	 * @param BH_Allergy_Reaction_ID Allergy Reaction
	 */
	@JsonProperty("BH_Allergy_Reaction_ID")
	public void setBH_Allergy_Reaction_IDFromJson(int BH_Allergy_Reaction_ID) {
		if (get_ID() == 0) {
			super.setBH_Allergy_Reaction_ID(BH_Allergy_Reaction_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Allergy_Reaction_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Allergy_Reaction_UU();
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
}
