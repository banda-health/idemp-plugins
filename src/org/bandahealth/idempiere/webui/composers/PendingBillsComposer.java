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
	private List<MOrder> patientBills;
	private Integer patientBillsCount = 0;
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
		patientBills = PendingBillsDataService.getBillsInDraftState();
		ListModelList<MOrder> model = new ListModelList<>();
		if (patientBills != null) {
			patientBillsCount = patientBills.size();
			model = new ListModelList<>(patientBills, true);
		}
		return model;
	}

	public PendingBillsListRenderer getRenderer() {
		return new PendingBillsListRenderer();
	}

	private void refreshModelList(ListModelList<MOrder> modelList) {
		// update listmodel every 2 seconds
		TimerTask task = new TimerTask() {
			Thread refresherThread = new ModelUpdateThread(modelList);

			@Override
			public void run() {
				if (updatedListAvailable()) {
					patientBillsCount = patientBills.size();
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
				model.addAll(patientBills);
				Executions.deactivate(desktop);
			} catch (DesktopUnavailableException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean updatedListAvailable() {
		boolean hasBeenUpdated = false;
		List<MOrder> currentList = PendingBillsDataService.getBillsInDraftState();
		if (currentList.size() != patientBillsCount) {
			patientBills = currentList;
			hasBeenUpdated = true;
		}
		return hasBeenUpdated;
	}

	@Override
	public void onEvent(Event event) throws Exception {
		Component component = event.getTarget();
		String eventName = event.getName();
		if (eventName.equals(Events.ON_SELECT)) {
			Listitem selected = ((Listbox) component).getSelectedItem();
			Integer selectedDocNumber = Integer.parseInt(selected.getValue().toString());
			int windowId = PendingBillsDataService.getBillingWindowId();
			MQuery query = PendingBillsDataService.createQueryForSelectedBill(selectedDocNumber);
			
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
