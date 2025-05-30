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
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
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
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class IncomeStatementProfitAndLossTest extends ChuBoePopulateFactoryVO {
    private static final String incomeStatementProfitAndLossReportUuid = "8ea6c947-4450-48dd-8bd0-76b0f307dcb0";
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
    public void IncomeRevenueIsCorrectlyGenerated() throws SQLException, IOException {
        ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
        valueObject.prepareIt(getScenarioName(), true, get_TrxName());
        assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

        valueObject.setStepName("Create business partner");
        ChuBoeCreateEntity.createPatient(valueObject);
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

        valueObject.setStepName("Create first visit");
        Timestamp valueObjectDate = valueObject.getDate();
        valueObject.setDate(valueObjectDate);
        ChuBoeCreateEntity.createVisit(valueObject);
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

        valueObject.clearProduct();
        valueObject.setStepName("Create Service");
        ChuBoeCreateEntity.createProduct(valueObject);
        valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
        commitEx();

        valueObject.setStepName("Create first visit");
        ChuBoeCreateEntity.createVisit(valueObject);
        commitEx();

        valueObject.setStepName("Create second sales order");
        valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
        valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
                false, false);
        valueObject.setQuantity(new BigDecimal(4000));
        ChuBoeCreateEntity.createOrder(valueObject);
        commitEx();

        valueObject.setStepName("Create payment for the second sales order");
        valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
        valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
        valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
        valueObject.setPaymentAmount(new BigDecimal(1300));
        ChuBoeCreateEntity.createPayment(valueObject);
        commitEx();
        valueObject.setStepName("Generate the report");
        valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
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
            Row headerRow = TableUtils.getHeaderRow(sheet, "Item");
            int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");


            Optional<Row> titleRow = StreamSupport
                    .stream(sheet.spliterator(), false).filter(
                            row -> StreamSupport.stream(row.spliterator(), false)
                                    .anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
                                            && cell.getStringCellValue().contains("Income Statement (Profit & Loss)")))
                    .findFirst();
            assertTrue(titleRow.isPresent(), "title is present");
            Optional<Row> productSalesRow = StreamSupport
                    .stream(sheet.spliterator(), false).filter(
                            row -> StreamSupport.stream(row.spliterator(), false)
                                    .anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
                                            && cell.getStringCellValue().contains("Product Sales")))
                    .findFirst();
            assertTrue(productSalesRow.isPresent(), "product Revenue is present");
            assertEquals(1300, productSalesRow.get().getCell(amountColumnIndex).getNumericCellValue());
            Optional<Row> serviceRevenueRow = StreamSupport
                    .stream(sheet.spliterator(), false).filter(
                            row -> StreamSupport.stream(row.spliterator(), false)
                                    .anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
                                            && cell.getStringCellValue().contains("Service Revenue")))
                    .findFirst();
            assertTrue(serviceRevenueRow.isPresent(), "Service Revenue is present");
            assertEquals(400, serviceRevenueRow .get().getCell(amountColumnIndex).getNumericCellValue());
        }
    }
}
