package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_DD_NetworkDistributionLine;

/**
 * Data Loader for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_NetworkDistributionLineDataLoader extends PODataLoader<X_DD_NetworkDistributionLine> {
	public static String DD_NetworkDistributionLine_BY_ID_DATA_LOADER = "DD_NetworkDistributionLineByIdDataLoader";
	public static String DD_NetworkDistributionLine_BY_UUID_DATA_LOADER = "DD_NetworkDistributionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_DD_NetworkDistributionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DD_NetworkDistributionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DD_NetworkDistributionLine_BY_UUID_DATA_LOADER;
	}
}
