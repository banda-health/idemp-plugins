package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Cycle;
import org.compiere.model.X_C_CycleStep;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CycleStepInput extends X_C_CycleStep implements I_C_CycleStepInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Cycle;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_CycleStep_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CycleStepInput(@JsonProperty("UU") String UU) {
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
	 * Set Project Cycle.
	 *
	 * @param C_Cycle Identifier for this Project Reporting Cycle
	 */
	@JsonProperty("C_Cycle")
	public void setC_CycleInput(ForeignEntityInput C_Cycle) {
		this.mC_Cycle = C_Cycle;
		if (get_ID() != 0) {
			return;
		}
		if (C_Cycle != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Cycle foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Cycle", "C_Cycle_UU=?", get_TrxName())
							.setParameters(C_Cycle.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Cycle_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Cycle with UU " + C_Cycle.getUU());
			}
		} else {
			this.setC_Cycle_ID(0);
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
	@JsonProperty("C_CycleStep_ID")
	public void setC_CycleStep_IDFromJson(int C_CycleStep_ID) {
		if (get_ID() == 0) {
			super.setC_CycleStep_ID(C_CycleStep_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_CycleStep_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_CycleStep_UU();
	}
}
