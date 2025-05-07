package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_PA_GoalResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColorSchema;
import org.compiere.model.MGoal;
import org.compiere.model.MMeasure;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_GoalInput extends MGoal implements I_PA_GoalInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mChartType;
	private ForeignEntityInput mMeasureDisplay;
	private ForeignEntityInput mMeasureScope;
	private ForeignEntityInput mPA_ColorSchema;
	private ForeignEntityInput mPA_GoalParent;
	private ForeignEntityInput mPA_Measure;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PA_Goal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_GoalInput(@JsonProperty("UU") String UU) {
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UU " + AD_Role.getUU());
			}
		} else {
			this.setAD_Role_ID(-1);
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
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	public void setChartTypeInput(ForeignEntityInput ChartType) {
		this.mChartType = ChartType;
		if (ChartType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_GoalResolver.CHARTTYPE_UUIDS_BY_VALUE.containsValue(ChartType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ChartType.getUU() +
						" is not in the list defined for the ChartType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ChartType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setChartType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ChartType.getUU());
			}
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
	public ForeignEntityInput ChartType() {
		return mChartType;
	}
	/**
	 * Set Date Last Run.
	 *
	 * @param DateLastRun Date the process was last run.
	 */
	@JsonProperty("DateLastRun")
	public void setDateLastRunFromJson(Timestamp DateLastRun) {
		if (get_ID() == 0) {
			super.setDateLastRun(DateLastRun);
		}
	}
	/**
	 * Set Performance Goal.
	 *
	 * @param GoalPerformance Target achievement from 0..1
	 */
	@JsonProperty("GoalPerformance")
	public void setGoalPerformanceFromJson(BigDecimal GoalPerformance) {
		if (get_ID() == 0) {
			super.setGoalPerformance(GoalPerformance);
		}
	}
	/**
	 * Set Measure Actual.
	 *
	 * @param MeasureActual Actual value that has been measured.
	 */
	@JsonProperty("MeasureActual")
	public void setMeasureActualFromJson(BigDecimal MeasureActual) {
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
	public void setMeasureDisplayInput(ForeignEntityInput MeasureDisplay) {
		this.mMeasureDisplay = MeasureDisplay;
		if (MeasureDisplay != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_GoalResolver.MEASUREDISPLAY_UUIDS_BY_VALUE.containsValue(MeasureDisplay.getUU())) {
				throw new AdempiereException("The reference list UU of " + MeasureDisplay.getUU() +
						" is not in the list defined for the MeasureDisplay column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MeasureDisplay.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setMeasureDisplay(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + MeasureDisplay.getUU());
			}
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
	public ForeignEntityInput MeasureDisplay() {
		return mMeasureDisplay;
	}

	/**
	 * Set Measure Scope.
	 *
	 * @param MeasureScope Performance Measure Scope
	 */
	@JsonProperty("MeasureScope")
	public void setMeasureScopeInput(ForeignEntityInput MeasureScope) {
		this.mMeasureScope = MeasureScope;
		if (MeasureScope != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PA_GoalResolver.MEASURESCOPE_UUIDS_BY_VALUE.containsValue(MeasureScope.getUU())) {
				throw new AdempiereException("The reference list UU of " + MeasureScope.getUU() +
						" is not in the list defined for the MeasureScope column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MeasureScope.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setMeasureScope(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + MeasureScope.getUU());
			}
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
	public ForeignEntityInput MeasureScope() {
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
		if (PA_ColorSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MColorSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ColorSchema", "PA_ColorSchema_UU=?", get_TrxName())
							.setParameters(PA_ColorSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPA_ColorSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ColorSchema with UU " + PA_ColorSchema.getUU());
			}
		} else {
			this.setPA_ColorSchema_ID(0);
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
	@JsonProperty("PA_Goal_ID")
	public void setPA_Goal_IDFromJson(int PA_Goal_ID) {
		if (get_ID() == 0) {
			super.setPA_Goal_ID(PA_Goal_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPA_Goal_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (PA_GoalParent != null) {
			// Since an entity was passed, make sure it's in the DB
			MGoal foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Goal", "PA_Goal_UU=?", get_TrxName())
							.setParameters(PA_GoalParent.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPA_GoalParent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Goal with UU " + PA_GoalParent.getUU());
			}
		} else {
			this.setPA_GoalParent_ID(0);
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
		if (PA_Measure != null) {
			// Since an entity was passed, make sure it's in the DB
			MMeasure foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Measure", "PA_Measure_UU=?", get_TrxName())
							.setParameters(PA_Measure.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPA_Measure_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Measure with UU " + PA_Measure.getUU());
			}
		} else {
			this.setPA_Measure_ID(0);
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
