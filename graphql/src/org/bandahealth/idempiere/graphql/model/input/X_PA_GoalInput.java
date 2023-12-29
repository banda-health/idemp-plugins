package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColorSchema;
import org.compiere.model.MGoal;
import org.compiere.model.MMeasure;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalInput extends MGoal implements I_PA_GoalInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ChartType_RL;
	 private I_AD_Ref_ListInput MeasureDisplay_RL;
	 private I_AD_Ref_ListInput MeasureScope_RL;
	 private I_AD_RoleInput AD_Role;
	 private I_AD_UserInput AD_User;
	 private I_PA_ColorSchemaInput PA_ColorSchema;
	 private I_PA_GoalInput PA_GoalParent;
	 private I_PA_MeasureInput PA_Measure;

	/**
	 * Standard constructor
	 */
	public X_PA_GoalInput(String ID) {
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	public void setAD_Role(I_AD_RoleInput AD_Role) {
		this.AD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public I_AD_RoleInput getAD_Role() {
		return AD_Role;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set Chart Type.
	 *
	 * @param ChartType_RL Type of chart to render
	 */
	public void setChartType_RL(I_AD_Ref_ListInput ChartType_RL) {
		this.ChartType_RL = ChartType_RL;
		MRefList foreignEntity;
		if (ChartType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ChartType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setChartType(foreignEntity.getValue());
		} else {
			this.setChartType(null);
		}
	}

	/**
	 * Get Chart Type.
	 *
	 * @return Type of chart to render
	 */
	public I_AD_Ref_ListInput getChartType_RL() {
		return ChartType_RL;
	}
	/**
	 * Set Date last run.
	 *
	 * @param DateLastRun Date the process was last run.
	 */
	public void setDateLastRun(Timestamp DateLastRun) {
		if (get_ID() == 0) {
			super.setDateLastRun(DateLastRun);
		}
	}
	/**
	 * Set Performance Goal.
	 *
	 * @param GoalPerformance Target achievement from 0..1
	 */
	public void setGoalPerformance(BigDecimal GoalPerformance) {
		if (get_ID() == 0) {
			super.setGoalPerformance(GoalPerformance);
		}
	}
	/**
	 * Set Measure Actual.
	 *
	 * @param MeasureActual Actual value that has been measured.
	 */
	public void setMeasureActual(BigDecimal MeasureActual) {
		if (get_ID() == 0) {
			super.setMeasureActual(MeasureActual);
		}
	}

	/**
	 * Set Measure Display.
	 *
	 * @param MeasureDisplay_RL Measure Scope initially displayed
	 */
	public void setMeasureDisplay_RL(I_AD_Ref_ListInput MeasureDisplay_RL) {
		this.MeasureDisplay_RL = MeasureDisplay_RL;
		MRefList foreignEntity;
		if (MeasureDisplay_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureDisplay_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMeasureDisplay(foreignEntity.getValue());
		} else {
			this.setMeasureDisplay(null);
		}
	}

	/**
	 * Get Measure Display.
	 *
	 * @return Measure Scope initially displayed
	 */
	public I_AD_Ref_ListInput getMeasureDisplay_RL() {
		return MeasureDisplay_RL;
	}

	/**
	 * Set Measure Scope.
	 *
	 * @param MeasureScope_RL Performance Measure Scope
	 */
	public void setMeasureScope_RL(I_AD_Ref_ListInput MeasureScope_RL) {
		this.MeasureScope_RL = MeasureScope_RL;
		MRefList foreignEntity;
		if (MeasureScope_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureScope_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMeasureScope(foreignEntity.getValue());
		} else {
			this.setMeasureScope(null);
		}
	}

	/**
	 * Get Measure Scope.
	 *
	 * @return Performance Measure Scope
	 */
	public I_AD_Ref_ListInput getMeasureScope_RL() {
		return MeasureScope_RL;
	}

	/**
	 * Set Color Schema.
	 *
	 * @param PA_ColorSchema Performance Color Schema
	 */
	public void setPA_ColorSchema(I_PA_ColorSchemaInput PA_ColorSchema) {
		this.PA_ColorSchema = PA_ColorSchema;
		MColorSchema foreignEntity;
		if (PA_ColorSchema != null &&
				(foreignEntity = new Query(getCtx(), MColorSchema.Table_Name, MColorSchema.COLUMNNAME_PA_ColorSchema_UU + "=?", get_TrxName())
						.setParameters(PA_ColorSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_ColorSchema_ID(foreignEntity.get_ID());
		} else {
			this.setPA_ColorSchema_ID(0);
		}
	}

	/**
	 * Get Color Schema.
	 *
	 * @return Performance Color Schema
	 */
	public I_PA_ColorSchemaInput getPA_ColorSchema() {
		return PA_ColorSchema;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_Goal_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_Goal_UU();
	}

	/**
	 * Set Parent Goal.
	 *
	 * @param PA_GoalParent Parent Goal
	 */
	public void setPA_GoalParent(I_PA_GoalInput PA_GoalParent) {
		this.PA_GoalParent = PA_GoalParent;
		MGoal foreignEntity;
		if (PA_GoalParent != null &&
				(foreignEntity = new Query(getCtx(), MGoal.Table_Name, MGoal.COLUMNNAME_PA_Goal_UU + "=?", get_TrxName())
						.setParameters(PA_GoalParent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_GoalParent_ID(foreignEntity.get_ID());
		} else {
			this.setPA_GoalParent_ID(0);
		}
	}

	/**
	 * Get Parent Goal.
	 *
	 * @return Parent Goal
	 */
	public I_PA_GoalInput getPA_GoalParent() {
		return PA_GoalParent;
	}

	/**
	 * Set Measure.
	 *
	 * @param PA_Measure Concrete Performance Measurement
	 */
	public void setPA_Measure(I_PA_MeasureInput PA_Measure) {
		this.PA_Measure = PA_Measure;
		MMeasure foreignEntity;
		if (PA_Measure != null &&
				(foreignEntity = new Query(getCtx(), MMeasure.Table_Name, MMeasure.COLUMNNAME_PA_Measure_UU + "=?", get_TrxName())
						.setParameters(PA_Measure.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Measure_ID(foreignEntity.get_ID());
		} else {
			this.setPA_Measure_ID(0);
		}
	}

	/**
	 * Get Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	public I_PA_MeasureInput getPA_Measure() {
		return PA_Measure;
	}
}
