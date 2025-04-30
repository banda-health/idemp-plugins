package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.Query;
import org.compiere.model.X_C_CyclePhase;
import org.compiere.model.X_C_CycleStep;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CyclePhaseInput extends X_C_CyclePhase implements I_C_CyclePhaseInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_CycleStep;
	private ForeignEntityInput mC_Phase;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_CyclePhase_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CyclePhaseInput(@JsonProperty("UU") String UU) {
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_CyclePhase_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_CyclePhase_UU();
	}

	/**
	 * Set Cycle Step.
	 *
	 * @param C_CycleStep The step for this Cycle
	 */
	@JsonProperty("C_CycleStep")
	public void setC_CycleStepInput(ForeignEntityInput C_CycleStep) {
		this.mC_CycleStep = C_CycleStep;
		if (!is_new()) {
			return;
		}
		if (C_CycleStep != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_CycleStep foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CycleStep", "C_CycleStep_UU=?", get_TrxName())
							.setParameters(C_CycleStep.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_CycleStep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CycleStep with UU " + C_CycleStep.getUU());
			}
		} else {
			this.setC_CycleStep_ID(0);
		}
	}

	/**
	 * Get Cycle Step.
	 *
	 * @return The step for this Cycle
	 */
	@JsonProperty("C_CycleStep")
	public ForeignEntityInput C_CycleStep() {
		return mC_CycleStep;
	}

	/**
	 * Set Standard Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	@JsonProperty("C_Phase")
	public void setC_PhaseInput(ForeignEntityInput C_Phase) {
		this.mC_Phase = C_Phase;
		if (!is_new()) {
			return;
		}
		if (C_Phase != null) {
			// Since an entity was passed, make sure it's in the DB
			MProjectTypePhase foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Phase", "C_Phase_UU=?", get_TrxName())
							.setParameters(C_Phase.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Phase_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Phase with UU " + C_Phase.getUU());
			}
		} else {
			this.setC_Phase_ID(0);
		}
	}

	/**
	 * Get Standard Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	@JsonProperty("C_Phase")
	public ForeignEntityInput C_Phase() {
		return mC_Phase;
	}
}
