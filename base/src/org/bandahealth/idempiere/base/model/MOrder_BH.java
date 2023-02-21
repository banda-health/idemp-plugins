package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MOrder;
import org.compiere.model.MProject;
import org.compiere.util.Env;

public class MOrder_BH extends MOrder {
	/**
	 * Column name bh_isexpense
	 */
	public static final String COLUMNNAME_BH_IsExpense = "BH_isexpense";
	public static final String COLUMNNAME_BH_NEWVISIT = "bh_newvisit";
	public static final String COLUMNNAME_BH_CHIEF_COMPLAINT = "BH_ChiefComplaint";
	public static final String COLUMNNAME_BH_TEMPERATURE = "BH_Temperature";
	public static final String COLUMNNAME_BH_PULSE = "BH_Pulse";
	public static final String COLUMNNAME_BH_RESPIRATORY_RATE = "BH_RespiratoryRate";
	public static final String COLUMNNAME_BH_BLOOD_PRESSURE = "BH_BloodPressure";
	public static final String COLUMNNAME_BH_HEIGHT = "BH_Height";
	public static final String COLUMNNAME_BH_WEIGHT = "BH_Weight";
	/**
	 * Column name BH_Clinician_User_ID
	 */
	public static final String COLUMNNAME_BH_Clinician_User_ID = "BH_Clinician_User_ID";
	public static final String COLUMNNAME_BH_PROCESS_STAGE = "BH_Process_Stage";
	public static final String COLUMNNAME_BH_PRIMARY_CODED_DIAGNOSIS_ID = "BH_PrimaryCodedDiagnosis_ID";
	public static final String COLUMNNAME_BH_SECONDARY_CODED_DIAGNOSIS_ID = "BH_SecondaryCodedDiagnosis_ID";
	public static final String COLUMNNAME_BH_PRIMARY_UNCODED_DIAGNOSIS = "BH_PrimaryUncodedDiagnosis"; // previously
	// Description
	public static final String COLUMNNAME_BH_SECONDARY_UNCODED_DIAGNOSIS = "BH_SecondaryUncodedDiagnosis"; // previously
	// bh_seconddiagnosis
	public static final String COLUMNNAME_BH_VOIDED_REASON_ID = "BH_Voided_Reason_ID";
	/**
	 * Column name BH_OxygenSaturation
	 */
	public static final String COLUMNNAME_BH_OxygenSaturation = "BH_OxygenSaturation";

	/**
	 * Column name bh_referral
	 */
	public static final String COLUMNNAME_bh_referral = "bh_referral";

	/**
	 * Column name BH_ClinicalNotes
	 */
	public static final String COLUMNNAME_BH_ClinicalNotes = "BH_ClinicalNotes";

	/**
	 * Column name BH_LabNotes
	 */
	public static final String COLUMNNAME_BH_LabNotes = "BH_LabNotes";

	/**
	 * Column name BH_PatientType
	 */
	public static final String COLUMNNAME_BH_PatientType = "BH_PatientType";
	/**
	 * Referral from health facilities = hf
	 */
	public static final String BH_REFERRAL_ReferralFromHealthFacilities = "hf";
	/**
	 * Referral to other health facility = OHF
	 */
	public static final String BH_REFERRAL_ReferralToOtherHealthFacility = "OHF";
	/**
	 * Referral from Community Unit = fcu
	 */
	public static final String BH_REFERRAL_ReferralFromCommunityUnit = "fcu";
	/**
	 * Referral to Community Unit = tcu
	 */
	public static final String BH_REFERRAL_ReferralToCommunityUnit = "tcu";
	/**
	 * Outpatient (OPD) = O
	 */
	public static final String BH_PATIENTTYPE_OutpatientOPD = "O";
	/**
	 * Inpatient (IPD) = I
	 */
	public static final String BH_PATIENTTYPE_InpatientIPD = "I";
	/**
	 * Column name BH_ReferredFromTo
	 */
	public static final String COLUMNNAME_BH_ReferredFromTo = "BH_ReferredFromTo";

	/**
	 * Column name BH_VisitDate
	 */
	public static final String COLUMNNAME_BH_VisitDate = "BH_VisitDate";

	/**
	 * Column name bh_systolic_blood_pressure
	 */
	public static final String COLUMNNAME_bh_systolic_blood_pressure = "bh_systolic_blood_pressure";
	/**
	 * Column name bh_diastolic_blood_pressure
	 */
	public static final String COLUMNNAME_bh_diastolic_blood_pressure = "bh_diastolic_blood_pressure";
	private static final long serialVersionUID = 1L;

	public MOrder_BH(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
	}

	public MOrder_BH(MProject project, boolean IsSOTrx, String DocSubTypeSO) {
		super(project, IsSOTrx, DocSubTypeSO);
	}

	public MOrder_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Set BH_IsExpense.
	 *
	 * @param BH_IsExpense BH_IsExpense
	 */
	public void setBH_IsExpense(Boolean BH_IsExpense) {
		set_Value(COLUMNNAME_BH_IsExpense, BH_IsExpense);
	}

	/**
	 * Get BH_IsExpense.
	 *
	 * @return BH_IsExpense
	 */
	public Boolean isBH_IsExpense() {
		Object oo = get_Value(COLUMNNAME_BH_IsExpense);
		if (oo != null) {
			if (oo instanceof Boolean)
				return ((Boolean) oo).booleanValue();
			return "Y".equals(oo);
		}
		return null;
	}

	public boolean isBH_NewVisit() {
		Object oo = get_Value(COLUMNNAME_BH_NEWVISIT);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}

	public void setBH_NewVisit(boolean newVisit) {
		set_Value(COLUMNNAME_BH_NEWVISIT, newVisit);
	}

	public String getBH_Chief_Complaint() {
		return (String) get_Value(COLUMNNAME_BH_CHIEF_COMPLAINT);
	}

	public void setBH_Chief_Complaint(String BH_Chief_Complaint) {
		set_Value(COLUMNNAME_BH_CHIEF_COMPLAINT, BH_Chief_Complaint);
	}

	public String getBH_Temperature() {
		return (String) get_Value(COLUMNNAME_BH_TEMPERATURE);
	}

	public void setBH_Temperature(String BH_Temperature) {
		set_Value(COLUMNNAME_BH_TEMPERATURE, BH_Temperature);
	}

	public String getBH_Pulse() {
		return (String) get_Value(COLUMNNAME_BH_PULSE);
	}

	public void setBH_Pulse(String BH_Pulse) {
		set_Value(COLUMNNAME_BH_PULSE, BH_Pulse);
	}

	public String getBH_Respiratory_Rate() {
		return (String) get_Value(COLUMNNAME_BH_RESPIRATORY_RATE);
	}

	public void setBH_Respiratory_Rate(String BH_Respiratory_Rate) {
		set_Value(COLUMNNAME_BH_RESPIRATORY_RATE, BH_Respiratory_Rate);
	}

	public String getBH_Blood_Pressure() {
		return (String) get_Value(COLUMNNAME_BH_BLOOD_PRESSURE);
	}

	public void setBH_Blood_Pressure(String BH_Blood_Pressure) {
		set_Value(COLUMNNAME_BH_BLOOD_PRESSURE, BH_Blood_Pressure);
	}

	public String getBH_Height() {
		return (String) get_Value(COLUMNNAME_BH_HEIGHT);
	}

	public void setBH_Height(String BH_Height) {
		set_Value(COLUMNNAME_BH_HEIGHT, BH_Height);
	}

	public String getBH_Weight() {
		return (String) get_Value(COLUMNNAME_BH_WEIGHT);
	}

	public void setBH_Weight(String BH_Weight) {
		set_Value(COLUMNNAME_BH_WEIGHT, BH_Weight);
	}

	public int getBH_PrimaryCodedDiagnosisID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_PRIMARY_CODED_DIAGNOSIS_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public void setBH_PrimaryCodedDiagnosisID(int BH_PrimaryDiagnosis_ID) {
		if (BH_PrimaryDiagnosis_ID < 1) {
			set_Value(COLUMNNAME_BH_PRIMARY_CODED_DIAGNOSIS_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_PRIMARY_CODED_DIAGNOSIS_ID, Integer.valueOf(BH_PrimaryDiagnosis_ID));
		}
	}

	public String getBH_PrimaryUnCodedDiagnosis() {
		return (String) get_Value(COLUMNNAME_BH_PRIMARY_UNCODED_DIAGNOSIS);
	}

	public void setBH_PrimaryUnCodedDiagnosis(String BH_PrimaryUncodedDiagnosis) {
		set_Value(COLUMNNAME_BH_PRIMARY_UNCODED_DIAGNOSIS, BH_PrimaryUncodedDiagnosis);
	}

	public int getBH_SecondaryCodedDiagnosisID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_SECONDARY_CODED_DIAGNOSIS_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public void setBH_SecondaryCodedDiagnosisID(int BH_SecondaryDiagnosis_ID) {
		if (BH_SecondaryDiagnosis_ID < 1) {
			set_Value(COLUMNNAME_BH_SECONDARY_CODED_DIAGNOSIS_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_SECONDARY_CODED_DIAGNOSIS_ID, Integer.valueOf(BH_SecondaryDiagnosis_ID));
		}
	}

	public String getBH_SecondaryUnCodedDiagnosis() {
		return (String) get_Value(COLUMNNAME_BH_SECONDARY_UNCODED_DIAGNOSIS);
	}

	public void setBH_SecondaryUnCodedDiagnosis(String BH_SecondaryUncodedDiagnosis) {
		set_Value(COLUMNNAME_BH_SECONDARY_UNCODED_DIAGNOSIS, BH_SecondaryUncodedDiagnosis);
	}

	/**
	 * Set Referral.
	 *
	 * @param bh_referral Referral
	 */
	public void setbh_referral(String bh_referral) {

		set_Value(COLUMNNAME_bh_referral, bh_referral);
	}

	/**
	 * Get Referral.
	 *
	 * @return Referral
	 */
	public String getbh_referral() {
		return (String) get_Value(COLUMNNAME_bh_referral);
	}

	/**
	 * Get Clinical Notes.
	 *
	 * @return Clinical Notes
	 */
	public String getBH_ClinicalNotes() {
		return (String) get_Value(COLUMNNAME_BH_ClinicalNotes);
	}

	/**
	 * Set Clinical Notes.
	 *
	 * @param BH_ClinicalNotes Clinical Notes
	 */
	public void setBH_ClinicalNotes(String BH_ClinicalNotes) {
		set_Value(COLUMNNAME_BH_ClinicalNotes, BH_ClinicalNotes);
	}

	/**
	 * Get Lab Notes.
	 *
	 * @return Lab Notes
	 */
	public String getBH_LabNotes() {
		return (String) get_Value(COLUMNNAME_BH_LabNotes);
	}

	/**
	 * Set Lab Notes.
	 *
	 * @param BH_LabNotes Lab Notes
	 */
	public void setBH_LabNotes(String BH_LabNotes) {
		set_Value(COLUMNNAME_BH_LabNotes, BH_LabNotes);
	}

	/**
	 * Get Patient Type.
	 *
	 * @return Patient Type
	 */
	public String getBH_PatientType() {
		return (String) get_Value(COLUMNNAME_BH_PatientType);
	}

	/**
	 * Set Patient Type.
	 *
	 * @param BH_PatientType Patient Type
	 */
	public void setBH_PatientType(String BH_PatientType) {

		set_Value(COLUMNNAME_BH_PatientType, BH_PatientType);
	}

	/**
	 * Set BH_Clinician_User_ID.
	 *
	 * @param BH_Clinician_User_ID BH_Clinician_User_ID
	 */
	public void setBH_Clinician_User_ID(int BH_Clinician_User_ID) {
		if (BH_Clinician_User_ID < 1)
			set_Value(COLUMNNAME_BH_Clinician_User_ID, null);
		else
			set_Value(COLUMNNAME_BH_Clinician_User_ID, Integer.valueOf(BH_Clinician_User_ID));
	}

	/**
	 * Get BH_Clinician_User_ID.
	 *
	 * @return BH_Clinician_User_ID
	 */
	public int getBH_Clinician_User_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Clinician_User_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public String getBH_ProcessStage() {
		return (String) get_Value(COLUMNNAME_BH_PROCESS_STAGE);
	}

	public void setBH_ProcessStage(String BH_ProcessStage) {
		set_Value(COLUMNNAME_BH_PROCESS_STAGE, BH_ProcessStage);
	}

	/**
	 * Get Referred From/To.
	 *
	 * @return Referred From/To
	 */
	public String getBH_ReferredFromTo() {
		return (String) get_Value(COLUMNNAME_BH_ReferredFromTo);
	}

	/**
	 * Set Referred From/To.
	 *
	 * @param BH_ReferredFromTo Referred From/To
	 */
	public void setBH_ReferredFromTo(String BH_ReferredFromTo) {
		set_Value(COLUMNNAME_BH_ReferredFromTo, BH_ReferredFromTo);
	}

	/**
	 * Get Visit Date.
	 *
	 * @return Visit Date
	 */
	public Timestamp getBH_VisitDate() {
		return (Timestamp) get_Value(COLUMNNAME_BH_VisitDate);
	}

	/**
	 * Set Visit Date.
	 *
	 * @param BH_VisitDate Visit Date
	 */
	public void setBH_VisitDate(Timestamp BH_VisitDate) {
		set_Value(COLUMNNAME_BH_VisitDate, BH_VisitDate);
	}

	public int getBH_VoidedReasonID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_VOIDED_REASON_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public void setBH_VoidedReasonID(int BH_VoidedReason_ID) {
		if (BH_VoidedReason_ID < 1) {
			set_Value(COLUMNNAME_BH_VOIDED_REASON_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_VOIDED_REASON_ID, Integer.valueOf(BH_VoidedReason_ID));
		}
	}

	/**
	 * Set bh_systolic_blood_pressure.
	 *
	 * @param bh_systolic_blood_pressure bh_systolic_blood_pressure
	 */
	public void setbh_systolic_blood_pressure(int bh_systolic_blood_pressure) {
		set_Value(COLUMNNAME_bh_systolic_blood_pressure, Integer.valueOf(bh_systolic_blood_pressure));
	}

	/**
	 * Get bh_systolic_blood_pressure.
	 *
	 * @return bh_systolic_blood_pressure
	 */
	public int getbh_systolic_blood_pressure() {
		Integer ii = (Integer) get_Value(COLUMNNAME_bh_systolic_blood_pressure);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Set bh_diastolic_blood_pressure.
	 *
	 * @param bh_diastolic_blood_pressure bh_diastolic_blood_pressure
	 */
	public void setbh_diastolic_blood_pressure(int bh_diastolic_blood_pressure) {
		set_Value(COLUMNNAME_bh_diastolic_blood_pressure, Integer.valueOf(bh_diastolic_blood_pressure));
	}

	/**
	 * Get bh_diastolic_blood_pressure.
	 *
	 * @return bh_diastolic_blood_pressure
	 */
	public int getbh_diastolic_blood_pressure() {
		Integer ii = (Integer) get_Value(COLUMNNAME_bh_diastolic_blood_pressure);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Get Oxygen Saturation.
	 *
	 * @return Oxygen Saturation
	 */
	public BigDecimal getBH_OxygenSaturation() {
		BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_BH_OxygenSaturation);
		if (bd == null)
			return Env.ZERO;
		return bd;
	}

	/**
	 * Set Oxygen Saturation.
	 *
	 * @param BH_OxygenSaturation Oxygen Saturation
	 */
	public void setBH_OxygenSaturation(BigDecimal BH_OxygenSaturation) {
		set_Value(COLUMNNAME_BH_OxygenSaturation, BH_OxygenSaturation);
	}
}
