package org.bandahealth.idempiere.webui;

import org.junit.Test;

import test.AdempiereTestCase;

public class DashboardMenuTest extends AdempiereTestCase {

	private DashboardMenu myMenu;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		myMenu = new DashboardMenu();
//		assertEquals("Id error", "bandaDashboard", "891");
	}

	@Test
	public void testAssembleComponents() {
		assertEquals("Id error", "bandaDashboard", "891");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		myMenu = null;
	}

}
