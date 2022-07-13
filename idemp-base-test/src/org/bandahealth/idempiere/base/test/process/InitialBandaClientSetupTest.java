package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.assertion.ChuBoeAssert;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MRole;
import org.compiere.model.MUserRoles;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InitialBandaClientSetupTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRun
	public void clientIsCreatedProperly() throws SQLException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		valueObject.setStepName("Create a system user");
		int currentClientId = Env.getAD_Client_ID(valueObject.getCtx());
		Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, 0);
		MUser_BH newSystemUser = new MUser_BH(valueObject.getCtx(), 0, valueObject.get_trxName());
		newSystemUser.setName(valueObject.getScenarioName());
		newSystemUser.setDescription(valueObject.getStepMsgLong());
		newSystemUser.saveEx();
		commitEx();

		MUserRoles userRole = new MUserRoles(valueObject.getCtx(), 0, valueObject.get_trxName());
		userRole.setAD_Role_ID(0);
		userRole.setAD_User_ID(newSystemUser.get_ID());
		userRole.saveEx();
		commitEx();
		Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, currentClientId);

		valueObject.setStepName("Create Client");
		valueObject.setProcess_UU("b6ad401a-b8e0-465e-8ffb-1d5485b96efd");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		// The DB has many hard limits of 60 characters for names, some with something appended to the client name
		// So, limit the client name to 40 characters (and replace any underscores from the scenario name with dashes)
		String[] scenarioParts = valueObject.getScenarioName().split("_");
		String clientName = Arrays.stream(scenarioParts).skip(1).collect(Collectors.joining("-"));
		if (clientName.length() > 40) {
			clientName = clientName.substring(0, 40);
		}
		valueObject.setProcessInfoParams(List.of(
				new ProcessInfoParameter("ClientName", clientName, null, null, null),
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

		BandaCreateEntity.runProcessAsSystem(valueObject);
		commitEx();

		try {
			PO.setCrossTenantSafe();

			// Assert client and organization are created
			MClient_BH client = new Query(valueObject.getCtx(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
					valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(clientName).first();
			assertNotNull(client, "Client exists");
			List<MOrg> organizations = new Query(valueObject.getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Client_ID + "=?",
					valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(client.get_ID()).list();
			assertEquals(1, organizations.size(), "Only one organization created by default");
			MOrg organization = organizations.get(0);

			// Assert correct creation and assignment of roles
			List<MRole> masterRoles = new Query(valueObject.getCtx(), MRole.Table_Name,
					MRole.COLUMNNAME_IsMasterRole + "=? AND " + MRole.COLUMNNAME_AD_Role_ID + " IN (SELECT " +
							MBHDefaultIncludedRole.COLUMNNAME_Included_Role_ID + " FROM " + MBHDefaultIncludedRole.Table_Name + ")",
					valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters("Y").list();
			List<MRole> clientRoles = new Query(valueObject.getCtx(), MRole.Table_Name, MRole.COLUMNNAME_AD_Client_ID + "=?",
					valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(client.get_ID()).list();
			assertEquals(masterRoles.size(), clientRoles.size() - 2,
					"A role was created for each master role, plus the two default roles");

			MUser_BH clientAdminUser = new Query(valueObject.getCtx(), MUser_BH.Table_Name,
					MUser_BH.COLUMNNAME_AD_Client_ID + "=? AND " + MUser_BH.COLUMNNAME_Name + "=?",
					valueObject.get_trxName()).setOnlyActiveRecords(true)
					.setParameters(client.get_ID(), client.getName() + "Admin").first();
			assertNotNull(clientAdminUser, "Admin user was created");
			// The `getRoles` method reads the environment context, so update it
			Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, client.get_ID());
			assertEquals(masterRoles.size() + 2, newSystemUser.getRoles(organization.get_ID()).length,
					"System users are assigned new roles, including the two iDempiere adds by default");
			Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, currentClientId);

			// Assert default warehouse & locators created
			List<MWarehouse_BH> warehouses =
					new Query(valueObject.getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_AD_Org_ID + "=?",
							valueObject.get_trxName()).setParameters(organization.get_ID()).setOnlyActiveRecords(true).list();
			assertThat("Only one warehouse is created", warehouses.size(), is(1));
			assertTrue(warehouses.get(0).isBH_IsDefaultWarehouse(), "The warehouse is default");
			List<MLocator> locators =
					new Query(valueObject.getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Warehouse_ID + "=?",
							valueObject.get_trxName()).setParameters(warehouses.get(0).get_ID()).setOnlyActiveRecords(true).list();
			assertThat("Only one locator is created", locators.size(), is(1));
			assertTrue(locators.get(0).isDefault(), "The locator is default");

			// Assert attribute sets created
			List<MAttributeSet_BH> configurationClientAttributeSets =
					new Query(valueObject.getCtx(), MAttributeSet.Table_Name, MAttributeSet_BH.COLUMNNAME_AD_Client_ID + "=?",
							valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(MClient_BH.CLIENTID_CONFIG).list();
			List<MAttributeSet_BH> clientAttributeSets =
					new Query(valueObject.getCtx(), MAttributeSet.Table_Name, MAttributeSet_BH.COLUMNNAME_AD_Client_ID + "=?",
							valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(client.get_ID()).list();
			assertEquals(configurationClientAttributeSets.size(), clientAttributeSets.size(), "Attribute sets were created");
			assertTrue(clientAttributeSets.stream().allMatch(MAttributeSet_BH::isBH_Locked),
					"All client attributes sets are marked as locked");

			// Assert default charges and charge types are created
			List<MCharge_BH> configurationClientCharges =
					new Query(valueObject.getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_AD_Client_ID + "=?",
							valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(MClient_BH.CLIENTID_CONFIG).list();
			List<MCharge_BH> clientCharges =
					new Query(valueObject.getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_AD_Client_ID + "=?",
							valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(client.get_ID()).list();
			assertEquals(configurationClientCharges.size(), clientCharges.size(), "Charges were created");
			assertTrue(clientCharges.stream().allMatch(MCharge_BH::isBH_Locked), "All client charges are marked as locked");

			List<MChargeType_BH> configurationClientChargeTypes =
					new Query(valueObject.getCtx(), MChargeType_BH.Table_Name, MChargeType_BH.COLUMNNAME_AD_Client_ID + "=?",
							valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(MClient_BH.CLIENTID_CONFIG).list();
			Set<Integer> clientChargeTypeIds =
					clientCharges.stream().map(MCharge_BH::getC_ChargeType_ID).collect(Collectors.toSet());
			assertTrue(clientChargeTypeIds.size() > 0, "Client charge types were created");
			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(clientChargeTypeIds, parameters);
			List<MChargeType_BH> clientChargeTypes = new Query(valueObject.getCtx(), MChargeType_BH.Table_Name,
					MChargeType_BH.COLUMNNAME_C_ChargeType_ID + " IN (" + whereClause + ")",
					valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(parameters).list();
			assertEquals(configurationClientChargeTypes.size(), clientChargeTypes.size(), "Charge Types were created");
			assertTrue(clientChargeTypes.stream().allMatch(chargeType -> chargeType.getAD_Client_ID() == client.get_ID()),
					"All client charge types are mapped to the correct client");

			// Assert CoA is inserted
			assertTrue(new Query(valueObject.getCtx(), MElementValue.Table_Name,
							MElementValue.COLUMNNAME_Value + "!=? AND " + MElementValue.COLUMNNAME_AD_Client_ID + "=?",
							valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters("99999", client.get_ID()).count() > 0,
					"Non DO NOT USE accounts created");

			// Assert bank accounts are created
			addAssertionSQL(
					"SELECT " +
							"	'Assert that Cash, Mobile, Savings, and the Default Bank Accounts were created' AS name, " +
							"	(" +
							"		SELECT COUNT(*) = 4 " +
							"		FROM c_bankaccount " +
							"		WHERE ad_client_id = " + client.get_ID() +
							"			AND isactive = 'Y'" +
							"	)                                                                               AS result"
			);
			addAssertionSQL(
					"SELECT " +
							"	'All bank accounts map to an account' AS name, " +
							"	COUNT(*) = 0                          AS result " +
							"FROM " +
							"	c_elementvalue ev " +
							"		JOIN c_validcombination vc " +
							"			ON ev.c_elementvalue_id = vc.account_id " +
							"		JOIN c_bankaccount_acct baa " +
							"			ON vc.c_validcombination_id = baa.b_asset_acct " +
							"		JOIN c_bankaccount ba " +
							"			ON baa.c_bankaccount_id = ba.c_bankaccount_id " +
							"WHERE " +
							"	ba.ad_client_id = " + client.get_ID() +
							"	AND ba.isactive = 'Y'" +
							"	AND ev.value = '999999'"
			);

			// Assert price lists are created
			List<MPriceList> priceLists =
					new Query(valueObject.getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_AD_Client_ID + "=?",
							valueObject.get_trxName()).setOnlyActiveRecords(true).setParameters(client.get_ID()).list();
			assertEquals(2, priceLists.size(), "Only two price lists exist for a client");
			assertTrue(priceLists.stream().anyMatch(MPriceList::isSOPriceList), "One is a sales price list");
			assertTrue(priceLists.stream().anyMatch(Predicate.not(MPriceList::isSOPriceList)),
					"One is a purchase price list");

			// Price list versions valid from is a year ago
			addAssertionSQL(
					"SELECT " +
							"	'Price List Versions are valid from at least a year in the past' AS name, " +
							"	(" +
							"		SELECT " +
							"			COUNT(*) = 2 " +
							"		FROM " +
							"			m_pricelist_version " +
							"		WHERE " +
							"			ad_client_id = " + client.get_ID() +
							"			AND validfrom <= NOW() - '1 year'::interval" +
							"	)                                                                AS result"
			);

			// Assert calendar year periods are opened
			addAssertionSQL(
					"SELECT " +
							"	'Ensure all periods are open'                                 AS name, " +
							"	NOT EXISTS(SELECT * " +
							"	           FROM " +
							"		           c_period p " +
							"			           JOIN c_periodcontrol pc " +
							"				           ON p.c_period_id = pc.c_period_id " +
							"	           WHERE " +
							"		           p.ad_client_id = " + client.get_ID() +
							"		           AND (p.isactive = 'N' OR pc.periodstatus = 'C')) AS result"
			);

			// Assert default business partners are deactivated
			addAssertionSQL(
					"SELECT " +
							"	'Default customer Business Partners are inactive' AS name, " +
							"	NOT EXISTS(SELECT * " +
							"	           FROM " +
							"		           c_bpartner " +
							"	           WHERE " +
							"		           ad_client_id = " + client.get_ID() +
							"		           AND iscustomer = 'Y' " +
							"		           AND isactive = 'Y')                  AS result"
			);
		} finally {
			PO.clearCrossTenantSafe();
			// Ensure client ID is correct...
			Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, currentClientId);
		}

		ChuBoeAssert.executeSQLAsserts(getAssertionSQL(), valueObject.getCtx(), valueObject.get_trxName());
	}
}
