package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MProcessPara;
import org.compiere.model.MValRule;
import org.compiere.model.M_Element;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Process_ParaInput extends MProcessPara implements I_AD_Process_ParaInput {

	 private I_AD_ElementInput AD_Element;
	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_ProcessInput AD_Process;
	 private I_AD_ReferenceInput AD_Reference;
	 private I_AD_ReferenceInput AD_Reference_Value;
	 private I_AD_Val_RuleInput AD_Val_Rule;

	/**
	 * Standard constructor
	 */
	public X_AD_Process_ParaInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set System Element.
	 *
	 * @param AD_Element System Element enables the central maintenance of column description and help.
	 */
	public void setAD_Element(I_AD_ElementInput AD_Element) {
		this.AD_Element = AD_Element;
		M_Element foreignEntity;
		if (AD_Element != null &&
				(foreignEntity = new Query(getCtx(), M_Element.Table_Name, M_Element.COLUMNNAME_AD_Element_UU + "=?", get_TrxName())
						.setParameters(AD_Element.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Element_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Element_ID(0);
		}
	}

	/**
	 * Get System Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	public I_AD_ElementInput getAD_Element() {
		return AD_Element;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	public void setAD_Process(I_AD_ProcessInput AD_Process) {
		this.AD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (get_ID() == 0 &&AD_Process != null &&
				(foreignEntity = new Query(getCtx(), MProcess_BH.Table_Name, MProcess_BH.COLUMNNAME_AD_Process_UU + "=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Process_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public I_AD_ProcessInput getAD_Process() {
		return AD_Process;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Process_Para_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Process_Para_UU();
	}

	/**
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	public void setAD_Reference(I_AD_ReferenceInput AD_Reference) {
		this.AD_Reference = AD_Reference;
		MReference_BH foreignEntity;
		if (AD_Reference != null &&
				(foreignEntity = new Query(getCtx(), MReference_BH.Table_Name, MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", get_TrxName())
						.setParameters(AD_Reference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Reference_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public I_AD_ReferenceInput getAD_Reference() {
		return AD_Reference;
	}

	/**
	 * Set Reference Key.
	 *
	 * @param AD_Reference_Value Required to specify, if data type is Table or List
	 */
	public void setAD_Reference_Value(I_AD_ReferenceInput AD_Reference_Value) {
		this.AD_Reference_Value = AD_Reference_Value;
		MReference_BH foreignEntity;
		if (AD_Reference_Value != null &&
				(foreignEntity = new Query(getCtx(), MReference_BH.Table_Name, MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", get_TrxName())
						.setParameters(AD_Reference_Value.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Reference_Value_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Reference_Value_ID(0);
		}
	}

	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public I_AD_ReferenceInput getAD_Reference_Value() {
		return AD_Reference_Value;
	}

	/**
	 * Set Dynamic Validation.
	 *
	 * @param AD_Val_Rule Dynamic Validation Rule
	 */
	public void setAD_Val_Rule(I_AD_Val_RuleInput AD_Val_Rule) {
		this.AD_Val_Rule = AD_Val_Rule;
		MValRule foreignEntity;
		if (AD_Val_Rule != null &&
				(foreignEntity = new Query(getCtx(), MValRule.Table_Name, MValRule.COLUMNNAME_AD_Val_Rule_UU + "=?", get_TrxName())
						.setParameters(AD_Val_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Val_Rule_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Val_Rule_ID(0);
		}
	}

	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public I_AD_Val_RuleInput getAD_Val_Rule() {
		return AD_Val_Rule;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.get_ID());
		} else {
			this.setEntityType(0);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}
}
