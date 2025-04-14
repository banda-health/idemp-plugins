package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.MDDOrderLine;

/**
 * Data Loader for DD_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_DD_OrderLineDataLoader extends PODataLoader<MDDOrderLine> {
	public static String DATALOADER_DD_OrderLine_BY_ID = "DD_OrderLineByIdDataLoader";
	public static String DATALOADER_DD_OrderLine_BY_UUID = "DD_OrderLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDDOrderLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_DD_OrderLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_DD_OrderLine_BY_UUID;
	}
}
