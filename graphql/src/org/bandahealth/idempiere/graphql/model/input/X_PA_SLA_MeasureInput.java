package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSLAGoal;
import org.compiere.model.MSLAMeasure;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_MeasureInput extends MSLAMeasure implements I_PA_SLA_MeasureInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_TableInput AD_Table;
	 private I_PA_SLA_GoalInput PA_SLA_Goal;

	/**
	 * Standard constructor
	 */
	public X_PA_SLA_MeasureInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	public void setAD_Table(I_AD_TableInput AD_Table) {
		this.AD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public I_AD_TableInput getAD_Table() {
		return AD_Table;
	}

	/**
	 * Set SLA Goal.
	 *
	 * @param PA_SLA_Goal Service Level Agreement Goal
	 */
	public void setPA_SLA_Goal(I_PA_SLA_GoalInput PA_SLA_Goal) {
		this.PA_SLA_Goal = PA_SLA_Goal;
		MSLAGoal foreignEntity;
		if (get_ID() == 0 &&PA_SLA_Goal != null &&
				(foreignEntity = new Query(getCtx(), MSLAGoal.Table_Name, MSLAGoal.COLUMNNAME_PA_SLA_Goal_UU + "=?", get_TrxName())
						.setParameters(PA_SLA_Goal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_SLA_Goal_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get SLA Goal.
	 *
	 * @return Service Level Agreement Goal
	 */
	public I_PA_SLA_GoalInput getPA_SLA_Goal() {
		return PA_SLA_Goal;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_SLA_Measure_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_SLA_Measure_UU();
	}
}
