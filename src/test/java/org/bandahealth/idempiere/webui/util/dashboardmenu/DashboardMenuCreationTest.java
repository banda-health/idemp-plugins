package org.bandahealth.idempiere.webui.util.dashboardmenu;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import test.AdempiereTestCase;

public class DashboardMenuCreationTest extends AdempiereTestCase{

	MHomeScreenButton button;
	DashboardMenuButtonCreation menuCreator;

	boolean isInfoWindow = false;
	boolean isReportOrProcess = false;
	boolean isSpecialForm = false;

	@Before
	public void setUp() throws Exception {
		button = mock(MHomeScreenButton.class);
		menuCreator = new DashboardMenuButtonCreation();
	}

	@Test
	public void testButtonTypeSetsAsWindowId() {
		when(button.getAD_Window_ID()).thenReturn(1000004); //receive products window id
		menuCreator.setButtonType(button);
		assertThat(isReportOrProcess, is(false));
		assertThat(isInfoWindow, is(false));
		assertThat(isSpecialForm, is(false));
	}
	
	@Test
	public void testButtonTypeSetsIsProcessAttributeToTrue() {
		when(button.getAD_Window_ID()).thenReturn(0);
		when(button.getAD_InfoWindow_ID()).thenReturn(0);
		when(button.getAD_Form_ID()).thenReturn(0);
		when(button.getAD_Process_ID()).thenReturn(1000017); //income-exp report process
		menuCreator.setButtonType(button);
		assertThat(menuCreator.isReportOrProcess, is(true));
	}
	
	@Test
	public void testButtonTypeSetsIsFormAttributeToTrue() {
		when(button.getAD_Window_ID()).thenReturn(0);
		when(button.getAD_Process_ID()).thenReturn(0);
		when(button.getAD_Form_ID()).thenReturn(1000001);
		menuCreator.setButtonType(button); // metrics form window
		assertThat(menuCreator.isSpecialForm, is(true));
	}
	
	@Override
	public void tearDown() {
		button = null;
		menuCreator = null;
	}
}
