package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.MUserDefField;
import org.compiere.model.MUserDefTab;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_FieldInput extends MUserDefField implements I_AD_UserDef_FieldInput {

	private ForeignEntityInput mAD_Chart;
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
	private ForeignEntityInput mIsAlwaysUpdateable;
	private ForeignEntityInput mIsAutocomplete;
	private ForeignEntityInput mIsDisplayed;
	private ForeignEntityInput mIsDisplayedGrid;
	private ForeignEntityInput mIsMandatory;
	private ForeignEntityInput mIsReadOnly;
	private ForeignEntityInput mIsSameLine;
	private ForeignEntityInput mIsToolbarButton;
	private ForeignEntityInput mIsUpdateable;
	private ForeignEntityInput mPA_DashboardContent;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_UserDef_Field_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_FieldInput(@JsonProperty("UU") String UU) {
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
							.setParameters(AD_Field.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Field_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Field with UU " + AD_Field.getUU());
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_UserDef_Field_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
			MUserDefTab foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_UserDef_Tab", "AD_UserDef_Tab_UU=?", get_TrxName())
							.setParameters(AD_UserDef_Tab.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_UserDef_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Tab with UU " + AD_UserDef_Tab.getUU());
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
	 * Set Always Updatable.
	 *
	 * @param IsAlwaysUpdateable The column is always updateable, even if the record is not active or processed
	 */
	@JsonProperty("IsAlwaysUpdateable")
	public void setIsAlwaysUpdateableInput(ForeignEntityInput IsAlwaysUpdateable) {
		this.mIsAlwaysUpdateable = IsAlwaysUpdateable;
		if (IsAlwaysUpdateable != null) {
			// Since an entity was passed, make sure it's in the DB
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
	 * Set Auto complete.
	 *
	 * @param IsAutocomplete Automatic completion for text fields
	 */
	@JsonProperty("IsAutocomplete")
	public void setIsAutocompleteInput(ForeignEntityInput IsAutocomplete) {
		this.mIsAutocomplete = IsAutocomplete;
		if (IsAutocomplete != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsAutocomplete.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsAutocomplete(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsAutocomplete.getUU());
			}
		} else {
			this.setIsAutocomplete(null);
		}
	}

	/**
	 * Get Auto complete.
	 *
	 * @return Automatic completion for text fields
	 */
	@JsonProperty("IsAutocomplete")
	public ForeignEntityInput IsAutocomplete() {
		return mIsAutocomplete;
	}

	/**
	 * Set Displayed.
	 *
	 * @param IsDisplayed Determines, if this field is displayed
	 */
	@JsonProperty("IsDisplayed")
	public void setIsDisplayedInput(ForeignEntityInput IsDisplayed) {
		this.mIsDisplayed = IsDisplayed;
		if (IsDisplayed != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsDisplayed.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsDisplayed(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsDisplayed.getUU());
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
	public ForeignEntityInput IsDisplayed() {
		return mIsDisplayed;
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
			// Since an entity was passed, make sure it's in the DB
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

	/**
	 * Set Mandatory.
	 *
	 * @param IsMandatory Data entry is required in this column
	 */
	@JsonProperty("IsMandatory")
	public void setIsMandatoryInput(ForeignEntityInput IsMandatory) {
		this.mIsMandatory = IsMandatory;
		if (IsMandatory != null) {
			// Since an entity was passed, make sure it's in the DB
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
	 * Set Read Only.
	 *
	 * @param IsReadOnly Field is read only
	 */
	@JsonProperty("IsReadOnly")
	public void setIsReadOnlyInput(ForeignEntityInput IsReadOnly) {
		this.mIsReadOnly = IsReadOnly;
		if (IsReadOnly != null) {
			// Since an entity was passed, make sure it's in the DB
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
	 * Set Same Line.
	 *
	 * @param IsSameLine Displayed on same line as previous field
	 */
	@JsonProperty("IsSameLine")
	public void setIsSameLineInput(ForeignEntityInput IsSameLine) {
		this.mIsSameLine = IsSameLine;
		if (IsSameLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsSameLine.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsSameLine(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsSameLine.getUU());
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
	public ForeignEntityInput IsSameLine() {
		return mIsSameLine;
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
			// Since an entity was passed, make sure it's in the DB
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
			// Since an entity was passed, make sure it's in the DB
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
							.setParameters(PA_DashboardContent.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPA_DashboardContent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_DashboardContent with UU " + PA_DashboardContent.getUU());
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
