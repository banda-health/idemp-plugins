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
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void canRunReport() throws SQLException, IOException {
        ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
        valueObject.prepareIt(getScenarioName(), true, get_TrxName());
        assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));
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

            Optional<Row> titleRow = StreamSupport
                    .stream(sheet.spliterator(), false).filter(
                            row -> StreamSupport.stream(row.spliterator(), false)
                                    .anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
                                            && cell.getStringCellValue().contains("Income Statement (Profit & Loss)")))
                    .findFirst();
            assertTrue(titleRow.isPresent(), "title is present");
        }
    }
}
