package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TabInput extends MTab implements I_AD_TabInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_ColumnSortOrder;
	private ForeignEntityInput mAD_ColumnSortYesNo;
	private ForeignEntityInput mAD_CtxHelp;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mIncluded_Tab;
	private ForeignEntityInput mParent_Column;
	private I_AD_Ref_ListInput mTreeDisplayedOn;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_TabInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTab(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
	}

	/**
	 * Set Order Column.
	 *
	 * @param AD_ColumnSortOrder Column determining the order
	 */
	@JsonProperty("AD_ColumnSortOrder")
	public void setAD_ColumnSortOrderInput(ForeignEntityInput AD_ColumnSortOrder) {
		this.mAD_ColumnSortOrder = AD_ColumnSortOrder;
		MColumn foreignEntity;
		if (AD_ColumnSortOrder != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_ColumnSortOrder.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ColumnSortOrder_ID(foreignEntity.get_ID());
		} else {
			super.setAD_ColumnSortOrder_ID(0);
		}
	}

	/**
	 * Get Order Column.
	 *
	 * @return Column determining the order
	 */
	@JsonProperty("AD_ColumnSortOrder")
	public ForeignEntityInput AD_ColumnSortOrder() {
		return mAD_ColumnSortOrder;
	}

	/**
	 * Set Included Column.
	 *
	 * @param AD_ColumnSortYesNo Column determining if a Table Column is included in Ordering
	 */
	@JsonProperty("AD_ColumnSortYesNo")
	public void setAD_ColumnSortYesNoInput(ForeignEntityInput AD_ColumnSortYesNo) {
		this.mAD_ColumnSortYesNo = AD_ColumnSortYesNo;
		MColumn foreignEntity;
		if (AD_ColumnSortYesNo != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_ColumnSortYesNo.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ColumnSortYesNo_ID(foreignEntity.get_ID());
		} else {
			super.setAD_ColumnSortYesNo_ID(0);
		}
	}

	/**
	 * Get Included Column.
	 *
	 * @return Column determining if a Table Column is included in Ordering
	 */
	@JsonProperty("AD_ColumnSortYesNo")
	public ForeignEntityInput AD_ColumnSortYesNo() {
		return mAD_ColumnSortYesNo;
	}

	/**
	 * Set Context Help.
	 *
	 * @param AD_CtxHelp Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public void setAD_CtxHelpInput(ForeignEntityInput AD_CtxHelp) {
		this.mAD_CtxHelp = AD_CtxHelp;
		MCtxHelp foreignEntity;
		if (AD_CtxHelp != null &&
				(foreignEntity = new Query(getCtx(), "AD_CtxHelp", "AD_CtxHelp_UU=?", get_TrxName())
						.setParameters(AD_CtxHelp.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_CtxHelp_ID(foreignEntity.get_ID());
		} else {
			super.setAD_CtxHelp_ID(0);
		}
	}

	/**
	 * Get Context Help.
	 *
	 * @return Context Help
	 */
	@JsonProperty("AD_CtxHelp")
	public ForeignEntityInput AD_CtxHelp() {
		return mAD_CtxHelp;
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Image_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
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
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (AD_Process != null &&
				(foreignEntity = new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public ForeignEntityInput AD_Process() {
		return mAD_Process;
	}
	/**
	 * Set Tab.
	 *
	 * @param AD_Tab_ID Tab within a Window
	 */

	public void setAD_Tab_ID(int AD_Tab_ID) {
		if (get_ID() == 0) {
			super.setAD_Tab_ID(AD_Tab_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Tab_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Tab_UU();
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable_BH foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (get_ID() == 0 && AD_Window != null &&
				(foreignEntity = new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}

	/**
	 * Set Included Tab.
	 *
	 * @param Included_Tab Included Tab in this Tab (Master Detail)
	 */
	@JsonProperty("Included_Tab")
	public void setIncluded_TabInput(ForeignEntityInput Included_Tab) {
		this.mIncluded_Tab = Included_Tab;
		MTab foreignEntity;
		if (Included_Tab != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
						.setParameters(Included_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIncluded_Tab_ID(foreignEntity.get_ID());
		} else {
			super.setIncluded_Tab_ID(0);
		}
	}

	/**
	 * Get Included Tab.
	 *
	 * @return Included Tab in this Tab (Master Detail)
	 */
	@JsonProperty("Included_Tab")
	public ForeignEntityInput Included_Tab() {
		return mIncluded_Tab;
	}

	/**
	 * Set Parent Column.
	 *
	 * @param Parent_Column The link column on the parent tab.
	 */
	@JsonProperty("Parent_Column")
	public void setParent_ColumnInput(ForeignEntityInput Parent_Column) {
		this.mParent_Column = Parent_Column;
		MColumn foreignEntity;
		if (Parent_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(Parent_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setParent_Column_ID(foreignEntity.get_ID());
		} else {
			super.setParent_Column_ID(0);
		}
	}

	/**
	 * Get Parent Column.
	 *
	 * @return The link column on the parent tab.
	 */
	@JsonProperty("Parent_Column")
	public ForeignEntityInput Parent_Column() {
		return mParent_Column;
	}

	/**
	 * Set Tree displayed.
	 *
	 * @param TreeDisplayedOn The tree can be displayed on master tab, detail tab or both
	 */
	@JsonProperty("TreeDisplayedOn")
	public void setTreeDisplayedOnInput(I_AD_Ref_ListInput TreeDisplayedOn) {
		this.mTreeDisplayedOn = TreeDisplayedOn;
		MRefList_BH foreignEntity;
		if (TreeDisplayedOn != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TreeDisplayedOn.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTreeDisplayedOn(foreignEntity.getValue());
		} else {
			this.setTreeDisplayedOn(null);
		}
	}

	/**
	 * Get Tree displayed.
	 *
	 * @return The tree can be displayed on master tab, detail tab or both
	 */
	@JsonProperty("TreeDisplayedOn")
	public I_AD_Ref_ListInput TreeDisplayedOn() {
		return mTreeDisplayedOn;
	}
}
