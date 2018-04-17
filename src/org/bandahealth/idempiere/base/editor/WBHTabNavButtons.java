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
		List<MTabNavBtnTab> tabButtons = new Query(Env.getCtx(), MTabNavBtnTab.Table_Name, whereClause, null)
				.setParameters(tabId)
				.list();

		ADWindow window = ADWindow.get(gridField.getWindowNo());
		IADTabbox windowTabs = window.getADWindowContent().getADTab();

		for (MTabNavBtnTab tabButton : tabButtons) {
			Div buttonDiv = new Div();
			MTabNavBtn buttonInfo = (MTabNavBtn) tabButton.getBH_TabNavBtn();
			if (buttonInfo.getIconClassName() != null) {
				I icon = new I();
				icon.setSclass(buttonInfo.getIconClassName());
				buttonDiv.appendChild(icon);
			}
			if (buttonInfo.getButtonText() != null) {
				Span buttonText = new Span();
				buttonText.appendChild(new Text(buttonInfo.getButtonText()));
				buttonDiv.appendChild(buttonText);
			}
			if (buttonInfo.getButtonHelpText() != null) {
				buttonDiv.setAttribute("title", buttonInfo.getButtonHelpText());
			}

			buttonDiv.setSclass(buttonInfo.getButtonClassName());

			buttonDiv.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

				@Override
				public void onEvent(Event event) throws Exception {
					if (event.getName().equals(Events.ON_CLICK) && event.getTarget() instanceof Div) {
						int associatedTabIndex = -1;
						// This loop must be here instead of outside the event because the tab count changes depending
						// on when this is called in the Window load process
						int totalNumberOfTabs = windowTabs.getTabCount();
						for (int i = 0; i < totalNumberOfTabs; i++) {
							IADTabpanel potentialTab = windowTabs.getADTabpanel(i);
							if (buttonInfo.getAD_Tab_ID() == potentialTab.getGridTab().getAD_Tab_ID()) {
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
										new Object[]{windowTabs.getSelectedIndex(), tabIndexToNavigateTo});
								window.getADWindowContent().onEvent(tabSelectionChanged);
							}
						});
					}
				}
			});

			layout.appendChild(buttonDiv);
		}
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
