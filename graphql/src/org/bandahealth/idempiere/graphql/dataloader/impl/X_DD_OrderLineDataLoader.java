package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MDDOrderLine;

/**
 * Data Loader for DD_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_OrderLineDataLoader extends PODataLoader<MDDOrderLine> {
	public static String DD_OrderLine_BY_ID_DATA_LOADER = "DD_OrderLineByIdDataLoader";
	public static String DD_OrderLine_BY_UUID_DATA_LOADER = "DD_OrderLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDDOrderLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DD_OrderLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DD_OrderLine_BY_UUID_DATA_LOADER;
	}
}
