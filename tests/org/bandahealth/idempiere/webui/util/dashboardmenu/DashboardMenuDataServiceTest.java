package org.bandahealth.idempiere.webui.util.dashboardmenu;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.DashboardMenuDataService;
import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import test.AdempiereTestCase;

public class DashboardMenuDataServiceTest extends AdempiereTestCase {

	private DashboardMenuDataService dashboardMenuDataService;
	private List<MHomeScreenButtonGroup> groups;
	private List<MHomeScreenButton> buttons;

	@Override
	@BeforeClass
	public void setUp() throws Exception {
		super.setUp();
		dashboardMenuDataService = new DashboardMenuDataService();
		groups = dashboardMenuDataService.getButtonGroups();
		buttons = dashboardMenuDataService.getButtons();
	}

	@Test
	public void testDashboardMenuDataServiceIsNotNull() {
		assertThat(dashboardMenuDataService, notNullValue());
	}

	@Test
	public void testGetButtonGroupsReturnsMHomeScreenButtonGroupList() {
		assertThat(groups, isA(List.class));
		assertThat(groups, not(Collections.EMPTY_LIST)); // assumes groups setup during config...
		assertThat(groups, everyItem(instanceOf(MHomeScreenButtonGroup.class)));
	}

	@Test
	public void testGetButtonsReturnsMHomeScreenButtonList() {
		assertThat(buttons, isA(List.class));
		assertThat(buttons, not(Collections.EMPTY_LIST));
		assertThat(buttons, everyItem(instanceOf(MHomeScreenButton.class)));
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		dashboardMenuDataService = null;
	}
}
