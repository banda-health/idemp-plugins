package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInfoColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.MUserDefInfo;
import org.compiere.model.MUserDefInfoColumn;
import org.compiere.model.MValRule;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Info_ColumnInput extends MUserDefInfoColumn implements I_AD_UserDef_Info_ColumnInput {

	private ForeignEntityInput mAD_FieldStyle;
	private ForeignEntityInput mAD_InfoColumn;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_UserDef_Info;
	private ForeignEntityInput mAD_Val_Rule;
	private I_AD_Ref_ListInput mIsAutocomplete;
	private I_AD_Ref_ListInput mIsDisplayed;
	private I_AD_Ref_ListInput mIsMandatory;
	private I_AD_Ref_ListInput mIsQueryCriteria;
	private I_AD_Ref_ListInput mIsReadOnly;
	private I_AD_Ref_ListInput mQueryOperator;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserDef_Info_ColumnInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUserDefInfoColumn(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Info Column.
	 *
	 * @param AD_InfoColumn Info Window Column
	 */
	@JsonProperty("AD_InfoColumn")
	public void setAD_InfoColumnInput(ForeignEntityInput AD_InfoColumn) {
		this.mAD_InfoColumn = AD_InfoColumn;
		MInfoColumn foreignEntity;
		if (get_ID() == 0 && AD_InfoColumn != null &&
				(foreignEntity = new Query(getCtx(), "AD_InfoColumn", "AD_InfoColumn_UU=?", get_TrxName())
						.setParameters(AD_InfoColumn.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_InfoColumn_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Info Column.
	 *
	 * @return Info Window Column
	 */
	@JsonProperty("AD_InfoColumn")
	public ForeignEntityInput AD_InfoColumn() {
		return mAD_InfoColumn;
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
	 * Set User defined Info Column.
	 *
	 * @param AD_UserDef_Info_Column_ID User defined Info Column
	 */

	public void setAD_UserDef_Info_Column_ID(int AD_UserDef_Info_Column_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Info_Column_ID(AD_UserDef_Info_Column_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_UserDef_Info_Column_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_UserDef_Info_Column_UU();
	}

	/**
	 * Set User defined Info Window.
	 *
	 * @param AD_UserDef_Info User defined Info Window
	 */
	@JsonProperty("AD_UserDef_Info")
	public void setAD_UserDef_InfoInput(ForeignEntityInput AD_UserDef_Info) {
		this.mAD_UserDef_Info = AD_UserDef_Info;
		MUserDefInfo foreignEntity;
		if (get_ID() == 0 && AD_UserDef_Info != null &&
				(foreignEntity = new Query(getCtx(), "AD_UserDef_Info", "AD_UserDef_Info_UU=?", get_TrxName())
						.setParameters(AD_UserDef_Info.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_UserDef_Info_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get User defined Info Window.
	 *
	 * @return User defined Info Window
	 */
	@JsonProperty("AD_UserDef_Info")
	public ForeignEntityInput AD_UserDef_Info() {
		return mAD_UserDef_Info;
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
	 * Set Query Criteria.
	 *
	 * @param IsQueryCriteria The column is also used as a query criteria
	 */
	@JsonProperty("IsQueryCriteria")
	public void setIsQueryCriteriaInput(I_AD_Ref_ListInput IsQueryCriteria) {
		this.mIsQueryCriteria = IsQueryCriteria;
		MRefList_BH foreignEntity;
		if (IsQueryCriteria != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsQueryCriteria.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsQueryCriteria(foreignEntity.getValue());
		} else {
			this.setIsQueryCriteria(null);
		}
	}

	/**
	 * Get Query Criteria.
	 *
	 * @return The column is also used as a query criteria
	 */
	@JsonProperty("IsQueryCriteria")
	public I_AD_Ref_ListInput IsQueryCriteria() {
		return mIsQueryCriteria;
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
	 * Set Query Operator.
	 *
	 * @param QueryOperator Operator for database query
	 */
	@JsonProperty("QueryOperator")
	public void setQueryOperatorInput(I_AD_Ref_ListInput QueryOperator) {
		this.mQueryOperator = QueryOperator;
		MRefList_BH foreignEntity;
		if (QueryOperator != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(QueryOperator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setQueryOperator(foreignEntity.getValue());
		} else {
			this.setQueryOperator(null);
		}
	}

	/**
	 * Get Query Operator.
	 *
	 * @return Operator for database query
	 */
	@JsonProperty("QueryOperator")
	public I_AD_Ref_ListInput QueryOperator() {
		return mQueryOperator;
	}
}
