package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_DD_NetworkDistribution;

/**
 * Data Loader for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_DD_NetworkDistributionDataLoader extends PODataLoader<X_DD_NetworkDistribution> {
	public static String DATALOADER_DD_NetworkDistribution_BY_ID = "DD_NetworkDistributionByIdDataLoader";
	public static String DATALOADER_DD_NetworkDistribution_BY_UUID = "DD_NetworkDistributionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_DD_NetworkDistribution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_DD_NetworkDistribution_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_DD_NetworkDistribution_BY_UUID;
	}
}
