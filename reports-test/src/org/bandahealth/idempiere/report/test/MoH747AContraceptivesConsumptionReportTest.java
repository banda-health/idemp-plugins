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
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.UUID.randomUUID;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoH747AContraceptivesConsumptionReportTest extends ChuBoePopulateFactoryVO {
	private static final String reportUU = "d5d7582e-8364-429c-a7e8-a11f2fcd3401";

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

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> titleRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Facility Contraceptives")))
					.findFirst();
			assertTrue(titleRow.isPresent(), "title is present");
		}
	}

	@IPopulateAnnotation.CanRun
	public void numbersAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		String combinedOralContraceptivePills = "Combined Oral contraceptive Pills";
		String progestinOnlyPills = "Progestin only pills";
		String dmpaIM = "DMPA-IM";
		String dmpaSC = "DMPA-SC";
		String implants1Rod = "Implants (1-Rod) - ENG 68mg";
		String implants2Rod3 = "Implants (2-Rod) - LNG 75mg (3 years)";
		String implants2Rod5 = "Implant (2-Rod) - LNG 75mg (5 years)";
		String nonHormonalIucd = "Non-Hormonal IUCD";
		String hormonalIucd = "Hormonal IUCD";
		String emergencyContraceptivePills = "Emergency Contraceptive pills";
		String maleCondoms = "Male Condoms";
		String femaleCondoms = "Female Condoms";
		String cycleBeads = "Cycle Beads";

		Timestamp startOfMonth = TimestampUtils.startOfMonth();
		Timestamp endOfMonth = TimestampUtils.endOfMonth();

		valueObject.setStepName("Generate the report for initial counts");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
						new ProcessInfoParameter("End Date", endOfMonth, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		Map<String, ConceptCounts> initialData = new HashMap<>();
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			List<Row> tableHeaderRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Contraceptive Method"))).collect(Collectors.toUnmodifiableList());
			assertEquals(2, tableHeaderRows.size(), "there are two table headers");

			List<Row> inventoryRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getRowNum() > tableHeaderRows.get(0).getRowNum() &&
							row.getRowNum() < tableHeaderRows.get(1).getRowNum()).collect(Collectors.toUnmodifiableList());
			List<Row> statisticsRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getRowNum() > tableHeaderRows.get(1).getRowNum()).collect(Collectors.toUnmodifiableList());

			int beginningBalanceColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(A)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(A)")).findFirst().orElseThrow().getColumnIndex();
			int receivedColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(B)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(B)")).findFirst().orElseThrow().getColumnIndex();
			int soldColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(C)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(C)")).findFirst().orElseThrow().getColumnIndex();
			int lossColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(D)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(D)")).findFirst().orElseThrow().getColumnIndex();
			int positiveAdjustmentsColumnIndex =
					StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("(E)"))).findFirst().orElseThrow().spliterator(), false)
							.filter(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("(E)")).findFirst().orElseThrow().getColumnIndex();
			int negativeAdjustmentsColumnIndex =
					StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("(F)"))).findFirst().orElseThrow().spliterator(), false)
							.filter(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("(F)")).findFirst().orElseThrow().getColumnIndex();
			int firstNewClientIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("New client"))).findFirst().orElseThrow().spliterator(),
							false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("New client")).findFirst().orElseThrow().getColumnIndex();
			int firstRevisitIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("Revisits"))).findFirst().orElseThrow().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("Revisits")).findFirst().orElseThrow().getColumnIndex();
			int secondNewClientIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("New client"))).findFirst().orElseThrow().spliterator(),
							false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("New client")).collect(Collectors.toUnmodifiableList()).get(1)
					.getColumnIndex();
			int secondRevisitIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("Revisits"))).findFirst().orElseThrow().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("Revisits")).collect(Collectors.toUnmodifiableList()).get(1)
					.getColumnIndex();
			//
			//
			Row oralContraceptivePillsRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(combinedOralContraceptivePills))).findFirst().orElseThrow();
			initialData.put(combinedOralContraceptivePills, new ConceptCounts() {{
				setBeginning(oralContraceptivePillsRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(oralContraceptivePillsRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(oralContraceptivePillsRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(oralContraceptivePillsRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(oralContraceptivePillsRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(oralContraceptivePillsRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row progestinOnlyPillsRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(progestinOnlyPills))).findFirst().orElseThrow();
			initialData.put(progestinOnlyPills, new ConceptCounts() {{
				setBeginning(progestinOnlyPillsRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(progestinOnlyPillsRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(progestinOnlyPillsRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(progestinOnlyPillsRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(progestinOnlyPillsRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(progestinOnlyPillsRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row dmpaIMRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaIM))).findFirst().orElseThrow();
			initialData.put(dmpaIM, new ConceptCounts() {{
				setBeginning(dmpaIMRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(dmpaIMRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(dmpaIMRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(dmpaIMRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(dmpaIMRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(dmpaIMRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row dmpaSCRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaSC))).findFirst().orElseThrow();
			initialData.put(dmpaSC, new ConceptCounts() {{
				setBeginning(dmpaSCRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(dmpaSCRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(dmpaSCRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(dmpaSCRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(dmpaSCRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(dmpaSCRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row implants1Row =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants1Rod))).findFirst().orElseThrow();
			initialData.put(implants1Rod, new ConceptCounts() {{
				setBeginning(implants1Row.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(implants1Row.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(implants1Row.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(implants1Row.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(implants1Row.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(implants1Row.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row implants23Row =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod3))).findFirst().orElseThrow();
			initialData.put(implants2Rod3, new ConceptCounts() {{
				setBeginning(implants23Row.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(implants23Row.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(implants23Row.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(implants23Row.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(implants23Row.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(implants23Row.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row implants53Row =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod5))).findFirst().orElseThrow();
			initialData.put(implants2Rod5, new ConceptCounts() {{
				setBeginning(implants53Row.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(implants53Row.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(implants53Row.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(implants53Row.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(implants53Row.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(implants53Row.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row nonHormonalIucdRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(nonHormonalIucd))).findFirst().orElseThrow();
			initialData.put(nonHormonalIucd, new ConceptCounts() {{
				setBeginning(nonHormonalIucdRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(nonHormonalIucdRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(nonHormonalIucdRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(nonHormonalIucdRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(nonHormonalIucdRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(nonHormonalIucdRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row hormonalIucdRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(hormonalIucd))).findFirst().orElseThrow();
			initialData.put(hormonalIucd, new ConceptCounts() {{
				setBeginning(hormonalIucdRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(hormonalIucdRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(hormonalIucdRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(hormonalIucdRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(hormonalIucdRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(hormonalIucdRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row emergencyContraceptivePillsRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(emergencyContraceptivePills))).findFirst().orElseThrow();
			initialData.put(emergencyContraceptivePills, new ConceptCounts() {{
				setBeginning(emergencyContraceptivePillsRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(emergencyContraceptivePillsRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(emergencyContraceptivePillsRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(emergencyContraceptivePillsRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(
						emergencyContraceptivePillsRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(
						emergencyContraceptivePillsRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row maleCondomsRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(maleCondoms))).findFirst().orElseThrow();
			initialData.put(maleCondoms, new ConceptCounts() {{
				setBeginning(maleCondomsRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(maleCondomsRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(maleCondomsRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(maleCondomsRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(maleCondomsRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(maleCondomsRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row femaleCondomsRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(femaleCondoms))).findFirst().orElseThrow();
			initialData.put(femaleCondoms, new ConceptCounts() {{
				setBeginning(femaleCondomsRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(femaleCondomsRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(femaleCondomsRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(femaleCondomsRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(femaleCondomsRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(femaleCondomsRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			Row cycleBeadsRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(cycleBeads))).findFirst().orElseThrow();
			initialData.put(cycleBeads, new ConceptCounts() {{
				setBeginning(cycleBeadsRow.getCell(beginningBalanceColumnIndex).getNumericCellValue());
				setReceived(cycleBeadsRow.getCell(receivedColumnIndex).getNumericCellValue());
				setSold(cycleBeadsRow.getCell(soldColumnIndex).getNumericCellValue());
				setLoss(cycleBeadsRow.getCell(lossColumnIndex).getNumericCellValue());
				setPositiveAdjustment(cycleBeadsRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue());
				setNegativeAdjustment(cycleBeadsRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue());
			}});
			//
			// Now get the statistics
			//
			Row statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(combinedOralContraceptivePills))).findFirst().orElseThrow();
			initialData.get(combinedOralContraceptivePills)
					.setNewClients(statisticRow.getCell(firstNewClientIndex).getNumericCellValue());
			initialData.get(combinedOralContraceptivePills)
					.setRevisits(statisticRow.getCell(firstRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(progestinOnlyPills))).findFirst().orElseThrow();
			initialData.get(progestinOnlyPills)
					.setNewClients(statisticRow.getCell(firstNewClientIndex).getNumericCellValue());
			initialData.get(progestinOnlyPills)
					.setRevisits(statisticRow.getCell(firstRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaIM))).findFirst().orElseThrow();
			initialData.get(dmpaIM)
					.setNewClients(statisticRow.getCell(firstNewClientIndex).getNumericCellValue());
			initialData.get(dmpaIM)
					.setRevisits(statisticRow.getCell(firstRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaSC))).findFirst().orElseThrow();
			initialData.get(dmpaSC)
					.setNewClients(statisticRow.getCell(firstNewClientIndex).getNumericCellValue());
			initialData.get(dmpaSC)
					.setRevisits(statisticRow.getCell(firstRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants1Rod))).findFirst().orElseThrow();
			initialData.get(implants1Rod)
					.setNewClients(statisticRow.getCell(firstNewClientIndex).getNumericCellValue());
			initialData.get(implants1Rod)
					.setRevisits(statisticRow.getCell(firstRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod3))).findFirst().orElseThrow();
			initialData.get(implants2Rod3)
					.setNewClients(statisticRow.getCell(firstNewClientIndex).getNumericCellValue());
			initialData.get(implants2Rod3)
					.setRevisits(statisticRow.getCell(firstRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod5))).findFirst().orElseThrow();
			initialData.get(implants2Rod5)
					.setNewClients(statisticRow.getCell(firstNewClientIndex).getNumericCellValue());
			initialData.get(implants2Rod5)
					.setRevisits(statisticRow.getCell(firstRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(nonHormonalIucd))).findFirst().orElseThrow();
			initialData.get(nonHormonalIucd)
					.setNewClients(statisticRow.getCell(secondNewClientIndex).getNumericCellValue());
			initialData.get(nonHormonalIucd)
					.setRevisits(statisticRow.getCell(secondRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(hormonalIucd))).findFirst().orElseThrow();
			initialData.get(hormonalIucd)
					.setNewClients(statisticRow.getCell(secondNewClientIndex).getNumericCellValue());
			initialData.get(hormonalIucd)
					.setRevisits(statisticRow.getCell(secondRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(emergencyContraceptivePills))).findFirst().orElseThrow();
			initialData.get(emergencyContraceptivePills)
					.setNewClients(statisticRow.getCell(secondNewClientIndex).getNumericCellValue());
			initialData.get(emergencyContraceptivePills)
					.setRevisits(statisticRow.getCell(secondRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(maleCondoms))).findFirst().orElseThrow();
			initialData.get(maleCondoms)
					.setNewClients(statisticRow.getCell(secondNewClientIndex).getNumericCellValue());
			initialData.get(maleCondoms)
					.setRevisits(statisticRow.getCell(secondRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(femaleCondoms))).findFirst().orElseThrow();
			initialData.get(femaleCondoms)
					.setNewClients(statisticRow.getCell(secondNewClientIndex).getNumericCellValue());
			initialData.get(femaleCondoms)
					.setRevisits(statisticRow.getCell(secondRevisitIndex).getNumericCellValue());
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(cycleBeads))).findFirst().orElseThrow();
			initialData.get(cycleBeads)
					.setNewClients(statisticRow.getCell(secondNewClientIndex).getNumericCellValue());
			initialData.get(cycleBeads)
					.setRevisits(statisticRow.getCell(secondRevisitIndex).getNumericCellValue());
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		Map<String, ConceptCounts> conceptCounts = new HashMap<>();
		conceptCounts.put(combinedOralContraceptivePills, new ConceptCounts());
		generateConceptData(valueObject, "01 - Combined Oral Contraceptive Pills",
				conceptCounts.get(combinedOralContraceptivePills));
		//
		conceptCounts.put(progestinOnlyPills, new ConceptCounts());
		generateConceptData(valueObject, "02 - Progestin Only Pills", conceptCounts.get(progestinOnlyPills));
		//
		conceptCounts.put(dmpaIM, new ConceptCounts());
		generateConceptData(valueObject, "03 - DMPA-IM", conceptCounts.get(dmpaIM));
		//
		conceptCounts.put(dmpaSC, new ConceptCounts());
		generateConceptData(valueObject, "04 - DMPA-SC", conceptCounts.get(dmpaSC));
		//
		conceptCounts.put(implants1Rod, new ConceptCounts());
		generateConceptData(valueObject, "05 - Implants (1-Rod) - ENG", conceptCounts.get(implants1Rod));
		//
		conceptCounts.put(implants2Rod3, new ConceptCounts());
		generateConceptData(valueObject, "06 - Implant (2-Rod) - LNG 75mg (3 years)", conceptCounts.get(implants2Rod3));
		//
		conceptCounts.put(implants2Rod5, new ConceptCounts());
		generateConceptData(valueObject, "07 - Implant (2-Rod) - LNG 75mg (5 years)", conceptCounts.get(implants2Rod5));
		//
		conceptCounts.put(nonHormonalIucd, new ConceptCounts());
		generateConceptData(valueObject, "08 - Non-Hormonal IUD", conceptCounts.get(nonHormonalIucd));
		//
		conceptCounts.put(hormonalIucd, new ConceptCounts());
		generateConceptData(valueObject, "09 - Hormonal IUD", conceptCounts.get(hormonalIucd));
		//
		conceptCounts.put(emergencyContraceptivePills, new ConceptCounts());
		generateConceptData(valueObject, "10 - Emergency Contraceptive Pills",
				conceptCounts.get(emergencyContraceptivePills));
		//
		conceptCounts.put(maleCondoms, new ConceptCounts());
		generateConceptData(valueObject, "11 - Male Condoms", conceptCounts.get(maleCondoms));
		//
		conceptCounts.put(femaleCondoms, new ConceptCounts());
		generateConceptData(valueObject, "12 - Female Condoms", conceptCounts.get(femaleCondoms));
		//
		conceptCounts.put(cycleBeads, new ConceptCounts());
		generateConceptData(valueObject, "13 - Cycle Beads", conceptCounts.get(cycleBeads));


		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
						new ProcessInfoParameter("End Date", endOfMonth, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			List<Row> tableHeaderRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Contraceptive Method"))).collect(Collectors.toUnmodifiableList());
			assertEquals(2, tableHeaderRows.size(), "there are two table headers");

			List<Row> inventoryRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getRowNum() > tableHeaderRows.get(0).getRowNum() &&
							row.getRowNum() < tableHeaderRows.get(1).getRowNum()).collect(Collectors.toUnmodifiableList());
			List<Row> statisticsRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getRowNum() > tableHeaderRows.get(1).getRowNum()).collect(Collectors.toUnmodifiableList());

			int beginningBalanceColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(A)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(A)")).findFirst().orElseThrow().getColumnIndex();
			int receivedColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(B)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(B)")).findFirst().orElseThrow().getColumnIndex();
			int soldColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(C)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(C)")).findFirst().orElseThrow().getColumnIndex();
			int lossColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(D)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(D)")).findFirst().orElseThrow().getColumnIndex();
			int positiveAdjustmentsColumnIndex =
					StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("(E)"))).findFirst().orElseThrow().spliterator(), false)
							.filter(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("(E)")).findFirst().orElseThrow().getColumnIndex();
			int negativeAdjustmentsColumnIndex =
					StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("(F)"))).findFirst().orElseThrow().spliterator(), false)
							.filter(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("(F)")).findFirst().orElseThrow().getColumnIndex();
			int endingBalanceColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().endsWith("(G)"))).findFirst().orElseThrow().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("(G)")).findFirst().orElseThrow().getColumnIndex();
			int quantityToOrderColumnIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("H=(Cx6)-G"))).findFirst().orElseThrow().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("H=(Cx6)-G")).findFirst().orElseThrow().getColumnIndex();
			int firstNewClientIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("New client"))).findFirst().orElseThrow().spliterator(),
							false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("New client")).findFirst().orElseThrow().getColumnIndex();
			int firstRevisitIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("Revisits"))).findFirst().orElseThrow().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("Revisits")).findFirst().orElseThrow().getColumnIndex();
			int secondNewClientIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().endsWith("New client"))).findFirst().orElseThrow().spliterator(),
							false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("New client")).collect(Collectors.toUnmodifiableList()).get(1)
					.getColumnIndex();
			int secondRevisitIndex = StreamSupport.stream(StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().endsWith("Revisits"))).findFirst().orElseThrow().spliterator(), false)
					.filter(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
							cell.getStringCellValue().endsWith("Revisits")).collect(Collectors.toUnmodifiableList()).get(1)
					.getColumnIndex();
			//
			//
			Row inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(combinedOralContraceptivePills))).findFirst().orElseThrow();
			String conceptString = combinedOralContraceptivePills;
			ConceptCounts initialValues = initialData.get(conceptString);
			ConceptCounts updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			double calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(progestinOnlyPills))).findFirst().orElseThrow();
			conceptString = progestinOnlyPills;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaIM))).findFirst().orElseThrow();
			conceptString = dmpaIM;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaSC))).findFirst().orElseThrow();
			conceptString = dmpaSC;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants1Rod))).findFirst().orElseThrow();
			conceptString = implants1Rod;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod3))).findFirst().orElseThrow();
			conceptString = implants2Rod3;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod5))).findFirst().orElseThrow();
			conceptString = implants2Rod5;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(nonHormonalIucd))).findFirst().orElseThrow();
			conceptString = nonHormonalIucd;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(hormonalIucd))).findFirst().orElseThrow();
			conceptString = hormonalIucd;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(emergencyContraceptivePills))).findFirst().orElseThrow();
			conceptString = emergencyContraceptivePills;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(maleCondoms))).findFirst().orElseThrow();
			conceptString = maleCondoms;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(femaleCondoms))).findFirst().orElseThrow();
			conceptString = femaleCondoms;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			inventoryRow =
					inventoryRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(cycleBeads))).findFirst().orElseThrow();
			conceptString = cycleBeads;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			assertEquals(initialValues.getBeginning() + updatedValues.getBeginning(),
					inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue(),
					conceptString + " beginning values are correct");
			assertEquals(initialValues.getReceived() + updatedValues.getReceived(),
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue(),
					conceptString + " received values are correct");
			assertEquals(initialValues.getSold() + updatedValues.getSold(),
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue(), conceptString + " sold values are correct");
			assertEquals(initialValues.getLoss() + updatedValues.getLoss(),
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue(), conceptString + " loss values are correct");
			assertEquals(initialValues.getPositiveAdjustment() + updatedValues.getPositiveAdjustment(),
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " positive adjustment values are correct");
			assertEquals(initialValues.getNegativeAdjustment() + updatedValues.getNegativeAdjustment(),
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue(),
					conceptString + " negative adjustment values are correct");
			calculatedEnding = inventoryRow.getCell(beginningBalanceColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(receivedColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(soldColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(lossColumnIndex).getNumericCellValue() +
					inventoryRow.getCell(positiveAdjustmentsColumnIndex).getNumericCellValue() -
					inventoryRow.getCell(negativeAdjustmentsColumnIndex).getNumericCellValue();
			assertEquals(calculatedEnding, inventoryRow.getCell(endingBalanceColumnIndex).getNumericCellValue(),
					conceptString + " ending values are correct");
			assertEquals(Math.max(inventoryRow.getCell(soldColumnIndex).getNumericCellValue() * 6 - calculatedEnding, 0),
					inventoryRow.getCell(quantityToOrderColumnIndex).getNumericCellValue(),
					conceptString + " quantity to order values are correct");
			//
			// Now get the statistics
			//
			double firstColumnNewClientTotals = 0;
			double firstColumnRevisitTotals = 0;
			double secondColumnNewClientTotals = 0;
			double secondColumnRevisitTotals = 0;
			Row statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(combinedOralContraceptivePills))).findFirst().orElseThrow();
			conceptString = combinedOralContraceptivePills;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			firstColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			firstColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(firstRevisitIndex).getNumericCellValue(), conceptString + " revisit values are " +
							"correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(progestinOnlyPills))).findFirst().orElseThrow();
			conceptString = progestinOnlyPills;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			firstColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			firstColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(firstRevisitIndex).getNumericCellValue(), conceptString + " revisit values are " +
							"correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaIM))).findFirst().orElseThrow();
			conceptString = dmpaIM;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			firstColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			firstColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(firstRevisitIndex).getNumericCellValue(), conceptString + " revisit values are " +
							"correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(dmpaSC))).findFirst().orElseThrow();
			conceptString = dmpaSC;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			firstColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			firstColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(firstRevisitIndex).getNumericCellValue(), conceptString + " revisit values are " +
							"correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants1Rod))).findFirst().orElseThrow();
			conceptString = implants1Rod;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			firstColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			firstColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(firstRevisitIndex).getNumericCellValue(), conceptString + " revisit values are " +
							"correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod3))).findFirst().orElseThrow();
			conceptString = implants2Rod3;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			firstColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			firstColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(firstRevisitIndex).getNumericCellValue(), conceptString + " revisit values are " +
							"correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(implants2Rod5))).findFirst().orElseThrow();
			conceptString = implants2Rod5;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			firstColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			firstColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(firstRevisitIndex).getNumericCellValue(), conceptString + " revisit values are " +
							"correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(nonHormonalIucd))).findFirst().orElseThrow();
			conceptString = nonHormonalIucd;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			secondColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			secondColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(secondNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(secondRevisitIndex).getNumericCellValue(),
					conceptString + " revisit values are correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(hormonalIucd))).findFirst().orElseThrow();
			conceptString = hormonalIucd;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			secondColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			secondColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(secondNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(secondRevisitIndex).getNumericCellValue(),
					conceptString + " revisit values are correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(emergencyContraceptivePills))).findFirst().orElseThrow();
			conceptString = emergencyContraceptivePills;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			secondColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			secondColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(secondNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(secondRevisitIndex).getNumericCellValue(),
					conceptString + " revisit values are correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(maleCondoms))).findFirst().orElseThrow();
			conceptString = maleCondoms;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			secondColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			secondColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(secondNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(secondRevisitIndex).getNumericCellValue(),
					conceptString + " revisit values are correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(femaleCondoms))).findFirst().orElseThrow();
			conceptString = femaleCondoms;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			secondColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			secondColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(secondNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(secondRevisitIndex).getNumericCellValue(),
					conceptString + " revisit values are correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(cycleBeads))).findFirst().orElseThrow();
			conceptString = cycleBeads;
			initialValues = initialData.get(conceptString);
			updatedValues = conceptCounts.get(conceptString);
			secondColumnNewClientTotals += initialValues.getNewClients() + updatedValues.getNewClients();
			secondColumnRevisitTotals += initialValues.getRevisits() + updatedValues.getRevisits();
			assertEquals(initialValues.getNewClients() + updatedValues.getNewClients(),
					statisticRow.getCell(secondNewClientIndex).getNumericCellValue(),
					conceptString + " new client values are correct");
			assertEquals(initialValues.getRevisits() + updatedValues.getRevisits(),
					statisticRow.getCell(secondRevisitIndex).getNumericCellValue(),
					conceptString + " revisit values are correct");
			//
			statisticRow =
					statisticsRows.stream().filter(row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Total"))).findFirst().orElseThrow();
			assertEquals(firstColumnNewClientTotals, statisticRow.getCell(firstNewClientIndex).getNumericCellValue(),
					"first total column new client values are correct");
			assertEquals(firstColumnRevisitTotals, statisticRow.getCell(firstRevisitIndex).getNumericCellValue(),
					"first total column values are correct");
			assertEquals(secondColumnNewClientTotals, statisticRow.getCell(secondNewClientIndex).getNumericCellValue(),
					"second total column new client values are correct");
			assertEquals(secondColumnRevisitTotals, statisticRow.getCell(secondRevisitIndex).getNumericCellValue(),
					"second total column values are correct");
		}
	}

	private void generateConceptData(ChuBoePopulateVO valueObject, String conceptExtraValue,
			ConceptCounts conceptCounts) throws SQLException {
		valueObject.setStepName("Create concept for value " + conceptExtraValue);
		var concept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		concept.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		concept.setIsActive(true);
		concept.setBH_ExternalID(UUID.randomUUID().toString());
		concept.setOcl_Uuid(UUID.randomUUID().toString());
		concept.setBH_OclID(String.valueOf(UUID.randomUUID().hashCode()));
		concept.setBH_Owner("Banda");
		concept.setOcl_Uuid(randomUUID().toString());
		concept.setBH_Source("BHPharmacy");
		concept.setURL("/orgs/Banda/sources/BHPharmacy/concepts/" + concept.getBH_OclID() + "/");
		concept.saveEx();
		commitEx();

		var conceptExtra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
		conceptExtra.setBH_Concept_ID(concept.getBH_Concept_ID());
		conceptExtra.setBH_Key("moh_747_711_grouping");
		conceptExtra.setBH_Value(conceptExtraValue);
		conceptExtra.saveEx();
		commitEx();

		valueObject.setStepName("Create product - " + conceptExtraValue);
		valueObject.clearProduct();
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setBH_Concept_ID(concept.getBH_Concept_ID());
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Set beginning balance - " + conceptExtraValue);
		valueObject.setDateOffset(-60);
		valueObject.setQuantity(BigDecimal.valueOf(conceptCounts.getBeginning()));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialMovement, null, false, false, false);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		ChuBoeCreateEntity.createInventory(valueObject);
		commitEx();

		valueObject.setStepName("Receive stock - " + conceptExtraValue);
		valueObject.setDateOffset(60);
		valueObject.setQuantity(BigDecimal.valueOf(conceptCounts.getReceived()));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt - " + conceptExtraValue);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		// Sell products one at a time until we're on the last order
		int inventorySold = 0;
		for (int i = (int) conceptCounts.newClients; i > 0; i--) {
			valueObject.setStepName("Create new visit - " + conceptExtraValue + " - " + i);
			ChuBoeCreateEntity.createVisit(valueObject);
			valueObject.getVisit().setBH_NewVisit(true);
			valueObject.getVisit().saveEx();
			commitEx();

			valueObject.setStepName("Sell inventory - " + conceptExtraValue + " - " + i);
			valueObject.setQuantity(
					BigDecimal.valueOf(i == 1 && conceptCounts.revisits == 0 ? conceptCounts.sold - inventorySold : 1));
			valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true,
					false, false);
			valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
			ChuBoeCreateEntity.createOrder(valueObject);
			commitEx();

			inventorySold++;
		}
		for (int i = (int) conceptCounts.revisits; i > 0; i--) {
			valueObject.setStepName("Create revisit - " + conceptExtraValue + " - " + i);
			ChuBoeCreateEntity.createVisit(valueObject);
			valueObject.getVisit().setBH_NewVisit(false);
			valueObject.getVisit().saveEx();
			commitEx();

			valueObject.setStepName("Sell inventory - " + conceptExtraValue + " - " + i);
			// If we're at the last one, sell whatever is remaining to be sold
			valueObject.setQuantity(BigDecimal.valueOf(i == 1 ? conceptCounts.sold - inventorySold : 1));
			valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true,
					false, false);
			valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
			ChuBoeCreateEntity.createOrder(valueObject);
			commitEx();

			inventorySold++;
		}

		valueObject.setStepName("Lose inventory - " + conceptExtraValue);
		valueObject.setQuantity(BigDecimal.valueOf(
				conceptCounts.getBeginning() + conceptCounts.getReceived() - conceptCounts.getSold() -
						conceptCounts.getLoss()));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialMovement, null, false, false, false);
		ChuBoeCreateEntity.createInventory(valueObject);
		valueObject.getInventory().setbh_update_reason(MInventory_BH.BH_UPDATE_REASON_LostOrStolenProducts);
		valueObject.getInventory().saveEx();
		commitEx();

		valueObject.setStepName("Adjust inventory positively - " + conceptExtraValue);
		valueObject.setQuantity(BigDecimal.valueOf(
				conceptCounts.getBeginning() + conceptCounts.getReceived() - conceptCounts.getSold() - conceptCounts.getLoss() +
						conceptCounts.getPositiveAdjustment()));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialMovement, null, false, false, false);
		ChuBoeCreateEntity.createInventory(valueObject);
		valueObject.getInventory().setbh_update_reason(MInventory_BH.BH_UPDATE_REASON_WrongQuantityReceived);
		valueObject.getInventory().saveEx();
		commitEx();

		valueObject.setStepName("Adjust inventory negatively - " + conceptExtraValue);
		valueObject.setQuantity(BigDecimal.valueOf(
				conceptCounts.getBeginning() + conceptCounts.getReceived() - conceptCounts.getSold() - conceptCounts.getLoss() +
						conceptCounts.getPositiveAdjustment() - conceptCounts.getNegativeAdjustment()));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialMovement, null, false, false, false);
		ChuBoeCreateEntity.createInventory(valueObject);
		valueObject.getInventory().setbh_update_reason(MInventory_BH.BH_UPDATE_REASON_DamagedProducts);
		valueObject.getInventory().saveEx();
		commitEx();
	}

	private class ConceptCounts {
		private double beginning;
		private double received;
		private double sold;
		private double loss;
		private double positiveAdjustment;
		private double negativeAdjustment;
		private double newClients;
		private double revisits;

		public ConceptCounts() {
			beginning = Math.ceil(Math.random() * 5) + 50;
			received = Math.ceil(Math.random() * 5) + 10;
			sold = Math.ceil(Math.random() * 10) + 1;
			loss = Math.ceil(Math.random() * 5);
			positiveAdjustment = Math.ceil(Math.random() * 5);
			negativeAdjustment = Math.ceil(Math.random() * 5);
			newClients = (Math.floor(Math.random() * 3));
			revisits = (Math.floor(Math.random() * 3));
			if (newClients + revisits > sold) {
				newClients = 1;
				revisits = sold - 1;
			} else if (newClients == 0 && revisits == 0) {
				newClients = 1;
			}
		}

		public double getNegativeAdjustment() {
			return negativeAdjustment;
		}

		public void setNegativeAdjustment(double negativeAdjustment) {
			this.negativeAdjustment = negativeAdjustment;
		}

		public double getPositiveAdjustment() {
			return positiveAdjustment;
		}

		public void setPositiveAdjustment(double positiveAdjustment) {
			this.positiveAdjustment = positiveAdjustment;
		}

		public double getLoss() {
			return loss;
		}

		public void setLoss(double loss) {
			this.loss = loss;
		}

		public double getSold() {
			return sold;
		}

		public void setSold(double sold) {
			this.sold = sold;
		}

		public double getReceived() {
			return received;
		}

		public void setReceived(double received) {
			this.received = received;
		}

		public double getBeginning() {
			return beginning;
		}

		public void setBeginning(double beginning) {
			this.beginning = beginning;
		}

		public double getNewClients() {
			return newClients;
		}

		public void setNewClients(double newClients) {
			this.newClients = newClients;
		}

		public double getRevisits() {
			return revisits;
		}

		public void setRevisits(double revisits) {
			this.revisits = revisits;
		}
	}
}
