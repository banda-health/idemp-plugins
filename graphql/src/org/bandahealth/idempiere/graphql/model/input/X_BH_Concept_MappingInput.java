package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Concept_Mapping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Concept_MappingInput extends MBHConceptMapping implements I_BH_Concept_MappingInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mFrom_BH_Concept;
	private ForeignEntityInput mTo_BH_Concept;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Concept_Mapping_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Concept_MappingInput(@JsonProperty("UU") String UU) {
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
	 * Set Concept Mapping.
	 *
	 * @param BH_Concept_Mapping_ID Concept Mapping
	 */
	@JsonProperty("BH_Concept_Mapping_ID")
	public void setBH_Concept_Mapping_IDFromJson(int BH_Concept_Mapping_ID) {
		if (get_ID() == 0) {
			super.setBH_Concept_Mapping_ID(BH_Concept_Mapping_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Concept_Mapping_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Concept_Mapping_UU();
	}

	/**
	 * Set From Concept.
	 *
	 * @param From_BH_Concept From Concept
	 */
	@JsonProperty("From_BH_Concept")
	public void setFrom_BH_ConceptInput(ForeignEntityInput From_BH_Concept) {
		this.mFrom_BH_Concept = From_BH_Concept;
		if (get_ID() != 0) {
			return;
		}
		if (From_BH_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHConcept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Concept", "BH_Concept_UU=?", get_TrxName())
							.setParameters(From_BH_Concept.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setFrom_BH_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Concept with UU " + From_BH_Concept.getUU());
			}
		} else {
			this.setFrom_BH_Concept_ID(0);
		}
	}

	/**
	 * Get From Concept.
	 *
	 * @return From Concept
	 */
	@JsonProperty("From_BH_Concept")
	public ForeignEntityInput From_BH_Concept() {
		return mFrom_BH_Concept;
	}

	/**
	 * Set To Concept.
	 *
	 * @param To_BH_Concept To Concept
	 */
	@JsonProperty("To_BH_Concept")
	public void setTo_BH_ConceptInput(ForeignEntityInput To_BH_Concept) {
		this.mTo_BH_Concept = To_BH_Concept;
		if (get_ID() != 0) {
			return;
		}
		if (To_BH_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHConcept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Concept", "BH_Concept_UU=?", get_TrxName())
							.setParameters(To_BH_Concept.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setTo_BH_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Concept with UU " + To_BH_Concept.getUU());
			}
		} else {
			this.setTo_BH_Concept_ID(0);
		}
	}

	/**
	 * Get To Concept.
	 *
	 * @return To Concept
	 */
	@JsonProperty("To_BH_Concept")
	public ForeignEntityInput To_BH_Concept() {
		return mTo_BH_Concept;
	}
}
