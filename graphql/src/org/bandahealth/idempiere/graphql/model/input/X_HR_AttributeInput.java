package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MOrg;
import org.compiere.model.MRule;
import org.compiere.model.Query;
import org.eevolution.model.X_HR_Attribute;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Employee;
import org.eevolution.model.X_HR_Job;
import org.eevolution.model.X_HR_Payroll;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_AttributeInput extends X_HR_Attribute implements I_HR_AttributeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Rule;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mHR_Attribute_A;
	private ForeignEntityInput mHR_Concept;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mHR_Employee;
	private ForeignEntityInput mHR_Job;
	private ForeignEntityInput mHR_Payroll;
	private I_AD_Ref_ListInput mColumnType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_AttributeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_Attribute(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
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
	 * Set Payroll Attribute Account.
	 *
	 * @param HR_Attribute_A Payroll Attribute Account
	 */
	@JsonProperty("HR_Attribute_A")
	public void setHR_Attribute_AInput(ForeignEntityInput HR_Attribute_A) {
		this.mHR_Attribute_A = HR_Attribute_A;
		MAccount foreignEntity;
		if (HR_Attribute_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(HR_Attribute_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Attribute_Acct(foreignEntity.get_ID());
		} else {
			super.setHR_Attribute_Acct(0);
		}
	}

	/**
	 * Get Payroll Attribute Account.
	 *
	 * @return Payroll Attribute Account
	 */
	@JsonProperty("HR_Attribute_A")
	public ForeignEntityInput HR_Attribute_A() {
		return mHR_Attribute_A;
	}
	/**
	 * Set Payroll Employee Attribute.
	 *
	 * @param HR_Attribute_ID Payroll Employee Attribute
	 */

	public void setHR_Attribute_ID(int HR_Attribute_ID) {
		if (get_ID() == 0) {
			super.setHR_Attribute_ID(HR_Attribute_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_Attribute_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_Attribute_UU();
	}

	/**
	 * Set Payroll Concept.
	 *
	 * @param HR_Concept Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public void setHR_ConceptInput(ForeignEntityInput HR_Concept) {
		this.mHR_Concept = HR_Concept;
		X_HR_Concept foreignEntity;
		if (get_ID() == 0 && HR_Concept != null &&
				(foreignEntity = new Query(getCtx(), "HR_Concept", "HR_Concept_UU=?", get_TrxName())
						.setParameters(HR_Concept.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Concept_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public ForeignEntityInput HR_Concept() {
		return mHR_Concept;
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
	 * Set Payroll Employee.
	 *
	 * @param HR_Employee Payroll Employee
	 */
	@JsonProperty("HR_Employee")
	public void setHR_EmployeeInput(ForeignEntityInput HR_Employee) {
		this.mHR_Employee = HR_Employee;
		X_HR_Employee foreignEntity;
		if (HR_Employee != null &&
				(foreignEntity = new Query(getCtx(), "HR_Employee", "HR_Employee_UU=?", get_TrxName())
						.setParameters(HR_Employee.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setHR_Employee_ID(foreignEntity.get_ID());
		} else {
			super.setHR_Employee_ID(0);
		}
	}

	/**
	 * Get Payroll Employee.
	 *
	 * @return Payroll Employee
	 */
	@JsonProperty("HR_Employee")
	public ForeignEntityInput HR_Employee() {
		return mHR_Employee;
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
}
