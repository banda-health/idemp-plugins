package org.bandahealth.idempiere.base.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;

public class HomeScreenButtonSingleNavigationEnforcer implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		if (value != null) {
			if (mField.getColumnName().equalsIgnoreCase(MHomeScreenButton.COLUMNNAME_AD_Window_ID)) {
				mTab.setValue(MHomeScreenButton.COLUMNNAME_AD_InfoWindow_ID, null);
				mTab.setValue(MHomeScreenButton.COLUMNNAME_AD_Process_ID, null);
			} else if (mField.getColumnName().equalsIgnoreCase(MHomeScreenButton.COLUMNNAME_AD_InfoWindow_ID)) {
				mTab.setValue(MHomeScreenButton.COLUMNNAME_AD_Window_ID, null);
				mTab.setValue(MHomeScreenButton.COLUMNNAME_AD_Process_ID, null);
			} else if (mField.getColumnName().equalsIgnoreCase(MHomeScreenButton.COLUMNNAME_AD_Process_ID)) {
				mTab.setValue(MHomeScreenButton.COLUMNNAME_AD_Window_ID, null);
				mTab.setValue(MHomeScreenButton.COLUMNNAME_AD_InfoWindow_ID, null);
			}
		}

		return null;
	}
}
