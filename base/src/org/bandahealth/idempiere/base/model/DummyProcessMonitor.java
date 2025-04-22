package org.bandahealth.idempiere.base.model;

import org.adempiere.util.Callback;
import org.adempiere.util.IProcessUI;
import org.compiere.model.MLookup;
import org.compiere.process.ProcessInfo;

import java.io.File;
import java.util.List;

/**
 * When running tests, iDempiere doesn't return a process UI. So this can be used instead.
 */
public class DummyProcessMonitor implements IProcessUI {
	@Override
	public void lockUI(ProcessInfo pi) {
	}

	@Override
	public void unlockUI(ProcessInfo pi) {
	}

	@Override
	public boolean isUILocked() {
		return false;
	}

	@Override
	public void statusUpdate(String message) {
	}

	@Override
	public void ask(String message, Callback<Boolean> callback) {
	}

	@Override
	public void askForInput(String message, Callback<String> callback) {
	}

	@Override
	public void askForSecretInput(String message, Callback<String> callback) {
	}

	@Override
	public void askForInput(String message, MLookup lookup, int displayType, Callback<Object> callback) {
	}

	@Override
	public void download(File file) {
	}

	@Override
	public void showReports(List<File> pdfList) {
	}

	@Override
	public void showInfoWindow(int WindowNo, String tableName, String keyColumn, String queryValue,
			boolean multipleSelection, String whereClause, Integer AD_InfoWindow_ID, boolean lookup) {
	}
}
