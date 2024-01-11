package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRule;
import org.compiere.model.MTable;
import org.compiere.model.MTableScriptValidator;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Table_ScriptValidatorInput extends MTableScriptValidator implements I_AD_Table_ScriptValidatorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Rule;
	private ForeignEntityInput mAD_Table;
	private I_AD_Ref_ListInput mEventModelValidator;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Table_ScriptValidatorInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTableScriptValidator(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Rule.
	 *
	 * @param AD_Rule Rule
	 */
	@JsonProperty("AD_Rule")
	public void setAD_RuleInput(ForeignEntityInput AD_Rule) {
		this.mAD_Rule = AD_Rule;
		MRule foreignEntity;
		if (AD_Rule != null &&
				(foreignEntity = new Query(getCtx(), "AD_Rule", "AD_Rule_UU=?", get_TrxName())
						.setParameters(AD_Rule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Rule_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Rule_ID(0);
		}
	}

	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	@JsonProperty("AD_Rule")
	public ForeignEntityInput AD_Rule() {
		return mAD_Rule;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (get_ID() == 0 && AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
	/**
	 * Set Table Script Validator.
	 *
	 * @param AD_Table_ScriptValidator_ID Table Script Validator
	 */

	public void setAD_Table_ScriptValidator_ID(int AD_Table_ScriptValidator_ID) {
		if (get_ID() == 0) {
			super.setAD_Table_ScriptValidator_ID(AD_Table_ScriptValidator_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Table_ScriptValidator_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Table_ScriptValidator_UU();
	}

	/**
	 * Set Event Model Validator.
	 *
	 * @param EventModelValidator Event Model Validator
	 */
	@JsonProperty("EventModelValidator")
	public void setEventModelValidatorInput(I_AD_Ref_ListInput EventModelValidator) {
		this.mEventModelValidator = EventModelValidator;
		MRefList_BH foreignEntity;
		if (EventModelValidator != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(EventModelValidator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEventModelValidator(foreignEntity.getValue());
		} else {
			this.setEventModelValidator(null);
		}
	}

	/**
	 * Get Event Model Validator.
	 *
	 * @return Event Model Validator
	 */
	@JsonProperty("EventModelValidator")
	public I_AD_Ref_ListInput EventModelValidator() {
		return mEventModelValidator;
	}
}
