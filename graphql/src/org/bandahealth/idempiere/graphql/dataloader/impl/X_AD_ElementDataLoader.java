package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.M_Element;

/**
 * Data Loader for AD_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ElementDataLoader extends PODataLoader<M_Element> {
	public static String DATALOADER_AD_Element_BY_ID = "AD_ElementByIdDataLoader";
	public static String DATALOADER_AD_Element_BY_UUID = "AD_ElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return M_Element.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Element_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Element_BY_UUID;
	}
}
