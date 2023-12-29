package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.M_Element;

/**
 * Data Loader for AD_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ElementDataLoader extends PODataLoader<M_Element> {
	public static String AD_Element_BY_ID_DATA_LOADER = "AD_ElementByIdDataLoader";
	public static String AD_Element_BY_UUID_DATA_LOADER = "AD_ElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return M_Element.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Element_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Element_BY_UUID_DATA_LOADER;
	}
}
