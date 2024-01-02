package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartInput extends MChart implements I_AD_ChartInput {

	 private I_AD_EntityTypeInput mAD_EntityType;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mChartOrientation;
	 private I_AD_Ref_ListInput mChartType;
	 private I_AD_Ref_ListInput mTimeUnit;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ChartInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Chart_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Chart_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Orientation.
	 *
	 * @param ChartOrientation The orientation of the chart.
	 */
	@JsonProperty("ChartOrientation")
	public void setChartOrientationInput(I_AD_Ref_ListInput ChartOrientation) {
		this.mChartOrientation = ChartOrientation;
		MRefList_BH foreignEntity;
		if (ChartOrientation != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ChartOrientation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setChartOrientation(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput ChartOrientation() {
		return mChartOrientation;
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
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(I_AD_EntityTypeInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public I_AD_EntityTypeInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Time Unit.
	 *
	 * @param TimeUnit The unit of time for grouping chart data.
	 */
	@JsonProperty("TimeUnit")
	public void setTimeUnitInput(I_AD_Ref_ListInput TimeUnit) {
		this.mTimeUnit = TimeUnit;
		MRefList_BH foreignEntity;
		if (TimeUnit != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TimeUnit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTimeUnit(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput TimeUnit() {
		return mTimeUnit;
	}
}
