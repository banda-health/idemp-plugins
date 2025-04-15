package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_UserDef_Proc_ParameterResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProcessPara;
import org.compiere.model.MUserDefProc;
import org.compiere.model.MUserDefProcParameter;
import org.compiere.model.MValRule;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterInput extends MUserDefProcParameter implements I_AD_UserDef_Proc_ParameterInput {

	private ForeignEntityInput mAD_FieldGroup;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process_Para;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_UserDef_Proc;
	private ForeignEntityInput mAD_Val_Rule;
	private ForeignEntityInput mIsDisplayed;
	private ForeignEntityInput mIsMandatory;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_UserDef_Proc_Parameter_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_Proc_ParameterInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_FieldGroup.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Process Parameter.
	 *
	 * @param AD_Process_Para Process Parameter
	 */
	@JsonProperty("AD_Process_Para")
	public void setAD_Process_ParaInput(ForeignEntityInput AD_Process_Para) {
		this.mAD_Process_Para = AD_Process_Para;
		if (AD_Process_Para != null) {
			// Since an entity was passed, make sure it's in the DB
			MProcessPara foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process_Para", "AD_Process_Para_UU=?", get_TrxName())
							.setParameters(AD_Process_Para.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Process_Para_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process_Para with UU " + AD_Process_Para.getUU());
			}
		} else {
			this.setAD_Process_Para_ID(0);
		}
	}

	/**
	 * Get Process Parameter.
	 *
	 * @return Process Parameter
	 */
	@JsonProperty("AD_Process_Para")
	public ForeignEntityInput AD_Process_Para() {
		return mAD_Process_Para;
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
							.setParameters(AD_Reference.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(AD_Reference_Value.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set User defined Process.
	 *
	 * @param AD_UserDef_Proc Primary Key : User defined Process
	 */
	@JsonProperty("AD_UserDef_Proc")
	public void setAD_UserDef_ProcInput(ForeignEntityInput AD_UserDef_Proc) {
		this.mAD_UserDef_Proc = AD_UserDef_Proc;
		if (get_ID() != 0) {
			return;
		}
		if (AD_UserDef_Proc != null) {
			// Since an entity was passed, make sure it's in the DB
			MUserDefProc foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_UserDef_Proc", "AD_UserDef_Proc_UU=?", get_TrxName())
							.setParameters(AD_UserDef_Proc.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_UserDef_Proc_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Proc with UU " + AD_UserDef_Proc.getUU());
			}
		} else {
			this.setAD_UserDef_Proc_ID(0);
		}
	}

	/**
	 * Get User defined Process.
	 *
	 * @return Primary Key : User defined Process
	 */
	@JsonProperty("AD_UserDef_Proc")
	public ForeignEntityInput AD_UserDef_Proc() {
		return mAD_UserDef_Proc;
	}
	/**
	 * Set AD_UserDef_Proc_Parameter_ID.
	 *
	 * @param AD_UserDef_Proc_Parameter_ID Primary Key : User defined Process Parameter
	 */
	@JsonProperty("AD_UserDef_Proc_Parameter_ID")
	public void setAD_UserDef_Proc_Parameter_IDFromJson(int AD_UserDef_Proc_Parameter_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Proc_Parameter_ID(AD_UserDef_Proc_Parameter_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_UserDef_Proc_Parameter_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_UserDef_Proc_Parameter_UU();
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
							.setParameters(AD_Val_Rule.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Displayed.
	 *
	 * @param IsDisplayed Determines, if this field is displayed
	 */
	@JsonProperty("IsDisplayed")
	public void setIsDisplayedInput(ForeignEntityInput IsDisplayed) {
		this.mIsDisplayed = IsDisplayed;
		if (IsDisplayed != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserDef_Proc_ParameterResolver.ISDISPLAYED_UUIDS_BY_VALUE.containsValue(IsDisplayed.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsDisplayed.getUU() +
						" is not in the list defined for the IsDisplayed column");
			}
			// Now make sure it's in the DB
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
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserDef_Proc_ParameterResolver.ISMANDATORY_UUIDS_BY_VALUE.containsValue(IsMandatory.getUU())) {
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
}
