package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
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
 * @version Release 8.2 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserDef_Proc_Parameter_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserDef_Proc_ParameterInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MUserDefProcParameter(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Process_Para.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Process_Para_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process_Para with UUID " + AD_Process_Para.getUUID());
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
							.setParameters(AD_UserDef_Proc.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_UserDef_Proc_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_UserDef_Proc with UUID " + AD_UserDef_Proc.getUUID());
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

	public void setAD_UserDef_Proc_Parameter_ID(int AD_UserDef_Proc_Parameter_ID) {
		if (get_ID() == 0) {
			super.setAD_UserDef_Proc_Parameter_ID(AD_UserDef_Proc_Parameter_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_UserDef_Proc_Parameter_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
}
