package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MToolBarButton;

/**
 * Data Loader for AD_ToolBarButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ToolBarButtonDataLoader extends PODataLoader<MToolBarButton> {
	public static String DATALOADER_AD_ToolBarButton_BY_ID = "AD_ToolBarButtonByIdDataLoader";
	public static String DATALOADER_AD_ToolBarButton_BY_UUID = "AD_ToolBarButtonByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MToolBarButton.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ToolBarButton_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ToolBarButton_BY_UUID;
	}
}
