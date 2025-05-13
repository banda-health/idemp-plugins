package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHOclOriginatingSource;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Ocl_Originating_SourceResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Ocl_Originating_Source - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Ocl_Originating_SourceInput extends MBHOclOriginatingSource implements I_BH_Ocl_Originating_SourceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Concept;
	private ForeignEntityInput mBH_Ocl_Source;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Ocl_Originating_Source_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Ocl_Originating_SourceInput(@JsonProperty("UU") String UU) {
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
	 * Set OCL Originating Source.
	 *
	 * @param BH_Ocl_Originating_Source_ID OCL Originating Source
	 */
	@JsonProperty("BH_Ocl_Originating_Source_ID")
	public void setBH_Ocl_Originating_Source_IDFromJson(int BH_Ocl_Originating_Source_ID) {
		if (get_ID() == 0) {
			super.setBH_Ocl_Originating_Source_ID(BH_Ocl_Originating_Source_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Ocl_Originating_Source_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Ocl_Originating_Source_UU();
	}

	/**
	 * Set BH Ocl Source.
	 *
	 * @param BH_Ocl_Source BH Ocl Source
	 */
	@JsonProperty("BH_Ocl_Source")
	public void setBH_Ocl_SourceInput(ForeignEntityInput BH_Ocl_Source) {
		this.mBH_Ocl_Source = BH_Ocl_Source;
		if (!is_new()) {
			return;
		}
		if (BH_Ocl_Source != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Ocl_Originating_SourceResolver.BH_OCL_SOURCE_UUIDS_BY_VALUE.containsValue(BH_Ocl_Source.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Ocl_Source.getUU() +
						" is not in the list defined for the BH_Ocl_Source column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Ocl_Source.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Ocl_Source(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Ocl_Source.getUU());
			}
		} else {
			this.setBH_Ocl_Source(null);
		}
	}

	/**
	 * Get BH Ocl Source.
	 *
	 * @return BH Ocl Source
	 */
	@JsonProperty("BH_Ocl_Source")
	public ForeignEntityInput BH_Ocl_Source() {
		return mBH_Ocl_Source;
	}
}
