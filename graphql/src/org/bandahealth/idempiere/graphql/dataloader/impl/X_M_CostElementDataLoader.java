package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostElement;

/**
 * Data Loader for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostElementDataLoader extends PODataLoader<MCostElement> {
	public static String M_CostElement_BY_ID_DATA_LOADER = "M_CostElementByIdDataLoader";
	public static String M_CostElement_BY_UUID_DATA_LOADER = "M_CostElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_CostElement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_CostElement_BY_UUID_DATA_LOADER;
	}
}
