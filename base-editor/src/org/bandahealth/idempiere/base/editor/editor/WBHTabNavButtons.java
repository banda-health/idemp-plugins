package org.bandahealth.idempiere.base.editor.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.adwindow.CompositeADTabbox;
import org.adempiere.webui.adwindow.IADTabbox;
import org.adempiere.webui.adwindow.IADTabpanel;
import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.event.ActionEvent;
import org.bandahealth.idempiere.base.editor.helper.BHButtonEvaluatee;
import org.bandahealth.idempiere.base.editor.helper.BHProcessButton;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.compiere.model.DataStatusEvent;
import org.compiere.model.DataStatusListener;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.compiere.model.StateChangeEvent;
import org.compiere.model.StateChangeListener;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Evaluatee;
import org.compiere.util.Evaluator;
import org.zkoss.zhtml.I;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Vlayout;

public class WBHTabNavButtons extends WEditor implements StateChangeListener {

	private CLogger log = CLogger.getCLogger(WBHTabNavButtons.class);

	public WBHTabNavButtons(GridField gridField, GridTab gridTab) {
		super(new Vlayout(), gridField);

		initializeEditor(gridField, gridTab);
	}

	private void initializeEditor(GridField gridField, GridTab gridTab) {

		Vlayout layout = (Vlayout) this.getComponent();
		layout.setWidth("100%");

		Div innerLayout = new Div();
		innerLayout.setSclass("bh-tab-nav-buttons");
		layout.appendChild(innerLayout);

		createNavButtons(innerLayout, gridField, gridTab);
	}

	private void createNavButtons(Div layout, GridField gridField, GridTab gridTab) {
		int tabId = gridField.getAD_Tab_ID();

		String whereClause = MTabNavBtnTab.COLUMNNAME_AD_Tab_ID + "=?";
		List<MTabNavBtnTab> tabButtonsForTab = new Query(Env.getCtx(), MTabNavBtnTab.Table_Name, whereClause, null)
				.setParameters(tabId)
				.setOnlyActiveRecords(true)
				.list();

		ADWindow window = ADWindow.get(gridField.getWindowNo());
		IADTabbox windowTabs = null;
		if (window != null && window.getADWindowContent() != null) {
			windowTabs = window.getADWindowContent().getADTab();
		}

		Div fullDiv = new Div();
		Div leftDiv = new Div();
		Div middleDiv = new Div();
		Div rightDiv = new Div();
		fullDiv.setSclass("full");
		leftDiv.setSclass("left");
		middleDiv.setSclass("middle");
		rightDiv.setSclass("right");

		layout.appendChild(fullDiv);
		layout.appendChild(leftDiv);
		layout.appendChild(middleDiv);
		layout.appendChild(rightDiv);

		List<MTabNavBtnTab> buttonsWithLogic = new ArrayList<>();
		Map<String, Div> btnToDivs = new HashMap<>();
		for (MTabNavBtnTab tabButtonForTab : tabButtonsForTab) {
			MTabNavBtn tabButton = (MTabNavBtn) tabButtonForTab.getBH_TabNavBtn();
			if (!tabButton.isActive()) {
				continue;
			}

			Div buttonDiv = new Div();

			appendButtonInfo(buttonDiv, tabButtonForTab, tabButton);

			if (tabButton.getDisplayLogic() != null || tabButtonForTab.getDisplayLogic() != null) {
				buttonsWithLogic.add(tabButtonForTab);
				btnToDivs.put(tabButtonForTab.getBH_TabNavBtn_Tab_UU(), buttonDiv);
			}

			assignButtonEvents(buttonDiv, window, windowTabs, tabButton);

			String buttonLocation = tabButtonForTab.getButtonLocation();
			if (buttonLocation == null) {
				buttonLocation = tabButton.getButtonLocation();
			}
			switch (buttonLocation) {
				case MTabNavBtn.BUTTONLOCATION_Full:
					fullDiv.appendChild(buttonDiv);
					break;
				case MTabNavBtn.BUTTONLOCATION_Left:
					leftDiv.appendChild(buttonDiv);
					break;
				case MTabNavBtn.BUTTONLOCATION_Middle:
					middleDiv.appendChild(buttonDiv);
					break;
				case MTabNavBtn.BUTTONLOCATION_Right:
					rightDiv.appendChild(buttonDiv);
					break;
			}
		}

		if (windowTabs != null && buttonsWithLogic.size() > 0) {
			DataStatusListener updateButtonVisibility = new DataStatusListener() {

				@Override
				public void dataStatusChanged(DataStatusEvent e) {
					for (MTabNavBtnTab tabButtonForTab : buttonsWithLogic) {
						MTabNavBtn tabButton = (MTabNavBtn) tabButtonForTab.getBH_TabNavBtn();
						Div buttonDiv = btnToDivs.get(tabButtonForTab.getBH_TabNavBtn_Tab_UU());

						String displayLogic = tabButtonForTab.getDisplayLogic();
						if (displayLogic == null) {
							displayLogic = tabButton.getDisplayLogic();
						}
						String currentClass = buttonDiv.getSclass();
						BHButtonEvaluatee buttonEvaluatee = new BHButtonEvaluatee(gridTab);
						if (Evaluator.evaluateLogic(buttonEvaluatee, displayLogic)) {
							currentClass = currentClass.replaceAll("\\sgone", "");
							buttonDiv.setSclass(currentClass);
						} else if (!currentClass.contains(" gone")) {
							currentClass += " gone";
							buttonDiv.setSclass(currentClass);
						}
					}
				}
			};
			if (gridTab != null) {
				gridTab.addDataStatusListener(updateButtonVisibility);
			}
		}
	}

	private void assignButtonEvents(Div buttonDiv, ADWindow window, IADTabbox windowTabs, MTabNavBtn tabButton) {
		// If there are no window tabs, this must be the tab editor in WTF and we don't want events
		if (windowTabs == null) {
			return;
		}

		EventListener<Event> buttonEvent = null;
		switch (tabButton.getButtonAction()) {
			case MTabNavBtn.BUTTONACTION_Cancel:
				buttonEvent = new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						window.getADWindowContent().onIgnore();
					}
				};
				break;
			case MTabNavBtn.BUTTONACTION_Copy:
				buttonEvent = new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						window.getADWindowContent().onCopy();
					}
				};
				break;
			case MTabNavBtn.BUTTONACTION_Delete:
				buttonEvent = new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						window.getADWindowContent().onDelete();
					}
				};
				break;
			case MTabNavBtn.BUTTONACTION_Navigation:
				buttonEvent = getTabNavigationEvent(tabButton.getAD_Tab_ID(), window, windowTabs);
				break;
			case MTabNavBtn.BUTTONACTION_New:
				buttonEvent = new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						window.getADWindowContent().onSave();
						window.getADWindowContent().onNew();
					}
				};
				break;
			case MTabNavBtn.BUTTONACTION_Process:
				buttonEvent = getTabProcessEvent(tabButton, window);
				break;
			case MTabNavBtn.BUTTONACTION_Save:
				buttonEvent = new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						window.getADWindowContent().onSave();
					}
				};
				break;
		}
		buttonDiv.addEventListener(Events.ON_CLICK, buttonEvent);
	}

	private void appendButtonInfo(Div buttonDiv, MTabNavBtnTab tabButtonForTab, MTabNavBtn tabButton) {
		// Handle overrides, if there are any
		String buttonIconClassName = tabButtonForTab.getIconClassName();
		if (buttonIconClassName == null) {
			buttonIconClassName = tabButton.getIconClassName();
		}
		String buttonText = tabButtonForTab.get_Translation(MTabNavBtnTab.COLUMNNAME_ButtonText);
		if (buttonText == null) {
			buttonText = tabButton.get_Translation(MTabNavBtn.COLUMNNAME_ButtonText);
		}
		String buttonHelpText = tabButtonForTab.get_Translation(MTabNavBtnTab.COLUMNNAME_ButtonHelpText);
		if (buttonHelpText == null) {
			buttonHelpText = tabButton.get_Translation(MTabNavBtn.COLUMNNAME_ButtonHelpText);
		}
		String buttonClassName = tabButtonForTab.getButtonClassName();
		if (buttonClassName == null) {
			buttonClassName = tabButton.getButtonClassName();
		}

		// Do assignments and HTML creation
		if (buttonIconClassName != null) {
			I icon = new I();
			icon.setSclass(buttonIconClassName);
			buttonDiv.appendChild(icon);
		}
		if (buttonText != null) {
			buttonDiv.appendChild(new Text(buttonText));
		}
		if (buttonHelpText != null) {
			buttonDiv.setTooltiptext(buttonHelpText);
		}

		buttonDiv.setSclass(buttonClassName);
	}

	private EventListener<Event> getTabProcessEvent(MTabNavBtn tabButton, ADWindow window) {
		return new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				window.getADWindowContent().saveAndNavigate(new Callback<Boolean>() {

					@Override
					public void onCallback(Boolean result) {
						ActionEvent runProcessEvent = new ActionEvent(new BHProcessButton(tabButton, window),
								tabButton.getAD_Column().getName(), Events.ON_CLICK);
						window.getADWindowContent().onRefresh();
						window.getADWindowContent().actionPerformed(runProcessEvent);
					}
				});
			}
		};
	}

	private EventListener<Event> getTabNavigationEvent(int tabID, ADWindow window, IADTabbox windowTabs) {
		return new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				if (event.getName().equals(Events.ON_CLICK) && event.getTarget() instanceof Div) {
					int associatedTabIndex = -1;
					// This loop must be here instead of outside the event because the tab count changes depending
					// on when this is called in the Window load process
					int totalNumberOfTabs = windowTabs.getTabCount();
					for (int i = 0; i < totalNumberOfTabs; i++) {
						IADTabpanel potentialTab = windowTabs.getADTabpanel(i);
						if (tabID == potentialTab.getGridTab().getAD_Tab_ID()) {
							associatedTabIndex = i;
							break;
						}
					}
					final int tabIndexToNavigateTo = associatedTabIndex;

					window.getADWindowContent().saveAndNavigate(new Callback<Boolean>() {

						@Override
						public void onCallback(Boolean result) {
							Event tabSelectionChanged = new Event(CompositeADTabbox.ON_SELECTION_CHANGED_EVENT,
									null,
									new Object[] { windowTabs.getSelectedIndex(), tabIndexToNavigateTo });
							window.getADWindowContent().onEvent(tabSelectionChanged);
						}
					});
				}
			}
		};
	}

	@Override
	public void setReadWrite(boolean readWrite) {
	}

	@Override
	public boolean isReadWrite() {
		return false;
	}

	@Override
	public void setValue(Object value) {

	}

	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public String getDisplay() {
		return null;
	}

	@Override
	public void stateChange(StateChangeEvent event) {

	}

	@Override
	public void onEvent(Event event) throws Exception {
	}
}
