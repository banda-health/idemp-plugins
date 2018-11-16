package org.bandahealth.idempiere.webui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.webui.component.Column;
import org.adempiere.webui.component.Columns;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.Tab;
import org.adempiere.webui.component.Tabbox;
import org.adempiere.webui.component.Tabpanel;
import org.adempiere.webui.component.Tabpanels;
import org.adempiere.webui.component.Tabs;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.webui.util.UIUtil;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.Div;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.A;
import org.zkoss.zul.Hlayout;

public class DashboardMenu extends DashboardPanel implements EventListener<Event> {

	private static final long serialVersionUID = 1L;
	private Hlayout layout;
	private Div sideBar;
	private Tabbox tabbox;
	private Tabs tabs;
	private Tabpanels tabpanels;
	private String[] labels = { "Patients and Vendors", "Inventory", "Cashier", "Reports", "Alerts" };

	private CLogger log = CLogger.getCLogger(DashboardMenu.class);

	public DashboardMenu() {
		super();
		initLayout();
		assembleComponents();
	}

	private void initLayout() {
		layout = new Hlayout();
		layout.setParent(this);
		sideBar = new Div();
		tabbox = new Tabbox();
		tabbox.setMold("accordion");
		tabs = new Tabs();
		tabpanels = new Tabpanels();

	}

	private void assembleComponents() {
		tabs = createTabs(labels);
		tabpanels = createTabpanels();
		tabs.setParent(tabbox);
		tabpanels.setParent(tabbox);
		sideBar.appendChild(tabbox);
		layout.appendChild(sideBar);
	}

	private Tabs createTabs(String[] labels) {
		Tabs tabs = new Tabs();
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
				null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
			log.info(buttonGroup.getName());
			Tab tab = new Tab(buttonGroup.getName());
			tabs.appendChild(tab);
		}
		return tabs;
	}

	private Tabpanels createTabpanels() {
		Tabpanels tabpanelsContainer = new Tabpanels();
		List<Tabpanel> tabpanelsList = new ArrayList<Tabpanel>();
		//get all button groups
		List<MHomeScreenButtonGroup> buttonGroups = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null,
				null).setOnlyActiveRecords(true).setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).list();
		
		for (MHomeScreenButtonGroup buttonGroup : buttonGroups) {
		//get all buttons
		List<MHomeScreenButton> buttons = new Query(Env.getCtx(), MHomeScreenButton.Table_Name, null, null)
				.setOnlyActiveRecords(true).setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo).list();

		//filter buttons matching current group
		List<MHomeScreenButton> buttonsInGroup = buttons.stream()
				.filter(b -> b.getBH_HmScrn_ButtonGroup_ID() == buttonGroup.getBH_HmScrn_ButtonGroup_ID())
				.collect(Collectors.toList());
		
		Grid grid = new Grid();
		Columns columns = new Columns();
		Rows rows = new Rows();
		Column[] col = { new Column(""), new Column("") };
		for (int i = 0; i < col.length; i++) {
			col[i].setParent(columns);
		}
		grid.appendChild(columns);
		grid.appendChild(rows);
		//create a tabpanel using these buttons as rows...
		for (MHomeScreenButton button : buttonsInGroup) {
			Row row = new Row();
			org.zkoss.zul.Div divButton = UIUtil.initDivButton(button);
			row.appendChild(divButton);
			row.setParent(rows);
		}
		Tabpanel panel = new Tabpanel();
		panel.appendChild(grid);
		tabpanelsContainer.appendChild(panel);
		
		}
		return tabpanelsContainer;
	}

	@Override
	public void onEvent(Event event) throws Exception {

	}

}
