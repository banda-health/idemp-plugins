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
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisitReceiptTest extends ChuBoePopulateFactoryVO {
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
	public void canGenerateReceipt() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		// Set the BP's name to be short so the visit receipt can show it properly in an Excel export
		valueObject.getBusinessPartner().setName(valueObject.getBusinessPartner().getName().substring(0, 19));
		valueObject.getBusinessPartner().saveEx();
		valueObject.setRandom();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(20));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getVisit().get_ID()), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> patientNameRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Patient:"))).findFirst();
			assertTrue(patientNameRow.isPresent(), "Patient label is on the receipt");
			assertTrue(StreamSupport.stream(patientNameRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains(valueObject.getBusinessPartner().getName())),
					"Patient's name is on the receipt");

			String casedProductName = valueObject.getOrderLine().getName().substring(0, 1).toUpperCase() +
					valueObject.getOrderLine().getName().substring(1).toLowerCase();
			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains(casedProductName.substring(0, 18)))).findFirst();
			assertTrue(productRow.isPresent(), "Products are included");
			assertTrue(StreamSupport.stream(productRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getOrderLine().getLineNetAmt().doubleValue()),
					"Product's prices are included");

			Optional<Row> totalChargedRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Charge:"))).findFirst();
			assertTrue(totalChargedRow.isPresent(), "Total charges are included");
			assertTrue(StreamSupport.stream(totalChargedRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getOrderLine().getLineNetAmt().doubleValue()),
					"Total charged amount is correct");

			Optional<Row> cashRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("CASH"))).findFirst();
			assertTrue(cashRow.isPresent(), "Payments are included");
			assertTrue(StreamSupport.stream(cashRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Payment amounts are included");

			Optional<Row> totalPaymentRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Payment:"))).findFirst();
			assertTrue(totalPaymentRow.isPresent(), "Total payment row is included");
			assertTrue(StreamSupport.stream(totalPaymentRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Total payment amount is correct");

			Optional<Row> changeDueRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Change Due:"))).findFirst();
			assertTrue(changeDueRow.isEmpty(), "Change due row is not included");

			double outstandingAmount = valueObject.getOrderLine().getLineNetAmt().doubleValue() -
					valueObject.getPayment().getPayAmt().doubleValue();
			Optional<Row> outstandingAmountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding:"))).findFirst();
			assertTrue(outstandingAmountRow.isPresent(), "Outstanding amount row is included");
			assertTrue(StreamSupport.stream(outstandingAmountRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Outstanding amount is correct");

			Optional<Row> outstandingFromPreviousVisitsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding previous"))).findFirst();
			assertTrue(outstandingFromPreviousVisitsRow.isPresent(), "Outstanding from previous visit row is included");
			assertTrue(StreamSupport.stream(outstandingFromPreviousVisitsRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 0d),
					"Outstanding from previous visit amount is correct");

			Optional<Row> totalOutstandingDebtRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Outstanding:"))).findFirst();
			assertTrue(totalOutstandingDebtRow.isPresent(), "Total outstanding debt row is included");
			assertTrue(StreamSupport.stream(totalOutstandingDebtRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Total outstanding amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void receiptCorrectForReCompletedVisits() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(20));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getVisit().get_ID()), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> cashRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("CASH"))).findFirst();
			assertTrue(cashRow.isPresent(), "'CASH' is on the receipt");
			assertTrue(StreamSupport.stream(cashRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Cash amount is correct");

			Optional<Row> totalPaymentRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Payment:"))).findFirst();
			assertTrue(totalPaymentRow.isPresent(), "Total payment row is included");
			assertTrue(StreamSupport.stream(totalPaymentRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Total payment amount is correct");

			double outstandingAmount =
					valueObject.getOrderLine().getLineNetAmt().doubleValue() - valueObject.getPayment().getPayAmt().doubleValue();
			Optional<Row> outstandingAmountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding:"))).findFirst();
			assertTrue(outstandingAmountRow.isPresent(), "Outstanding amount row is included");
			assertTrue(StreamSupport.stream(outstandingAmountRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Outstanding amount is correct");

			Optional<Row> outstandingFromPreviousVisitsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding previous"))).findFirst();
			assertTrue(outstandingFromPreviousVisitsRow.isPresent(), "Outstanding from previous visit row is included");
			assertTrue(StreamSupport.stream(outstandingFromPreviousVisitsRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 0d),
					"Outstanding from previous visit amount is correct");

			Optional<Row> totalOutstandingDebtRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Outstanding:"))).findFirst();
			assertTrue(totalOutstandingDebtRow.isPresent(), "Total outstanding debt row is included");
			assertTrue(StreamSupport.stream(totalOutstandingDebtRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Total outstanding amount is correct");
		}

		valueObject.setStepName("Re-open order");
		List<MPayment_BH> ordersPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND " +
						MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL", valueObject.getTransactionName()).setParameters(
				valueObject.getVisit().get_ID(), MPayment_BH.DOCSTATUS_Completed).list();
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate), "Order was re-activated");
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
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=?",
				valueObject.getTransactionName()).setParameters(valueObject.getVisit().get_ID(), MPayment_BH.DOCSTATUS_Drafted)
				.first());
		valueObject.refresh();

		valueObject.setStepName("Re-complete order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete), "Sales order was re-completed");
		commitEx();

		valueObject.setStepName("Change payment");
		valueObject.getPayment().setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.getPayment().setPayAmt(new BigDecimal(21));
		valueObject.getPayment().setBH_TenderAmount(new BigDecimal(21));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Partial payment was re-completed");
		commitEx();

		valueObject.setStepName("Add new payment");
		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(10));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Regenerate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getVisit().get_ID()), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> cashRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("CASH"))).findFirst();
			assertTrue(cashRow.isPresent(), "'CASH' is not on the receipt");
			assertTrue(StreamSupport.stream(cashRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 10d),
					"Mobile money amount is correct");

			Optional<Row> mobileMoneyRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("MOBILE MONEY"))).findFirst();
			assertTrue(mobileMoneyRow.isPresent(), "'MOBILE MONEY' is on the receipt");
			assertTrue(StreamSupport.stream(mobileMoneyRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 21d),
					"Mobile money amount is correct");

			Optional<Row> totalPaymentRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Payment:"))).findFirst();
			assertTrue(totalPaymentRow.isPresent(), "Total payment row is included");
			assertTrue(StreamSupport.stream(totalPaymentRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 31d),
					"Total payment amount is correct");

			double outstandingAmount = 19d;
			Optional<Row> outstandingAmountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding:"))).findFirst();
			assertTrue(outstandingAmountRow.isPresent(), "Outstanding amount row is included");
			assertTrue(StreamSupport.stream(outstandingAmountRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Outstanding amount is correct");

			Optional<Row> outstandingFromPreviousVisitsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding previous"))).findFirst();
			assertTrue(outstandingFromPreviousVisitsRow.isPresent(), "Outstanding from previous visit row is included");
			assertTrue(StreamSupport.stream(outstandingFromPreviousVisitsRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 0d),
					"Outstanding from previous visit amount is correct");

			Optional<Row> totalOutstandingDebtRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Outstanding:"))).findFirst();
			assertTrue(totalOutstandingDebtRow.isPresent(), "Total outstanding debt row is included");
			assertTrue(StreamSupport.stream(totalOutstandingDebtRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Total outstanding amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void nonPatientPaymentsAppearOnReceipt() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create non-patient payment");
		valueObject.setRandom();
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setBH_SubType(MCharge_BH.BH_SUBTYPE_Waiver);
		valueObject.getCharge().setName(valueObject.getRandomNumber() + valueObject.getCharge().getName());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);

		valueObject.setStepName("Add non-patient payment to order");
		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(valueObject.getOrder().get_ID());
		orderLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		orderLine.setQty(Env.ONE);
		orderLine.setPrice(new BigDecimal(-20));
		orderLine.setHeaderInfo(valueObject.getOrder());
		orderLine.setPrice();
		orderLine.saveEx();
		commitEx();

		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocAction.ACTION_Complete), "Order completes");
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(14));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getVisit().get_ID()), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> cashRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("CASH"))).findFirst();
			assertTrue(cashRow.isPresent(), "Cash row is included");
			assertTrue(StreamSupport.stream(cashRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Cash amount is correct");

			Optional<Row> nonPatientPaymentRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains(valueObject.getCharge().getName().substring(0, 8)))).findFirst();
			assertTrue(nonPatientPaymentRow.isPresent(), "Non-patient-payment row is included");
			assertTrue(StreamSupport.stream(nonPatientPaymentRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 20d),
					"Non-patient-payment amount is correct");

			Optional<Row> totalPaymentRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Payment:"))).findFirst();
			assertTrue(totalPaymentRow.isPresent(), "Total payment row is included");
			assertTrue(StreamSupport.stream(totalPaymentRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 34d),
					"Total payment amount is correct");

			double outstandingAmount = 16d;
			Optional<Row> outstandingAmountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding:"))).findFirst();
			assertTrue(outstandingAmountRow.isPresent(), "Outstanding amount row is included");
			assertTrue(StreamSupport.stream(outstandingAmountRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Outstanding amount is correct");

			Optional<Row> outstandingFromPreviousVisitsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding previous"))).findFirst();
			assertTrue(outstandingFromPreviousVisitsRow.isPresent(), "Outstanding from previous visit row is included");
			assertTrue(StreamSupport.stream(outstandingFromPreviousVisitsRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 0d),
					"Outstanding from previous visit amount is correct");

			Optional<Row> totalOutstandingDebtRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Outstanding:"))).findFirst();
			assertTrue(totalOutstandingDebtRow.isPresent(), "Total outstanding debt row is included");
			assertTrue(StreamSupport.stream(totalOutstandingDebtRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == outstandingAmount), "Total outstanding amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void noOutstandingBalanceAppearsIfFullPaymentMade() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(50));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getVisit().get_ID()), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> cashRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("CASH"))).findFirst();
			assertTrue(cashRow.isPresent(), "Cash row is included");
			assertTrue(StreamSupport.stream(cashRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Cash amount is correct");

			Optional<Row> totalPaymentRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Payment:"))).findFirst();
			assertTrue(totalPaymentRow.isPresent(), "Total payment row is included");
			assertTrue(StreamSupport.stream(totalPaymentRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Total payment amount is correct");

			Optional<Row> outstandingAmountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding:"))).findFirst();
			assertTrue(outstandingAmountRow.isPresent(), "Outstanding amount row is included");
			assertTrue(StreamSupport.stream(outstandingAmountRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 0d),
					"Outstanding amount is correct");

			Optional<Row> outstandingFromPreviousVisitsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding previous"))).findFirst();
			assertTrue(outstandingFromPreviousVisitsRow.isPresent(), "Outstanding from previous visit row is included");
			assertTrue(StreamSupport.stream(outstandingFromPreviousVisitsRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 0d),
					"Outstanding from previous visit amount is correct");

			Optional<Row> totalOutstandingDebtRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Outstanding:"))).findFirst();
			assertTrue(totalOutstandingDebtRow.isPresent(), "Total outstanding debt row is included");
			assertTrue(StreamSupport.stream(totalOutstandingDebtRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 0d),
					"Total outstanding amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void outstandingBalanceFromPreviousVisitIsDisplayed() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(200));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(30));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(19));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create second visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(40));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(new BigDecimal(28));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create third visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create third sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create third payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(new BigDecimal(70));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getVisit().get_ID()), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> cashRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("CASH"))).findFirst();
			assertTrue(cashRow.isEmpty(), "Cash row is not included");

			Optional<Row> mobileMoney = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("MOBILE MONEY"))).findFirst();
			assertTrue(mobileMoney.isPresent(), "Mobile money row is included");
			assertTrue(StreamSupport.stream(mobileMoney.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Mobile money amount is correct");

			Optional<Row> totalPaymentRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Payment:"))).findFirst();
			assertTrue(totalPaymentRow.isPresent(), "Total payment row is included");
			assertTrue(StreamSupport.stream(totalPaymentRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
									cell.getNumericCellValue() == valueObject.getPayment().getBH_TenderAmount().doubleValue()),
					"Total payment amount is correct");

			Optional<Row> changeDueRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Change Due:"))).findFirst();
			assertTrue(changeDueRow.isPresent(), "Change due row is included");
			assertTrue(StreamSupport.stream(changeDueRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() ==
							(valueObject.getPayment().getBH_TenderAmount().doubleValue() -
									valueObject.getPayment().getPayAmt().doubleValue())), "Total payment amount is correct");

			Optional<Row> outstandingFromPreviousVisitsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Outstanding previous"))).findFirst();
			assertTrue(outstandingFromPreviousVisitsRow.isPresent(), "Outstanding from previous visit row is included");
			assertTrue(StreamSupport.stream(outstandingFromPreviousVisitsRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 23d),
					"Outstanding from previous visit amount is correct");

			Optional<Row> totalOutstandingDebtRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Total Outstanding:"))).findFirst();
			assertTrue(totalOutstandingDebtRow.isPresent(), "Total outstanding debt row is included");
			assertTrue(StreamSupport.stream(totalOutstandingDebtRow.get().spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) && cell.getNumericCellValue() == 23d),
					"Total outstanding amount is correct");
		}
	}
}
