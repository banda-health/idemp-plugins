package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.SQLException;
import java.util.List;

public class ImportBusinessPartnersProcessTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRun
	public void businessPartnerIsImportedProperly() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Run CSV Import");
		valueObject.setProcessUuid("95ee94ea-d050-4f20-b4f3-1b6776df6d62");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(List.of(
				new ProcessInfoParameter("AD_ImportTemplate_ID", "1000000", null, null, null),
				new ProcessInfoParameter("FileName", "./data/import/BandaBusinessPartnerImportTest.csv", null, null, null),
				new ProcessInfoParameter("ImportMode", "I", null, null, null)
		));

		ChuBoeCreateEntity.runProcessAsSystem(valueObject);
		assertThat("Process ran successfully", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));
		commitEx();
    }
}
