package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColorSchema;
import org.compiere.model.MGoal;
import org.compiere.model.MMeasure;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalInput extends MGoal implements I_PA_GoalInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mPA_ColorSchema;
	private ForeignEntityInput mPA_GoalParent;
	private ForeignEntityInput mPA_Measure;
	private I_AD_Ref_ListInput mChartType;
	private I_AD_Ref_ListInput mMeasureDisplay;
	private I_AD_Ref_ListInput mMeasureScope;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_GoalInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MGoal(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Chart Type.
	 *
	 * @param ChartType Type of chart to render
	 */
	@JsonProperty("ChartType")
	public void setChartTypeInput(I_AD_Ref_ListInput ChartType) {
		this.mChartType = ChartType;
		MRefList_BH foreignEntity;
		if (ChartType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ChartType.getID())
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
	@JsonProperty("ChartType")
	public I_AD_Ref_ListInput ChartType() {
		return mChartType;
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
	 * @param MeasureDisplay Measure Scope initially displayed
	 */
	@JsonProperty("MeasureDisplay")
	public void setMeasureDisplayInput(I_AD_Ref_ListInput MeasureDisplay) {
		this.mMeasureDisplay = MeasureDisplay;
		MRefList_BH foreignEntity;
		if (MeasureDisplay != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureDisplay.getID())
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
	@JsonProperty("MeasureDisplay")
	public I_AD_Ref_ListInput MeasureDisplay() {
		return mMeasureDisplay;
	}

	/**
	 * Set Measure Scope.
	 *
	 * @param MeasureScope Performance Measure Scope
	 */
	@JsonProperty("MeasureScope")
	public void setMeasureScopeInput(I_AD_Ref_ListInput MeasureScope) {
		this.mMeasureScope = MeasureScope;
		MRefList_BH foreignEntity;
		if (MeasureScope != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MeasureScope.getID())
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
	@JsonProperty("MeasureScope")
	public I_AD_Ref_ListInput MeasureScope() {
		return mMeasureScope;
	}

	/**
	 * Set Color Schema.
	 *
	 * @param PA_ColorSchema Performance Color Schema
	 */
	@JsonProperty("PA_ColorSchema")
	public void setPA_ColorSchemaInput(ForeignEntityInput PA_ColorSchema) {
		this.mPA_ColorSchema = PA_ColorSchema;
		MColorSchema foreignEntity;
		if (PA_ColorSchema != null &&
				(foreignEntity = new Query(getCtx(), "PA_ColorSchema", "PA_ColorSchema_UU=?", get_TrxName())
						.setParameters(PA_ColorSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_ColorSchema_ID(foreignEntity.get_ID());
		} else {
			super.setPA_ColorSchema_ID(0);
		}
	}

	/**
	 * Get Color Schema.
	 *
	 * @return Performance Color Schema
	 */
	@JsonProperty("PA_ColorSchema")
	public ForeignEntityInput PA_ColorSchema() {
		return mPA_ColorSchema;
	}
	/**
	 * Set Goal.
	 *
	 * @param PA_Goal_ID Performance Goal
	 */

	public void setPA_Goal_ID(int PA_Goal_ID) {
		if (get_ID() == 0) {
			super.setPA_Goal_ID(PA_Goal_ID);
		}
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
	@JsonProperty("PA_GoalParent")
	public void setPA_GoalParentInput(ForeignEntityInput PA_GoalParent) {
		this.mPA_GoalParent = PA_GoalParent;
		MGoal foreignEntity;
		if (PA_GoalParent != null &&
				(foreignEntity = new Query(getCtx(), "PA_Goal", "PA_Goal_UU=?", get_TrxName())
						.setParameters(PA_GoalParent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_GoalParent_ID(foreignEntity.get_ID());
		} else {
			super.setPA_GoalParent_ID(0);
		}
	}

	/**
	 * Get Parent Goal.
	 *
	 * @return Parent Goal
	 */
	@JsonProperty("PA_GoalParent")
	public ForeignEntityInput PA_GoalParent() {
		return mPA_GoalParent;
	}

	/**
	 * Set Measure.
	 *
	 * @param PA_Measure Concrete Performance Measurement
	 */
	@JsonProperty("PA_Measure")
	public void setPA_MeasureInput(ForeignEntityInput PA_Measure) {
		this.mPA_Measure = PA_Measure;
		MMeasure foreignEntity;
		if (PA_Measure != null &&
				(foreignEntity = new Query(getCtx(), "PA_Measure", "PA_Measure_UU=?", get_TrxName())
						.setParameters(PA_Measure.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_Measure_ID(foreignEntity.get_ID());
		} else {
			super.setPA_Measure_ID(0);
		}
	}

	/**
	 * Get Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	@JsonProperty("PA_Measure")
	public ForeignEntityInput PA_Measure() {
		return mPA_Measure;
	}
}
