package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Encounter_DiagnosticResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Encounter_Diagnostic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Encounter_DiagnosticInput extends MBHEncounterDiagnostic implements I_BH_Encounter_DiagnosticInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Concept;
	private ForeignEntityInput mBH_Diagnostic_Status;
	private ForeignEntityInput mBH_Encounter;
	private ForeignEntityInput mSelected_Panel;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Encounter_Diagnostic_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Encounter_DiagnosticInput(@JsonProperty("UU") String UU) {
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
	 * Set Diagnostic Status.
	 *
	 * @param BH_Diagnostic_Status Diagnostic Status
	 */
	@JsonProperty("BH_Diagnostic_Status")
	public void setBH_Diagnostic_StatusInput(ForeignEntityInput BH_Diagnostic_Status) {
		this.mBH_Diagnostic_Status = BH_Diagnostic_Status;
		if (BH_Diagnostic_Status != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Encounter_DiagnosticResolver.BH_DIAGNOSTIC_STATUS_UUIDS_BY_VALUE.containsValue(BH_Diagnostic_Status.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Diagnostic_Status.getUU() +
						" is not in the list defined for the BH_Diagnostic_Status column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Diagnostic_Status.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Diagnostic_Status(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Diagnostic_Status.getUU());
			}
		} else {
			this.setBH_Diagnostic_Status(null);
		}
	}

	/**
	 * Get Diagnostic Status.
	 *
	 * @return Diagnostic Status
	 */
	@JsonProperty("BH_Diagnostic_Status")
	public ForeignEntityInput BH_Diagnostic_Status() {
		return mBH_Diagnostic_Status;
	}
	/**
	 * Set Encounter Diagnostic.
	 *
	 * @param BH_Encounter_Diagnostic_ID Encounter Diagnostic
	 */
	@JsonProperty("BH_Encounter_Diagnostic_ID")
	public void setBH_Encounter_Diagnostic_IDFromJson(int BH_Encounter_Diagnostic_ID) {
		if (get_ID() == 0) {
			super.setBH_Encounter_Diagnostic_ID(BH_Encounter_Diagnostic_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Encounter_Diagnostic_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Encounter_Diagnostic_UU();
	}

	/**
	 * Set Encounter.
	 *
	 * @param BH_Encounter Encounter
	 */
	@JsonProperty("BH_Encounter")
	public void setBH_EncounterInput(ForeignEntityInput BH_Encounter) {
		this.mBH_Encounter = BH_Encounter;
		if (BH_Encounter != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHEncounter foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Encounter", "BH_Encounter_UU=?", get_TrxName())
							.setParameters(BH_Encounter.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Encounter_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Encounter with UU " + BH_Encounter.getUU());
			}
		} else {
			this.setBH_Encounter_ID(0);
		}
	}

	/**
	 * Get Encounter.
	 *
	 * @return Encounter
	 */
	@JsonProperty("BH_Encounter")
	public ForeignEntityInput BH_Encounter() {
		return mBH_Encounter;
	}
	/**
	 * Set Group1.
	 *
	 * @param Group1 Group1
	 */
	@JsonProperty("Group1")
	public void setGroup1FromJson(String Group1) {
		if (get_ID() == 0) {
			super.setGroup1(Group1);
		}
	}

	/**
	 * Set Selected Panel.
	 *
	 * @param Selected_Panel Selected Panel
	 */
	@JsonProperty("Selected_Panel")
	public void setSelected_PanelInput(ForeignEntityInput Selected_Panel) {
		this.mSelected_Panel = Selected_Panel;
		if (!is_new()) {
			return;
		}
		if (Selected_Panel != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHConcept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Concept", "BH_Concept_UU=?", get_TrxName())
							.setParameters(Selected_Panel.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSelected_Panel_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Concept with UU " + Selected_Panel.getUU());
			}
		} else {
			this.setSelected_Panel_ID(0);
		}
	}

	/**
	 * Get Selected Panel.
	 *
	 * @return Selected Panel
	 */
	@JsonProperty("Selected_Panel")
	public ForeignEntityInput Selected_Panel() {
		return mSelected_Panel;
	}
}
