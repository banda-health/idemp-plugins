package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_QM_SpecificationLine;

/**
 * Data Loader for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_QM_SpecificationLineDataLoader extends PODataLoader<X_QM_SpecificationLine> {
	public static String DATALOADER_QM_SpecificationLine_BY_ID = "QM_SpecificationLineByIdDataLoader";
	public static String DATALOADER_QM_SpecificationLine_BY_UUID = "QM_SpecificationLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_QM_SpecificationLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_QM_SpecificationLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_QM_SpecificationLine_BY_UUID;
	}
}
