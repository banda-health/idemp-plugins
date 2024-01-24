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
 * @version Release 7.1 - $Id$
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
	 * @param UUID The C_RevenueRecognition_Run_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RevenueRecognition_RunInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRevenueRecognitionRun(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Revenue Recognition Service.
	 *
	 * @param C_RevenueRecog_Service Revenue Recognition Service
	 */
	@JsonProperty("C_RevenueRecog_Service")
	public void setC_RevenueRecog_ServiceInput(ForeignEntityInput C_RevenueRecog_Service) {
		this.mC_RevenueRecog_Service = C_RevenueRecog_Service;
		MRevenueRecogService foreignEntity;
		if (C_RevenueRecog_Service != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecog_Service", "C_RevenueRecog_Service_UU=?", get_TrxName())
							.setParameters(C_RevenueRecog_Service.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_RevenueRecog_Service_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecog_Service with UUID " + C_RevenueRecog_Service.getUUID());
			}
		} else {
			super.setC_RevenueRecog_Service_ID(0);
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
		MRevenueRecognitionPlan foreignEntity;
		if (get_ID() == 0 && C_RevenueRecognition_Plan != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecognition_Plan", "C_RevenueRecognition_Plan_UU=?", get_TrxName())
							.setParameters(C_RevenueRecognition_Plan.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_RevenueRecognition_Plan_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecognition_Plan with UUID " + C_RevenueRecognition_Plan.getUUID());
			}
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

	public void setC_RevenueRecognition_Run_ID(int C_RevenueRecognition_Run_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecognition_Run_ID(C_RevenueRecognition_Run_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_RevenueRecognition_Run_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		MJournal foreignEntity;
		if (get_ID() == 0 && GL_Journal != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "GL_Journal", "GL_Journal_UU=?", get_TrxName())
							.setParameters(GL_Journal.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setGL_Journal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Journal with UUID " + GL_Journal.getUUID());
			}
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

	public void setRecognizedAmt(BigDecimal RecognizedAmt) {
		if (get_ID() == 0) {
			super.setRecognizedAmt(RecognizedAmt);
		}
	}
}
