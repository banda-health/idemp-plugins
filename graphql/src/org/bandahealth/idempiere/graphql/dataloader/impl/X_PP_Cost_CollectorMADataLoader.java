package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Cost_CollectorMA;

/**
 * Data Loader for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Cost_CollectorMADataLoader extends PODataLoader<X_PP_Cost_CollectorMA> {
	public static String DATALOADER_PP_Cost_CollectorMA_BY_ID = "PP_Cost_CollectorMAByIdDataLoader";
	public static String DATALOADER_PP_Cost_CollectorMA_BY_UUID = "PP_Cost_CollectorMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Cost_CollectorMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Cost_CollectorMA_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Cost_CollectorMA_BY_UUID;
	}
}
