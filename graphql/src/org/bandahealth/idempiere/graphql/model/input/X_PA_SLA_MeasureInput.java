package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_PA_SLA_Goal;
import org.compiere.model.X_PA_SLA_Measure;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_SLA_MeasureInput extends X_PA_SLA_Measure implements I_PA_SLA_MeasureInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mPA_SLA_Goal;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PA_SLA_Measure_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_SLA_MeasureInput(@JsonProperty("UU") String UU) {
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set SLA Goal.
	 *
	 * @param PA_SLA_Goal Service Level Agreement Goal
	 */
	@JsonProperty("PA_SLA_Goal")
	public void setPA_SLA_GoalInput(ForeignEntityInput PA_SLA_Goal) {
		this.mPA_SLA_Goal = PA_SLA_Goal;
		if (get_ID() != 0) {
			return;
		}
		if (PA_SLA_Goal != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PA_SLA_Goal foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_SLA_Goal", "PA_SLA_Goal_UU=?", get_TrxName())
							.setParameters(PA_SLA_Goal.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPA_SLA_Goal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_SLA_Goal with UU " + PA_SLA_Goal.getUU());
			}
		} else {
			this.setPA_SLA_Goal_ID(0);
		}
	}

	/**
	 * Get SLA Goal.
	 *
	 * @return Service Level Agreement Goal
	 */
	@JsonProperty("PA_SLA_Goal")
	public ForeignEntityInput PA_SLA_Goal() {
		return mPA_SLA_Goal;
	}
	/**
	 * Set SLA Measure.
	 *
	 * @param PA_SLA_Measure_ID Service Level Agreement Measure
	 */
	@JsonProperty("PA_SLA_Measure_ID")
	public void setPA_SLA_Measure_IDFromJson(int PA_SLA_Measure_ID) {
		if (get_ID() == 0) {
			super.setPA_SLA_Measure_ID(PA_SLA_Measure_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPA_SLA_Measure_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPA_SLA_Measure_UU();
	}
}
