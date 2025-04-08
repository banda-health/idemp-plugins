package org.bandahealth.idempiere.report.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;

import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.hamcrest.Matchers;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;

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
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientsReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Patient's name is on the report", reportContent,
				containsString(valueObject.getBusinessPartner().getName().substring(0, 30)));
	}
}
