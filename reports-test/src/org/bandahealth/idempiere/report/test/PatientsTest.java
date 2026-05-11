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
import org.bandahealth.idempiere.base.model.MBHBPartnerTags;
import org.bandahealth.idempiere.base.model.MBHTag;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientsTest extends ChuBoePopulateFactoryVO {
	private static final String patientsReportUuid = "feaa97fb-b424-4dce-8790-035ba80ca023";

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
		ChuBoeCreateEntity.createPatient(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientsReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Row headerRow = TableUtils.getHeaderRow(sheet, "Patient Name");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");

			Optional<Row> patientRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).findFirst();
			assertTrue(patientRow.isPresent(), "Patient's name is on the report");
		}
	}

	@IPopulateAnnotation.CanRun
	public void patientsReportIsGeneratedCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner 1");
		ChuBoeCreateEntity.createPatient(valueObject);
		valueObject.getBusinessPartner().setTotalOpenBalance(new BigDecimal(1000));
		valueObject.getBusinessPartner().saveEx();
		String businessPartner1Name = valueObject.getBusinessPartner().getName();
		commitEx();

		valueObject.clearBusinessPartner();

		valueObject.setStepName("Create business partner 2 without group");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setTotalOpenBalance(new BigDecimal(1200));
		valueObject.getBusinessPartner().saveEx();
		String businessPartner2Name = valueObject.getBusinessPartner().getName();
		commitEx();

		valueObject.setStepName("Generate the report to get initial data");
		valueObject.setProcessUuid(patientsReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> patientRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains(businessPartner1Name)))
					.findFirst();
			Optional<Row> patientRow2 = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains(businessPartner2Name)))
					.findFirst();
			assertTrue(patientRow.isPresent(), "Patient is present");
			assertTrue(patientRow2.isEmpty(), "Business partner is not a patient");
		}
	}

	@IPopulateAnnotation.CanRun
	public void canFilterPatientsByTags() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner 1");
		ChuBoeCreateEntity.createPatient(valueObject);
		valueObject.getBusinessPartner().setTotalOpenBalance(new BigDecimal(1000));
		valueObject.getBusinessPartner().saveEx();
		String businessPartner1Name = valueObject.getBusinessPartner().getName();
		commitEx();

		valueObject.clearBusinessPartner();

		valueObject.setStepName("Create business partner 2");
		ChuBoeCreateEntity.createPatient(valueObject);
		valueObject.getBusinessPartner().setTotalOpenBalance(new BigDecimal(1200));
		valueObject.getBusinessPartner().saveEx();
		String businessPartner2Name = valueObject.getBusinessPartner().getName();
		commitEx();

		valueObject.setStepName("Create business partner tag");
		MBHTag tag = new MBHTag(valueObject.getContext(), 0, valueObject.getTransactionName());
		tag.setName(String.valueOf(valueObject.getRandomNumber()));
		tag.saveEx();
		MBHBPartnerTags businessPartnerTag =
				new MBHBPartnerTags(valueObject.getContext(), 0, valueObject.getTransactionName());
		businessPartnerTag.setC_BPartner_ID(valueObject.getBusinessPartner().get_ID());
		businessPartnerTag.setBH_Tag_ID(tag.get_ID());
		businessPartnerTag.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report to get initial data");
		valueObject.setProcessUuid(patientsReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		valueObject.setProcessInformationParameters(List.of(
				new ProcessInfoParameter("Patient Tags", Collections.singletonList(tag.getBH_Tag_UU()), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Optional<Row> patientRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains(businessPartner1Name)))
					.findFirst();
			Optional<Row> patientRow2 = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains(businessPartner2Name)))
					.findFirst();
			assertTrue(patientRow.isEmpty(), "Patient is present");
			assertTrue(patientRow2.isPresent(), "Business partner is present");
		}
	}
}
