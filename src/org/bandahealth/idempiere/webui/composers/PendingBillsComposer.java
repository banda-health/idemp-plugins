package org.bandahealth.idempiere.webui.composers;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.webui.PendingBillsDataService;
import org.bandahealth.idempiere.webui.util.PendingBillsListRenderer;
import org.compiere.model.MOrder;
import org.compiere.model.MQuery;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

public class PendingBillsComposer extends SelectorComposer<Window> implements EventListener<Event> {

	private static final long serialVersionUID = 1L;
	private List<MOrder> saleOrders;
	private Integer unclosedSOCount = 0;
	@Wire
	private Listbox pendingBillsListBox;

	@Override
	public void doAfterCompose(Window window) {
		try {
			super.doAfterCompose(window);
			pendingBillsListBox.addEventListener(Events.ON_SELECT, this);
			refreshModelList(getPendingBillsModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListModelList<MOrder> getPendingBillsModel() {
		saleOrders = PendingBillsDataService.getBillsInDraftState();
		ListModelList<MOrder> model = new ListModelList<>();
		if (saleOrders != null) {
			unclosedSOCount = saleOrders.size();
			model = new ListModelList<>(saleOrders, true);
		}
		return model;
	}

	public PendingBillsListRenderer getRenderer() {
		return new PendingBillsListRenderer();
	}

//	public Window addToWindow() {
//		Window notifications = new Window("Pending Patient Bills: (" + saleOrders.size() + ")", "none", false);
//		notifications.setStyle("z-window-popup");
//		notifications.setTooltiptext("List of all orders that have not been closed");
//		notifications.appendChild(this.getSelf());
//		widgetArea.appendChild(notifications);
//		return notifications;
//	}

	private void refreshModelList(ListModelList<MOrder> modelList) {
		// update listmodel every 2 seconds
		TimerTask task = new TimerTask() {
			Thread refresherThread = new ModelUpdateThread(modelList);

			@Override
			public void run() {
				if (updatedListAvailable()) {
					unclosedSOCount = saleOrders.size();
					if (!refresherThread.isAlive()) {
						refresherThread.start();
					}
				}
			}
		};
		Timer t = new Timer();
		t.schedule(task, 2000, 5000);
	}

	class ModelUpdateThread extends Thread {
		private ListModelList<MOrder> model;

		public ModelUpdateThread(ListModelList<MOrder> model) {
			this.model = model;
		}

		public void run() {
			Desktop desktop = Executions.getCurrent().getDesktop();
			desktop.enableServerPush(true);
			try {
				Executions.activate(desktop);
				model.clear();
				model.addAll(saleOrders);
				Executions.deactivate(desktop);
			} catch (DesktopUnavailableException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean updatedListAvailable() {
		boolean hasBeenUpdated = false;
		List<MOrder> currentList = PendingBillsDataService.getBillsInDraftState();
		if (currentList.size() != unclosedSOCount) {
			saleOrders = currentList;
			hasBeenUpdated = true;
		}
		return hasBeenUpdated;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		System.out.println("Inside event listener");
		String eventName = event.getName();
		if (eventName.equals(Events.ON_SELECT)) {
			Listitem selected = ((Listbox) component).getSelectedItem();
			Integer selectedDocNumber = Integer.parseInt(selected.getValue().toString());

			MWindow bhSOWindow = new Query(Env.getCtx(), MWindow.Table_Name,
			        MWindow.COLUMNNAME_Name + " LIKE '%Patient Bill%'", null).setOnlyActiveRecords(true).first();
			int windowId = bhSOWindow.getAD_Window_ID();

			MQuery query = new MQuery(MOrder.Table_Name);
			query.addRestriction(MOrder.COLUMNNAME_DocumentNo + "='" + String.valueOf(selectedDocNumber) + "' AND "
			        + MOrder.COLUMNNAME_DocStatus + "='DR'");
			SessionManager.getAppDesktop().openWindow(windowId, query, new Callback<ADWindow>() {

				@Override
				public void onCallback(ADWindow result) {
					if (result == null)
						return;
					result.getADWindowContent().onZoomAcross();
				}
			});
		}
	}
}
