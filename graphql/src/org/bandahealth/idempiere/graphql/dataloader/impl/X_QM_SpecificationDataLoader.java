package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_QM_Specification;

/**
 * Data Loader for QM_Specification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_QM_SpecificationDataLoader extends PODataLoader<X_QM_Specification> {
	public static String DATALOADER_QM_Specification_BY_ID = "QM_SpecificationByIdDataLoader";
	public static String DATALOADER_QM_Specification_BY_UUID = "QM_SpecificationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_QM_Specification.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_QM_Specification_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_QM_Specification_BY_UUID;
	}
}
