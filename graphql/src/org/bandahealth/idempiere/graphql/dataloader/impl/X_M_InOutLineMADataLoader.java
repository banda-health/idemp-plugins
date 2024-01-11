package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInOutLineMA;

/**
 * Data Loader for M_InOutLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineMADataLoader extends PODataLoader<MInOutLineMA> {
	public static String M_InOutLineMA_BY_ID_DATA_LOADER = "M_InOutLineMAByIdDataLoader";
	public static String M_InOutLineMA_BY_UUID_DATA_LOADER = "M_InOutLineMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOutLineMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_InOutLineMA_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_InOutLineMA_BY_UUID_DATA_LOADER;
	}
}
