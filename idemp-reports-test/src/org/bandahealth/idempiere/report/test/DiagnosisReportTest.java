package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiagnosisReportTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		String patientNameSuffix = String.valueOf(valueObject.getRandom());
		commitEx();

		valueObject.setStepName("Create product");
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create coded diagnosis");
		valueObject.setRandom();
		MBHCodedDiagnosis codedDiagnosis = new MBHCodedDiagnosis(valueObject.getCtx(), 0, valueObject.get_trxName());
		codedDiagnosis.setBH_CielName(valueObject.getScenarioName());
		codedDiagnosis.saveEx();
		String diagnosisNameSuffix = String.valueOf(valueObject.getRandom());
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setRandom();
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrderBH();
		String nonCodedDiagnosis = "The Diagnosis of the Century";
		order.setBH_PrimaryUnCodedDiagnosis(nonCodedDiagnosis);
		order.setBH_PrimaryCodedDiagnosisID(codedDiagnosis.get_ID());
		order.setDocAction(MOrder_BH.ACTION_Complete);
		order.processIt(MOrder_BH.ACTION_Complete);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("7c29028a-8dd3-4025-a5af-87701748d81f");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		BandaCreateEntity.runReport(valueObject);
		commitEx();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("The patient's name is on the report", reportContent, containsString(patientNameSuffix));
		assertThat("The coded diagnosis is on the report", reportContent, containsString(diagnosisNameSuffix));
		assertThat("The non-coded diagnosis is on the report", reportContent, containsString(nonCodedDiagnosis));
	}
}
