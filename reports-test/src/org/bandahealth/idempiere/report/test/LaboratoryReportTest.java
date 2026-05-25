package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaboratoryReportTest extends ChuBoePopulateFactoryVO {

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
	public void canRunReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		String patientNameSuffix = String.valueOf(valueObject.getRandomNumber());
		commitEx();

		valueObject.setStepName("Create attribute set to track expirations");
		MAttributeSet_BH attributeSet = new MAttributeSet_BH(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		attributeSet.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		attributeSet.setName(valueObject.getScenarioName());
		attributeSet.setDescription(valueObject.getScenarioName());
		attributeSet.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesStandardPrice(new BigDecimal(50));
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setM_AttributeSet_ID(attributeSet.get_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create valid attribute set instance");
		MAttributeSetInstance_BH
				validAttributeSetInstance =
				new MAttributeSetInstance_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		validAttributeSetInstance.setM_AttributeSet_ID(attributeSet.get_ID());
		validAttributeSetInstance.setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		validAttributeSetInstance.setDescription(valueObject.getScenarioName());
		validAttributeSetInstance.saveEx();
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setAttributeSetInstance(validAttributeSetInstance);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().setQty(new BigDecimal(10));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostic concept");
		valueObject.setRandom();
		MBHConcept diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		String diagnosticName = diagnostic.getBH_Display_Name();
		diagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "positive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		order.setSalesRep_ID(valueObject.getUser().get_ID());
		order.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("1a7175fe-2afe-4404-9c56-58d2fda9bc57");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));
		commitEx();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("The patient's name is on the report", reportContent, containsString(patientNameSuffix));
		assertThat("The diagnostic is on the report", reportContent, containsString(diagnosticName));
		assertThat("The diagnostic value is on the report", reportContent, containsString(diagnosticValue));
		assertThat("Served By is on the report", reportContent,
				containsString(valueObject.getUser().getName().substring(0, 20)));
	}

	@IPopulateAnnotation.CanRun
	public void testStatusDisplaysCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().setQty(new BigDecimal(10));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostic concept");
		valueObject.setRandom();
		MBHConcept diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create concept extra");
		valueObject.setRandom();
		MBHConceptExtra conceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptExtra.setBH_Key("hi_normal");
		conceptExtra.setBH_Value("5");
		conceptExtra.setBH_Concept_ID(diagnostic.getBH_Concept_ID());
		conceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "10";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		order.setSalesRep_ID(valueObject.getUser().get_ID());
		order.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("1a7175fe-2afe-4404-9c56-58d2fda9bc57");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Status");
			int statusColumnIndex = TableUtils.getColumnIndex(headerRow, "Status");

			List<Row> testRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(statusColumnIndex) != null &&
							row.getCell(statusColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(statusColumnIndex).getStringCellValue().contains("High")).collect(Collectors.toList());
			assertFalse(testRows.isEmpty(), "Status message appears");
		}
	}

	@IPopulateAnnotation.CanRun
	public void clientReferenceRangesAreRespected() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().setQty(new BigDecimal(10));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostic concept");
		valueObject.setRandom();
		MBHConcept diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create low concept extra");
		valueObject.setRandom();
		MBHConceptExtra conceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptExtra.setBH_Key("low_normal");
		conceptExtra.setBH_Value("5");
		conceptExtra.setBH_Concept_ID(diagnostic.getBH_Concept_ID());
		conceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create high concept extra");
		valueObject.setRandom();
		conceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptExtra.setBH_Key("hi_normal");
		conceptExtra.setBH_Value("10");
		conceptExtra.setBH_Concept_ID(diagnostic.getBH_Concept_ID());
		conceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		commitEx();

		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value("7");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		order.setSalesRep_ID(valueObject.getUser().get_ID());
		order.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("1a7175fe-2afe-4404-9c56-58d2fda9bc57");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "REFERENCE RANGE");
			int referenceRangeColumnIndex = TableUtils.getColumnIndex(headerRow, "REFERENCE RANGE");
			int statusColumnIndex = TableUtils.getColumnIndex(headerRow, "STATUS");

			Optional<Row> testRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(referenceRangeColumnIndex) != null &&
							row.getCell(referenceRangeColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(referenceRangeColumnIndex).getStringCellValue().equals("5 - 10")).findFirst();
			assertTrue(testRow.isPresent(), "Reference range is correct");
			assertEquals("Normal", testRow.get().getCell(statusColumnIndex).getStringCellValue(),
					"Status message is correct");
		}

		valueObject.setStepName("Create high normal override");
		MBHClientConceptExtra clientConceptExtra =
				new MBHClientConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		clientConceptExtra.setBH_Concept_Extra_ID(conceptExtra.get_ID());
		clientConceptExtra.setBH_Value("6");
		clientConceptExtra.saveEx();
		commitEx();

		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "REFERENCE RANGE");
			int referenceRangeColumnIndex = TableUtils.getColumnIndex(headerRow, "REFERENCE RANGE");
			int statusColumnIndex = TableUtils.getColumnIndex(headerRow, "STATUS");

			Optional<Row> testRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(referenceRangeColumnIndex) != null &&
							row.getCell(referenceRangeColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(referenceRangeColumnIndex).getStringCellValue().equals("5 - 6")).findFirst();
			assertTrue(testRow.isPresent(), "Reference range is correct");
			assertEquals("High", testRow.get().getCell(statusColumnIndex).getStringCellValue(),
					"Status message is correct");
		}

		clientConceptExtra.setBH_Value(null);
		clientConceptExtra.saveEx();
		commitEx();

		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "REFERENCE RANGE");
			int referenceRangeColumnIndex = TableUtils.getColumnIndex(headerRow, "REFERENCE RANGE");
			int statusColumnIndex = TableUtils.getColumnIndex(headerRow, "STATUS");

			Optional<Row> testRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(referenceRangeColumnIndex) != null &&
							row.getCell(referenceRangeColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(referenceRangeColumnIndex).getStringCellValue().equals("> 5")).findFirst();
			assertTrue(testRow.isPresent(), "Reference range is correct");
			assertEquals("Normal", testRow.get().getCell(statusColumnIndex).getStringCellValue(),
					"Status message is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void mappedTestWithBothReferenceRangesAppearsOnceOnReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().setQty(new BigDecimal(10));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostic concept");
		valueObject.setRandom();
		MBHConcept diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		diagnostic.setBH_Display_Name("Blood Glucose " + valueObject.getRandomNumber());
		diagnostic.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		String diagnosticName = diagnostic.getBH_Display_Name();
		diagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create concept mapping");
		valueObject.setRandom();
		MBHConcept fromConcept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		fromConcept.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		fromConcept.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		fromConcept.saveEx();
		MBHConceptMapping conceptMapping = new MBHConceptMapping(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptMapping.setTo_BH_Concept_ID(diagnostic.getBH_Concept_ID());
		conceptMapping.setFrom_BH_Concept_ID(fromConcept.getBH_Concept_ID());
		conceptMapping.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		conceptMapping.saveEx();
		commitEx();

		MBHConceptExtra lowConceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		lowConceptExtra.setBH_Key("low_normal");
		lowConceptExtra.setBH_Value("70");
		lowConceptExtra.setBH_Concept_Mapping_ID(conceptMapping.getBH_Concept_Mapping_ID());
		lowConceptExtra.saveEx();

		MBHConceptExtra highConceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		highConceptExtra.setBH_Key("hi_normal");
		highConceptExtra.setBH_Value("110");
		highConceptExtra.setBH_Concept_Mapping_ID(conceptMapping.getBH_Concept_Mapping_ID());
		highConceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_LabDiagnostics);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value("95");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		order.setSalesRep_ID(valueObject.getUser().get_ID());
		order.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("1a7175fe-2afe-4404-9c56-58d2fda9bc57");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(valueObject.getReport()))) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "REFERENCE RANGE");
			int nameColumnIndex = TableUtils.getColumnIndex(headerRow, "NAME");

			long testNameOccurrences = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(nameColumnIndex) != null &&
							row.getCell(nameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(nameColumnIndex).getStringCellValue().equals(diagnosticName)).count();
			assertEquals(1, testNameOccurrences, "Blood Glucose-style mapped test appears once on the lab report");
		}
	}

	@IPopulateAnnotation.CanRun
	public void clientReferenceRangesFromMappingsAreRespected() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().setQty(new BigDecimal(10));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create 'from' concept");
		valueObject.setRandom();
		MBHConcept randomConcept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		randomConcept.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		randomConcept.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		randomConcept.saveEx();
		commitEx();

		valueObject.setStepName("Create diagnostic concept");
		valueObject.setRandom();
		MBHConcept diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create concept mapping");
		valueObject.setRandom();
		MBHConceptMapping conceptMapping = new MBHConceptMapping(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptMapping.setTo_BH_Concept_ID(diagnostic.getBH_Concept_ID());
		conceptMapping.setFrom_BH_Concept_ID(randomConcept.getBH_Concept_ID());
		conceptMapping.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		conceptMapping.saveEx();
		commitEx();

		valueObject.setStepName("Create low concept extra");
		valueObject.setRandom();
		MBHConceptExtra conceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptExtra.setBH_Key("low_normal");
		conceptExtra.setBH_Value("5");
		conceptExtra.setBH_Concept_Mapping_ID(conceptMapping.getBH_Concept_Mapping_ID());
		conceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create high concept extra");
		valueObject.setRandom();
		conceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptExtra.setBH_Key("hi_normal");
		conceptExtra.setBH_Value("10");
		conceptExtra.setBH_Concept_Mapping_ID(conceptMapping.getBH_Concept_Mapping_ID());
		conceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		commitEx();

		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value("7");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		order.setSalesRep_ID(valueObject.getUser().get_ID());
		order.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("1a7175fe-2afe-4404-9c56-58d2fda9bc57");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "REFERENCE RANGE");
			int referenceRangeColumnIndex = TableUtils.getColumnIndex(headerRow, "REFERENCE RANGE");
			int statusColumnIndex = TableUtils.getColumnIndex(headerRow, "STATUS");

			Optional<Row> testRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(referenceRangeColumnIndex) != null &&
							row.getCell(referenceRangeColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(referenceRangeColumnIndex).getStringCellValue().equals("5 - 10")).findFirst();
			assertTrue(testRow.isPresent(), "Reference range is correct");
			assertEquals("Normal", testRow.get().getCell(statusColumnIndex).getStringCellValue(),
					"Status message is correct");
		}

		valueObject.setStepName("Create high normal override");
		MBHClientConceptExtra clientConceptExtra =
				new MBHClientConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		clientConceptExtra.setBH_Concept_Extra_ID(conceptExtra.get_ID());
		clientConceptExtra.setBH_Value("6");
		clientConceptExtra.saveEx();
		commitEx();

		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "REFERENCE RANGE");
			int referenceRangeColumnIndex = TableUtils.getColumnIndex(headerRow, "REFERENCE RANGE");
			int statusColumnIndex = TableUtils.getColumnIndex(headerRow, "STATUS");

			Optional<Row> testRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(referenceRangeColumnIndex) != null &&
							row.getCell(referenceRangeColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(referenceRangeColumnIndex).getStringCellValue().equals("5 - 6")).findFirst();
			assertTrue(testRow.isPresent(), "Reference range is correct");
			assertEquals("High", testRow.get().getCell(statusColumnIndex).getStringCellValue(),
					"Status message is correct");
		}

		clientConceptExtra.setBH_Value(null);
		clientConceptExtra.saveEx();
		commitEx();

		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "REFERENCE RANGE");
			int referenceRangeColumnIndex = TableUtils.getColumnIndex(headerRow, "REFERENCE RANGE");
			int statusColumnIndex = TableUtils.getColumnIndex(headerRow, "STATUS");

			Optional<Row> testRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(referenceRangeColumnIndex) != null &&
							row.getCell(referenceRangeColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(referenceRangeColumnIndex).getStringCellValue().equals("> 5")).findFirst();
			assertTrue(testRow.isPresent(), "Reference range is correct");
			assertEquals("Normal", testRow.get().getCell(statusColumnIndex).getStringCellValue(),
					"Status message is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void labNotesAreDisplayedCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().setQty(new BigDecimal(10));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostic concept");
		valueObject.setRandom();
		MBHConcept diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create concept extra");
		valueObject.setRandom();
		MBHConceptExtra conceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptExtra.setBH_Key("hi_normal");
		conceptExtra.setBH_Value("5");
		conceptExtra.setBH_Concept_ID(diagnostic.getBH_Concept_ID());
		conceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "10";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setBH_Diagnostic_Note("Are within range");
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		order.setSalesRep_ID(valueObject.getUser().get_ID());
		order.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("1a7175fe-2afe-4404-9c56-58d2fda9bc57");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> notesRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Are within range"))).findFirst();
			assertTrue(notesRow.isPresent(), "Notes Appear");
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

		try (Workbook workbook = generateLabReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in years next to label", hasRowContaining(sheet, "Age:", "5 years"), is(true));
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

		try (Workbook workbook = generateLabReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in months next to label", hasRowContaining(sheet, "Age:", "6 months"), is(true));
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

		try (Workbook workbook = generateLabReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in weeks and days next to label",
					hasRowContaining(sheet, "Age:", "2 weeks, 6 days"), is(true));
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

		try (Workbook workbook = generateLabReportForVisit(valueObject)) {
			Sheet sheet = workbook.getSheetAt(0);
			assertThat("Age displays in days next to label", hasRowContaining(sheet, "Age:", "10 days"), is(true));
		}
	}

	private Workbook generateLabReportForVisit(ChuBoePopulateVO valueObject) throws SQLException, IOException {
		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrderLine().setPrice(new BigDecimal(20));
		valueObject.getOrderLine().setQty(new BigDecimal(10));
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostic concept");
		valueObject.setRandom();
		MBHConcept diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		diagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value("positive");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		order.setSalesRep_ID(valueObject.getUser().get_ID());
		order.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("1a7175fe-2afe-4404-9c56-58d2fda9bc57");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		return new XSSFWorkbook(new FileInputStream(valueObject.getReport()));
	}

	private boolean hasRowContaining(Sheet sheet, String label, String value) {
		return StreamSupport.stream(sheet.spliterator(), false).anyMatch(row -> {
			boolean hasLabel = StreamSupport.stream(row.spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().contains(label));
			boolean hasValue = StreamSupport.stream(row.spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().contains(value));
			return hasLabel && hasValue;
		});
	}
}
