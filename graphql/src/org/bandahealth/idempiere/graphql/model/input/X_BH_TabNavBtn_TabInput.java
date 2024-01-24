package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_TabNavBtn_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_TabNavBtn_TabInput extends MTabNavBtnTab implements I_BH_TabNavBtn_TabInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mBH_TabNavBtn;
	private I_AD_Ref_ListInput mButtonLocation;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_TabNavBtn_TabInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTabNavBtnTab(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Tab Navigation Button.
	 *
	 * @param BH_TabNavBtn Tab Navigation Button
	 */
	@JsonProperty("BH_TabNavBtn")
	public void setBH_TabNavBtnInput(ForeignEntityInput BH_TabNavBtn) {
		this.mBH_TabNavBtn = BH_TabNavBtn;
		MTabNavBtn foreignEntity;
		if (BH_TabNavBtn != null &&
				(foreignEntity = new Query(getCtx(), "BH_TabNavBtn", "BH_TabNavBtn_UU=?", get_TrxName())
						.setParameters(BH_TabNavBtn.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_TabNavBtn_ID(foreignEntity.get_ID());
		} else {
			super.setBH_TabNavBtn_ID(0);
		}
	}

	/**
	 * Get Tab Navigation Button.
	 *
	 * @return Tab Navigation Button
	 */
	@JsonProperty("BH_TabNavBtn")
	public ForeignEntityInput BH_TabNavBtn() {
		return mBH_TabNavBtn;
	}
	/**
	 * Set BH_TabNavBtn_Tab.
	 *
	 * @param BH_TabNavBtn_Tab_ID BH_TabNavBtn_Tab
	 */

	public void setBH_TabNavBtn_Tab_ID(int BH_TabNavBtn_Tab_ID) {
		if (get_ID() == 0) {
			super.setBH_TabNavBtn_Tab_ID(BH_TabNavBtn_Tab_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_TabNavBtn_Tab_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_TabNavBtn_Tab_UU();
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
