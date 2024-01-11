package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.MUserDefField;
import org.compiere.model.MUserDefTab;
import org.compiere.model.MValRule;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_FieldInput extends MUserDefField implements I_AD_UserDef_FieldInput {

	private ForeignEntityInput mAD_Field;
	private ForeignEntityInput mAD_FieldGroup;
	private ForeignEntityInput mAD_FieldStyle;
	private ForeignEntityInput mAD_LabelStyle;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_UserDef_Tab;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mAD_Val_Rule_Lookup;
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
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserDef_FieldInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUserDefField(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	@JsonProperty("AD_Field")
	public void setAD_FieldInput(ForeignEntityInput AD_Field) {
		this.mAD_Field = AD_Field;
		MField_BH foreignEntity;
		if (AD_Field != null &&
				(foreignEntity = new Query(getCtx(), "AD_Field", "AD_Field_UU=?", get_TrxName())
						.setParameters(AD_Field.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Field_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Field_ID(0);
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
	 * Set Field Group.
	 *
	 * @param AD_FieldGroup Logical grouping of fields
	 */
	@JsonProperty("AD_FieldGroup")
	public void setAD_FieldGroupInput(ForeignEntityInput AD_FieldGroup) {
		this.mAD_FieldGroup = AD_FieldGroup;
		MFieldGroup_BH foreignEntity;
		if (AD_FieldGroup != null &&
				(foreignEntity = new Query(getCtx(), "AD_FieldGroup", "AD_FieldGroup_UU=?", get_TrxName())
						.setParameters(AD_FieldGroup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_FieldGroup_ID(foreignEntity.get_ID());
		} else {
			super.setAD_FieldGroup_ID(0);
		}
	}

	/**
	 * Get Field Group.
	 *
	 * @return Logical grouping of fields
	 */
	@JsonProperty("AD_FieldGroup")
	public ForeignEntityInput AD_FieldGroup() {
		return mAD_FieldGroup;
	}

	/**
	 * Set Field Style.
	 *
	 * @param AD_FieldStyle Field CSS Style 
	 */
	@JsonProperty("AD_FieldStyle")
	public void setAD_FieldStyleInput(ForeignEntityInput AD_FieldStyle) {
		this.mAD_FieldStyle = AD_FieldStyle;
		MStyle foreignEntity;
		if (AD_FieldStyle != null &&
				(foreignEntity = new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
						.setParameters(AD_FieldStyle.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_FieldStyle_ID(foreignEntity.get_ID());
		} else {
			super.setAD_FieldStyle_ID(0);
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
		MStyle foreignEntity;
		if (AD_LabelStyle != null &&
				(foreignEntity = new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
						.setParameters(AD_LabelStyle.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_LabelStyle_ID(foreignEntity.get_ID());
		} else {
			super.setAD_LabelStyle_ID(0);
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		MReference_BH foreignEntity;
		if (AD_Reference != null &&
				(foreignEntity = new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
						.setParameters(AD_Reference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Reference_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Reference_ID(0);
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
		MReference_BH foreignEntity;
		if (AD_Reference_Value != null &&
				(foreignEntity = new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
						.setParameters(AD_Reference_Value.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Reference_Value_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Reference_Value_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_UserDef_Field_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MUserDefTab foreignEntity;
		if (get_ID() == 0 && AD_UserDef_Tab != null &&
				(foreignEntity = new Query(getCtx(), "AD_UserDef_Tab", "AD_UserDef_Tab_UU=?", get_TrxName())
						.setParameters(AD_UserDef_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_UserDef_Tab_ID(foreignEntity.get_ID());
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
		MValRule foreignEntity;
		if (AD_Val_Rule != null &&
				(foreignEntity = new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
						.setParameters(AD_Val_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Val_Rule_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Val_Rule_ID(0);
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
	 * Set Dynamic Validation (Lookup).
	 *
	 * @param AD_Val_Rule_Lookup Override Dynamic Validation Rule for Lookup Window
	 */
	@JsonProperty("AD_Val_Rule_Lookup")
	public void setAD_Val_Rule_LookupInput(ForeignEntityInput AD_Val_Rule_Lookup) {
		this.mAD_Val_Rule_Lookup = AD_Val_Rule_Lookup;
		MValRule foreignEntity;
		if (AD_Val_Rule_Lookup != null &&
				(foreignEntity = new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
						.setParameters(AD_Val_Rule_Lookup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Val_Rule_Lookup_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Val_Rule_Lookup_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation (Lookup).
	 *
	 * @return Override Dynamic Validation Rule for Lookup Window
	 */
	@JsonProperty("AD_Val_Rule_Lookup")
	public ForeignEntityInput AD_Val_Rule_Lookup() {
		return mAD_Val_Rule_Lookup;
	}

	/**
	 * Set Always Updatable.
	 *
	 * @param IsAlwaysUpdateable The column is always updateable, even if the record is not active or processed
	 */
	@JsonProperty("IsAlwaysUpdateable")
	public void setIsAlwaysUpdateableInput(I_AD_Ref_ListInput IsAlwaysUpdateable) {
		this.mIsAlwaysUpdateable = IsAlwaysUpdateable;
		MRefList_BH foreignEntity;
		if (IsAlwaysUpdateable != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsAlwaysUpdateable.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsAlwaysUpdateable(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (IsAutocomplete != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsAutocomplete.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsAutocomplete(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (IsDisplayed != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsDisplayed.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsDisplayed(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (IsMandatory != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsMandatory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsMandatory(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (IsReadOnly != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsReadOnly.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsReadOnly(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (IsSameLine != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsSameLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsSameLine(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (IsToolbarButton != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsToolbarButton.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsToolbarButton(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (IsUpdateable != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsUpdateable.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsUpdateable(foreignEntity.getValue());
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
		MDashboardContent foreignEntity;
		if (PA_DashboardContent != null &&
				(foreignEntity = new Query(getCtx(), "PA_DashboardContent", "PA_DashboardContent_UU=?", get_TrxName())
						.setParameters(PA_DashboardContent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_DashboardContent_ID(foreignEntity.get_ID());
		} else {
			super.setPA_DashboardContent_ID(0);
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
