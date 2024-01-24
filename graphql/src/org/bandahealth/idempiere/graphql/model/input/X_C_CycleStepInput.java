package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Cycle;
import org.compiere.model.X_C_CycleStep;

import java.sql.ResultSet;

/**
 * Generated Model for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CycleStepInput extends X_C_CycleStep implements I_C_CycleStepInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Cycle;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CycleStepInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_CycleStep(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Project Cycle.
	 *
	 * @param C_Cycle Identifier for this Project Reporting Cycle
	 */
	@JsonProperty("C_Cycle")
	public void setC_CycleInput(ForeignEntityInput C_Cycle) {
		this.mC_Cycle = C_Cycle;
		X_C_Cycle foreignEntity;
		if (get_ID() == 0 && C_Cycle != null &&
				(foreignEntity = new Query(getCtx(), "C_Cycle", "C_Cycle_UU=?", get_TrxName())
						.setParameters(C_Cycle.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Cycle_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Cycle.
	 *
	 * @return Identifier for this Project Reporting Cycle
	 */
	@JsonProperty("C_Cycle")
	public ForeignEntityInput C_Cycle() {
		return mC_Cycle;
	}
	/**
	 * Set Cycle Step.
	 *
	 * @param C_CycleStep_ID The step for this Cycle
	 */

	public void setC_CycleStep_ID(int C_CycleStep_ID) {
		if (get_ID() == 0) {
			super.setC_CycleStep_ID(C_CycleStep_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CycleStep_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_CycleStep_UU();
	}
}
