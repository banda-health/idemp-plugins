package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DailyCashierCollectionsTest extends ChuBoePopulateFactoryVO {

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();
		String patientSuffix = String.valueOf(valueObject.getRandom());

		valueObject.setStepName("Create product");
		valueObject.setRandom();
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setRandom();
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("fb90406f-1ba4-43df-9cec-6844e10c13d9");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		BandaCreateEntity.runReport(valueObject);
		commitEx();

		MUser_BH currentUser = new Query(valueObject.getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_ID + "=?",
				valueObject.get_trxName()).setParameters(Env.getAD_User_ID(valueObject.getCtx())).first();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Patient's name is on the report", reportContent, containsString(patientSuffix));
		assertThat("The cashier's name is on the report", reportContent, containsString(currentUser.getName()));
	}
}
