package org.bandahealth.idempiere.report.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class PatientSummaryReportTest extends ChuBoePopulateFactoryVO {

	private static final String patientSummaryReportUU = "c0e1adfc-f743-49e4-9346-4da29f1e9f6c";

	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void canGeneratePatientSummaryReportWithPatientAndVisitDetails() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		String uniqueToken = String.valueOf(valueObject.getRandomNumber());
		valueObject.getBusinessPartner().setName("PatientSummary " + uniqueToken);
		valueObject.getBusinessPartner().setBH_PatientID("PID-" + uniqueToken);
		valueObject.getBusinessPartner().setBH_Phone("0700" + uniqueToken.substring(0, Math.min(6, uniqueToken.length())));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setName("Service " + uniqueToken);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setbh_referral("Referral reason " + uniqueToken);
		valueObject.getVisit().setBH_ReferredFromTo("Referral destination " + uniqueToken);
		valueObject.getVisit().setBH_Clinician_User_ID(valueObject.getUser().get_ID());
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(2));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create coded diagnoses");
		MBHConcept primaryDiagnosis = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		primaryDiagnosis.setBH_Display_Name("PrimaryDx " + uniqueToken);
		primaryDiagnosis.setOcl_Uuid("primary-dx-" + uniqueToken);
		primaryDiagnosis.saveEx();
		String uncodedDiagnosis = "SecondaryDx " + uniqueToken;
		commitEx();

		valueObject.setStepName("Create clinical details encounter with diagnoses and notes");
		MBHEncounter clinicalEncounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		clinicalEncounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		clinicalEncounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		clinicalEncounter.setBH_Encounter_Date(TimestampUtils.today());
		clinicalEncounter.saveEx();
		MBHEncounterDiagnosis primaryEncounterDiagnosis =
				new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		primaryEncounterDiagnosis.setBH_Encounter_ID(clinicalEncounter.getBH_Encounter_ID());
		primaryEncounterDiagnosis.setBH_Concept_ID(primaryDiagnosis.get_ID());
		primaryEncounterDiagnosis.setLineNo(10);
		primaryEncounterDiagnosis.saveEx();
		MBHEncounterDiagnosis secondaryEncounterDiagnosis =
				new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		secondaryEncounterDiagnosis.setBH_Encounter_ID(clinicalEncounter.getBH_Encounter_ID());
		secondaryEncounterDiagnosis.setBH_Uncoded_Diagnosis(uncodedDiagnosis);
		secondaryEncounterDiagnosis.setLineNo(20);
		secondaryEncounterDiagnosis.saveEx();
		String clinicalNotes = "Patient presents with mild headache " + uniqueToken;
		int clinicalNotesFieldId = new Query(valueObject.getContext(), "AD_Field",
				"AD_Column_ID IN (SELECT AD_Column_ID FROM AD_Column WHERE AD_Column_UU=?)",
				valueObject.getTransactionName())
				.setParameters("9bcfded3-3af9-41d3-94ae-319d1859bb30")
				.firstId();
		MBHObservation clinicalNotesObs = new MBHObservation(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		clinicalNotesObs.setBH_Encounter_ID(clinicalEncounter.getBH_Encounter_ID());
		clinicalNotesObs.setAD_Field_ID(clinicalNotesFieldId);
		clinicalNotesObs.setBH_Value(clinicalNotes);
		clinicalNotesObs.saveEx();
		commitEx();

		valueObject.setStepName("Create chief complaint encounter with observation");
		MBHEncounter chiefComplaintEncounter =
				new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		chiefComplaintEncounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ChiefComplaint);
		chiefComplaintEncounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		chiefComplaintEncounter.setBH_Encounter_Date(TimestampUtils.today());
		chiefComplaintEncounter.saveEx();
		String chiefComplaintText = "Headache and fever " + uniqueToken;
		int chiefComplaintFieldId = new Query(valueObject.getContext(), "AD_Field",
				"AD_Field_UU=?", valueObject.getTransactionName())
				.setParameters("e1d01fe4-16b6-4125-a385-34cf4531c06f")
				.firstId();
		MBHObservation chiefComplaintObs = new MBHObservation(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		chiefComplaintObs.setBH_Encounter_ID(chiefComplaintEncounter.getBH_Encounter_ID());
		chiefComplaintObs.setAD_Field_ID(chiefComplaintFieldId);
		chiefComplaintObs.setBH_Value(chiefComplaintText);
		chiefComplaintObs.saveEx();
		commitEx();

		valueObject.setStepName("Create vitals encounter with observations");
		MBHEncounter vitalsEncounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		vitalsEncounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_CaptureVitals);
		vitalsEncounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		vitalsEncounter.setBH_Encounter_Date(TimestampUtils.today());
		vitalsEncounter.saveEx();
		String[][] vitalFields = {
				{"cd376ad7-d03b-4970-ab2b-34ef000b93f9", "120"},
				{"769b6475-1e35-4618-ad36-09fa0111affb", "80"},
				{"d3dc091f-ee3d-4607-91d1-4e766cfe5528", "37.2"},
				{"c0f0f904-4977-4360-8065-a0e91d4f3a71", "78"},
				{"7bb73318-f6cc-4540-85d7-69672a18cc5f", "98"},
				{"87183dfb-1b7d-4c18-b350-593e576bb49b", "18"},
		};
		for (String[] vitalField : vitalFields) {
			int fieldId = new Query(valueObject.getContext(), "AD_Field",
					"AD_Field_UU=?", valueObject.getTransactionName())
					.setParameters(vitalField[0])
					.firstId();
			MBHObservation vitalObs = new MBHObservation(valueObject.getContext(), 0,
					valueObject.getTransactionName());
			vitalObs.setBH_Encounter_ID(vitalsEncounter.getBH_Encounter_ID());
			vitalObs.setAD_Field_ID(fieldId);
			vitalObs.setBH_Value(vitalField[1]);
			vitalObs.saveEx();
		}
		commitEx();

		valueObject.setStepName("Generate the patient summary report");
		valueObject.setProcessUuid(patientSummaryReportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().getBH_Visit_UU(), null, null, null)));
		valueObject.setReportType("pdf");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);

		assertThat("Full name label is shown", reportContent, containsString("Full Name:"));
		assertThat("Patient full name is shown", reportContent,
				containsString(valueObject.getBusinessPartner().getName()));

		assertThat("Patient number label is shown", reportContent, containsString("IP / OP Number:"));
		assertThat("Patient number is shown", reportContent, containsString(valueObject.getVisit().getDocumentNo()));

		assertThat("Age label is shown", reportContent, containsString("Age:"));
		assertThat("National ID label is shown", reportContent, containsString("ID/Passport No:"));
		assertThat("National ID value is shown", reportContent,
				containsString(valueObject.getBusinessPartner().getBH_PatientID()));
		assertThat("Contact number label is shown", reportContent, containsString("Contact Number:"));
		assertThat("Contact number value is shown", reportContent,
				containsString(valueObject.getBusinessPartner().getBH_Phone()));

		assertThat("Vitals section is shown", reportContent, containsString("Vitals:"));
		assertThat("Blood pressure is shown", reportContent, containsString("120/80"));
		assertThat("Temperature is shown", reportContent, containsString("37.2"));
		assertThat("Pulse is shown", reportContent, containsString("78"));
		assertThat("SpO2 is shown", reportContent, containsString("98"));
		assertThat("Respiratory rate is shown", reportContent, containsString("18"));

		assertThat("Chief complaint label is shown", reportContent, containsString("Chief Complaint (Reason for Visit):"));
		assertThat("Chief complaint value is shown", reportContent, containsString(chiefComplaintText));

		assertThat("Brief history label is shown", reportContent, containsString("Brief History & Physical Findings:"));
		assertThat("Clinical notes value is shown", reportContent, containsString(clinicalNotes));

		assertThat("Primary diagnosis label is shown", reportContent, containsString("Primary Diagnosis:"));
		assertThat("Primary diagnosis value is shown", reportContent,
				containsString(primaryDiagnosis.getBH_Display_Name()));
		assertThat("Secondary diagnosis label is shown", reportContent, containsString("Secondary Diagnosis:"));
		assertThat("Secondary diagnosis value is shown", reportContent, containsString(uncodedDiagnosis));

		assertThat("Products/services section is shown", reportContent,
				containsString("Medication / Management Provided:"));
		assertThat("Products/services on visit are shown", reportContent, containsString("Service " + uniqueToken));

		assertThat("Referral information is shown", reportContent, containsString("Referred To:"));
		assertThat("Referral destination is shown", reportContent, containsString("Referral destination " + uniqueToken));

		assertThat("Clinician information is shown", reportContent, containsString("Clinician Name:"));
		assertThat("Clinician name value is shown", reportContent, containsString(valueObject.getUser().getName()));
	}
}
