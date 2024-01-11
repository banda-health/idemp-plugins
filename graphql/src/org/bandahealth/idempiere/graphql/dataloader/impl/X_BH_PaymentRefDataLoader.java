package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPaymentRef;

/**
 * Data Loader for BH_PaymentRef - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_PaymentRefDataLoader extends PODataLoader<MBHPaymentRef> {
	public static String BH_PaymentRef_BY_ID_DATA_LOADER = "BH_PaymentRefByIdDataLoader";
	public static String BH_PaymentRef_BY_UUID_DATA_LOADER = "BH_PaymentRefByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPaymentRef.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_PaymentRef_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_PaymentRef_BY_UUID_DATA_LOADER;
	}
}
