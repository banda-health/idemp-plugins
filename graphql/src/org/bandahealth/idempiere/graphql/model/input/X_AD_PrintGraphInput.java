package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_PrintFormatItem;
import org.compiere.model.X_AD_PrintGraph;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
	private I_AD_Ref_ListInput mGraphType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintGraphInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_PrintGraph(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFormat_ID(0);
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

	public void setAD_PrintGraph_ID(int AD_PrintGraph_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintGraph_ID(AD_PrintGraph_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintGraph_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_AD_PrintFormatItem foreignEntity;
		if (Data_PrintFormatItem != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
						.setParameters(Data_PrintFormatItem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setData_PrintFormatItem_ID(foreignEntity.get_ID());
		} else {
			super.setData_PrintFormatItem_ID(0);
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
		X_AD_PrintFormatItem foreignEntity;
		if (Data1_PrintFormatItem != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
						.setParameters(Data1_PrintFormatItem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setData1_PrintFormatItem_ID(foreignEntity.get_ID());
		} else {
			super.setData1_PrintFormatItem_ID(0);
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
		X_AD_PrintFormatItem foreignEntity;
		if (Data2_PrintFormatItem != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
						.setParameters(Data2_PrintFormatItem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setData2_PrintFormatItem_ID(foreignEntity.get_ID());
		} else {
			super.setData2_PrintFormatItem_ID(0);
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
		X_AD_PrintFormatItem foreignEntity;
		if (Data3_PrintFormatItem != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
						.setParameters(Data3_PrintFormatItem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setData3_PrintFormatItem_ID(foreignEntity.get_ID());
		} else {
			super.setData3_PrintFormatItem_ID(0);
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
		X_AD_PrintFormatItem foreignEntity;
		if (Data4_PrintFormatItem != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
						.setParameters(Data4_PrintFormatItem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setData4_PrintFormatItem_ID(foreignEntity.get_ID());
		} else {
			super.setData4_PrintFormatItem_ID(0);
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
		X_AD_PrintFormatItem foreignEntity;
		if (Description_PrintFormatItem != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormatItem", "AD_PrintFormatItem_UU=?", get_TrxName())
						.setParameters(Description_PrintFormatItem.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDescription_PrintFormatItem_ID(foreignEntity.get_ID());
		} else {
			super.setDescription_PrintFormatItem_ID(0);
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
	public void setGraphTypeInput(I_AD_Ref_ListInput GraphType) {
		this.mGraphType = GraphType;
		MRefList_BH foreignEntity;
		if (GraphType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(GraphType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGraphType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput GraphType() {
		return mGraphType;
	}
}
