package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
		valueObject.getUser().load(valueObject.getTransactionName());
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
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(valueObject.getReport()))) {
			Sheet sheet = workbook.getSheetAt(0);

			assertThat("Full name is shown",
					hasCellContaining(sheet, valueObject.getBusinessPartner().getName()), is(true));
			assertThat("Patient number is shown",
					hasCellContaining(sheet, valueObject.getVisit().getDocumentNo()), is(true));
			assertThat("Age label is shown", hasCellContaining(sheet, "Age:"), is(true));
			assertThat("National ID is shown",
					hasCellContaining(sheet, valueObject.getBusinessPartner().getBH_PatientID()), is(true));
			assertThat("Contact number is shown",
					hasCellContaining(sheet, valueObject.getBusinessPartner().getBH_Phone()), is(true));

			assertThat("Vitals section is shown", hasCellContaining(sheet, "Vitals:"), is(true));
			assertThat("Blood pressure is shown", hasCellContaining(sheet, "120/80"), is(true));
			assertThat("Temperature is shown", hasCellContaining(sheet, "37.2"), is(true));
			assertThat("Pulse is shown", hasCellContaining(sheet, "78"), is(true));
			assertThat("SpO2 is shown", hasCellContaining(sheet, "98"), is(true));
			assertThat("Respiratory rate is shown", hasCellContaining(sheet, "18"), is(true));

			assertThat("Chief complaint label is shown",
					hasCellContaining(sheet, "Chief Complaint (Reason for Visit):"), is(true));
			assertThat("Chief complaint value is shown",
					hasCellContaining(sheet, chiefComplaintText), is(true));
			assertThat("Brief history label is shown",
					hasCellContaining(sheet, "Brief History & Physical Findings:"), is(true));
			assertThat("Clinical notes value is shown",
					hasCellContaining(sheet, clinicalNotes), is(true));

			assertThat("Primary diagnosis is shown",
					hasCellContaining(sheet, primaryDiagnosis.getBH_Display_Name()), is(true));
			assertThat("Secondary diagnosis is shown",
					hasCellContaining(sheet, uncodedDiagnosis), is(true));

			assertThat("Products/services section is shown",
					hasCellContaining(sheet, "Medication / Management Provided"), is(true));
			assertThat("Products/services on visit are shown",
					hasCellContaining(sheet, "Service " + uniqueToken), is(true));

			assertThat("Clinician name is shown",
					hasCellContaining(sheet, valueObject.getUser().getName()), is(true));
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportShowsAgeInYearsForPatientOlderThanTwoYears() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(TimestampUtils.addToNow(Calendar.YEAR, -5));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		try (Workbook workbook = generateReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in years", hasAgeCellContaining(sheet, "5 years"), is(true));
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportShowsAgeInMonthsForPatientYoungerThanTwoYears() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(TimestampUtils.addToNow(Calendar.MONTH, -6));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		try (Workbook workbook = generateReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in months", hasAgeCellContaining(sheet, "6 months"), is(true));
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportShowsAgeInWeeksAndDaysForPatientYoungerThanTwoMonths() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, -20));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		try (Workbook workbook = generateReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in weeks and days", hasAgeCellContaining(sheet, "2 weeks, 6 days"), is(true));
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportShowsAgeInDaysForPatientYoungerThanFifteenDays() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, -10));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		try (Workbook workbook = generateReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in days", hasAgeCellContaining(sheet, "10 days"), is(true));
		}
	}

	private Workbook generateReportForVisit(ChuBoePopulateVO valueObject) throws SQLException, IOException {
		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Generate report");
		valueObject.setProcessUuid(patientSummaryReportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().getBH_Visit_UU(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		return new XSSFWorkbook(new FileInputStream(valueObject.getReport()));
	}

	private boolean hasCellContaining(Sheet sheet, String text) {
		return StreamSupport.stream(sheet.spliterator(), false).anyMatch(
				row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
						cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
								cell.getStringCellValue().contains(text)));
	}

	private boolean hasAgeCellContaining(Sheet sheet, String expectedAge) {
		return StreamSupport.stream(sheet.spliterator(), false).anyMatch(
				row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
						cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
								cell.getStringCellValue().contains("Age:") &&
								cell.getStringCellValue().contains(expectedAge)));
	}
}
