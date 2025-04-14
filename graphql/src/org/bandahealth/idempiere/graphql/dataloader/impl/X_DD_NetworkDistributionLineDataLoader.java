package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_DD_NetworkDistributionLine;

/**
 * Data Loader for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_DD_NetworkDistributionLineDataLoader extends PODataLoader<X_DD_NetworkDistributionLine> {
	public static String DATALOADER_DD_NetworkDistributionLine_BY_ID = "DD_NetworkDistributionLineByIdDataLoader";
	public static String DATALOADER_DD_NetworkDistributionLine_BY_UUID = "DD_NetworkDistributionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_DD_NetworkDistributionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_DD_NetworkDistributionLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_DD_NetworkDistributionLine_BY_UUID;
	}
}
