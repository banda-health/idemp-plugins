package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_UserDef_TabResolver;
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
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_TabInput extends MUserDefTab implements I_AD_UserDef_TabInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_UserDef_Win;
	private ForeignEntityInput mIsAllowAdvancedLookup;
	private ForeignEntityInput mIsHighVolume;
	private ForeignEntityInput mIsLookupOnlySelection;
	private ForeignEntityInput mIsReadOnly;
	private ForeignEntityInput mIsSingleRow;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_UserDef_Tab_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_TabInput(@JsonProperty("UU") String UU) {
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
							.setParameters(AD_Process.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UU " + AD_Process.getUU());
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Tab != null) {
			// Since an entity was passed, make sure it's in the DB
			MTab foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
							.setParameters(AD_Tab.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_UserDef_Tab_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
							.setParameters(AD_UserDef_Win.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_UserDef_Win_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Win with UU " + AD_UserDef_Win.getUU());
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
	public void setIsAllowAdvancedLookupInput(ForeignEntityInput IsAllowAdvancedLookup) {
		this.mIsAllowAdvancedLookup = IsAllowAdvancedLookup;
		if (IsAllowAdvancedLookup != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserDef_TabResolver.ISALLOWADVANCEDLOOKUP_UUIDS_BY_VALUE.containsValue(IsAllowAdvancedLookup.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsAllowAdvancedLookup.getUU() +
						" is not in the list defined for the IsAllowAdvancedLookup column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAllowAdvancedLookup.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsAllowAdvancedLookup(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsAllowAdvancedLookup.getUU());
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
	public ForeignEntityInput IsAllowAdvancedLookup() {
		return mIsAllowAdvancedLookup;
	}

	/**
	 * Set High Volume.
	 *
	 * @param IsHighVolume Use Search instead of Pick list
	 */
	@JsonProperty("IsHighVolume")
	public void setIsHighVolumeInput(ForeignEntityInput IsHighVolume) {
		this.mIsHighVolume = IsHighVolume;
		if (IsHighVolume != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserDef_TabResolver.ISHIGHVOLUME_UUIDS_BY_VALUE.containsValue(IsHighVolume.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsHighVolume.getUU() +
						" is not in the list defined for the IsHighVolume column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsHighVolume.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsHighVolume(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsHighVolume.getUU());
			}
		} else {
			this.setIsHighVolume(null);
		}
	}

	/**
	 * Get High Volume.
	 *
	 * @return Use Search instead of Pick list
	 */
	@JsonProperty("IsHighVolume")
	public ForeignEntityInput IsHighVolume() {
		return mIsHighVolume;
	}

	/**
	 * Set Lookup Only Selection Columns.
	 *
	 * @param IsLookupOnlySelection When defined to true Lookup panel will display only selection columns. Default to false.
	 */
	@JsonProperty("IsLookupOnlySelection")
	public void setIsLookupOnlySelectionInput(ForeignEntityInput IsLookupOnlySelection) {
		this.mIsLookupOnlySelection = IsLookupOnlySelection;
		if (IsLookupOnlySelection != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserDef_TabResolver.ISLOOKUPONLYSELECTION_UUIDS_BY_VALUE.containsValue(IsLookupOnlySelection.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsLookupOnlySelection.getUU() +
						" is not in the list defined for the IsLookupOnlySelection column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsLookupOnlySelection.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsLookupOnlySelection(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsLookupOnlySelection.getUU());
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
	public ForeignEntityInput IsLookupOnlySelection() {
		return mIsLookupOnlySelection;
	}

	/**
	 * Set Read Only.
	 *
	 * @param IsReadOnly Field is read only
	 */
	@JsonProperty("IsReadOnly")
	public void setIsReadOnlyInput(ForeignEntityInput IsReadOnly) {
		this.mIsReadOnly = IsReadOnly;
		if (IsReadOnly != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserDef_TabResolver.ISREADONLY_UUIDS_BY_VALUE.containsValue(IsReadOnly.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsReadOnly.getUU() +
						" is not in the list defined for the IsReadOnly column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsReadOnly.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsReadOnly(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsReadOnly.getUU());
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
	public ForeignEntityInput IsReadOnly() {
		return mIsReadOnly;
	}

	/**
	 * Set Single Row Layout.
	 *
	 * @param IsSingleRow Default for toggle between Single- and Multi-Row (Grid) Layout
	 */
	@JsonProperty("IsSingleRow")
	public void setIsSingleRowInput(ForeignEntityInput IsSingleRow) {
		this.mIsSingleRow = IsSingleRow;
		if (IsSingleRow != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserDef_TabResolver.ISSINGLEROW_UUIDS_BY_VALUE.containsValue(IsSingleRow.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsSingleRow.getUU() +
						" is not in the list defined for the IsSingleRow column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsSingleRow.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsSingleRow(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsSingleRow.getUU());
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
	public ForeignEntityInput IsSingleRow() {
		return mIsSingleRow;
	}
}
