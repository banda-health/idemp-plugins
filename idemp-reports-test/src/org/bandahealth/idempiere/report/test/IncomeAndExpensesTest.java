package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.ProcessInfoParameter;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class IncomeAndExpensesTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("f777f042-3907-4293-94c4-49fe6eb58780");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.lastMonth(), null, null, null),
				new ProcessInfoParameter("End Date", new Timestamp(System.currentTimeMillis()), null, null, null)
		));
		BandaCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Income section is on the report", reportContent, containsString("INCOME"));
		assertThat("Expenses section is on the report", reportContent, containsString("EXPENSES"));
	}
}
