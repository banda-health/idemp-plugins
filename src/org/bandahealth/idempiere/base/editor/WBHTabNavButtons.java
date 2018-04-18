package org.bandahealth.idempiere.base.editor;

import java.util.List;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.adwindow.CompositeADTabbox;
import org.adempiere.webui.adwindow.DetailPane;
import org.adempiere.webui.adwindow.IADTabbox;
import org.adempiere.webui.adwindow.IADTabpanel;
import org.adempiere.webui.editor.WEditor;
import org.bandahealth.idempiere.base.model.MTabNavBtn;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.Query;
import org.compiere.model.StateChangeEvent;
import org.compiere.model.StateChangeListener;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.I;
import org.zkoss.zhtml.Span;
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

		initializeEditor(gridField);
	}

	private void initializeEditor(GridField gridField) {

		Vlayout layout = (Vlayout) this.getComponent();
		layout.setWidth("100%");

		Div innerLayout = new Div();
		innerLayout.setSclass("bh-tab-nav-buttons");
		layout.appendChild(innerLayout);

		createNavButtons(innerLayout, gridField);
	}

	private void createNavButtons(Div layout, GridField gridField) {
		int tabId = gridField.getAD_Tab_ID();

		String whereClause = MTabNavBtnTab.COLUMNNAME_AD_Tab_ID + "=?";
		List<MTabNavBtnTab> tabButtonsForTab = new Query(Env.getCtx(), MTabNavBtnTab.Table_Name, whereClause, null)
				.setParameters(tabId)
				.list();

		ADWindow window = ADWindow.get(gridField.getWindowNo());
		IADTabbox windowTabs = null;
		if (window != null && window.getADWindowContent() != null) {
			windowTabs = window.getADWindowContent().getADTab();
		}

		for (MTabNavBtnTab tabButtonForTab : tabButtonsForTab) {
			Div buttonDiv = new Div();
			MTabNavBtn tabButton = (MTabNavBtn) tabButtonForTab.getBH_TabNavBtn();

			// Handle overrides, if there are any
			String buttonIconClassName = tabButtonForTab.getIconClassName();
			if (buttonIconClassName == null) {
				buttonIconClassName = tabButton.getIconClassName();
			}
			String buttonText = tabButtonForTab.getButtonText();
			if (buttonText == null) {
				buttonText = tabButton.getButtonText();
			}
			String buttonHelpText = tabButtonForTab.getButtonText();
			if (buttonHelpText == null) {
				buttonHelpText = tabButton.getButtonText();
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

			// If we can, assign associated events
			if (windowTabs != null) {
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
								window.getADWindowContent().onSaveCreate();
							}
						};
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

			layout.appendChild(buttonDiv);
		}
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
