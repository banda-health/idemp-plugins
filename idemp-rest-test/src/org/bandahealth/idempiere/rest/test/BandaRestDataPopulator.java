package org.bandahealth.idempiere.rest.test;

import com.chuboe.test.assertion.ChuBoeAssert;
import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is meant to populate all needed data for the Rest API tests
 */
public class BandaRestDataPopulator extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRunBeforeClass
	public void createClientForRestTests() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		// If the client doesn't exist, we'll create it
		// PO.setCrossTenantSafe();
		MClient_BH testClient = new Query(valueObject.getContext(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
				valueObject.getTransactionName()).setParameters("Rest Test Client").first();
		// PO.clearCrossTenantSafe();

		if (testClient == null) {
			valueObject.setStepName("Create Test Client");
			valueObject.setProcessUuid("b6ad401a-b8e0-465e-8ffb-1d5485b96efd");
			valueObject.setProcessRecordId(0);
			valueObject.setProcessTableId(0);
			valueObject.setProcessInformationParameters(List.of(
					new ProcessInfoParameter("ClientName", "Rest Test Client", null, null, null),
					new ProcessInfoParameter("C_Currency_ID", 266, null, null, null), // KES
					new ProcessInfoParameter("IsSetInitialPassword", "Y", null, null, null),
					new ProcessInfoParameter("C_Country_ID", 219, null, null, null), // Kenya
					new ProcessInfoParameter("CityName", "Nairobi", null, null, null),
					new ProcessInfoParameter("IsUseBPDimension", "Y", null, null, null),
					new ProcessInfoParameter("IsUseProductDimension", "Y", null, null, null),
					new ProcessInfoParameter("IsUseProjectDimension", "N", null, null, null),
					new ProcessInfoParameter("IsUseCampaignDimension", "N", null, null, null),
					new ProcessInfoParameter("IsUseSalesRegionDimension", "N", null, null, null),
					new ProcessInfoParameter("ClientLevel", "B", null, null, null), // Basic CoA
					new ProcessInfoParameter("IsUsingCashBox", "Y", null, null, null),
					new ProcessInfoParameter("IsUsingMobile", "Y", null, null, null),
					new ProcessInfoParameter("IsUsingSavings", "Y", null, null, null),
					new ProcessInfoParameter("InactivateDefaults", "N", null, null, null)
			));

			ChuBoeCreateEntity.runProcessAsSystem(valueObject);
			commitEx();
		}

		String sql = "SELECT '" + valueObject.getStepMessageLong() +
				"' as name, EXISTS(SELECT * FROM ad_client WHERE name = 'Rest Test Client') as result ";
		addAssertionSQL(sql);
	}

	@IPopulateAnnotation.CanRun
	public void restTestClientExists() {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		// PO.setCrossTenantSafe();
		MClient_BH testClient = new Query(valueObject.getContext(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
				valueObject.getTransactionName()).setParameters("Rest Test Client").first();
		// PO.clearCrossTenantSafe();

		assertNotNull(testClient);
		ChuBoeAssert.executeSQLAsserts(getAssertionSQL(), valueObject.getContext(), valueObject.getTransactionName());
	}
}
