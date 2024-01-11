package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.MTab;
import org.compiere.model.MValRule;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FieldInput extends MField_BH implements I_AD_FieldInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_FieldGroup;
	private ForeignEntityInput mAD_FieldStyle;
	private ForeignEntityInput mAD_LabelStyle;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mAD_Val_Rule_Lookup;
	private ForeignEntityInput mIncluded_Tab;
	private I_AD_Ref_ListInput mIsAllowCopy;
	private I_AD_Ref_ListInput mIsAlwaysUpdateable;
	private I_AD_Ref_ListInput mIsMandatory;
	private I_AD_Ref_ListInput mIsSelectionColumn;
	private I_AD_Ref_ListInput mIsToolbarButton;
	private I_AD_Ref_ListInput mIsUpdateable;
	private I_AD_Ref_ListInput mObscureType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_FieldInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MField_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Field.
	 *
	 * @param AD_Field_ID Field on a database table
	 */

	public void setAD_Field_ID(int AD_Field_ID) {
		if (get_ID() == 0) {
			super.setAD_Field_ID(AD_Field_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Field_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Field_UU();
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
	 * Set Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public void setAD_TabInput(ForeignEntityInput AD_Tab) {
		this.mAD_Tab = AD_Tab;
		MTab foreignEntity;
		if (get_ID() == 0 && AD_Tab != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
						.setParameters(AD_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tab_ID(foreignEntity.get_ID());
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
	 * Set Allow Copy.
	 *
	 * @param IsAllowCopy Determine if a column must be copied when pushing the button to copy record
	 */
	@JsonProperty("IsAllowCopy")
	public void setIsAllowCopyInput(I_AD_Ref_ListInput IsAllowCopy) {
		this.mIsAllowCopy = IsAllowCopy;
		MRefList_BH foreignEntity;
		if (IsAllowCopy != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsAllowCopy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsAllowCopy(foreignEntity.getValue());
		} else {
			this.setIsAllowCopy(null);
		}
	}

	/**
	 * Get Allow Copy.
	 *
	 * @return Determine if a column must be copied when pushing the button to copy record
	 */
	@JsonProperty("IsAllowCopy")
	public I_AD_Ref_ListInput IsAllowCopy() {
		return mIsAllowCopy;
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
	 * Set Selection Column.
	 *
	 * @param IsSelectionColumn Is this column used for finding rows in windows
	 */
	@JsonProperty("IsSelectionColumn")
	public void setIsSelectionColumnInput(I_AD_Ref_ListInput IsSelectionColumn) {
		this.mIsSelectionColumn = IsSelectionColumn;
		MRefList_BH foreignEntity;
		if (IsSelectionColumn != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsSelectionColumn.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsSelectionColumn(foreignEntity.getValue());
		} else {
			this.setIsSelectionColumn(null);
		}
	}

	/**
	 * Get Selection Column.
	 *
	 * @return Is this column used for finding rows in windows
	 */
	@JsonProperty("IsSelectionColumn")
	public I_AD_Ref_ListInput IsSelectionColumn() {
		return mIsSelectionColumn;
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
	 * Set Obscure.
	 *
	 * @param ObscureType Type of obscuring the data (limiting the display)
	 */
	@JsonProperty("ObscureType")
	public void setObscureTypeInput(I_AD_Ref_ListInput ObscureType) {
		this.mObscureType = ObscureType;
		MRefList_BH foreignEntity;
		if (ObscureType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ObscureType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setObscureType(foreignEntity.getValue());
		} else {
			this.setObscureType(null);
		}
	}

	/**
	 * Get Obscure.
	 *
	 * @return Type of obscuring the data (limiting the display)
	 */
	@JsonProperty("ObscureType")
	public I_AD_Ref_ListInput ObscureType() {
		return mObscureType;
	}
}
