package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is meant to test all reports related to income so numbers can be
 * verified across them
 */
public class NonPatientPaymentReportTest extends ChuBoePopulateFactoryVO {
	private final String nonPatientPaymentReportUuid = "19464274-e2bc-4dbe-ad69-ae48b9f7778c";

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
	public void reportRendersAndDisplaysCorrectData() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		Timestamp beginDate = TimestampUtils.startOfYesterday();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Timestamp endDate = new Timestamp(calendar.getTimeInMillis());

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(50000));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(1300));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment for the first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(new BigDecimal(1300));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(1690));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment for the second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(1690));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create third sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(6840));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment for the third sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(new BigDecimal(6840));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create fourth sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(1550));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment for the fourth sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(1550));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create fifth sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(1100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment for the fifth sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(1100));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create waiver charge");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setBH_SubType(MCharge_BH.BH_SUBTYPE_Waiver);
		commitEx();

		valueObject.setStepName("Create sixth sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(5300));
		ChuBoeCreateEntity.createOrder(valueObject);

		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(valueObject.getOrder().get_ID());
		orderLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		orderLine.setQty(Env.ONE);
		orderLine.setHeaderInfo(valueObject.getOrder());
		orderLine.setPrice(new BigDecimal(1300));
		orderLine.saveEx();

		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocAction.ACTION_Complete), "Sixth sales order was completed");
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create payment for the sixth sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(1000));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(new BigDecimal(1000));
		commitEx();

		valueObject.setStepName("Create seventh sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(9500));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial payment for the seventh sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(9000));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Re-open seventh sales order");
		List<MPayment_BH> ordersPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND "
						+ MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL",
				valueObject.getTransactionName())
						.setParameters(valueObject.getOrder().get_ID(), MPayment_BH.DOCSTATUS_Completed).list();
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate), "Sales order was re-activated");
		valueObject.getOrder().saveEx();
		commitEx();
		valueObject.setPayment(null);

		valueObject.setStepName("Cancel previous payments");
		for (MPayment_BH payment : ordersPayments) {
			MPayment_BH newPayment = payment.copy();
			newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
			newPayment.saveEx();

			payment.setDocAction(DocAction.ACTION_Reverse_Accrual);
			assertTrue(payment.processIt(DocAction.ACTION_Reverse_Accrual), "Old payment was reversed");
			payment.saveEx();
		}
		commitEx();
		valueObject.refresh();

		valueObject.setPayment(new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=?",
				valueObject.getTransactionName())
						.setParameters(valueObject.getOrder().get_ID(), MPayment_BH.DOCSTATUS_Drafted).first());
		valueObject.refresh();

		valueObject.setStepName("Re-complete seventh sales order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete), "Sales order was re-completed");
		commitEx();

		valueObject.setStepName("Change payment");
		valueObject.getPayment().setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.getPayment().setPayAmt(new BigDecimal(8000));
		valueObject.getPayment().setBH_TenderAmount(new BigDecimal(8000));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Partial payment was re-completed");
		commitEx();

		valueObject.setStepName("Generate the patient transaction report");
		valueObject.setProcessUuid(patientTransactionsReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double totalCharged = 0;
		double totalPaid = 0;
		double totalCashPaid = 0;
		double totalMobileMoneyPaid = 0;
		double totalCreditDebitPaid = 0;
		double totalBankTransferPaid = 0;
		double totalChequePaid = 0;
		double totalInsurancePaid = 0;
		double totalWaiverPaid = 0;
		double totalDonationsPaid = 0;
		double totalOtherPaid = 0;
		double totalUnpaid = 0;
		double totalDebtPayments = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int billTotalColumnIndex = TableUtils.getColumnIndex(headerRow, "Bill Total");
			int totalPaymentColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Payment");
			int cashColumnIndex = TableUtils.getColumnIndex(headerRow, "Cash");
			int mobileMoneyColumnIndex = TableUtils.getColumnIndex(headerRow, "Mobile Money");
			int creditDebitColumnIndex = TableUtils.getColumnIndex(headerRow, "Credit/ Debit");
			int bankTransferColumnIndex = TableUtils.getColumnIndex(headerRow, "Bank Transfer");
			int chequeColumnIndex = TableUtils.getColumnIndex(headerRow, "Cheque");
			int insuranceColumnIndex = TableUtils.getColumnIndex(headerRow, "Insurance");
			int waiverColumnIndex = TableUtils.getColumnIndex(headerRow, "Waiver");
			int donationsColumnIndex = TableUtils.getColumnIndex(headerRow, "Donations");
			int otherColumnIndex = TableUtils.getColumnIndex(headerRow, "Other");
			int unpaidColumnIndex = TableUtils.getColumnIndex(headerRow, "Unpaid Amount");

			int totalsRowIndex = -1;
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Cell patientNameCell = row.getCell(patientNameColumnIndex);
				Cell billTotalTotalsCell = row.getCell(billTotalColumnIndex);
				if (patientNameCell != null && patientNameCell.getCellType().equals(CellType.STRING)
						&& patientNameCell.getStringCellValue().isEmpty() && billTotalTotalsCell != null
						&& billTotalTotalsCell.getCellType().equals(CellType.NUMERIC)
						&& billTotalTotalsCell.getNumericCellValue() > 0) {
					totalsRowIndex = i;
					totalCharged = billTotalTotalsCell.getNumericCellValue();
					totalPaid = row.getCell(totalPaymentColumnIndex).getNumericCellValue();
					totalCashPaid = row.getCell(cashColumnIndex).getNumericCellValue();
					totalMobileMoneyPaid = row.getCell(mobileMoneyColumnIndex).getNumericCellValue();
					totalCreditDebitPaid = row.getCell(creditDebitColumnIndex).getNumericCellValue();
					totalBankTransferPaid = row.getCell(bankTransferColumnIndex).getNumericCellValue();
					totalChequePaid = row.getCell(chequeColumnIndex).getNumericCellValue();
					totalInsurancePaid = row.getCell(insuranceColumnIndex).getNumericCellValue();
					totalWaiverPaid = row.getCell(waiverColumnIndex).getNumericCellValue();
					totalDonationsPaid = row.getCell(donationsColumnIndex).getNumericCellValue();
					totalOtherPaid = row.getCell(otherColumnIndex).getNumericCellValue();
					totalUnpaid = row.getCell(unpaidColumnIndex).getNumericCellValue();
					break;
				}
			}

			assertTrue(totalsRowIndex > -1, "Row totals displayed for transactions");
			assertTrue(totalPaid > 0, "Total charged is greater than zero");

			Row cashierPivotTableHeaderRow = TableUtils.getHeaderRow(sheet, "Cash", totalsRowIndex + 1);
			assertNotNull(cashierPivotTableHeaderRow, "Cashier income table exists");
			int cashierTotalsColumnIndex = TableUtils.getColumnIndex(cashierPivotTableHeaderRow, "Total");

			Row cashierPivotTableFooterRow = TableUtils.getHeaderRow(sheet, "Total",
					TableUtils.getIndexOfRow(sheet, cashierPivotTableHeaderRow) + 1);
			assertNotNull(cashierPivotTableFooterRow, "Cashier income table has a footer row");
			assertEquals(CellType.NUMERIC, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getCellType(),
					"Cashiers' totals cell is numeric");
			assertEquals(totalPaid, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getNumericCellValue(),
					"Cashier total matches total payment");

			Row outstandingBalanceHeaderRow = TableUtils.getHeaderRow(sheet, "Date Paid",
					TableUtils.getIndexOfRow(sheet, cashierPivotTableFooterRow));
			assertNotNull(outstandingBalanceHeaderRow, "Outstanding balance table header row exists");
			int amountPaidColumnIndex = TableUtils.getColumnIndex(outstandingBalanceHeaderRow, "Amount Paid");
			patientNameColumnIndex = TableUtils.getColumnIndex(outstandingBalanceHeaderRow, "Patient Name");
			headerRowIndex = TableUtils.getIndexOfRow(sheet, outstandingBalanceHeaderRow);
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Cell patientNameCell = row.getCell(patientNameColumnIndex);
				Cell amountPaidCell = row.getCell(amountPaidColumnIndex);
				if (patientNameCell != null && patientNameCell.getCellType().equals(CellType.STRING)
						&& patientNameCell.getStringCellValue().isEmpty() && amountPaidCell != null
						&& amountPaidCell.getCellType().equals(CellType.NUMERIC)
						&& amountPaidCell.getNumericCellValue() > 0) {
					totalDebtPayments = amountPaidCell.getNumericCellValue();
					break;
				}
			}
		}

		valueObject.setStepName("Generate the income & expense report");
		valueObject.setProcessUuid(incomeAndExpenseReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("pdf");
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);

		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		double totalIncome = totalPaid - totalInsurancePaid - totalWaiverPaid - totalOtherPaid - totalDonationsPaid
				+ totalDebtPayments;
		assertThat("Income total is correct", reportContent, containsString(decimalFormat.format(totalIncome)));
		assertThat("Payments received from visits is correct", reportContent,
				containsString(decimalFormat.format(totalIncome - totalDebtPayments)));
		assertEquals(totalIncome - totalDebtPayments,
				totalCashPaid + totalMobileMoneyPaid + totalCreditDebitPaid + totalBankTransferPaid + totalChequePaid,
				"Payments received from visits is calculated correctly");
		assertThat("Debt payments correct", reportContent, containsString(decimalFormat.format(totalDebtPayments)));
		assertThat("Waived balance is correct", reportContent, containsString(decimalFormat.format(totalWaiverPaid)));
		assertThat("Unpaid balance is correct", reportContent, containsString(decimalFormat.format(totalUnpaid)));
	}
}
