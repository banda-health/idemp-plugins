package org.bandahealth.idempiere.webui;

import org.bandahealth.idempiere.webui.util.DashboardSideMenuDataPopulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.AdempiereTestCase;

public class DashboardSideMenuDataPopulatorTest extends AdempiereTestCase{

	private DashboardSideMenuDataPopulator dashboardMenuPopulator;
	@Mock
	
	
	@Before
	public void setup() {
		try {
			super.setUp();
			dashboardMenuPopulator = new DashboardSideMenuDataPopulator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetButtonGroupsListNotNull() {
		dashboardMenuPopulator.getButtonGroups();
		assertNotNull(object);
	}
	
	@After
	public void tearDown() {
		
	}
}
