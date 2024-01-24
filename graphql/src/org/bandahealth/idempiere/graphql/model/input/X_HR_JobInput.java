package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_JobInput extends X_HR_Job implements I_HR_JobInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mNext_Job;
	private ForeignEntityInput mSupervisor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_HR_JobInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_HR_Job(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * @param HR_Job_ID Payroll Job
	 */

	public void setHR_Job_ID(int HR_Job_ID) {
		if (get_ID() == 0) {
			super.setHR_Job_ID(HR_Job_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setHR_Job_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getHR_Job_UU();
	}

	/**
	 * Set Next Job.
	 *
	 * @param Next_Job Next Job
	 */
	@JsonProperty("Next_Job")
	public void setNext_JobInput(ForeignEntityInput Next_Job) {
		this.mNext_Job = Next_Job;
		X_HR_Job foreignEntity;
		if (Next_Job != null &&
				(foreignEntity = new Query(getCtx(), "HR_Job", "HR_Job_UU=?", get_TrxName())
						.setParameters(Next_Job.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setNext_Job_ID(foreignEntity.get_ID());
		} else {
			super.setNext_Job_ID(0);
		}
	}

	/**
	 * Get Next Job.
	 *
	 * @return Next Job
	 */
	@JsonProperty("Next_Job")
	public ForeignEntityInput Next_Job() {
		return mNext_Job;
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public void setSupervisorInput(ForeignEntityInput Supervisor) {
		this.mSupervisor = Supervisor;
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(Supervisor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSupervisor_ID(foreignEntity.get_ID());
		} else {
			super.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public ForeignEntityInput Supervisor() {
		return mSupervisor;
	}
}
