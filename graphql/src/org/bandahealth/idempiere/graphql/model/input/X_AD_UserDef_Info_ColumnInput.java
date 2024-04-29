package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_Info_ColumnInput extends MUserDefInfoColumn implements I_AD_UserDef_Info_ColumnInput {

	private ForeignEntityInput mAD_FieldStyle;
	private ForeignEntityInput mAD_InfoColumn;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_UserDef_Info;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mIsAutocomplete;
	private ForeignEntityInput mIsDisplayed;
	private ForeignEntityInput mIsMandatory;
	private ForeignEntityInput mIsQueryAfterChange;
	private ForeignEntityInput mIsQueryCriteria;
	private ForeignEntityInput mIsReadOnly;
	private ForeignEntityInput mQueryOperator;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_UserDef_Info_Column_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_Info_ColumnInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set Info Column.
	 *
	 * @param AD_InfoColumn Info Window Column
	 */
	@JsonProperty("AD_InfoColumn")
	public void setAD_InfoColumnInput(ForeignEntityInput AD_InfoColumn) {
		this.mAD_InfoColumn = AD_InfoColumn;
		if (get_ID() != 0) {
			return;
		}
		if (AD_InfoColumn != null) {
			// Since an entity was passed, make sure it's in the DB
			MInfoColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoColumn", "AD_InfoColumn_UU=?", get_TrxName())
							.setParameters(AD_InfoColumn.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_InfoColumn_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoColumn with UU " + AD_InfoColumn.getUU());
			}
		} else {
			this.setAD_InfoColumn_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_UserDef_Info_Column_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_UserDef_Info != null) {
			// Since an entity was passed, make sure it's in the DB
			MUserDefInfo foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_UserDef_Info", "AD_UserDef_Info_UU=?", get_TrxName())
							.setParameters(AD_UserDef_Info.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_UserDef_Info_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Info with UU " + AD_UserDef_Info.getUU());
			}
		} else {
			this.setAD_UserDef_Info_ID(0);
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
	 * Set Query After Change.
	 *
	 * @param IsQueryAfterChange Issues a query request after the user has made changes to the field
	 */
	@JsonProperty("IsQueryAfterChange")
	public void setIsQueryAfterChangeInput(ForeignEntityInput IsQueryAfterChange) {
		this.mIsQueryAfterChange = IsQueryAfterChange;
		if (IsQueryAfterChange != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsQueryAfterChange.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsQueryAfterChange(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsQueryAfterChange.getUU());
			}
		} else {
			this.setIsQueryAfterChange(null);
		}
	}

	/**
	 * Get Query After Change.
	 *
	 * @return Issues a query request after the user has made changes to the field
	 */
	@JsonProperty("IsQueryAfterChange")
	public ForeignEntityInput IsQueryAfterChange() {
		return mIsQueryAfterChange;
	}

	/**
	 * Set Query Criteria.
	 *
	 * @param IsQueryCriteria The column is also used as a query criteria
	 */
	@JsonProperty("IsQueryCriteria")
	public void setIsQueryCriteriaInput(ForeignEntityInput IsQueryCriteria) {
		this.mIsQueryCriteria = IsQueryCriteria;
		if (IsQueryCriteria != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsQueryCriteria.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsQueryCriteria(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsQueryCriteria.getUU());
			}
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
	public ForeignEntityInput IsQueryCriteria() {
		return mIsQueryCriteria;
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
	 * Set Query Operator.
	 *
	 * @param QueryOperator Operator for database query
	 */
	@JsonProperty("QueryOperator")
	public void setQueryOperatorInput(ForeignEntityInput QueryOperator) {
		this.mQueryOperator = QueryOperator;
		if (QueryOperator != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(QueryOperator.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setQueryOperator(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + QueryOperator.getUU());
			}
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
	public ForeignEntityInput QueryOperator() {
		return mQueryOperator;
	}
}
