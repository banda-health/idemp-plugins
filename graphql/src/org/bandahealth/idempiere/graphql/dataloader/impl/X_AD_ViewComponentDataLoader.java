package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MViewComponent;

/**
 * Data Loader for AD_ViewComponent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ViewComponentDataLoader extends PODataLoader<MViewComponent> {
	public static String DATALOADER_AD_ViewComponent_BY_ID = "AD_ViewComponentByIdDataLoader";
	public static String DATALOADER_AD_ViewComponent_BY_UUID = "AD_ViewComponentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MViewComponent.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ViewComponent_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ViewComponent_BY_UUID;
	}
}
