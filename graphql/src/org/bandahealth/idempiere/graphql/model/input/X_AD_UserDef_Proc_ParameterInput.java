package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProcessPara;
import org.compiere.model.MUserDefProc;
import org.compiere.model.MUserDefProcParameter;
import org.compiere.model.MValRule;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterInput extends MUserDefProcParameter implements I_AD_UserDef_Proc_ParameterInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process_Para;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Reference_Value;
	private ForeignEntityInput mAD_UserDef_Proc;
	private ForeignEntityInput mAD_Val_Rule;
	private I_AD_Ref_ListInput mIsDisplayed;
	private I_AD_Ref_ListInput mIsMandatory;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserDef_Proc_ParameterInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUserDefProcParameter(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Process Parameter.
	 *
	 * @param AD_Process_Para Process Parameter
	 */
	@JsonProperty("AD_Process_Para")
	public void setAD_Process_ParaInput(ForeignEntityInput AD_Process_Para) {
		this.mAD_Process_Para = AD_Process_Para;
		MProcessPara foreignEntity;
		if (AD_Process_Para != null &&
				(foreignEntity = new Query(getCtx(), "AD_Process_Para", "AD_Process_Para_UU=?", get_TrxName())
						.setParameters(AD_Process_Para.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_Para_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Process_Para_ID(0);
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
	 * Set User defined Process.
	 *
	 * @param AD_UserDef_Proc Primary Key : User defined Process
	 */
	@JsonProperty("AD_UserDef_Proc")
	public void setAD_UserDef_ProcInput(ForeignEntityInput AD_UserDef_Proc) {
		this.mAD_UserDef_Proc = AD_UserDef_Proc;
		MUserDefProc foreignEntity;
		if (get_ID() == 0 && AD_UserDef_Proc != null &&
				(foreignEntity = new Query(getCtx(), "AD_UserDef_Proc", "AD_UserDef_Proc_UU=?", get_TrxName())
						.setParameters(AD_UserDef_Proc.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_UserDef_Proc_ID(foreignEntity.get_ID());
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

	public void setAD_UserDef_Proc_Parameter_ID(int AD_UserDef_Proc_Parameter_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Proc_Parameter_ID(AD_UserDef_Proc_Parameter_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_UserDef_Proc_Parameter_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
}
