package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.Query;
import org.compiere.model.X_C_CyclePhase;
import org.compiere.model.X_C_CycleStep;

import java.sql.ResultSet;

/**
 * Generated Model for C_CyclePhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CyclePhaseInput extends X_C_CyclePhase implements I_C_CyclePhaseInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_CycleStep;
	private ForeignEntityInput mC_Phase;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CyclePhaseInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_CyclePhase(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CyclePhase_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_C_CycleStep foreignEntity;
		if (get_ID() == 0 && C_CycleStep != null &&
				(foreignEntity = new Query(getCtx(), "C_CycleStep", "C_CycleStep_UU=?", get_TrxName())
						.setParameters(C_CycleStep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CycleStep_ID(foreignEntity.get_ID());
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
		MProjectTypePhase foreignEntity;
		if (get_ID() == 0 && C_Phase != null &&
				(foreignEntity = new Query(getCtx(), "C_Phase", "C_Phase_UU=?", get_TrxName())
						.setParameters(C_Phase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Phase_ID(foreignEntity.get_ID());
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
