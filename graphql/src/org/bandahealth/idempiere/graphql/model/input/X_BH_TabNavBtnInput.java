package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_TabNavBtn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_TabNavBtnInput extends MTabNavBtn implements I_BH_TabNavBtnInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_Window;
	private I_AD_Ref_ListInput mButtonAction;
	private I_AD_Ref_ListInput mButtonLocation;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_TabNavBtnInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTabNavBtn(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public void setAD_TabInput(ForeignEntityInput AD_Tab) {
		this.mAD_Tab = AD_Tab;
		MTab foreignEntity;
		if (AD_Tab != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
						.setParameters(AD_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tab_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tab_ID(0);
		}
	}

	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public ForeignEntityInput AD_Tab() {
		return mAD_Tab;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
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
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
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
	 * Set Tab Navigation Button.
	 *
	 * @param BH_TabNavBtn_ID Tab Navigation Button
	 */

	public void setBH_TabNavBtn_ID(int BH_TabNavBtn_ID) {
		if (get_ID() == 0) {
			super.setBH_TabNavBtn_ID(BH_TabNavBtn_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_TabNavBtn_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_TabNavBtn_UU();
	}

	/**
	 * Set Button Action.
	 *
	 * @param ButtonAction The action this button will perform
	 */
	@JsonProperty("ButtonAction")
	public void setButtonActionInput(I_AD_Ref_ListInput ButtonAction) {
		this.mButtonAction = ButtonAction;
		MRefList_BH foreignEntity;
		if (ButtonAction != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ButtonAction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setButtonAction(foreignEntity.getValue());
		} else {
			this.setButtonAction(null);
		}
	}

	/**
	 * Get Button Action.
	 *
	 * @return The action this button will perform
	 */
	@JsonProperty("ButtonAction")
	public I_AD_Ref_ListInput ButtonAction() {
		return mButtonAction;
	}

	/**
	 * Set Button Location.
	 *
	 * @param ButtonLocation The position of this button on the screen
	 */
	@JsonProperty("ButtonLocation")
	public void setButtonLocationInput(I_AD_Ref_ListInput ButtonLocation) {
		this.mButtonLocation = ButtonLocation;
		MRefList_BH foreignEntity;
		if (ButtonLocation != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ButtonLocation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setButtonLocation(foreignEntity.getValue());
		} else {
			this.setButtonLocation(null);
		}
	}

	/**
	 * Get Button Location.
	 *
	 * @return The position of this button on the screen
	 */
	@JsonProperty("ButtonLocation")
	public I_AD_Ref_ListInput ButtonLocation() {
		return mButtonLocation;
	}
}
