package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartInput extends MChart implements I_AD_ChartInput {

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ChartOrientation_RL;
	 private I_AD_Ref_ListInput ChartType_RL;
	 private I_AD_Ref_ListInput TimeUnit_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_ChartInput(String ID) {
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
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Orientation.
	 *
	 * @param ChartOrientation_RL The orientation of the chart.
	 */
	public void setChartOrientation_RL(I_AD_Ref_ListInput ChartOrientation_RL) {
		this.ChartOrientation_RL = ChartOrientation_RL;
		MRefList foreignEntity;
		if (ChartOrientation_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ChartOrientation_RL.getID())
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
	public I_AD_Ref_ListInput getChartOrientation_RL() {
		return ChartOrientation_RL;
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
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}

	/**
	 * Set Time Unit.
	 *
	 * @param TimeUnit_RL The unit of time for grouping chart data.
	 */
	public void setTimeUnit_RL(I_AD_Ref_ListInput TimeUnit_RL) {
		this.TimeUnit_RL = TimeUnit_RL;
		MRefList foreignEntity;
		if (TimeUnit_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TimeUnit_RL.getID())
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
	public I_AD_Ref_ListInput getTimeUnit_RL() {
		return TimeUnit_RL;
	}
}
