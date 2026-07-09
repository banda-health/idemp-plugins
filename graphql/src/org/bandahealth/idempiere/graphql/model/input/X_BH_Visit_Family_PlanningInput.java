package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Visit_Family_PlanningResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Visit_Family_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_PlanningInput extends MBHVisitFamilyPlanning implements I_BH_Visit_Family_PlanningInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Cervical_Cancer_Screening;
	private ForeignEntityInput mBH_Cervical_Pap_Method;
	private ForeignEntityInput mBH_Cervical_Results;
	private ForeignEntityInput mBH_Cycle_Beads_Given;
	private ForeignEntityInput mBH_Emergency_Contraception_Given;
	private ForeignEntityInput mBH_First_Ever_Contraceptive_User;
	private ForeignEntityInput mBH_First_Visit_Fp_At_Clinic;
	private ForeignEntityInput mBH_Hiv_Counseled_Tested;
	private ForeignEntityInput mBH_Hiv_Results;
	private ForeignEntityInput mBH_Implants_Type_Of_Visit;
	private ForeignEntityInput mBH_Injectable_Route;
	private ForeignEntityInput mBH_Injectable_Type_Of_Visit;
	private ForeignEntityInput mBH_Ipv_Reproductive_Coercion;
	private ForeignEntityInput mBH_Iucd_Type_Of_Visit;
	private ForeignEntityInput mBH_Natural_Fp_Counseled;
	private ForeignEntityInput mBH_Oral_Type_Of_Visit;
	private ForeignEntityInput mBH_Postpartum_Fp;
	private ForeignEntityInput mBH_Referral_Community_From;
	private ForeignEntityInput mBH_Referral_Community_To;
	private ForeignEntityInput mBH_Referrals;
	private ForeignEntityInput mBH_Tb_Screening;
	private ForeignEntityInput mBH_Visit;
	private ForeignEntityInput mBH_Vsc_Given;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Visit_Family_Planning_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Visit_Family_PlanningInput(@JsonProperty("UU") String UU) {
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
	 * Set Cervical Cancer Screening.
	 *
	 * @param BH_Cervical_Cancer_Screening Cervical Cancer Screening
	 */
	@JsonProperty("BH_Cervical_Cancer_Screening")
	public void setBH_Cervical_Cancer_ScreeningInput(ForeignEntityInput BH_Cervical_Cancer_Screening) {
		this.mBH_Cervical_Cancer_Screening = BH_Cervical_Cancer_Screening;
		if (BH_Cervical_Cancer_Screening != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_CERVICAL_CANCER_SCREENING_UUIDS_BY_VALUE.containsValue(BH_Cervical_Cancer_Screening.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Cervical_Cancer_Screening.getUU() +
						" is not in the list defined for the BH_Cervical_Cancer_Screening column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Cervical_Cancer_Screening.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Cervical_Cancer_Screening(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Cervical_Cancer_Screening.getUU());
			}
		} else {
			this.setBH_Cervical_Cancer_Screening(null);
		}
	}

	/**
	 * Get Cervical Cancer Screening.
	 *
	 * @return Cervical Cancer Screening
	 */
	@JsonProperty("BH_Cervical_Cancer_Screening")
	public ForeignEntityInput BH_Cervical_Cancer_Screening() {
		return mBH_Cervical_Cancer_Screening;
	}

	/**
	 * Set Cervical PAP Method.
	 *
	 * @param BH_Cervical_Pap_Method Cervical PAP Method
	 */
	@JsonProperty("BH_Cervical_Pap_Method")
	public void setBH_Cervical_Pap_MethodInput(ForeignEntityInput BH_Cervical_Pap_Method) {
		this.mBH_Cervical_Pap_Method = BH_Cervical_Pap_Method;
		if (BH_Cervical_Pap_Method != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_CERVICAL_PAP_METHOD_UUIDS_BY_VALUE.containsValue(BH_Cervical_Pap_Method.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Cervical_Pap_Method.getUU() +
						" is not in the list defined for the BH_Cervical_Pap_Method column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Cervical_Pap_Method.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Cervical_Pap_Method(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Cervical_Pap_Method.getUU());
			}
		} else {
			this.setBH_Cervical_Pap_Method(null);
		}
	}

	/**
	 * Get Cervical PAP Method.
	 *
	 * @return Cervical PAP Method
	 */
	@JsonProperty("BH_Cervical_Pap_Method")
	public ForeignEntityInput BH_Cervical_Pap_Method() {
		return mBH_Cervical_Pap_Method;
	}

	/**
	 * Set Cervical Results.
	 *
	 * @param BH_Cervical_Results Cervical Results
	 */
	@JsonProperty("BH_Cervical_Results")
	public void setBH_Cervical_ResultsInput(ForeignEntityInput BH_Cervical_Results) {
		this.mBH_Cervical_Results = BH_Cervical_Results;
		if (BH_Cervical_Results != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_CERVICAL_RESULTS_UUIDS_BY_VALUE.containsValue(BH_Cervical_Results.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Cervical_Results.getUU() +
						" is not in the list defined for the BH_Cervical_Results column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Cervical_Results.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Cervical_Results(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Cervical_Results.getUU());
			}
		} else {
			this.setBH_Cervical_Results(null);
		}
	}

	/**
	 * Get Cervical Results.
	 *
	 * @return Cervical Results
	 */
	@JsonProperty("BH_Cervical_Results")
	public ForeignEntityInput BH_Cervical_Results() {
		return mBH_Cervical_Results;
	}

	/**
	 * Set Cycle Beads Given.
	 *
	 * @param BH_Cycle_Beads_Given Cycle Beads Given
	 */
	@JsonProperty("BH_Cycle_Beads_Given")
	public void setBH_Cycle_Beads_GivenInput(ForeignEntityInput BH_Cycle_Beads_Given) {
		this.mBH_Cycle_Beads_Given = BH_Cycle_Beads_Given;
		if (BH_Cycle_Beads_Given != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_CYCLE_BEADS_GIVEN_UUIDS_BY_VALUE.containsValue(BH_Cycle_Beads_Given.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Cycle_Beads_Given.getUU() +
						" is not in the list defined for the BH_Cycle_Beads_Given column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Cycle_Beads_Given.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Cycle_Beads_Given(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Cycle_Beads_Given.getUU());
			}
		} else {
			this.setBH_Cycle_Beads_Given(null);
		}
	}

	/**
	 * Get Cycle Beads Given.
	 *
	 * @return Cycle Beads Given
	 */
	@JsonProperty("BH_Cycle_Beads_Given")
	public ForeignEntityInput BH_Cycle_Beads_Given() {
		return mBH_Cycle_Beads_Given;
	}

	/**
	 * Set Emergency Contraception Given.
	 *
	 * @param BH_Emergency_Contraception_Given Emergency Contraception Given
	 */
	@JsonProperty("BH_Emergency_Contraception_Given")
	public void setBH_Emergency_Contraception_GivenInput(ForeignEntityInput BH_Emergency_Contraception_Given) {
		this.mBH_Emergency_Contraception_Given = BH_Emergency_Contraception_Given;
		if (BH_Emergency_Contraception_Given != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_EMERGENCY_CONTRACEPTION_GIVEN_UUIDS_BY_VALUE.containsValue(BH_Emergency_Contraception_Given.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Emergency_Contraception_Given.getUU() +
						" is not in the list defined for the BH_Emergency_Contraception_Given column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Emergency_Contraception_Given.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Emergency_Contraception_Given(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Emergency_Contraception_Given.getUU());
			}
		} else {
			this.setBH_Emergency_Contraception_Given(null);
		}
	}

	/**
	 * Get Emergency Contraception Given.
	 *
	 * @return Emergency Contraception Given
	 */
	@JsonProperty("BH_Emergency_Contraception_Given")
	public ForeignEntityInput BH_Emergency_Contraception_Given() {
		return mBH_Emergency_Contraception_Given;
	}

	/**
	 * Set First Ever Contraceptive User.
	 *
	 * @param BH_First_Ever_Contraceptive_User First Ever Contraceptive User
	 */
	@JsonProperty("BH_First_Ever_Contraceptive_User")
	public void setBH_First_Ever_Contraceptive_UserInput(ForeignEntityInput BH_First_Ever_Contraceptive_User) {
		this.mBH_First_Ever_Contraceptive_User = BH_First_Ever_Contraceptive_User;
		if (BH_First_Ever_Contraceptive_User != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_FIRST_EVER_CONTRACEPTIVE_USER_UUIDS_BY_VALUE.containsValue(BH_First_Ever_Contraceptive_User.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_First_Ever_Contraceptive_User.getUU() +
						" is not in the list defined for the BH_First_Ever_Contraceptive_User column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_First_Ever_Contraceptive_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_First_Ever_Contraceptive_User(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_First_Ever_Contraceptive_User.getUU());
			}
		} else {
			this.setBH_First_Ever_Contraceptive_User(null);
		}
	}

	/**
	 * Get First Ever Contraceptive User.
	 *
	 * @return First Ever Contraceptive User
	 */
	@JsonProperty("BH_First_Ever_Contraceptive_User")
	public ForeignEntityInput BH_First_Ever_Contraceptive_User() {
		return mBH_First_Ever_Contraceptive_User;
	}

	/**
	 * Set First Visit FP at Clinic.
	 *
	 * @param BH_First_Visit_Fp_At_Clinic First Visit FP at Clinic
	 */
	@JsonProperty("BH_First_Visit_Fp_At_Clinic")
	public void setBH_First_Visit_Fp_At_ClinicInput(ForeignEntityInput BH_First_Visit_Fp_At_Clinic) {
		this.mBH_First_Visit_Fp_At_Clinic = BH_First_Visit_Fp_At_Clinic;
		if (BH_First_Visit_Fp_At_Clinic != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_FIRST_VISIT_FP_AT_CLINIC_UUIDS_BY_VALUE.containsValue(BH_First_Visit_Fp_At_Clinic.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_First_Visit_Fp_At_Clinic.getUU() +
						" is not in the list defined for the BH_First_Visit_Fp_At_Clinic column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_First_Visit_Fp_At_Clinic.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_First_Visit_Fp_At_Clinic(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_First_Visit_Fp_At_Clinic.getUU());
			}
		} else {
			this.setBH_First_Visit_Fp_At_Clinic(null);
		}
	}

	/**
	 * Get First Visit FP at Clinic.
	 *
	 * @return First Visit FP at Clinic
	 */
	@JsonProperty("BH_First_Visit_Fp_At_Clinic")
	public ForeignEntityInput BH_First_Visit_Fp_At_Clinic() {
		return mBH_First_Visit_Fp_At_Clinic;
	}

	/**
	 * Set HIV Counseled/Tested.
	 *
	 * @param BH_Hiv_Counseled_Tested HIV Counseled/Tested
	 */
	@JsonProperty("BH_Hiv_Counseled_Tested")
	public void setBH_Hiv_Counseled_TestedInput(ForeignEntityInput BH_Hiv_Counseled_Tested) {
		this.mBH_Hiv_Counseled_Tested = BH_Hiv_Counseled_Tested;
		if (BH_Hiv_Counseled_Tested != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_HIV_COUNSELED_TESTED_UUIDS_BY_VALUE.containsValue(BH_Hiv_Counseled_Tested.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Hiv_Counseled_Tested.getUU() +
						" is not in the list defined for the BH_Hiv_Counseled_Tested column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Hiv_Counseled_Tested.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Hiv_Counseled_Tested(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Hiv_Counseled_Tested.getUU());
			}
		} else {
			this.setBH_Hiv_Counseled_Tested(null);
		}
	}

	/**
	 * Get HIV Counseled/Tested.
	 *
	 * @return HIV Counseled/Tested
	 */
	@JsonProperty("BH_Hiv_Counseled_Tested")
	public ForeignEntityInput BH_Hiv_Counseled_Tested() {
		return mBH_Hiv_Counseled_Tested;
	}

	/**
	 * Set HIV Results.
	 *
	 * @param BH_Hiv_Results HIV Results
	 */
	@JsonProperty("BH_Hiv_Results")
	public void setBH_Hiv_ResultsInput(ForeignEntityInput BH_Hiv_Results) {
		this.mBH_Hiv_Results = BH_Hiv_Results;
		if (BH_Hiv_Results != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_HIV_RESULTS_UUIDS_BY_VALUE.containsValue(BH_Hiv_Results.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Hiv_Results.getUU() +
						" is not in the list defined for the BH_Hiv_Results column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Hiv_Results.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Hiv_Results(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Hiv_Results.getUU());
			}
		} else {
			this.setBH_Hiv_Results(null);
		}
	}

	/**
	 * Get HIV Results.
	 *
	 * @return HIV Results
	 */
	@JsonProperty("BH_Hiv_Results")
	public ForeignEntityInput BH_Hiv_Results() {
		return mBH_Hiv_Results;
	}

	/**
	 * Set Implants Type of Visit.
	 *
	 * @param BH_Implants_Type_Of_Visit Implants Type of Visit
	 */
	@JsonProperty("BH_Implants_Type_Of_Visit")
	public void setBH_Implants_Type_Of_VisitInput(ForeignEntityInput BH_Implants_Type_Of_Visit) {
		this.mBH_Implants_Type_Of_Visit = BH_Implants_Type_Of_Visit;
		if (BH_Implants_Type_Of_Visit != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_IMPLANTS_TYPE_OF_VISIT_UUIDS_BY_VALUE.containsValue(BH_Implants_Type_Of_Visit.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Implants_Type_Of_Visit.getUU() +
						" is not in the list defined for the BH_Implants_Type_Of_Visit column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Implants_Type_Of_Visit.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Implants_Type_Of_Visit(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Implants_Type_Of_Visit.getUU());
			}
		} else {
			this.setBH_Implants_Type_Of_Visit(null);
		}
	}

	/**
	 * Get Implants Type of Visit.
	 *
	 * @return Implants Type of Visit
	 */
	@JsonProperty("BH_Implants_Type_Of_Visit")
	public ForeignEntityInput BH_Implants_Type_Of_Visit() {
		return mBH_Implants_Type_Of_Visit;
	}

	/**
	 * Set Injectable Route.
	 *
	 * @param BH_Injectable_Route Injectable Route
	 */
	@JsonProperty("BH_Injectable_Route")
	public void setBH_Injectable_RouteInput(ForeignEntityInput BH_Injectable_Route) {
		this.mBH_Injectable_Route = BH_Injectable_Route;
		if (BH_Injectable_Route != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_INJECTABLE_ROUTE_UUIDS_BY_VALUE.containsValue(BH_Injectable_Route.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Injectable_Route.getUU() +
						" is not in the list defined for the BH_Injectable_Route column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Injectable_Route.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Injectable_Route(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Injectable_Route.getUU());
			}
		} else {
			this.setBH_Injectable_Route(null);
		}
	}

	/**
	 * Get Injectable Route.
	 *
	 * @return Injectable Route
	 */
	@JsonProperty("BH_Injectable_Route")
	public ForeignEntityInput BH_Injectable_Route() {
		return mBH_Injectable_Route;
	}

	/**
	 * Set Injectable Type of Visit.
	 *
	 * @param BH_Injectable_Type_Of_Visit Injectable Type of Visit
	 */
	@JsonProperty("BH_Injectable_Type_Of_Visit")
	public void setBH_Injectable_Type_Of_VisitInput(ForeignEntityInput BH_Injectable_Type_Of_Visit) {
		this.mBH_Injectable_Type_Of_Visit = BH_Injectable_Type_Of_Visit;
		if (BH_Injectable_Type_Of_Visit != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_INJECTABLE_TYPE_OF_VISIT_UUIDS_BY_VALUE.containsValue(BH_Injectable_Type_Of_Visit.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Injectable_Type_Of_Visit.getUU() +
						" is not in the list defined for the BH_Injectable_Type_Of_Visit column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Injectable_Type_Of_Visit.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Injectable_Type_Of_Visit(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Injectable_Type_Of_Visit.getUU());
			}
		} else {
			this.setBH_Injectable_Type_Of_Visit(null);
		}
	}

	/**
	 * Get Injectable Type of Visit.
	 *
	 * @return Injectable Type of Visit
	 */
	@JsonProperty("BH_Injectable_Type_Of_Visit")
	public ForeignEntityInput BH_Injectable_Type_Of_Visit() {
		return mBH_Injectable_Type_Of_Visit;
	}

	/**
	 * Set IPV/Reproductive Coercion.
	 *
	 * @param BH_Ipv_Reproductive_Coercion IPV/Reproductive Coercion
	 */
	@JsonProperty("BH_Ipv_Reproductive_Coercion")
	public void setBH_Ipv_Reproductive_CoercionInput(ForeignEntityInput BH_Ipv_Reproductive_Coercion) {
		this.mBH_Ipv_Reproductive_Coercion = BH_Ipv_Reproductive_Coercion;
		if (BH_Ipv_Reproductive_Coercion != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_IPV_REPRODUCTIVE_COERCION_UUIDS_BY_VALUE.containsValue(BH_Ipv_Reproductive_Coercion.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Ipv_Reproductive_Coercion.getUU() +
						" is not in the list defined for the BH_Ipv_Reproductive_Coercion column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Ipv_Reproductive_Coercion.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Ipv_Reproductive_Coercion(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Ipv_Reproductive_Coercion.getUU());
			}
		} else {
			this.setBH_Ipv_Reproductive_Coercion(null);
		}
	}

	/**
	 * Get IPV/Reproductive Coercion.
	 *
	 * @return IPV/Reproductive Coercion
	 */
	@JsonProperty("BH_Ipv_Reproductive_Coercion")
	public ForeignEntityInput BH_Ipv_Reproductive_Coercion() {
		return mBH_Ipv_Reproductive_Coercion;
	}

	/**
	 * Set IUCD Type of Visit.
	 *
	 * @param BH_Iucd_Type_Of_Visit IUCD Type of Visit
	 */
	@JsonProperty("BH_Iucd_Type_Of_Visit")
	public void setBH_Iucd_Type_Of_VisitInput(ForeignEntityInput BH_Iucd_Type_Of_Visit) {
		this.mBH_Iucd_Type_Of_Visit = BH_Iucd_Type_Of_Visit;
		if (BH_Iucd_Type_Of_Visit != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_IUCD_TYPE_OF_VISIT_UUIDS_BY_VALUE.containsValue(BH_Iucd_Type_Of_Visit.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Iucd_Type_Of_Visit.getUU() +
						" is not in the list defined for the BH_Iucd_Type_Of_Visit column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Iucd_Type_Of_Visit.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Iucd_Type_Of_Visit(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Iucd_Type_Of_Visit.getUU());
			}
		} else {
			this.setBH_Iucd_Type_Of_Visit(null);
		}
	}

	/**
	 * Get IUCD Type of Visit.
	 *
	 * @return IUCD Type of Visit
	 */
	@JsonProperty("BH_Iucd_Type_Of_Visit")
	public ForeignEntityInput BH_Iucd_Type_Of_Visit() {
		return mBH_Iucd_Type_Of_Visit;
	}

	/**
	 * Set Natural FP Counseled.
	 *
	 * @param BH_Natural_Fp_Counseled Natural FP Counseled
	 */
	@JsonProperty("BH_Natural_Fp_Counseled")
	public void setBH_Natural_Fp_CounseledInput(ForeignEntityInput BH_Natural_Fp_Counseled) {
		this.mBH_Natural_Fp_Counseled = BH_Natural_Fp_Counseled;
		if (BH_Natural_Fp_Counseled != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_NATURAL_FP_COUNSELED_UUIDS_BY_VALUE.containsValue(BH_Natural_Fp_Counseled.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Natural_Fp_Counseled.getUU() +
						" is not in the list defined for the BH_Natural_Fp_Counseled column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Natural_Fp_Counseled.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Natural_Fp_Counseled(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Natural_Fp_Counseled.getUU());
			}
		} else {
			this.setBH_Natural_Fp_Counseled(null);
		}
	}

	/**
	 * Get Natural FP Counseled.
	 *
	 * @return Natural FP Counseled
	 */
	@JsonProperty("BH_Natural_Fp_Counseled")
	public ForeignEntityInput BH_Natural_Fp_Counseled() {
		return mBH_Natural_Fp_Counseled;
	}

	/**
	 * Set Oral Type of Visit.
	 *
	 * @param BH_Oral_Type_Of_Visit Oral Type of Visit
	 */
	@JsonProperty("BH_Oral_Type_Of_Visit")
	public void setBH_Oral_Type_Of_VisitInput(ForeignEntityInput BH_Oral_Type_Of_Visit) {
		this.mBH_Oral_Type_Of_Visit = BH_Oral_Type_Of_Visit;
		if (BH_Oral_Type_Of_Visit != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_ORAL_TYPE_OF_VISIT_UUIDS_BY_VALUE.containsValue(BH_Oral_Type_Of_Visit.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Oral_Type_Of_Visit.getUU() +
						" is not in the list defined for the BH_Oral_Type_Of_Visit column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Oral_Type_Of_Visit.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Oral_Type_Of_Visit(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Oral_Type_Of_Visit.getUU());
			}
		} else {
			this.setBH_Oral_Type_Of_Visit(null);
		}
	}

	/**
	 * Get Oral Type of Visit.
	 *
	 * @return Oral Type of Visit
	 */
	@JsonProperty("BH_Oral_Type_Of_Visit")
	public ForeignEntityInput BH_Oral_Type_Of_Visit() {
		return mBH_Oral_Type_Of_Visit;
	}

	/**
	 * Set Postpartum FP.
	 *
	 * @param BH_Postpartum_Fp Postpartum FP
	 */
	@JsonProperty("BH_Postpartum_Fp")
	public void setBH_Postpartum_FpInput(ForeignEntityInput BH_Postpartum_Fp) {
		this.mBH_Postpartum_Fp = BH_Postpartum_Fp;
		if (BH_Postpartum_Fp != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_POSTPARTUM_FP_UUIDS_BY_VALUE.containsValue(BH_Postpartum_Fp.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Postpartum_Fp.getUU() +
						" is not in the list defined for the BH_Postpartum_Fp column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Postpartum_Fp.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Postpartum_Fp(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Postpartum_Fp.getUU());
			}
		} else {
			this.setBH_Postpartum_Fp(null);
		}
	}

	/**
	 * Get Postpartum FP.
	 *
	 * @return Postpartum FP
	 */
	@JsonProperty("BH_Postpartum_Fp")
	public ForeignEntityInput BH_Postpartum_Fp() {
		return mBH_Postpartum_Fp;
	}

	/**
	 * Set Referral Community From.
	 *
	 * @param BH_Referral_Community_From Referral Community From
	 */
	@JsonProperty("BH_Referral_Community_From")
	public void setBH_Referral_Community_FromInput(ForeignEntityInput BH_Referral_Community_From) {
		this.mBH_Referral_Community_From = BH_Referral_Community_From;
		if (BH_Referral_Community_From != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_REFERRAL_COMMUNITY_FROM_UUIDS_BY_VALUE.containsValue(BH_Referral_Community_From.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Referral_Community_From.getUU() +
						" is not in the list defined for the BH_Referral_Community_From column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Referral_Community_From.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Referral_Community_From(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Referral_Community_From.getUU());
			}
		} else {
			this.setBH_Referral_Community_From(null);
		}
	}

	/**
	 * Get Referral Community From.
	 *
	 * @return Referral Community From
	 */
	@JsonProperty("BH_Referral_Community_From")
	public ForeignEntityInput BH_Referral_Community_From() {
		return mBH_Referral_Community_From;
	}

	/**
	 * Set Referral Community To.
	 *
	 * @param BH_Referral_Community_To Referral Community To
	 */
	@JsonProperty("BH_Referral_Community_To")
	public void setBH_Referral_Community_ToInput(ForeignEntityInput BH_Referral_Community_To) {
		this.mBH_Referral_Community_To = BH_Referral_Community_To;
		if (BH_Referral_Community_To != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_REFERRAL_COMMUNITY_TO_UUIDS_BY_VALUE.containsValue(BH_Referral_Community_To.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Referral_Community_To.getUU() +
						" is not in the list defined for the BH_Referral_Community_To column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Referral_Community_To.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Referral_Community_To(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Referral_Community_To.getUU());
			}
		} else {
			this.setBH_Referral_Community_To(null);
		}
	}

	/**
	 * Get Referral Community To.
	 *
	 * @return Referral Community To
	 */
	@JsonProperty("BH_Referral_Community_To")
	public ForeignEntityInput BH_Referral_Community_To() {
		return mBH_Referral_Community_To;
	}

	/**
	 * Set Referrals.
	 *
	 * @param BH_Referrals Referrals
	 */
	@JsonProperty("BH_Referrals")
	public void setBH_ReferralsInput(ForeignEntityInput BH_Referrals) {
		this.mBH_Referrals = BH_Referrals;
		if (BH_Referrals != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_REFERRALS_UUIDS_BY_VALUE.containsValue(BH_Referrals.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Referrals.getUU() +
						" is not in the list defined for the BH_Referrals column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Referrals.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Referrals(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Referrals.getUU());
			}
		} else {
			this.setBH_Referrals(null);
		}
	}

	/**
	 * Get Referrals.
	 *
	 * @return Referrals
	 */
	@JsonProperty("BH_Referrals")
	public ForeignEntityInput BH_Referrals() {
		return mBH_Referrals;
	}

	/**
	 * Set TB Screening.
	 *
	 * @param BH_Tb_Screening TB Screening
	 */
	@JsonProperty("BH_Tb_Screening")
	public void setBH_Tb_ScreeningInput(ForeignEntityInput BH_Tb_Screening) {
		this.mBH_Tb_Screening = BH_Tb_Screening;
		if (BH_Tb_Screening != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_TB_SCREENING_UUIDS_BY_VALUE.containsValue(BH_Tb_Screening.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Tb_Screening.getUU() +
						" is not in the list defined for the BH_Tb_Screening column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Tb_Screening.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Tb_Screening(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Tb_Screening.getUU());
			}
		} else {
			this.setBH_Tb_Screening(null);
		}
	}

	/**
	 * Get TB Screening.
	 *
	 * @return TB Screening
	 */
	@JsonProperty("BH_Tb_Screening")
	public ForeignEntityInput BH_Tb_Screening() {
		return mBH_Tb_Screening;
	}
	/**
	 * Set Visit Family Planning.
	 *
	 * @param BH_Visit_Family_Planning_ID Visit Family Planning
	 */
	@JsonProperty("BH_Visit_Family_Planning_ID")
	public void setBH_Visit_Family_Planning_IDFromJson(int BH_Visit_Family_Planning_ID) {
		if (get_ID() == 0) {
			super.setBH_Visit_Family_Planning_ID(BH_Visit_Family_Planning_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Visit_Family_Planning_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Visit_Family_Planning_UU();
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	@JsonProperty("BH_Visit")
	public void setBH_VisitInput(ForeignEntityInput BH_Visit) {
		this.mBH_Visit = BH_Visit;
		if (BH_Visit != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVisit foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Visit", "BH_Visit_UU=?", get_TrxName())
							.setParameters(BH_Visit.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Visit_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Visit with UU " + BH_Visit.getUU());
			}
		} else {
			this.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	@JsonProperty("BH_Visit")
	public ForeignEntityInput BH_Visit() {
		return mBH_Visit;
	}

	/**
	 * Set VSC Given.
	 *
	 * @param BH_Vsc_Given VSC Given
	 */
	@JsonProperty("BH_Vsc_Given")
	public void setBH_Vsc_GivenInput(ForeignEntityInput BH_Vsc_Given) {
		this.mBH_Vsc_Given = BH_Vsc_Given;
		if (BH_Vsc_Given != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Visit_Family_PlanningResolver.BH_VSC_GIVEN_UUIDS_BY_VALUE.containsValue(BH_Vsc_Given.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Vsc_Given.getUU() +
						" is not in the list defined for the BH_Vsc_Given column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Vsc_Given.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Vsc_Given(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Vsc_Given.getUU());
			}
		} else {
			this.setBH_Vsc_Given(null);
		}
	}

	/**
	 * Get VSC Given.
	 *
	 * @return VSC Given
	 */
	@JsonProperty("BH_Vsc_Given")
	public ForeignEntityInput BH_Vsc_Given() {
		return mBH_Vsc_Given;
	}
}
