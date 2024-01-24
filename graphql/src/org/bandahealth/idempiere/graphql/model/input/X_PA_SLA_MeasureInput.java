package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSLAGoal;
import org.compiere.model.MSLAMeasure;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_SLA_MeasureInput extends MSLAMeasure implements I_PA_SLA_MeasureInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mPA_SLA_Goal;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_SLA_Measure_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_SLA_MeasureInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MSLAMeasure(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable_BH foreignEntity;
		if (AD_Table != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
			}
		} else {
			super.setAD_Table_ID(0);
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
		MSLAGoal foreignEntity;
		if (get_ID() == 0 && PA_SLA_Goal != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "PA_SLA_Goal", "PA_SLA_Goal_UU=?", get_TrxName())
							.setParameters(PA_SLA_Goal.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_SLA_Goal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_SLA_Goal with UUID " + PA_SLA_Goal.getUUID());
			}
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

	public void setPA_SLA_Measure_ID(int PA_SLA_Measure_ID) {
		if (get_ID() == 0) {
			super.setPA_SLA_Measure_ID(PA_SLA_Measure_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_SLA_Measure_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_SLA_Measure_UU();
	}
}
