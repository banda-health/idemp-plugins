package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ContractDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_AD_PrintFormat;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Contract;
import org.eevolution.model.X_HR_Payroll;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for HR_Payroll - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_PayrollResolver extends POResolver<X_HR_Payroll> implements GraphQLResolver<X_HR_Payroll> {



	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(X_HR_Payroll entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(X_HR_Payroll entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Payroll Contract.
	 *
	 * @return Payroll Contract
	 */
	public CompletableFuture<X_HR_Contract> HR_Contract(X_HR_Payroll entity, DataFetchingEnvironment environment) {
		if (entity.getHR_Contract_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_HR_Contract> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_HR_ContractDataLoader.DATALOADER_HR_Contract_BY_ID);
		return dataLoader.load(entity.getHR_Contract_ID());
	}

	public static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "d3874573-b7bf-4556-9b9c-3644698c959e"); // Credit or Debit Card
			put("K", "900adbf9-5069-4f56-9d97-0313c6372af3"); // Cheque
			put("A", "220f3864-24b8-42ba-9a91-a247f4697530"); // Direct Deposit
			put("D", "487227e8-c88e-45ef-8e6d-c0a480fdd0de"); // Debit Card
			put("T", "bd6f5227-483d-4bcf-b1fe-a840a3142327"); // Account
			put("X", "52c6c5a6-83ce-48c4-b874-721f8cd4e66b"); // Cash
			put("M", "7a78334e-3494-4d40-a718-c42cb053eea6"); // Mobile Money
			put("B", "ade64e84-cd1b-43bc-a85c-c17a14963305"); // Bill Waiver
			put("L", "7449ae78-c7d3-463b-921e-62a82a5e1a59"); // M-TIBA
			put("N", "28617687-cb93-494a-8f03-bc453da32658"); // NHIF
			put("F", "e24511d1-9180-491c-9cc6-354b8a08e1ff"); // Donor Fund
			put("i", "5b4b4fcf-85c0-4d7c-851d-ab0db2e84b6d"); // Linda Mama
			put("G", "bb077404-71a4-4348-9afa-2b99ae9e1381"); // CCC
			put("H", "55df64a7-1c7f-43f2-846b-f542c9cafa45"); // MCH
			put("O", "4caa3109-804f-4773-8115-9bdb116f329b"); // Outreach
			put("P", "64e8ad21-7c9d-442b-9655-f5223d76140c"); // PesaPal
			put("U", "97e54f17-fbae-40de-8dbd-e8ad7f884732"); // Jubilee insurance
			put("V", "52fc8585-3c61-45b8-a0dd-db10c1e7d79c"); // Liason insurance
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRule(X_HR_Payroll entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	public Boolean Processed(X_HR_Payroll entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_HR_Payroll entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
