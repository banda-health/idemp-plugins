package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MViewComponent;

/**
 * Data Loader for AD_ViewComponent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ViewComponentDataLoader extends PODataLoader<MViewComponent> {
	public static String AD_ViewComponent_BY_ID_DATA_LOADER = "AD_ViewComponentByIdDataLoader";
	public static String AD_ViewComponent_BY_UUID_DATA_LOADER = "AD_ViewComponentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MViewComponent.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ViewComponent_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ViewComponent_BY_UUID_DATA_LOADER;
	}
}
