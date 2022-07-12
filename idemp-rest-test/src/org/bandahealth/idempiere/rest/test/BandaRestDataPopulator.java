package org.bandahealth.idempiere.rest.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.compiere.model.PO;
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
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		// If the client doesn't exist, we'll create it
		// PO.setCrossTenantSafe();
		MClient_BH testClient = new Query(valueObject.getCtx(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
				valueObject.get_trxName()).setParameters("Rest Test Client").first();
		// PO.clearCrossTenantSafe();

		if (testClient == null) {
			valueObject.setStepName("Create Test Client");
			valueObject.setProcess_UU("b6ad401a-b8e0-465e-8ffb-1d5485b96efd");
			valueObject.setProcessRecord_ID(0);
			valueObject.setProcessTable_ID(0);
			valueObject.setProcessInfoParams(List.of(
					new ProcessInfoParameter("ClientName", "Rest Test Client", "", "", ""),
					new ProcessInfoParameter("C_Currency_ID", 266, "", "", ""), // KES
					new ProcessInfoParameter("IsSetInitialPassword", "Y", "", "", ""),
					new ProcessInfoParameter("C_Country_ID", 219, "", "", ""), // Kenya
					new ProcessInfoParameter("CityName", "Nairobi", "", "", ""),
					new ProcessInfoParameter("IsUseBPDimension", "Y", "", "", ""),
					new ProcessInfoParameter("IsUseProductDimension", "Y", "", "", ""),
					new ProcessInfoParameter("IsUseProjectDimension", "N", "", "", ""),
					new ProcessInfoParameter("IsUseCampaignDimension", "N", "", "", ""),
					new ProcessInfoParameter("IsUseSalesRegionDimension", "N", "", "", ""),
					new ProcessInfoParameter("ClientLevel", "B", "", "", ""), // Basic CoA
					new ProcessInfoParameter("IsUsingCashBox", "Y", "", "", ""),
					new ProcessInfoParameter("IsUsingMobile", "Y", "", "", ""),
					new ProcessInfoParameter("IsUsingSavings", "Y", "", "", ""),
					new ProcessInfoParameter("InactivateDefaults", "N", "", "", "")
			));

			BandaCreateEntity.runProcessAsSystem(valueObject);
			commitEx();
		}

		String sql = "SELECT '" + valueObject.getStepMsgLong() +
				"' as name, EXISTS(SELECT * FROM ad_client WHERE name = 'Rest Test Client') as result ";
		addAssertionSQL(sql);
	}

	@IPopulateAnnotation.CanRun
	public void restTestClientExists() {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		// PO.setCrossTenantSafe();
		MClient_BH testClient = new Query(valueObject.getCtx(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
				valueObject.get_trxName()).setParameters("Rest Test Client").first();
		// PO.clearCrossTenantSafe();

		assertNotNull(testClient);
	}
}
