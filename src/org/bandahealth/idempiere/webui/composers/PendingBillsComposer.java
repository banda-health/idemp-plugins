package org.bandahealth.idempiere.webui.composers;

import java.util.List;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.session.SessionManager;
import org.bandahealth.idempiere.webui.PendingBillsListRenderer;
import org.bandahealth.idempiere.webui.dataservice.impl.PendingBillsDataService;
import org.compiere.model.MOrder;
import org.compiere.model.MQuery;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Timer;
import org.zkoss.zul.Window;

public class PendingBillsComposer extends SelectorComposer<Window> implements EventListener<Event> {

	private static final long serialVersionUID = 1L;
	private List<MOrder> pendingBillsList;
	ListModelList<MOrder> model = new ListModelList<>();
	private Integer pendingBillsCount = 0;
	@Wire
	private Listbox pendingBillsListBox;

	@Override
	public void doAfterCompose(Window window) {
		try {
			super.doAfterCompose(window);
			pendingBillsListBox.addEventListener(Events.ON_SELECT, this);
			updatePendingBillsUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListModelList<MOrder> getPendingBillsModel() {
		pendingBillsList = PendingBillsDataService.getBillsInDraftState();
		if (pendingBillsList != null) {
			pendingBillsCount = pendingBillsList.size();
			model = new ListModelList<>(pendingBillsList, true);
		}
		return model;
	}

	public PendingBillsListRenderer getRenderer() {
		return new PendingBillsListRenderer();
	}

	private boolean updatedListAvailable() {
		boolean hasBeenUpdated = false;
		List<MOrder> updatedPendingBillsList = PendingBillsDataService.getBillsInDraftState();
		if (updatedPendingBillsList.size() != pendingBillsCount) {
			pendingBillsList = updatedPendingBillsList;
			hasBeenUpdated = true;
		}
		return hasBeenUpdated;
	}
	
	public void updatePendingBillsUI() {
		Timer timer = new Timer();
		timer.setRepeats(true);
		timer.setDelay(3000);
		timer.addEventListener(Events.ON_TIMER, new EventListener<Event>() {

			@Override
			public void onEvent(Event event) throws Exception {
				if(updatedListAvailable()) {
					model.clear();
					model.addAll(pendingBillsList);
				}
			}
			
		});
		pendingBillsListBox.getParent().appendChild(timer);
		timer.start();
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
