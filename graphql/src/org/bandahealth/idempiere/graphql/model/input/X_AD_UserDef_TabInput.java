package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.MUserDefTab;
import org.compiere.model.MUserDefWin;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_TabInput extends MUserDefTab implements I_AD_UserDef_TabInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_UserDef_Win;
	private I_AD_Ref_ListInput mIsAllowAdvancedLookup;
	private I_AD_Ref_ListInput mIsLookupOnlySelection;
	private I_AD_Ref_ListInput mIsReadOnly;
	private I_AD_Ref_ListInput mIsSingleRow;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserDef_Tab_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_TabInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
		if (AD_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			MProcess_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
							.setParameters(AD_Process.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UUID " + AD_Process.getUUID());
			}
		} else {
			this.setAD_Process_ID(0);
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
							.setParameters(AD_Tab.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tab with UUID " + AD_Tab.getUUID());
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
	 * Set User defined Tab.
	 *
	 * @param AD_UserDef_Tab_ID User defined Tab
	 */

	public void setAD_UserDef_Tab_ID(int AD_UserDef_Tab_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Tab_ID(AD_UserDef_Tab_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_UserDef_Tab_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_UserDef_Tab_UU();
	}

	/**
	 * Set User defined Window.
	 *
	 * @param AD_UserDef_Win User defined Window
	 */
	@JsonProperty("AD_UserDef_Win")
	public void setAD_UserDef_WinInput(ForeignEntityInput AD_UserDef_Win) {
		this.mAD_UserDef_Win = AD_UserDef_Win;
		if (get_ID() != 0) {
			return;
		}
		if (AD_UserDef_Win != null) {
			// Since an entity was passed, make sure it's in the DB
			MUserDefWin foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_UserDef_Win", "AD_UserDef_Win_UU=?", get_TrxName())
							.setParameters(AD_UserDef_Win.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_UserDef_Win_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Win with UUID " + AD_UserDef_Win.getUUID());
			}
		} else {
			this.setAD_UserDef_Win_ID(0);
		}
	}

	/**
	 * Get User defined Window.
	 *
	 * @return User defined Window
	 */
	@JsonProperty("AD_UserDef_Win")
	public ForeignEntityInput AD_UserDef_Win() {
		return mAD_UserDef_Win;
	}

	/**
	 * Set Allow Advanced Lookup.
	 *
	 * @param IsAllowAdvancedLookup Allow Advanced Lookup
	 */
	@JsonProperty("IsAllowAdvancedLookup")
	public void setIsAllowAdvancedLookupInput(I_AD_Ref_ListInput IsAllowAdvancedLookup) {
		this.mIsAllowAdvancedLookup = IsAllowAdvancedLookup;
		if (IsAllowAdvancedLookup != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAllowAdvancedLookup.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsAllowAdvancedLookup(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsAllowAdvancedLookup.getUUID());
			}
		} else {
			this.setIsAllowAdvancedLookup(null);
		}
	}

	/**
	 * Get Allow Advanced Lookup.
	 *
	 * @return Allow Advanced Lookup
	 */
	@JsonProperty("IsAllowAdvancedLookup")
	public I_AD_Ref_ListInput IsAllowAdvancedLookup() {
		return mIsAllowAdvancedLookup;
	}

	/**
	 * Set Lookup Only Selection Columns.
	 *
	 * @param IsLookupOnlySelection When defined to true Lookup panel will display only selection columns. Default to false.
	 */
	@JsonProperty("IsLookupOnlySelection")
	public void setIsLookupOnlySelectionInput(I_AD_Ref_ListInput IsLookupOnlySelection) {
		this.mIsLookupOnlySelection = IsLookupOnlySelection;
		if (IsLookupOnlySelection != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsLookupOnlySelection.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsLookupOnlySelection(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsLookupOnlySelection.getUUID());
			}
		} else {
			this.setIsLookupOnlySelection(null);
		}
	}

	/**
	 * Get Lookup Only Selection Columns.
	 *
	 * @return When defined to true Lookup panel will display only selection columns. Default to false.
	 */
	@JsonProperty("IsLookupOnlySelection")
	public I_AD_Ref_ListInput IsLookupOnlySelection() {
		return mIsLookupOnlySelection;
	}

	/**
	 * Set Read Only.
	 *
	 * @param IsReadOnly Field is read only
	 */
	@JsonProperty("IsReadOnly")
	public void setIsReadOnlyInput(I_AD_Ref_ListInput IsReadOnly) {
		this.mIsReadOnly = IsReadOnly;
		if (IsReadOnly != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsReadOnly.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsReadOnly(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsReadOnly.getUUID());
			}
		} else {
			this.setIsReadOnly(null);
		}
	}

	/**
	 * Get Read Only.
	 *
	 * @return Field is read only
	 */
	@JsonProperty("IsReadOnly")
	public I_AD_Ref_ListInput IsReadOnly() {
		return mIsReadOnly;
	}

	/**
	 * Set Single Row Layout.
	 *
	 * @param IsSingleRow Default for toggle between Single- and Multi-Row (Grid) Layout
	 */
	@JsonProperty("IsSingleRow")
	public void setIsSingleRowInput(I_AD_Ref_ListInput IsSingleRow) {
		this.mIsSingleRow = IsSingleRow;
		if (IsSingleRow != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsSingleRow.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsSingleRow(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsSingleRow.getUUID());
			}
		} else {
			this.setIsSingleRow(null);
		}
	}

	/**
	 * Get Single Row Layout.
	 *
	 * @return Default for toggle between Single- and Multi-Row (Grid) Layout
	 */
	@JsonProperty("IsSingleRow")
	public I_AD_Ref_ListInput IsSingleRow() {
		return mIsSingleRow;
	}
}
