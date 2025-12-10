package org.bandahealth.idempiere.report.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MProductCategory;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;

public class PrescriptionFormReportTest extends ChuBoePopulateFactoryVO {

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

		var adminUser = valueObject.getUser();

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		String patientNameSuffix = String.valueOf(valueObject.getRandomNumber());
		valueObject.getBusinessPartner().setName(patientNameSuffix + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().save();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		MProductCategory pharmacyProductCategory = new Query(valueObject.getContext(), MProductCategory.Table_Name,
				MProductCategory.COLUMNNAME_Name + "=?", valueObject.getTransactionName()).setParameters("Pharmacy")
				.setClient_ID().first();
		if (pharmacyProductCategory != null) {
			valueObject.getProduct().setM_Product_Category_ID(pharmacyProductCategory.get_ID());
			valueObject.getProduct().saveEx();
		}
		String productNameSuffix = String.valueOf(valueObject.getRandomNumber());
		valueObject.getProduct().setName(productNameSuffix + valueObject.getProduct().getName());
		valueObject.getProduct().save();
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create coded diagnosis");
		valueObject.setRandom();
		MBHConcept codedDiagnosis = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		codedDiagnosis.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		codedDiagnosis.setOcl_Uuid(String.valueOf(valueObject.getRandomNumber()));
		String diagnosisName = codedDiagnosis.getBH_Display_Name();
		codedDiagnosis.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		String nonCodedDiagnosis = "Malaria";
		commitEx();

		valueObject.setStepName("Create diagnoses");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis encounterDiagnosis = new MBHEncounterDiagnosis(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Uncoded_Diagnosis(nonCodedDiagnosis);
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.getOrder().setSalesRep_ID(adminUser.get_ID());
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("9fdbe1af-a79c-49ca-8081-0d32de89e053");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("The patient's name is on the report", reportContent, containsString(patientNameSuffix));
		assertFalse(reportContent.contains(diagnosisName), "The coded diagnosis is not on the report");
		assertFalse(reportContent.contains(nonCodedDiagnosis), "The non-coded diagnosis is not on the report");
		assertThat("Served By is on the report", reportContent, containsString(adminUser.getName()));
		assertThat("Product is on the report", reportContent, containsString(productNameSuffix));
	}

	@IPopulateAnnotation.CanRun
	public void orderLinesFromIncludedProductsDontAppear() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setName(valueObject.getBusinessPartner().getName().substring(0, 19));
		valueObject.getBusinessPartner().saveEx();
		valueObject.setRandom();
		commitEx();

		valueObject.setStepName("Create product 1");
		ChuBoeCreateEntity.createProduct(valueObject);
		MProduct_BH product1 = valueObject.getProduct();
		commitEx();

		valueObject.setStepName("Create purchase order 1");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt 1");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create product 2");
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order 2");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt 2");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		valueObject.setDateOffset(-21);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add included product");
		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(valueObject.getOrder().get_ID());
		orderLine.setM_Product_ID(product1.get_ID());
		orderLine.setC_UOM_ID(product1.getC_UOM_ID());
		orderLine.setQty(Env.ONE);
		orderLine.setHeaderInfo(valueObject.getOrder());
		orderLine.setIncluded_OrderLine_ID(valueObject.getOrderLine().get_ID());
		orderLine.setPrice(BigDecimal.ZERO);
		orderLine.saveEx();
		commitEx();

		valueObject.setStepName("Complete sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.getOrder().setDocAction(valueObject.getDocumentAction());
		valueObject.getOrder().processIt(valueObject.getDocumentAction());
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(50));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("9fdbe1af-a79c-49ca-8081-0d32de89e053");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				List.of(new ProcessInfoParameter("BH_Visit_UU", valueObject.getVisit().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> includedProductRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains(product1.getName()))).findFirst();
			assertTrue(includedProductRow.isEmpty(), "Included product is not on the report");
		}
	}
}
