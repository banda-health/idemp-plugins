package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_VisitInput extends MBHVisit implements I_BH_VisitInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Voided_Reason;
	private ForeignEntityInput mPatient;
	private I_AD_Ref_ListInput mBH_PatientType;
	private I_AD_Ref_ListInput mBH_Process_Stage;
	private I_AD_Ref_ListInput mbh_referral;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Visit_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_VisitInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBHVisit(null, (ResultSet) null, null),
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
	 * Set Patient Type.
	 *
	 * @param BH_PatientType Patient Type
	 */
	@JsonProperty("BH_PatientType")
	public void setBH_PatientTypeInput(I_AD_Ref_ListInput BH_PatientType) {
		this.mBH_PatientType = BH_PatientType;
		if (BH_PatientType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_PatientType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_PatientType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BH_PatientType.getUUID());
			}
		} else {
			this.setBH_PatientType(null);
		}
	}

	/**
	 * Get Patient Type.
	 *
	 * @return Patient Type
	 */
	@JsonProperty("BH_PatientType")
	public I_AD_Ref_ListInput BH_PatientType() {
		return mBH_PatientType;
	}

	/**
	 * Set BH_Process_Stage.
	 *
	 * @param BH_Process_Stage Drop down field in visits for users to define the process stage
	 */
	@JsonProperty("BH_Process_Stage")
	public void setBH_Process_StageInput(I_AD_Ref_ListInput BH_Process_Stage) {
		this.mBH_Process_Stage = BH_Process_Stage;
		if (BH_Process_Stage != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Process_Stage.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_Process_Stage(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BH_Process_Stage.getUUID());
			}
		} else {
			this.setBH_Process_Stage(null);
		}
	}

	/**
	 * Get BH_Process_Stage.
	 *
	 * @return Drop down field in visits for users to define the process stage
	 */
	@JsonProperty("BH_Process_Stage")
	public I_AD_Ref_ListInput BH_Process_Stage() {
		return mBH_Process_Stage;
	}

	/**
	 * Set Referral.
	 *
	 * @param bh_referral Referral
	 */
	@JsonProperty("bh_referral")
	public void setbh_referralInput(I_AD_Ref_ListInput bh_referral) {
		this.mbh_referral = bh_referral;
		if (bh_referral != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(bh_referral.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setbh_referral(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + bh_referral.getUUID());
			}
		} else {
			this.setbh_referral(null);
		}
	}

	/**
	 * Get Referral.
	 *
	 * @return Referral
	 */
	@JsonProperty("bh_referral")
	public I_AD_Ref_ListInput bh_referral() {
		return mbh_referral;
	}
	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */

	public void setBH_Visit_ID(int BH_Visit_ID) {
		if (get_ID() == 0) {
			super.setBH_Visit_ID(BH_Visit_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_Visit_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getBH_Visit_UU();
	}

	/**
	 * Set BH_Voided_Reason_ID.
	 *
	 * @param BH_Voided_Reason BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public void setBH_Voided_ReasonInput(ForeignEntityInput BH_Voided_Reason) {
		this.mBH_Voided_Reason = BH_Voided_Reason;
		if (BH_Voided_Reason != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVoidedReason foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Voided_Reason", "BH_Voided_Reason_UU=?", get_TrxName())
							.setParameters(BH_Voided_Reason.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_Voided_Reason_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Voided_Reason with UUID " + BH_Voided_Reason.getUUID());
			}
		} else {
			this.setBH_Voided_Reason_ID(0);
		}
	}

	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	@JsonProperty("BH_Voided_Reason")
	public ForeignEntityInput BH_Voided_Reason() {
		return mBH_Voided_Reason;
	}
	/**
	 * Set Document No.
	 *
	 * @param DocumentNo Document sequence number of the document
	 */

	public void setDocumentNo(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
	}

	/**
	 * Set Patient.
	 *
	 * @param Patient The Patient must be a valid business partner.
	 */
	@JsonProperty("Patient")
	public void setPatientInput(ForeignEntityInput Patient) {
		this.mPatient = Patient;
		if (Patient != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(Patient.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPatient_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + Patient.getUUID());
			}
		} else {
			this.setPatient_ID(0);
		}
	}

	/**
	 * Get Patient.
	 *
	 * @return The Patient must be a valid business partner.
	 */
	@JsonProperty("Patient")
	public ForeignEntityInput Patient() {
		return mPatient;
	}
}
