package org.bandahealth.idempiere.webui;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.util.DashboardSideMenuDataService;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import test.AdempiereTestCase;

public class DashboardSideMenuDataPopulatorTest extends AdempiereTestCase {

	private DashboardSideMenuDataService dashboardSideMenuDataService;
	private List<MHomeScreenButtonGroup> groups;

	public static List<String> buttonGroupNames() {
		return Arrays.asList(new String[] { "Patients and Suppliers", "My Products Services and Expenses",
		        "Cashier and Accounts", "Pharmacy and Stores", "Reports", "Metrics" });
	}

	@Override
	@BeforeClass
	public void setUp() throws Exception {
		super.setUp();
		dashboardSideMenuDataService = new DashboardSideMenuDataService();
		groups = dashboardSideMenuDataService.getButtonGroups();
	}

	@Test
	public void testDashboardPopulatorIsNotNull() {
		assertThat(dashboardSideMenuDataService, notNullValue());
	}

	@Test
	public void testButtonGroupsInstancesReturned() {
		assertThat(groups, everyItem(instanceOf(MHomeScreenButtonGroup.class)));
	}

	@Test
	public void testButtonGroupsFirstEntryHasNamesDefined() {
		assertThat(groups.get(0).getName(),containsString(buttonGroupNames().get(0)));
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		dashboardSideMenuDataService = null;
	}
}
