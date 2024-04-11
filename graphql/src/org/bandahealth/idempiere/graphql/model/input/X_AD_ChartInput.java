package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ChartInput extends MChart implements I_AD_ChartInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mChartOrientation;
	private ForeignEntityInput mChartType;
	private ForeignEntityInput mTimeUnit;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Chart_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ChartInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Chart.
	 *
	 * @param AD_Chart_ID Chart
	 */

	public void setAD_Chart_ID(int AD_Chart_ID) {
		if (get_ID() == 0) {
			super.setAD_Chart_ID(AD_Chart_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Chart_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Chart_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set Orientation.
	 *
	 * @param ChartOrientation The orientation of the chart.
	 */
	@JsonProperty("ChartOrientation")
	public void setChartOrientationInput(ForeignEntityInput ChartOrientation) {
		this.mChartOrientation = ChartOrientation;
		if (ChartOrientation != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ChartOrientation.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setChartOrientation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ChartOrientation.getUU());
			}
		} else {
			this.setChartOrientation(null);
		}
	}

	/**
	 * Get Orientation.
	 *
	 * @return The orientation of the chart.
	 */
	@JsonProperty("ChartOrientation")
	public ForeignEntityInput ChartOrientation() {
		return mChartOrientation;
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
			// Since an entity was passed, make sure it's in the DB
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
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
			}
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Time Unit.
	 *
	 * @param TimeUnit The unit of time for grouping chart data.
	 */
	@JsonProperty("TimeUnit")
	public void setTimeUnitInput(ForeignEntityInput TimeUnit) {
		this.mTimeUnit = TimeUnit;
		if (TimeUnit != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TimeUnit.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTimeUnit(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + TimeUnit.getUU());
			}
		} else {
			this.setTimeUnit(null);
		}
	}

	/**
	 * Get Time Unit.
	 *
	 * @return The unit of time for grouping chart data.
	 */
	@JsonProperty("TimeUnit")
	public ForeignEntityInput TimeUnit() {
		return mTimeUnit;
	}
}
