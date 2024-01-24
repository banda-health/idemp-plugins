package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_TabNavBtn_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_TabNavBtn_TabInput extends MTabNavBtnTab implements I_BH_TabNavBtn_TabInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mBH_TabNavBtn;
	private I_AD_Ref_ListInput mButtonLocation;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_TabNavBtn_Tab_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_TabNavBtn_TabInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MTabNavBtnTab(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (AD_Tab != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
							.setParameters(AD_Tab.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tab with UUID " + AD_Tab.getUUID());
			}
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
		if (BH_TabNavBtn != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "BH_TabNavBtn", "BH_TabNavBtn_UU=?", get_TrxName())
							.setParameters(BH_TabNavBtn.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_TabNavBtn_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_TabNavBtn with UUID " + BH_TabNavBtn.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_TabNavBtn_Tab_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (ButtonLocation != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ButtonLocation.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setButtonLocation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ButtonLocation.getUUID());
			}
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
