package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBankAccountProcessor;

/**
 * Data Loader for C_BankAccount_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BankAccount_ProcessorDataLoader extends PODataLoader<MBankAccountProcessor> {
	public static String DATALOADER_C_BankAccount_Processor_BY_ID = "C_BankAccount_ProcessorByIdDataLoader";
	public static String DATALOADER_C_BankAccount_Processor_BY_UUID = "C_BankAccount_ProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBankAccountProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BankAccount_Processor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BankAccount_Processor_BY_UUID;
	}
}
