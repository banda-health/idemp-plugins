package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_ASP_Process_ParaResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProcessPara;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Process;
import org.compiere.model.X_ASP_Process_Para;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Process_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_Process_ParaInput extends X_ASP_Process_Para implements I_ASP_Process_ParaInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process_Para;
	private ForeignEntityInput mASP_Process;
	private ForeignEntityInput mASP_Status;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The ASP_Process_Para_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_ASP_Process_ParaInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
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
		if (!is_new()) {
			return;
		}
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
	 * Set ASP Process.
	 *
	 * @param ASP_Process ASP Process
	 */
	@JsonProperty("ASP_Process")
	public void setASP_ProcessInput(ForeignEntityInput ASP_Process) {
		this.mASP_Process = ASP_Process;
		if (!is_new()) {
			return;
		}
		if (ASP_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			X_ASP_Process foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "ASP_Process", "ASP_Process_UU=?", get_TrxName())
							.setParameters(ASP_Process.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setASP_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table ASP_Process with UU " + ASP_Process.getUU());
			}
		} else {
			this.setASP_Process_ID(0);
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
	@JsonProperty("ASP_Process_Para_ID")
	public void setASP_Process_Para_IDFromJson(int ASP_Process_Para_ID) {
		if (get_ID() == 0) {
			super.setASP_Process_Para_ID(ASP_Process_Para_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setASP_Process_Para_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getASP_Process_Para_UU();
	}

	/**
	 * Set ASP Status.
	 *
	 * @param ASP_Status ASP Status
	 */
	@JsonProperty("ASP_Status")
	public void setASP_StatusInput(ForeignEntityInput ASP_Status) {
		this.mASP_Status = ASP_Status;
		if (ASP_Status != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_ASP_Process_ParaResolver.ASP_STATUS_UUIDS_BY_VALUE.containsValue(ASP_Status.getUU())) {
				throw new AdempiereException("The reference list UU of " + ASP_Status.getUU() +
						" is not in the list defined for the ASP_Status column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ASP_Status.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setASP_Status(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ASP_Status.getUU());
			}
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
	public ForeignEntityInput ASP_Status() {
		return mASP_Status;
	}
}
