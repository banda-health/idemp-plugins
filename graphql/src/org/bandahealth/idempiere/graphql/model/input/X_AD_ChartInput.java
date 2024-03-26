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
	private I_AD_Ref_ListInput mChartOrientation;
	private I_AD_Ref_ListInput mChartType;
	private I_AD_Ref_ListInput mTimeUnit;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Chart_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ChartInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Chart_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	public void setChartOrientationInput(I_AD_Ref_ListInput ChartOrientation) {
		this.mChartOrientation = ChartOrientation;
		if (ChartOrientation != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ChartOrientation.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setChartOrientation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ChartOrientation.getUUID());
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
		if (ChartType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ChartType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setChartType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ChartType.getUUID());
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
	public I_AD_Ref_ListInput ChartType() {
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
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
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
	public void setTimeUnitInput(I_AD_Ref_ListInput TimeUnit) {
		this.mTimeUnit = TimeUnit;
		if (TimeUnit != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TimeUnit.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTimeUnit(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TimeUnit.getUUID());
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
	public I_AD_Ref_ListInput TimeUnit() {
		return mTimeUnit;
	}
}
