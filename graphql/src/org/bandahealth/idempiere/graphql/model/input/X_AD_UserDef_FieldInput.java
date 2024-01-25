package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUserDefTab_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.MUserDefField;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserDef_FieldInput extends MUserDefField implements I_AD_UserDef_FieldInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_FieldStyle;
	private ForeignEntityInput mAD_LabelStyle;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_UserDef_Tab;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mPA_DashboardContent;
	private I_AD_Ref_ListInput mIsAlwaysUpdateable;
	private I_AD_Ref_ListInput mIsAutocomplete;
	private I_AD_Ref_ListInput mIsDisplayed;
	private I_AD_Ref_ListInput mIsMandatory;
	private I_AD_Ref_ListInput mIsReadOnly;
	private I_AD_Ref_ListInput mIsSameLine;
	private I_AD_Ref_ListInput mIsToolbarButton;
	private I_AD_Ref_ListInput mIsUpdateable;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserDef_Field_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_FieldInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MUserDefField(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		if (AD_Field != null) {
			// Since an entity was passed, make sure it's in the DB
			MField_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
							.setParameters(AD_Field.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Field_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Field with UUID " + AD_Field.getUUID());
			}
		} else {
			this.setAD_Field_ID(0);
		}
	}

	/**
	 * Get Field.
	 *
	 * @return Field on a database table
	 */
	@JsonProperty("AD_Field")
	public ForeignEntityInput AD_Field() {
		return mAD_Field;
	}

	/**
	 * Set Field Style.
	 *
	 * @param AD_FieldStyle Field CSS Style 
	 */
	@JsonProperty("AD_FieldStyle")
	public void setAD_FieldStyleInput(ForeignEntityInput AD_FieldStyle) {
		this.mAD_FieldStyle = AD_FieldStyle;
		if (AD_FieldStyle != null) {
			// Since an entity was passed, make sure it's in the DB
			MStyle foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
							.setParameters(AD_FieldStyle.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_FieldStyle_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Style with UUID " + AD_FieldStyle.getUUID());
			}
		} else {
			this.setAD_FieldStyle_ID(0);
		}
	}

	/**
	 * Get Field Style.
	 *
	 * @return Field CSS Style 
	 */
	@JsonProperty("AD_FieldStyle")
	public ForeignEntityInput AD_FieldStyle() {
		return mAD_FieldStyle;
	}

	/**
	 * Set Label Style.
	 *
	 * @param AD_LabelStyle Label CSS Style
	 */
	@JsonProperty("AD_LabelStyle")
	public void setAD_LabelStyleInput(ForeignEntityInput AD_LabelStyle) {
		this.mAD_LabelStyle = AD_LabelStyle;
		if (AD_LabelStyle != null) {
			// Since an entity was passed, make sure it's in the DB
			MStyle foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
							.setParameters(AD_LabelStyle.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_LabelStyle_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Style with UUID " + AD_LabelStyle.getUUID());
			}
		} else {
			this.setAD_LabelStyle_ID(0);
		}
	}

	/**
	 * Get Label Style.
	 *
	 * @return Label CSS Style
	 */
	@JsonProperty("AD_LabelStyle")
	public ForeignEntityInput AD_LabelStyle() {
		return mAD_LabelStyle;
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		if (AD_Reference != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference.getUUID());
			}
		} else {
			this.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public ForeignEntityInput AD_Reference() {
		return mAD_Reference;
	}

	/**
	 * Set Reference Key.
	 *
	 * @param AD_Reference_Value Required to specify, if data type is Table or List
	 */
	@JsonProperty("AD_Reference_Value")
	public void setAD_Reference_ValueInput(ForeignEntityInput AD_Reference_Value) {
		this.mAD_Reference_Value = AD_Reference_Value;
		if (AD_Reference_Value != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference_Value.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_Value_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference_Value.getUUID());
			}
		} else {
			this.setAD_Reference_Value_ID(0);
		}
	}

	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	@JsonProperty("AD_Reference_Value")
	public ForeignEntityInput AD_Reference_Value() {
		return mAD_Reference_Value;
	}
	/**
	 * Set User defined Field.
	 *
	 * @param AD_UserDef_Field_ID User defined Field
	 */

	public void setAD_UserDef_Field_ID(int AD_UserDef_Field_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Field_ID(AD_UserDef_Field_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_UserDef_Field_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_UserDef_Field_UU();
	}

	/**
	 * Set User defined Tab.
	 *
	 * @param AD_UserDef_Tab User defined Tab
	 */
	@JsonProperty("AD_UserDef_Tab")
	public void setAD_UserDef_TabInput(ForeignEntityInput AD_UserDef_Tab) {
		this.mAD_UserDef_Tab = AD_UserDef_Tab;
		if (get_ID() != 0) {
			return;
		}
		if (AD_UserDef_Tab != null) {
			// Since an entity was passed, make sure it's in the DB
			MUserDefTab_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_UserDef_Tab", "AD_UserDef_Tab_UU=?", get_TrxName())
							.setParameters(AD_UserDef_Tab.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_UserDef_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Tab with UUID " + AD_UserDef_Tab.getUUID());
			}
		} else {
			this.setAD_UserDef_Tab_ID(0);
		}
	}

	/**
	 * Get User defined Tab.
	 *
	 * @return User defined Tab
	 */
	@JsonProperty("AD_UserDef_Tab")
	public ForeignEntityInput AD_UserDef_Tab() {
		return mAD_UserDef_Tab;
	}

	/**
	 * Set Dynamic Validation.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public void setAD_Val_RuleInput(ForeignEntityInput AD_Val_Rule) {
		this.mAD_Val_Rule = AD_Val_Rule;
		if (AD_Val_Rule != null) {
			// Since an entity was passed, make sure it's in the DB
			MValRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
							.setParameters(AD_Val_Rule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Val_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Val_Rule with UUID " + AD_Val_Rule.getUUID());
			}
		} else {
			this.setAD_Val_Rule_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	@JsonProperty("AD_Val_Rule")
	public ForeignEntityInput AD_Val_Rule() {
		return mAD_Val_Rule;
	}

	/**
	 * Set Always Updatable.
	 *
	 * @param IsAlwaysUpdateable The column is always updateable, even if the record is not active or processed
	 */
	@JsonProperty("IsAlwaysUpdateable")
	public void setIsAlwaysUpdateableInput(I_AD_Ref_ListInput IsAlwaysUpdateable) {
		this.mIsAlwaysUpdateable = IsAlwaysUpdateable;
		if (IsAlwaysUpdateable != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAlwaysUpdateable.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsAlwaysUpdateable(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsAlwaysUpdateable.getUUID());
			}
		} else {
			this.setIsAlwaysUpdateable(null);
		}
	}

	/**
	 * Get Always Updatable.
	 *
	 * @return The column is always updateable, even if the record is not active or processed
	 */
	@JsonProperty("IsAlwaysUpdateable")
	public I_AD_Ref_ListInput IsAlwaysUpdateable() {
		return mIsAlwaysUpdateable;
	}

	/**
	 * Set Autocomplete.
	 *
	 * @param IsAutocomplete Automatic completion for textfields
	 */
	@JsonProperty("IsAutocomplete")
	public void setIsAutocompleteInput(I_AD_Ref_ListInput IsAutocomplete) {
		this.mIsAutocomplete = IsAutocomplete;
		if (IsAutocomplete != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAutocomplete.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsAutocomplete(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsAutocomplete.getUUID());
			}
		} else {
			this.setIsAutocomplete(null);
		}
	}

	/**
	 * Get Autocomplete.
	 *
	 * @return Automatic completion for textfields
	 */
	@JsonProperty("IsAutocomplete")
	public I_AD_Ref_ListInput IsAutocomplete() {
		return mIsAutocomplete;
	}

	/**
	 * Set Displayed.
	 *
	 * @param IsDisplayed Determines, if this field is displayed
	 */
	@JsonProperty("IsDisplayed")
	public void setIsDisplayedInput(I_AD_Ref_ListInput IsDisplayed) {
		this.mIsDisplayed = IsDisplayed;
		if (IsDisplayed != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsDisplayed.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsDisplayed(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsDisplayed.getUUID());
			}
		} else {
			this.setIsDisplayed(null);
		}
	}

	/**
	 * Get Displayed.
	 *
	 * @return Determines, if this field is displayed
	 */
	@JsonProperty("IsDisplayed")
	public I_AD_Ref_ListInput IsDisplayed() {
		return mIsDisplayed;
	}

	/**
	 * Set Mandatory.
	 *
	 * @param IsMandatory Data entry is required in this column
	 */
	@JsonProperty("IsMandatory")
	public void setIsMandatoryInput(I_AD_Ref_ListInput IsMandatory) {
		this.mIsMandatory = IsMandatory;
		if (IsMandatory != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsMandatory.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsMandatory(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsMandatory.getUUID());
			}
		} else {
			this.setIsMandatory(null);
		}
	}

	/**
	 * Get Mandatory.
	 *
	 * @return Data entry is required in this column
	 */
	@JsonProperty("IsMandatory")
	public I_AD_Ref_ListInput IsMandatory() {
		return mIsMandatory;
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
	 * Set Same Line.
	 *
	 * @param IsSameLine Displayed on same line as previous field
	 */
	@JsonProperty("IsSameLine")
	public void setIsSameLineInput(I_AD_Ref_ListInput IsSameLine) {
		this.mIsSameLine = IsSameLine;
		if (IsSameLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsSameLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsSameLine(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsSameLine.getUUID());
			}
		} else {
			this.setIsSameLine(null);
		}
	}

	/**
	 * Get Same Line.
	 *
	 * @return Displayed on same line as previous field
	 */
	@JsonProperty("IsSameLine")
	public I_AD_Ref_ListInput IsSameLine() {
		return mIsSameLine;
	}

	/**
	 * Set Toolbar Button.
	 *
	 * @param IsToolbarButton Show the button on the toolbar, the window, or both
	 */
	@JsonProperty("IsToolbarButton")
	public void setIsToolbarButtonInput(I_AD_Ref_ListInput IsToolbarButton) {
		this.mIsToolbarButton = IsToolbarButton;
		if (IsToolbarButton != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsToolbarButton.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsToolbarButton(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsToolbarButton.getUUID());
			}
		} else {
			this.setIsToolbarButton(null);
		}
	}

	/**
	 * Get Toolbar Button.
	 *
	 * @return Show the button on the toolbar, the window, or both
	 */
	@JsonProperty("IsToolbarButton")
	public I_AD_Ref_ListInput IsToolbarButton() {
		return mIsToolbarButton;
	}

	/**
	 * Set Updatable.
	 *
	 * @param IsUpdateable Determines, if the field can be updated
	 */
	@JsonProperty("IsUpdateable")
	public void setIsUpdateableInput(I_AD_Ref_ListInput IsUpdateable) {
		this.mIsUpdateable = IsUpdateable;
		if (IsUpdateable != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsUpdateable.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsUpdateable(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsUpdateable.getUUID());
			}
		} else {
			this.setIsUpdateable(null);
		}
	}

	/**
	 * Get Updatable.
	 *
	 * @return Determines, if the field can be updated
	 */
	@JsonProperty("IsUpdateable")
	public I_AD_Ref_ListInput IsUpdateable() {
		return mIsUpdateable;
	}

	/**
	 * Set Dashboard Content.
	 *
	 * @param PA_DashboardContent Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public void setPA_DashboardContentInput(ForeignEntityInput PA_DashboardContent) {
		this.mPA_DashboardContent = PA_DashboardContent;
		if (PA_DashboardContent != null) {
			// Since an entity was passed, make sure it's in the DB
			MDashboardContent foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_DashboardContent", "PA_DashboardContent_UU=?", get_TrxName())
							.setParameters(PA_DashboardContent.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_DashboardContent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_DashboardContent with UUID " + PA_DashboardContent.getUUID());
			}
		} else {
			this.setPA_DashboardContent_ID(0);
		}
	}

	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	@JsonProperty("PA_DashboardContent")
	public ForeignEntityInput PA_DashboardContent() {
		return mPA_DashboardContent;
	}
}
