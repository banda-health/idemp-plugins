package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_DD_NetworkDistribution;

/**
 * Data Loader for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_NetworkDistributionDataLoader extends PODataLoader<X_DD_NetworkDistribution> {
	public static String DD_NetworkDistribution_BY_ID_DATA_LOADER = "DD_NetworkDistributionByIdDataLoader";
	public static String DD_NetworkDistribution_BY_UUID_DATA_LOADER = "DD_NetworkDistributionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_DD_NetworkDistribution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DD_NetworkDistribution_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DD_NetworkDistribution_BY_UUID_DATA_LOADER;
	}
}
