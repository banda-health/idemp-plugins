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
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OTCSalesTest extends ChuBoePopulateFactoryVO {
	private static final String reportUU = "b8508f0a-c66f-4030-a88c-3ae383322ceb";
	private MBPGroup_BH otcBusinessPartnerGroup;

	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();

		otcBusinessPartnerGroup =
				new Query(valueObject.getContext(), MBPGroup_BH.Table_Name, MBPGroup_BH.COLUMNNAME_Name + "=?",
						valueObject.getTransactionName()).setParameters(MBPGroup_BH.NAME_OTC).setClient_ID().first();
		if (otcBusinessPartnerGroup == null) {
			otcBusinessPartnerGroup = new MBPGroup_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			otcBusinessPartnerGroup.setValue(MBPGroup_BH.NAME_OTC);
			otcBusinessPartnerGroup.setDescription("DO NOT CHANGE");
			otcBusinessPartnerGroup.setName(MBPGroup_BH.NAME_OTC);
			otcBusinessPartnerGroup.saveEx();
		}
	}

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBPGroup(otcBusinessPartnerGroup);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Sale Date");
			int productNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Product Name");

			List<Row> productRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(productNameColumnIndex) != null && row.getCell(5).getCellType().equals(CellType.STRING) &&
							row.getCell(productNameColumnIndex).getStringCellValue()
									.contains(valueObject.getProduct().getName().substring(0, 30))).collect(Collectors.toList());
			assertEquals(1, productRows.size(), "Product only appears once");
		}
	}

	@IPopulateAnnotation.CanRun
	public void orderLinesFromIncludedProductsDontAppear() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBPGroup(otcBusinessPartnerGroup);
		valueObject.getBusinessPartner().saveEx();
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

		valueObject.setStepName("Generate the invoice report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains(valueObject.getProduct().getName()))).findFirst();
			assertTrue(productRow.isPresent(), "Regular product is on the report");
			productRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains(product1.getName()))).findFirst();
			assertTrue(productRow.isEmpty(), "Included product is not on the report");
		}
	}

	@IPopulateAnnotation.CanRun
	public void totalsByCashierWorksCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double cashTotal = 0;
		double mobileMoneyTotal = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> totalsRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Total"))).collect(Collectors.toUnmodifiableList());
			if (totalsRows.size() > 1) {
				for (Cell cell : totalsRows.get(0)) {
					if (cell != null && cell.getCellType().equals(CellType.STRING)) {
						if (cell.getStringCellValue().equals("Cash")) {
							cashTotal = totalsRows.get(1).getCell(cell.getColumnIndex()).getNumericCellValue();
						} else if (cell.getStringCellValue().equals("Mobile Money")) {
							mobileMoneyTotal = totalsRows.get(1).getCell(cell.getColumnIndex()).getNumericCellValue();
						}
					}
				}
			}
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBPGroup(otcBusinessPartnerGroup);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create first product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();
		MProduct_BH firstProduct = valueObject.getProduct();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second product");
		valueObject.clearProduct();
		valueObject.setSalesPrice(new BigDecimal(5));
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();
		MProduct_BH secondProduct = valueObject.getProduct();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setProduct(firstProduct);
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add second order line");
		valueObject.setProduct(secondProduct);
		MOrder_BH order = valueObject.getOrder();
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setOrder(order);
		valueObject.getOrderLine().setC_Order_ID(order.get_ID());
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Complete the order");
		order.setDocAction(DocAction.ACTION_Complete);
		assertTrue(order.processIt(DocAction.ACTION_Complete), "Order was completed");
		commitEx();

		valueObject.setStepName("Create first payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(9));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create second payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(6));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		double newCashTotal = 0;
		double newMobileMoneyTotal = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> totalsRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Total"))).collect(Collectors.toUnmodifiableList());
			assertEquals(2, totalsRows.size(), "Totals rows are present");
			for (Cell cell : totalsRows.get(0)) {
				if (cell != null && cell.getCellType().equals(CellType.STRING)) {
					if (cell.getStringCellValue().equals("Cash")) {
						newCashTotal = totalsRows.get(1).getCell(cell.getColumnIndex()).getNumericCellValue();
					} else if (cell.getStringCellValue().equals("Mobile Money")) {
						newMobileMoneyTotal = totalsRows.get(1).getCell(cell.getColumnIndex()).getNumericCellValue();
					}
				}
			}
		}
		assertEquals(cashTotal + 9, newCashTotal, "Cash total is correct");
		assertEquals(mobileMoneyTotal + 6, newMobileMoneyTotal, "Mobile money total is correct");
	}
	@IPopulateAnnotation.CanRun
	public void totalsCorrectlyUseBigDecimal() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate baseline report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		Map<String, Double> baselineTotals = new HashMap<>();
		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> totalsRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Total"))).collect(Collectors.toUnmodifiableList());
			if (totalsRows.size() > 1) {
				for (Cell cell : totalsRows.get(0)) {
					if (cell != null && cell.getCellType().equals(CellType.STRING)) {
						Cell valueCell = totalsRows.get(1).getCell(cell.getColumnIndex());
						if (valueCell != null && valueCell.getCellType().equals(CellType.NUMERIC)) {
							baselineTotals.put(cell.getStringCellValue(), valueCell.getNumericCellValue());
						}
					}
				}
			}
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBPGroup(otcBusinessPartnerGroup);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(new BigDecimal("10.50"));
		ChuBoeCreateEntity.createProduct(valueObject);
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
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setQuantity(new BigDecimal(2));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Complete the order");
		MOrder_BH order = valueObject.getOrder();
		order.setDocAction(DocAction.ACTION_Complete);
		assertTrue(order.processIt(DocAction.ACTION_Complete), "Order was completed");
		order.saveEx();
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal("21.00"));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> totalsRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("Total"))).collect(Collectors.toUnmodifiableList());
			assertEquals(2, totalsRows.size(), "Totals rows are present");
			for (Cell cell : totalsRows.get(0)) {
				if (cell != null && cell.getCellType().equals(CellType.STRING)) {
					String columnLabel = cell.getStringCellValue();
					if (columnLabel.equals("Total")) {
						continue;
					}
					Cell valueCell = totalsRows.get(1).getCell(cell.getColumnIndex());
					if (valueCell != null && valueCell.getCellType().equals(CellType.NUMERIC)) {
						double baseline = baselineTotals.getOrDefault(columnLabel, 0.0);
						double expected = columnLabel.equals("Cash") ? baseline + 21.00 : baseline;
						assertEquals(expected, valueCell.getNumericCellValue(), 0.001,
								columnLabel + " total correctly shows BigDecimal value");
					}
				}
			}
		}
	}
}
