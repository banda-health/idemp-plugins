package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Concept_Category;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_ConceptInput extends X_HR_Concept implements I_HR_ConceptInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mHR_Concept_Category;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Job;
	private ForeignEntityInput mHR_Payroll;
	private I_AD_Ref_ListInput mAccountSign;
	private I_AD_Ref_ListInput mColumnType;
	private I_AD_Ref_ListInput mType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_ConceptInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_Concept(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Account Sign.
	 *
	 * @param AccountSign Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public void setAccountSignInput(I_AD_Ref_ListInput AccountSign) {
		this.mAccountSign = AccountSign;
		MRefList_BH foreignEntity;
		if (AccountSign != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AccountSign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccountSign(foreignEntity.getValue());
		} else {
			this.setAccountSign(null);
		}
	}

	/**
	 * Get Account Sign.
	 *
	 * @return Indicates the Natural Sign of the Account as a Debit or Credit
	 */
	@JsonProperty("AccountSign")
	public I_AD_Ref_ListInput AccountSign() {
		return mAccountSign;
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
	 * Set Column Type.
	 *
	 * @param ColumnType Column Type
	 */
	@JsonProperty("ColumnType")
	public void setColumnTypeInput(I_AD_Ref_ListInput ColumnType) {
		this.mColumnType = ColumnType;
		MRefList_BH foreignEntity;
		if (ColumnType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ColumnType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setColumnType(foreignEntity.getValue());
		} else {
			this.setColumnType(null);
		}
	}

	/**
	 * Get Column Type.
	 *
	 * @return Column Type
	 */
	@JsonProperty("ColumnType")
	public I_AD_Ref_ListInput ColumnType() {
		return mColumnType;
	}

	/**
	 * Set Payroll Concept Category.
	 *
	 * @param HR_Concept_Category Payroll Concept Category
	 */
	@JsonProperty("HR_Concept_Category")
	public void setHR_Concept_CategoryInput(ForeignEntityInput HR_Concept_Category) {
		this.mHR_Concept_Category = HR_Concept_Category;
		X_HR_Concept_Category foreignEntity;
		if (HR_Concept_Category != null &&
				(foreignEntity = new Query(getCtx(), "HR_Concept_Category", "HR_Concept_Category_UU=?", get_TrxName())
						.setParameters(HR_Concept_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Concept_Category_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Concept_Category_ID(0);
		}
	}

	/**
	 * Get Payroll Concept Category.
	 *
	 * @return Payroll Concept Category
	 */
	@JsonProperty("HR_Concept_Category")
	public ForeignEntityInput HR_Concept_Category() {
		return mHR_Concept_Category;
	}
	/**
	 * Set Payroll Concept.
	 *
	 * @param HR_Concept_ID Payroll Concept
	 */

	public void setHR_Concept_ID(int HR_Concept_ID) {
		if (get_ID() == 0) {
			super.setHR_Concept_ID(HR_Concept_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_Concept_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_Concept_UU();
	}

	/**
	 * Set Payroll Department.
	 *
	 * @param HR_Department Payroll Department
	 */
	@JsonProperty("HR_Department")
	public void setHR_DepartmentInput(ForeignEntityInput HR_Department) {
		this.mHR_Department = HR_Department;
		X_HR_Department foreignEntity;
		if (HR_Department != null &&
				(foreignEntity = new Query(getCtx(), "HR_Department", "HR_Department_UU=?", get_TrxName())
						.setParameters(HR_Department.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Department_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Department_ID(0);
		}
	}

	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	@JsonProperty("HR_Department")
	public ForeignEntityInput HR_Department() {
		return mHR_Department;
	}

	/**
	 * Set Payroll Job.
	 *
	 * @param HR_Job Payroll Job
	 */
	@JsonProperty("HR_Job")
	public void setHR_JobInput(ForeignEntityInput HR_Job) {
		this.mHR_Job = HR_Job;
		X_HR_Job foreignEntity;
		if (HR_Job != null &&
				(foreignEntity = new Query(getCtx(), "HR_Job", "HR_Job_UU=?", get_TrxName())
						.setParameters(HR_Job.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Job_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Job_ID(0);
		}
	}

	/**
	 * Get Payroll Job.
	 *
	 * @return Payroll Job
	 */
	@JsonProperty("HR_Job")
	public ForeignEntityInput HR_Job() {
		return mHR_Job;
	}

	/**
	 * Set Payroll.
	 *
	 * @param HR_Payroll Payroll
	 */
	@JsonProperty("HR_Payroll")
	public void setHR_PayrollInput(ForeignEntityInput HR_Payroll) {
		this.mHR_Payroll = HR_Payroll;
		X_HR_Payroll foreignEntity;
		if (HR_Payroll != null &&
				(foreignEntity = new Query(getCtx(), "HR_Payroll", "HR_Payroll_UU=?", get_TrxName())
						.setParameters(HR_Payroll.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Payroll_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Payroll_ID(0);
		}
	}

	/**
	 * Get Payroll.
	 *
	 * @return Payroll
	 */
	@JsonProperty("HR_Payroll")
	public ForeignEntityInput HR_Payroll() {
		return mHR_Payroll;
	}

	/**
	 * Set Type.
	 *
	 * @param Type Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public void setTypeInput(I_AD_Ref_ListInput Type) {
		this.mType = Type;
		MRefList_BH foreignEntity;
		if (Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setType(foreignEntity.getValue());
		} else {
			this.setType(null);
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Type of Validation (SQL, Java Script, Java Language)
	 */
	@JsonProperty("Type")
	public I_AD_Ref_ListInput Type() {
		return mType;
	}
}
