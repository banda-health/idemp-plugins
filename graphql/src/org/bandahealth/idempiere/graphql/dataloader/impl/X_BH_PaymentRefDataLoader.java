package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPaymentRef;

/**
 * Data Loader for BH_PaymentRef - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_PaymentRefDataLoader extends PODataLoader<MBHPaymentRef> {
	public static String DATALOADER_BH_PaymentRef_BY_ID = "BH_PaymentRefByIdDataLoader";
	public static String DATALOADER_BH_PaymentRef_BY_UUID = "BH_PaymentRefByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPaymentRef.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_PaymentRef_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_PaymentRef_BY_UUID;
	}
}
