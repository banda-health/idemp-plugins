package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProcessPara;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Process;
import org.compiere.model.X_ASP_Process_Para;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_Process_ParaInput extends X_ASP_Process_Para implements I_ASP_Process_ParaInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process_Para;
	private ForeignEntityInput mASP_Process;
	private I_AD_Ref_ListInput mASP_Status;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_ASP_Process_ParaInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_ASP_Process_Para(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (get_ID() == 0 && AD_Process_Para != null &&
				(foreignEntity = new Query(getCtx(), "AD_Process_Para", "AD_Process_Para_UU=?", get_TrxName())
						.setParameters(AD_Process_Para.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_Para_ID(foreignEntity.get_ID());
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
	 * Set ASP Process.
	 *
	 * @param ASP_Process ASP Process
	 */
	@JsonProperty("ASP_Process")
	public void setASP_ProcessInput(ForeignEntityInput ASP_Process) {
		this.mASP_Process = ASP_Process;
		X_ASP_Process foreignEntity;
		if (get_ID() == 0 && ASP_Process != null &&
				(foreignEntity = new Query(getCtx(), "ASP_Process", "ASP_Process_UU=?", get_TrxName())
						.setParameters(ASP_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setASP_Process_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get ASP Process.
	 *
	 * @return ASP Process
	 */
	@JsonProperty("ASP_Process")
	public ForeignEntityInput ASP_Process() {
		return mASP_Process;
	}
	/**
	 * Set ASP Process Parameter.
	 *
	 * @param ASP_Process_Para_ID ASP Process Parameter
	 */

	public void setASP_Process_Para_ID(int ASP_Process_Para_ID) {
		if (get_ID() == 0) {
			super.setASP_Process_Para_ID(ASP_Process_Para_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setASP_Process_Para_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getASP_Process_Para_UU();
	}

	/**
	 * Set ASP Status.
	 *
	 * @param ASP_Status ASP Status
	 */
	@JsonProperty("ASP_Status")
	public void setASP_StatusInput(I_AD_Ref_ListInput ASP_Status) {
		this.mASP_Status = ASP_Status;
		MRefList_BH foreignEntity;
		if (ASP_Status != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ASP_Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setASP_Status(foreignEntity.getValue());
		} else {
			this.setASP_Status(null);
		}
	}

	/**
	 * Get ASP Status.
	 *
	 * @return ASP Status
	 */
	@JsonProperty("ASP_Status")
	public I_AD_Ref_ListInput ASP_Status() {
		return mASP_Status;
	}
}
