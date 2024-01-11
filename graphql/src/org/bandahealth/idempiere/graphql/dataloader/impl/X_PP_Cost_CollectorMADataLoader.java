package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Cost_CollectorMA;

/**
 * Data Loader for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Cost_CollectorMADataLoader extends PODataLoader<X_PP_Cost_CollectorMA> {
	public static String PP_Cost_CollectorMA_BY_ID_DATA_LOADER = "PP_Cost_CollectorMAByIdDataLoader";
	public static String PP_Cost_CollectorMA_BY_UUID_DATA_LOADER = "PP_Cost_CollectorMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Cost_CollectorMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Cost_CollectorMA_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Cost_CollectorMA_BY_UUID_DATA_LOADER;
	}
}
