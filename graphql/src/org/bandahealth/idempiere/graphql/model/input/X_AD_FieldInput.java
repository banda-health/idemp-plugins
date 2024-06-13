package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_FieldResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MColumn;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.MTab;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_FieldInput extends MField_BH implements I_AD_FieldInput {

	private ForeignEntityInput mAD_Chart;
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
	private ForeignEntityInput mIsAllowCopy;
	private ForeignEntityInput mIsAlwaysUpdateable;
	private ForeignEntityInput mIsMandatory;
	private ForeignEntityInput mIsSelectionColumn;
	private ForeignEntityInput mIsToolbarButton;
	private ForeignEntityInput mIsUpdateable;
	private ForeignEntityInput mObscureType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Field_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_FieldInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Chart.
	 *
	 * @param AD_Chart Chart
	 */
	@JsonProperty("AD_Chart")
	public void setAD_ChartInput(ForeignEntityInput AD_Chart) {
		this.mAD_Chart = AD_Chart;
		if (AD_Chart != null) {
			// Since an entity was passed, make sure it's in the DB
			MChart foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Chart", "AD_Chart_UU=?", get_TrxName())
							.setParameters(AD_Chart.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Chart_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Chart with UU " + AD_Chart.getUU());
			}
		} else {
			this.setAD_Chart_ID(0);
		}
	}

	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	@JsonProperty("AD_Chart")
	public ForeignEntityInput AD_Chart() {
		return mAD_Chart;
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + AD_Column.getUU());
			}
		} else {
			this.setAD_Column_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Field_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (AD_FieldGroup != null) {
			// Since an entity was passed, make sure it's in the DB
			MFieldGroup_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_FieldGroup", "AD_FieldGroup_UU=?", get_TrxName())
							.setParameters(AD_FieldGroup.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_FieldGroup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_FieldGroup with UU " + AD_FieldGroup.getUU());
			}
		} else {
			this.setAD_FieldGroup_ID(0);
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
		if (AD_FieldStyle != null) {
			// Since an entity was passed, make sure it's in the DB
			MStyle foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
							.setParameters(AD_FieldStyle.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_FieldStyle_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Style with UU " + AD_FieldStyle.getUU());
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
							.setParameters(AD_LabelStyle.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_LabelStyle_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Style with UU " + AD_LabelStyle.getUU());
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
							.setParameters(AD_Reference.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UU " + AD_Reference.getUU());
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
							.setParameters(AD_Reference_Value.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Reference_Value_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UU " + AD_Reference_Value.getUU());
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
							.setParameters(AD_Val_Rule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Val_Rule_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Val_Rule with UU " + AD_Val_Rule.getUU());
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
	 * Set Dynamic Validation (Lookup).
	 *
	 * @param AD_Val_Rule_Lookup Override Dynamic Validation Rule for Lookup Window
	 */
	@JsonProperty("AD_Val_Rule_Lookup")
	public void setAD_Val_Rule_LookupInput(ForeignEntityInput AD_Val_Rule_Lookup) {
		this.mAD_Val_Rule_Lookup = AD_Val_Rule_Lookup;
		if (AD_Val_Rule_Lookup != null) {
			// Since an entity was passed, make sure it's in the DB
			MValRule foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Val_Rule", "AD_Val_Rule_UU=?", get_TrxName())
							.setParameters(AD_Val_Rule_Lookup.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Val_Rule_Lookup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Val_Rule with UU " + AD_Val_Rule_Lookup.getUU());
			}
		} else {
			this.setAD_Val_Rule_Lookup_ID(0);
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
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UU " + AD_EntityType.getUU());
			}
		} else {
			this.setEntityType(null);
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
		if (Included_Tab != null) {
			// Since an entity was passed, make sure it's in the DB
			MTab foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
							.setParameters(Included_Tab.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIncluded_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tab with UU " + Included_Tab.getUU());
			}
		} else {
			this.setIncluded_Tab_ID(0);
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
	public void setIsAllowCopyInput(ForeignEntityInput IsAllowCopy) {
		this.mIsAllowCopy = IsAllowCopy;
		if (IsAllowCopy != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldResolver.ISALLOWCOPY_UUIDS_BY_VALUE.containsValue(IsAllowCopy.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsAllowCopy.getUU() +
						" is not in the list defined for the IsAllowCopy column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAllowCopy.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsAllowCopy(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsAllowCopy.getUU());
			}
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
	public ForeignEntityInput IsAllowCopy() {
		return mIsAllowCopy;
	}

	/**
	 * Set Always Updatable.
	 *
	 * @param IsAlwaysUpdateable The column is always updateable, even if the record is not active or processed
	 */
	@JsonProperty("IsAlwaysUpdateable")
	public void setIsAlwaysUpdateableInput(ForeignEntityInput IsAlwaysUpdateable) {
		this.mIsAlwaysUpdateable = IsAlwaysUpdateable;
		if (IsAlwaysUpdateable != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldResolver.ISALWAYSUPDATEABLE_UUIDS_BY_VALUE.containsValue(IsAlwaysUpdateable.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsAlwaysUpdateable.getUU() +
						" is not in the list defined for the IsAlwaysUpdateable column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAlwaysUpdateable.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsAlwaysUpdateable(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsAlwaysUpdateable.getUU());
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
	public ForeignEntityInput IsAlwaysUpdateable() {
		return mIsAlwaysUpdateable;
	}

	/**
	 * Set Mandatory.
	 *
	 * @param IsMandatory Data entry is required in this column
	 */
	@JsonProperty("IsMandatory")
	public void setIsMandatoryInput(ForeignEntityInput IsMandatory) {
		this.mIsMandatory = IsMandatory;
		if (IsMandatory != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldResolver.ISMANDATORY_UUIDS_BY_VALUE.containsValue(IsMandatory.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsMandatory.getUU() +
						" is not in the list defined for the IsMandatory column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsMandatory.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsMandatory(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsMandatory.getUU());
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
	public ForeignEntityInput IsMandatory() {
		return mIsMandatory;
	}

	/**
	 * Set Selection Column.
	 *
	 * @param IsSelectionColumn Is this column used for finding rows in windows
	 */
	@JsonProperty("IsSelectionColumn")
	public void setIsSelectionColumnInput(ForeignEntityInput IsSelectionColumn) {
		this.mIsSelectionColumn = IsSelectionColumn;
		if (IsSelectionColumn != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldResolver.ISSELECTIONCOLUMN_UUIDS_BY_VALUE.containsValue(IsSelectionColumn.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsSelectionColumn.getUU() +
						" is not in the list defined for the IsSelectionColumn column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsSelectionColumn.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsSelectionColumn(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsSelectionColumn.getUU());
			}
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
	public ForeignEntityInput IsSelectionColumn() {
		return mIsSelectionColumn;
	}

	/**
	 * Set Toolbar Button.
	 *
	 * @param IsToolbarButton Show the button on the toolbar, the window, or both
	 */
	@JsonProperty("IsToolbarButton")
	public void setIsToolbarButtonInput(ForeignEntityInput IsToolbarButton) {
		this.mIsToolbarButton = IsToolbarButton;
		if (IsToolbarButton != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldResolver.ISTOOLBARBUTTON_UUIDS_BY_VALUE.containsValue(IsToolbarButton.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsToolbarButton.getUU() +
						" is not in the list defined for the IsToolbarButton column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsToolbarButton.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsToolbarButton(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsToolbarButton.getUU());
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
	public ForeignEntityInput IsToolbarButton() {
		return mIsToolbarButton;
	}

	/**
	 * Set Updatable.
	 *
	 * @param IsUpdateable Determines, if the field can be updated
	 */
	@JsonProperty("IsUpdateable")
	public void setIsUpdateableInput(ForeignEntityInput IsUpdateable) {
		this.mIsUpdateable = IsUpdateable;
		if (IsUpdateable != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldResolver.ISUPDATEABLE_UUIDS_BY_VALUE.containsValue(IsUpdateable.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsUpdateable.getUU() +
						" is not in the list defined for the IsUpdateable column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsUpdateable.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsUpdateable(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsUpdateable.getUU());
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
	public ForeignEntityInput IsUpdateable() {
		return mIsUpdateable;
	}

	/**
	 * Set Obscure.
	 *
	 * @param ObscureType Type of obscuring the data (limiting the display)
	 */
	@JsonProperty("ObscureType")
	public void setObscureTypeInput(ForeignEntityInput ObscureType) {
		this.mObscureType = ObscureType;
		if (ObscureType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_FieldResolver.OBSCURETYPE_UUIDS_BY_VALUE.containsValue(ObscureType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ObscureType.getUU() +
						" is not in the list defined for the ObscureType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ObscureType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setObscureType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ObscureType.getUU());
			}
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
	public ForeignEntityInput ObscureType() {
		return mObscureType;
	}
}
