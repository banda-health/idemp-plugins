package org.bandahealth.idempiere.rest.test;

import com.chuboe.test.assertion.ChuBoeAssert;
import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

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
		MClient_BH testClient =
				new Query(valueObject.getContext(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
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

//		PO.setCrossTenantSafe();
		testClient = new Query(valueObject.getContext(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
				valueObject.getTransactionName()).setParameters("Rest Test Client").first();
		int currentClientId = Env.getAD_Client_ID(valueObject.getContext());
		Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, testClient.get_ID());
		try {
			MWarehouse_BH mainWarehouse = new Query(valueObject.getContext(), MWarehouse_BH.Table_Name,
					MWarehouse_BH.COLUMNNAME_BH_DEFAULTWAREHOUSE + "=? AND " + MWarehouse_BH.COLUMNNAME_AD_Client_ID + "=?",
					valueObject.getTransactionName()).setParameters("Y", testClient.get_ID()).setOnlyActiveRecords(true).first();
			MOrg testOrganization = new Query(valueObject.getContext(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Client_ID + "=?",
					valueObject.getTransactionName()).setParameters(testClient.get_ID()).first();

			valueObject.setStepName("Create secondary warehouse");
			MWarehouse_BH secondWarehouse = new Query(valueObject.getContext(), MWarehouse_BH.Table_Name,
					MWarehouse_BH.COLUMNNAME_Name + "=? AND " + MWarehouse_BH.COLUMNNAME_AD_Client_ID + "=?",
					valueObject.getTransactionName()).setParameters("Secondary Warehouse", testClient.get_ID())
					.setOnlyActiveRecords(true).first();
			if (secondWarehouse == null) {
				secondWarehouse = new MWarehouse_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
				secondWarehouse.setBH_IsDefaultWarehouse(false);
				secondWarehouse.setName("Secondary Warehouse");
				secondWarehouse.setAD_Org_ID(testOrganization.get_ID());
				secondWarehouse.setIsDisallowNegativeInv(mainWarehouse.isDisallowNegativeInv());
				secondWarehouse.setC_Location_ID(mainWarehouse.getC_Location_ID());
				secondWarehouse.saveEx();
			}
			sql = "SELECT '" + valueObject.getStepMessageLong() +
					"' as name, EXISTS(SELECT * FROM m_warehouse WHERE name = 'Secondary Warehouse' AND ad_client_id = " +
					testClient.get_ID() + ") as result ";
			addAssertionSQL(sql);
			commitEx();

			valueObject.setStepName("Create secondary warehouse");
			MLocator secondLocator = new Query(valueObject.getContext(), MLocator.Table_Name,
					MLocator.COLUMNNAME_M_Warehouse_ID + "=? AND " + MLocator.COLUMNNAME_IsDefault + "=?",
					valueObject.getTransactionName()).setParameters(secondWarehouse.get_ID(), "Y").first();
			if (secondLocator == null) {
				secondLocator = new MLocator(valueObject.getContext(), 0, valueObject.getTransactionName());
				secondLocator.setIsDefault(true);
				secondLocator.setAD_Org_ID(testOrganization.get_ID());
				secondLocator.setM_Warehouse_ID(secondWarehouse.get_ID());
				secondLocator.saveEx();
			}
			sql = "SELECT '" + valueObject.getStepMessageLong() +
					"' as name, EXISTS(SELECT * FROM m_locator WHERE isdefault = 'Y' AND m_warehouse_id = " +
					secondWarehouse.get_ID() + ") as result ";
			addAssertionSQL(sql);

			valueObject.setStepName("Make sure the rest client always uses any new features");
			MSysConfig_BH newFeatureClientUuids = MSysConfig_BH.getByNameForSystem(valueObject.getContext(),
					MSysConfig_BH.NEW_FEATURE_ROLLOUT_ALLOW_FOR_CLIENTS, valueObject.getTransactionName());
			if (!newFeatureClientUuids.getValue().contains(testClient.getAD_Client_UU())) {
				if (newFeatureClientUuids.getValue().isEmpty() || newFeatureClientUuids.getValue().isBlank()) {
					newFeatureClientUuids.setValue(testClient.getAD_Client_UU());
				} else {
					newFeatureClientUuids.setValue(newFeatureClientUuids.getValue() + "," + testClient.getAD_Client_UU());
				}
				newFeatureClientUuids.saveEx();
			}
			commitEx();
		} catch (Exception exception) {
			fail(exception);
		} finally {
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, currentClientId);
		}
//		PO.clearCrossTenantSafe();
	}

	@IPopulateAnnotation.CanRun
	public void restTestClientExists() {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		// PO.setCrossTenantSafe();
		MClient_BH testClient =
				new Query(valueObject.getContext(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
						valueObject.getTransactionName()).setParameters("Rest Test Client").first();
		// PO.clearCrossTenantSafe();

		assertNotNull(testClient);
		ChuBoeAssert.executeSQLAsserts(getAssertionSQL(), valueObject.getContext(), valueObject.getTransactionName());
	}
}
