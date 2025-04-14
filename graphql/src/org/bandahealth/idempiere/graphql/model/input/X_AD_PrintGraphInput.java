package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_PrintGraphResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_PrintFormatItem;
import org.compiere.model.X_AD_PrintGraph;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintGraphInput extends X_AD_PrintGraph implements I_AD_PrintGraphInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mData1_PrintFormatItem;
	private ForeignEntityInput mData2_PrintFormatItem;
	private ForeignEntityInput mData3_PrintFormatItem;
	private ForeignEntityInput mData4_PrintFormatItem;
	private ForeignEntityInput mData_PrintFormatItem;
	private ForeignEntityInput mDescription_PrintFormatItem;
	private ForeignEntityInput mGraphType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_PrintGraph_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintGraphInput(@JsonProperty("UU") String UU) {
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
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		if (AD_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + AD_PrintFormat.getUU());
			}
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}
	/**
	 * Set Graph.
	 *
	 * @param AD_PrintGraph_ID Graph included in Reports
	 */
	@JsonProperty("AD_PrintGraph_ID")
	public void setAD_PrintGraph_IDFromJson(int AD_PrintGraph_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintGraph_ID(AD_PrintGraph_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_PrintGraph_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_PrintGraph_UU();
	}

	/**
	 * Set Data Column.
	 *
	 * @param Data_PrintFormatItem Data Column for Pie and Line Charts
	 */
	@JsonProperty("Data_PrintFormatItem")
	public void setData_PrintFormatItemInput(ForeignEntityInput Data_PrintFormatItem) {
		this.mData_PrintFormatItem = Data_PrintFormatItem;
		if (Data_PrintFormatItem != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormatItem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
							.setParameters(Data_PrintFormatItem.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setData_PrintFormatItem_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormatItem with UU " + Data_PrintFormatItem.getUU());
			}
		} else {
			this.setData_PrintFormatItem_ID(0);
		}
	}

	/**
	 * Get Data Column.
	 *
	 * @return Data Column for Pie and Line Charts
	 */
	@JsonProperty("Data_PrintFormatItem")
	public ForeignEntityInput Data_PrintFormatItem() {
		return mData_PrintFormatItem;
	}

	/**
	 * Set Data Column 2.
	 *
	 * @param Data1_PrintFormatItem Data Column for Line Charts
	 */
	@JsonProperty("Data1_PrintFormatItem")
	public void setData1_PrintFormatItemInput(ForeignEntityInput Data1_PrintFormatItem) {
		this.mData1_PrintFormatItem = Data1_PrintFormatItem;
		if (Data1_PrintFormatItem != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormatItem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
							.setParameters(Data1_PrintFormatItem.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setData1_PrintFormatItem_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormatItem with UU " + Data1_PrintFormatItem.getUU());
			}
		} else {
			this.setData1_PrintFormatItem_ID(0);
		}
	}

	/**
	 * Get Data Column 2.
	 *
	 * @return Data Column for Line Charts
	 */
	@JsonProperty("Data1_PrintFormatItem")
	public ForeignEntityInput Data1_PrintFormatItem() {
		return mData1_PrintFormatItem;
	}

	/**
	 * Set Data Column 3.
	 *
	 * @param Data2_PrintFormatItem Data Column for Line Charts
	 */
	@JsonProperty("Data2_PrintFormatItem")
	public void setData2_PrintFormatItemInput(ForeignEntityInput Data2_PrintFormatItem) {
		this.mData2_PrintFormatItem = Data2_PrintFormatItem;
		if (Data2_PrintFormatItem != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormatItem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
							.setParameters(Data2_PrintFormatItem.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setData2_PrintFormatItem_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormatItem with UU " + Data2_PrintFormatItem.getUU());
			}
		} else {
			this.setData2_PrintFormatItem_ID(0);
		}
	}

	/**
	 * Get Data Column 3.
	 *
	 * @return Data Column for Line Charts
	 */
	@JsonProperty("Data2_PrintFormatItem")
	public ForeignEntityInput Data2_PrintFormatItem() {
		return mData2_PrintFormatItem;
	}

	/**
	 * Set Data Column 4.
	 *
	 * @param Data3_PrintFormatItem Data Column for Line Charts
	 */
	@JsonProperty("Data3_PrintFormatItem")
	public void setData3_PrintFormatItemInput(ForeignEntityInput Data3_PrintFormatItem) {
		this.mData3_PrintFormatItem = Data3_PrintFormatItem;
		if (Data3_PrintFormatItem != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormatItem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
							.setParameters(Data3_PrintFormatItem.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setData3_PrintFormatItem_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormatItem with UU " + Data3_PrintFormatItem.getUU());
			}
		} else {
			this.setData3_PrintFormatItem_ID(0);
		}
	}

	/**
	 * Get Data Column 4.
	 *
	 * @return Data Column for Line Charts
	 */
	@JsonProperty("Data3_PrintFormatItem")
	public ForeignEntityInput Data3_PrintFormatItem() {
		return mData3_PrintFormatItem;
	}

	/**
	 * Set Data Column 5.
	 *
	 * @param Data4_PrintFormatItem Data Column for Line Charts
	 */
	@JsonProperty("Data4_PrintFormatItem")
	public void setData4_PrintFormatItemInput(ForeignEntityInput Data4_PrintFormatItem) {
		this.mData4_PrintFormatItem = Data4_PrintFormatItem;
		if (Data4_PrintFormatItem != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormatItem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
							.setParameters(Data4_PrintFormatItem.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setData4_PrintFormatItem_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormatItem with UU " + Data4_PrintFormatItem.getUU());
			}
		} else {
			this.setData4_PrintFormatItem_ID(0);
		}
	}

	/**
	 * Get Data Column 5.
	 *
	 * @return Data Column for Line Charts
	 */
	@JsonProperty("Data4_PrintFormatItem")
	public ForeignEntityInput Data4_PrintFormatItem() {
		return mData4_PrintFormatItem;
	}

	/**
	 * Set Description Column.
	 *
	 * @param Description_PrintFormatItem Description Column for Pie/Line/Bar Charts
	 */
	@JsonProperty("Description_PrintFormatItem")
	public void setDescription_PrintFormatItemInput(ForeignEntityInput Description_PrintFormatItem) {
		this.mDescription_PrintFormatItem = Description_PrintFormatItem;
		if (Description_PrintFormatItem != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormatItem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
							.setParameters(Description_PrintFormatItem.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setDescription_PrintFormatItem_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormatItem with UU " + Description_PrintFormatItem.getUU());
			}
		} else {
			this.setDescription_PrintFormatItem_ID(0);
		}
	}

	/**
	 * Get Description Column.
	 *
	 * @return Description Column for Pie/Line/Bar Charts
	 */
	@JsonProperty("Description_PrintFormatItem")
	public ForeignEntityInput Description_PrintFormatItem() {
		return mDescription_PrintFormatItem;
	}

	/**
	 * Set Graph Type.
	 *
	 * @param GraphType Type of graph to be painted
	 */
	@JsonProperty("GraphType")
	public void setGraphTypeInput(ForeignEntityInput GraphType) {
		this.mGraphType = GraphType;
		if (GraphType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintGraphResolver.GRAPHTYPE_UUIDS_BY_VALUE.containsValue(GraphType.getUU())) {
				throw new AdempiereException("The reference list UU of " + GraphType.getUU() +
						" is not in the list defined for the GraphType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(GraphType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGraphType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + GraphType.getUU());
			}
		} else {
			this.setGraphType(null);
		}
	}

	/**
	 * Get Graph Type.
	 *
	 * @return Type of graph to be painted
	 */
	@JsonProperty("GraphType")
	public ForeignEntityInput GraphType() {
		return mGraphType;
	}
}
