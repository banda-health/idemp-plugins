package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSTenderTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPOSPayment;
import org.compiere.model.X_C_POSTenderType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSPaymentResolver extends POResolver<MPOSPayment> implements GraphQLResolver<MPOSPayment> {



	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MPOSPayment entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MPOSPayment entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get POS Tender Type.
	 *
	 * @return POS Tender Type
	 */
	public CompletableFuture<X_C_POSTenderType> C_POSTenderType(MPOSPayment entity, DataFetchingEnvironment environment) {
		if (entity.getC_POSTenderType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_C_POSTenderType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSTenderTypeDataLoader.DATALOADER_C_POSTenderType_BY_ID);
		return dataLoader.load(entity.getC_POSTenderType_ID());
	}

	public static Map<String, String> CHECKSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "a1add19e-164b-4e39-bda5-d1e46690dc73"); // Charged
			put("D", "5b33e119-d7a5-4cea-bc93-08fbaf9e5598"); // Delayed
			put("P", "d136c5ab-5469-4909-902b-b22f53cbefb2"); // Replaced
			put("R", "f4234c44-1a21-4c11-b38f-db2afd89c0a2"); // Received
			put("T", "8acc92df-e6ce-4522-a0e9-5a97919e87a1"); // Returned
		}
	};
	public CompletableFuture<MRefList_BH> CheckStatus(MPOSPayment entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCheckStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CHECKSTATUS_UUIDS_BY_VALUE.get(entity.getCheckStatus()));
	}

	public static Map<String, String> CREDITCARDTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "0923716b-9efc-42ed-b1f9-ee1c5c7ca7fa"); // Amex
			put("M", "8b5451f8-2fd2-4745-b9de-f4459ac9265c"); // MasterCard
			put("V", "d89e4a0c-a891-462a-961a-155e00acdd8c"); // Visa
			put("C", "144e87eb-ed8e-4046-a804-bd27f0e5602d"); // ATM
			put("D", "4d14ee27-f39f-4899-aaf0-9b2d1c603563"); // Diners
			put("N", "404ed4d2-a97b-4626-b6ed-273f19e599be"); // Discover
			put("P", "32dc3f71-74c1-4868-9c34-4db70edce0c2"); // Purchase Card
		}
	};
	public CompletableFuture<MRefList_BH> CreditCardType(MPOSPayment entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCreditCardType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CREDITCARDTYPE_UUIDS_BY_VALUE.get(entity.getCreditCardType()));
	}

	public Boolean IsPostDated(MPOSPayment entity, DataFetchingEnvironment environment) {
		return entity.isPostDated();
	}

	public Boolean Processed(MPOSPayment entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public static Map<String, String> TENDERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "d3874573-b7bf-4556-9b9c-3644698c959e"); // Credit or Debit Card
			put("K", "900adbf9-5069-4f56-9d97-0313c6372af3"); // Cheque
			put("A", "220f3864-24b8-42ba-9a91-a247f4697530"); // Direct Deposit
			put("D", "487227e8-c88e-45ef-8e6d-c0a480fdd0de"); // Bank Transfer
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
			put("V", "52fc8585-3c61-45b8-a0dd-db10c1e7d79c"); // Liason insurance
			put("P", "64e8ad21-7c9d-442b-9655-f5223d76140c"); // PesaPal
			put("U", "97e54f17-fbae-40de-8dbd-e8ad7f884732"); // Jubilee insurance
		}
	};
	public CompletableFuture<MRefList_BH> TenderType(MPOSPayment entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTenderType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TENDERTYPE_UUIDS_BY_VALUE.get(entity.getTenderType()));
	}

}
