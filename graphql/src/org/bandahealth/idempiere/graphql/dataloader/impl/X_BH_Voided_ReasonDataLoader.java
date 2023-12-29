package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVoidedReason;

/**
 * Data Loader for BH_Voided_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Voided_ReasonDataLoader extends PODataLoader<MBHVoidedReason> {
	public static String BH_Voided_Reason_BY_ID_DATA_LOADER = "BH_Voided_ReasonByIdDataLoader";
	public static String BH_Voided_Reason_BY_UUID_DATA_LOADER = "BH_Voided_ReasonByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHVoidedReason.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Voided_Reason_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Voided_Reason_BY_UUID_DATA_LOADER;
	}
}
