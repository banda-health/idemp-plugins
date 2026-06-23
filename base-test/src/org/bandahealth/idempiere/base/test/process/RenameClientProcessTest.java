package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.MRole;
import org.compiere.model.MSession;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RenameClientProcessTest extends ChuBoePopulateFactoryVO {

	private static final String INITIAL_CLIENT_SETUP_PROCESS_UU = "b6ad401a-b8e0-465e-8ffb-1d5485b96efd";
	private static final String RENAME_CLINIC_PROCESS_UU = "730ece81-bfa9-418c-b73a-fe270507b94f";

	@IPopulateAnnotation.CanRun
	public void clientRenameCascadesToAllDerivedRecords() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		// Build the name of the client to rename from the (unique) scenario name. Cap it so the derived
		// accounting-schema name fits within its 60-char column at creation, and append an apostrophe to
		// confirm special characters are handled throughout the rename.
		String[] scenarioParts = valueObject.getScenarioName().split("_");
		String joinedScenarioName = Arrays.stream(scenarioParts).skip(1).collect(Collectors.joining("-"));
		// Effectively final (used in lambdas below): cap so the derived accounting-schema name fits its
		// 60-char column at creation, and append an apostrophe to confirm special characters are handled.
		final String oldName =
				(joinedScenarioName.length() > 30 ? joinedScenarioName.substring(0, 30) : joinedScenarioName) + "'a";

		// Create the client to rename (system-level process)
		valueObject.setStepName("Create the client to rename");
		valueObject.setProcessUuid(INITIAL_CLIENT_SETUP_PROCESS_UU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(List.of(
				new ProcessInfoParameter("ClientName", oldName, null, null, null),
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

		MClient_BH client;
		MOrg organization;
		try {
			PO.setCrossTenantSafe();
			client = new Query(valueObject.getContext(), MClient_BH.Table_Name, MClient_BH.COLUMNNAME_Name + "=?",
					valueObject.getTransactionName()).setOnlyActiveRecords(true).setParameters(oldName).first();
			assertNotNull(client, "Client to rename was created");
			organization = new Query(valueObject.getContext(), MOrg.Table_Name,
					MOrg.COLUMNNAME_AD_Client_ID + "=? AND " + MOrg.COLUMNNAME_AD_Org_ID + ">0",
					valueObject.getTransactionName()).setOnlyActiveRecords(true).setParameters(client.get_ID()).first();
			assertNotNull(organization, "Client organization exists");
			assertEquals(oldName, organization.getName(), "Organization is named after the client before rename");
		} finally {
			PO.clearCrossTenantSafe();
		}

		// New name: unique (via the client id), with an apostrophe, and forced to 40 characters so the run
		// also exercises truncation - the accounting-schema name (new name + " UN/.. Kenyan Shilling")
		// exceeds its 60-char column and must be clipped rather than error, while the 40-char value
		// columns hold the new name exactly. It must NOT start with the old name (so the "no role keeps the
		// old name" assertion is meaningful).
		StringBuilder newNameBuilder = new StringBuilder("Renamed O'Brien Clinic ").append(client.get_ID());
		while (newNameBuilder.length() < 40) {
			newNameBuilder.append('z');
		}
		final String newName = newNameBuilder.substring(0, 40);

		// Run the rename in the new client's context. The process reads its client from the context, so
		// switch the thread-local context (Env.getCtx(), which the process and POs read) to the new client,
		// org and one of its roles - plus a session, as ChuBoeCreateEntity.runProcessAsSystem does - then
		// restore everything afterward.
		Properties runContext = Env.getCtx();
		Properties savedVoContext = valueObject.getContext();
		int savedClientId = Env.getAD_Client_ID(runContext);
		int savedOrgId = Env.getAD_Org_ID(runContext);
		int savedRoleId = Env.getAD_Role_ID(runContext);
		int savedSessionId = Env.getContextAsInt(runContext, Env.AD_SESSION_ID);
		try {
			valueObject.setContext(runContext);
			Env.setContext(runContext, Env.AD_CLIENT_ID, client.get_ID());
			Env.setContext(runContext, Env.AD_ORG_ID, organization.get_ID());

			// In the client's context, one of its roles can be read same-tenant for the session
			MRole clientContextRole = new Query(runContext, MRole.Table_Name, MRole.COLUMNNAME_AD_Client_ID + "=?",
					valueObject.getTransactionName()).setOnlyActiveRecords(true).setParameters(client.get_ID()).first();
			assertNotNull(clientContextRole, "Client has a role to run the rename under");
			Env.setContext(runContext, Env.AD_ROLE_ID, clientContextRole.getAD_Role_ID());

			Env.setContext(runContext, Env.AD_SESSION_ID, 0);
			MSession session = MSession.create(runContext);
			session.saveEx();
			Env.setContext(runContext, Env.AD_SESSION_ID, session.get_ID());
			try {
				valueObject.setStepName("Rename the clinic");
				valueObject.setProcessUuid(RENAME_CLINIC_PROCESS_UU);
				valueObject.setProcessRecordId(0);
				valueObject.setProcessTableId(0);
				valueObject.setProcessInformationParameters(List.of(
						new ProcessInfoParameter("New Clinic Name", newName, null, null, null)
				));
				ChuBoeCreateEntity.runProcess(valueObject);
				commitEx();
			} finally {
				session.logout();
			}
		} finally {
			valueObject.setContext(savedVoContext);
			Env.setContext(runContext, Env.AD_CLIENT_ID, savedClientId);
			Env.setContext(runContext, Env.AD_ORG_ID, savedOrgId);
			Env.setContext(runContext, Env.AD_ROLE_ID, savedRoleId);
			Env.setContext(runContext, Env.AD_SESSION_ID, savedSessionId);
		}

		try {
			PO.setCrossTenantSafe();

			// The client and its organization are renamed
			MClient_BH renamedClient = new Query(valueObject.getContext(), MClient_BH.Table_Name,
					MClient_BH.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName())
					.setParameters(client.get_ID()).first();
			assertEquals(newName, renamedClient.getName(), "Client name is updated");

			MOrg renamedOrg = new Query(valueObject.getContext(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_ID + "=?",
					valueObject.getTransactionName()).setParameters(organization.get_ID()).first();
			assertEquals(newName, renamedOrg.getName(), "Organization name is updated");

			// The value (search key) columns are updated, truncated to their 40-char limit
			String expectedValue = newName.length() > 40 ? newName.substring(0, 40) : newName;
			assertEquals(expectedValue, renamedClient.getValue(),
					"Client value (search key) is updated and truncated to 40 characters");

			// Every role for the client now carries the new name prefix; none keep the old name
			List<MRole> clientRoles = new Query(valueObject.getContext(), MRole.Table_Name,
					MRole.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName()).setOnlyActiveRecords(true)
					.setParameters(client.get_ID()).list();
			assertTrue(clientRoles.size() > 0, "The client has roles to rename");
			assertTrue(clientRoles.stream().allMatch(role -> role.getName().startsWith(newName)),
					"All client roles are renamed with the new prefix");
			assertTrue(clientRoles.stream().noneMatch(role -> role.getName().startsWith(oldName)),
					"No client role keeps the old name");

			// Store rooms (warehouses): the clinic-named ones are renamed; none keep the old name
			List<MWarehouse> warehouses = new Query(valueObject.getContext(), MWarehouse.Table_Name,
					MWarehouse.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName()).setOnlyActiveRecords(true)
					.setParameters(client.get_ID()).list();
			assertTrue(warehouses.stream().anyMatch(warehouse -> warehouse.getName().startsWith(newName)),
					"A store room (warehouse) is renamed with the new prefix");
			assertTrue(warehouses.stream().noneMatch(warehouse -> warehouse.getName().startsWith(oldName)),
					"No store room keeps the old name");

			// The accounting schema is renamed and clipped to its 60-char column (no overflow error)
			MAcctSchema acctSchema = new Query(valueObject.getContext(), MAcctSchema.Table_Name,
					MAcctSchema.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName())
					.setParameters(client.get_ID()).first();
			assertNotNull(acctSchema, "Accounting schema exists");
			assertTrue(acctSchema.getName().startsWith(newName), "Accounting schema is renamed with the new prefix");
			assertTrue(acctSchema.getName().length() <= 60, "Accounting schema name is truncated to its 60-char column");

			// The calendar is renamed
			MCalendar calendar = new Query(valueObject.getContext(), MCalendar.Table_Name,
					MCalendar.COLUMNNAME_AD_Client_ID + "=?", valueObject.getTransactionName())
					.setParameters(client.get_ID()).first();
			assertNotNull(calendar, "Calendar exists");
			assertTrue(calendar.getName().startsWith(newName), "Calendar is renamed with the new prefix");
		} finally {
			PO.clearCrossTenantSafe();
		}
	}
}
