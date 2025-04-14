package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_Tab_CustomizationResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Tab_Customization;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Tab_CustomizationInput extends X_AD_Tab_Customization implements I_AD_Tab_CustomizationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mIsAutoHideEmptyColumn;
	private ForeignEntityInput mIsDisplayedGrid;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Tab_Customization_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Tab_CustomizationInput(@JsonProperty("UU") String UU) {
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
	 * Set Tab Customization.
	 *
	 * @param AD_Tab_Customization_ID Tab Customization
	 */
	@JsonProperty("AD_Tab_Customization_ID")
	public void setAD_Tab_Customization_IDFromJson(int AD_Tab_Customization_ID) {
		if (get_ID() == 0) {
			super.setAD_Tab_Customization_ID(AD_Tab_Customization_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Tab_Customization_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (AD_Tab != null) {
			// Since an entity was passed, make sure it's in the DB
			MTab foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
							.setParameters(AD_Tab.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tab with UU " + AD_Tab.getUU());
			}
		} else {
			this.setAD_Tab_ID(0);
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
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	 * Set Auto Hide Empty Column.
	 *
	 * @param IsAutoHideEmptyColumn Auto Hide Empty Column
	 */
	@JsonProperty("IsAutoHideEmptyColumn")
	public void setIsAutoHideEmptyColumnInput(ForeignEntityInput IsAutoHideEmptyColumn) {
		this.mIsAutoHideEmptyColumn = IsAutoHideEmptyColumn;
		if (IsAutoHideEmptyColumn != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Tab_CustomizationResolver.ISAUTOHIDEEMPTYCOLUMN_UUIDS_BY_VALUE.containsValue(IsAutoHideEmptyColumn.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsAutoHideEmptyColumn.getUU() +
						" is not in the list defined for the IsAutoHideEmptyColumn column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAutoHideEmptyColumn.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsAutoHideEmptyColumn(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsAutoHideEmptyColumn.getUU());
			}
		} else {
			this.setIsAutoHideEmptyColumn(null);
		}
	}

	/**
	 * Get Auto Hide Empty Column.
	 *
	 * @return Auto Hide Empty Column
	 */
	@JsonProperty("IsAutoHideEmptyColumn")
	public ForeignEntityInput IsAutoHideEmptyColumn() {
		return mIsAutoHideEmptyColumn;
	}

	/**
	 * Set Show in Grid.
	 *
	 * @param IsDisplayedGrid Show in Grid
	 */
	@JsonProperty("IsDisplayedGrid")
	public void setIsDisplayedGridInput(ForeignEntityInput IsDisplayedGrid) {
		this.mIsDisplayedGrid = IsDisplayedGrid;
		if (IsDisplayedGrid != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Tab_CustomizationResolver.ISDISPLAYEDGRID_UUIDS_BY_VALUE.containsValue(IsDisplayedGrid.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsDisplayedGrid.getUU() +
						" is not in the list defined for the IsDisplayedGrid column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsDisplayedGrid.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsDisplayedGrid(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsDisplayedGrid.getUU());
			}
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
	public ForeignEntityInput IsDisplayedGrid() {
		return mIsDisplayedGrid;
	}
}
