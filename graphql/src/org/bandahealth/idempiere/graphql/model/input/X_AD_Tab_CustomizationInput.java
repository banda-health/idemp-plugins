package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Tab_Customization;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Tab_CustomizationInput extends X_AD_Tab_Customization implements I_AD_Tab_CustomizationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_User;
	private I_AD_Ref_ListInput mIsDisplayedGrid;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Tab_CustomizationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_Tab_Customization(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Tab Customization.
	 *
	 * @param AD_Tab_Customization_ID Tab Customization
	 */

	public void setAD_Tab_Customization_ID(int AD_Tab_Customization_ID) {
		if (get_ID() == 0) {
			super.setAD_Tab_Customization_ID(AD_Tab_Customization_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Tab_Customization_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Tab_Customization_UU();
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
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
	 * Set Show in Grid.
	 *
	 * @param IsDisplayedGrid Show in Grid
	 */
	@JsonProperty("IsDisplayedGrid")
	public void setIsDisplayedGridInput(I_AD_Ref_ListInput IsDisplayedGrid) {
		this.mIsDisplayedGrid = IsDisplayedGrid;
		MRefList_BH foreignEntity;
		if (IsDisplayedGrid != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsDisplayedGrid.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsDisplayedGrid(foreignEntity.getValue());
		} else {
			this.setIsDisplayedGrid(null);
		}
	}

	/**
	 * Get Show in Grid.
	 *
	 * @return Show in Grid
	 */
	@JsonProperty("IsDisplayedGrid")
	public I_AD_Ref_ListInput IsDisplayedGrid() {
		return mIsDisplayedGrid;
	}
}
