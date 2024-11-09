package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MJournal;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecogService;
import org.compiere.model.MRevenueRecognitionPlan;
import org.compiere.model.MRevenueRecognitionRun;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for C_RevenueRecognition_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecognition_RunInput extends MRevenueRecognitionRun implements I_C_RevenueRecognition_RunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RevenueRecog_Service;
	private ForeignEntityInput mC_RevenueRecognition_Plan;
	private ForeignEntityInput mGL_Journal;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_RevenueRecognition_Run_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RevenueRecognition_RunInput(@JsonProperty("UU") String UU) {
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
	 * Set Revenue Recognition Service.
	 *
	 * @param C_RevenueRecog_Service Revenue Recognition Service
	 */
	@JsonProperty("C_RevenueRecog_Service")
	public void setC_RevenueRecog_ServiceInput(ForeignEntityInput C_RevenueRecog_Service) {
		this.mC_RevenueRecog_Service = C_RevenueRecog_Service;
		if (C_RevenueRecog_Service != null) {
			// Since an entity was passed, make sure it's in the DB
			MRevenueRecogService foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecog_Service", "C_RevenueRecog_Service_UU=?", get_TrxName())
							.setParameters(C_RevenueRecog_Service.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_RevenueRecog_Service_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecog_Service with UU " + C_RevenueRecog_Service.getUU());
			}
		} else {
			this.setC_RevenueRecog_Service_ID(0);
		}
	}

	/**
	 * Get Revenue Recognition Service.
	 *
	 * @return Revenue Recognition Service
	 */
	@JsonProperty("C_RevenueRecog_Service")
	public ForeignEntityInput C_RevenueRecog_Service() {
		return mC_RevenueRecog_Service;
	}

	/**
	 * Set Revenue Recognition Plan.
	 *
	 * @param C_RevenueRecognition_Plan Plan for recognizing or recording revenue
	 */
	@JsonProperty("C_RevenueRecognition_Plan")
	public void setC_RevenueRecognition_PlanInput(ForeignEntityInput C_RevenueRecognition_Plan) {
		this.mC_RevenueRecognition_Plan = C_RevenueRecognition_Plan;
		if (get_ID() != 0) {
			return;
		}
		if (C_RevenueRecognition_Plan != null) {
			// Since an entity was passed, make sure it's in the DB
			MRevenueRecognitionPlan foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecognition_Plan", "C_RevenueRecognition_Plan_UU=?", get_TrxName())
							.setParameters(C_RevenueRecognition_Plan.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_RevenueRecognition_Plan_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecognition_Plan with UU " + C_RevenueRecognition_Plan.getUU());
			}
		} else {
			this.setC_RevenueRecognition_Plan_ID(0);
		}
	}

	/**
	 * Get Revenue Recognition Plan.
	 *
	 * @return Plan for recognizing or recording revenue
	 */
	@JsonProperty("C_RevenueRecognition_Plan")
	public ForeignEntityInput C_RevenueRecognition_Plan() {
		return mC_RevenueRecognition_Plan;
	}
	/**
	 * Set Revenue Recognition Run.
	 *
	 * @param C_RevenueRecognition_Run_ID Revenue Recognition Run or Process
	 */
	@JsonProperty("C_RevenueRecognition_Run_ID")
	public void setC_RevenueRecognition_Run_IDFromJson(int C_RevenueRecognition_Run_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecognition_Run_ID(C_RevenueRecognition_Run_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_RevenueRecognition_Run_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_RevenueRecognition_Run_UU();
	}

	/**
	 * Set Journal.
	 *
	 * @param GL_Journal General Ledger Journal
	 */
	@JsonProperty("GL_Journal")
	public void setGL_JournalInput(ForeignEntityInput GL_Journal) {
		this.mGL_Journal = GL_Journal;
		if (get_ID() != 0) {
			return;
		}
		if (GL_Journal != null) {
			// Since an entity was passed, make sure it's in the DB
			MJournal foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Journal", "GL_Journal_UU=?", get_TrxName())
							.setParameters(GL_Journal.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setGL_Journal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Journal with UU " + GL_Journal.getUU());
			}
		} else {
			this.setGL_Journal_ID(0);
		}
	}

	/**
	 * Get Journal.
	 *
	 * @return General Ledger Journal
	 */
	@JsonProperty("GL_Journal")
	public ForeignEntityInput GL_Journal() {
		return mGL_Journal;
	}
	/**
	 * Set Recognized Amount.
	 *
	 * @param RecognizedAmt Recognized Amount
	 */
	@JsonProperty("RecognizedAmt")
	public void setRecognizedAmtFromJson(BigDecimal RecognizedAmt) {
		if (get_ID() == 0) {
			super.setRecognizedAmt(RecognizedAmt);
		}
	}
}
