package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_AdditionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_RetirementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_Table_HeaderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MAssetChange;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MLocation;
import org.compiere.model.X_A_Asset_Retirement;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_ChangeResolver extends POResolver<MAssetChange> implements GraphQLResolver<MAssetChange> {



	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	public CompletableFuture<MAccount> A_Accumdepreciation_A(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Accumdepreciation_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Accumdepreciation_Acct());
	}


	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	public CompletableFuture<MAccount> A_Asset_A(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Acct());
	}


	/**
	 * Get Asset Addition.
	 *
	 * @return Asset Addition
	 */
	public CompletableFuture<MAssetAddition> A_Asset_Addition(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Addition_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetAddition> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_AdditionDataLoader.A_Asset_Addition_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Addition_ID());
	}


	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.A_Asset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Asset Retirement.
	 *
	 * @return Internally used asset is not longer used.
	 */
	public CompletableFuture<X_A_Asset_Retirement> A_Asset_Retirement(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Retirement_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_A_Asset_Retirement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_RetirementDataLoader.A_Asset_Retirement_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Retirement_ID());
	}


	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	public CompletableFuture<MAccount> A_Depreciation_A(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Depreciation_Acct());
	}

	static Map<String, String> A_DEPRECIATION_MANUAL_PERIOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("PR", "35e7efb6-c084-458c-89e6-bdeeb3757add");
			put("YR", "d34572f8-bbc3-4768-9662-8ae6f48f7398");
		}
	};
	public CompletableFuture<MRefList_BH> A_Depreciation_Manual_Period(MAssetChange entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Depreciation_Manual_Period())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_DEPRECIATION_MANUAL_PERIOD_UUIDS_BY_VALUE.get(entity.getA_Depreciation_Manual_Period()));
	}


	/**
	 * Get A_Depreciation_Table_Header_ID.
	 *
	 * @return A_Depreciation_Table_Header_ID
	 */
	public CompletableFuture<X_A_Depreciation_Table_Header> A_Depreciation_Table_Header(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Depreciation_Table_Header_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_A_Depreciation_Table_Header> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Depreciation_Table_HeaderDataLoader.A_Depreciation_Table_Header_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Depreciation_Table_Header_ID());
	}


	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	public CompletableFuture<MAccount> A_Disposal_Loss_A(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Loss_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Disposal_Loss_Acct());
	}


	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	public CompletableFuture<MAccount> A_Disposal_Revenue_A(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Disposal_Revenue_Acct() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Disposal_Revenue_Acct());
	}


	/**
	 * Get Parent Asset.
	 *
	 * @return Parent Asset
	 */
	public CompletableFuture<MAsset> A_Parent_Asset(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getA_Parent_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.A_Asset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Parent_Asset_ID());
	}

	static Map<String, String> A_REVAL_CAL_METHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DFT", "c11a5c1d-7b50-4462-92f3-5fd512c7c3f9");
			put("IDF", "82c0032e-1d8f-4001-b365-39f9a8cc2b05");
			put("YBF", "2e54c6d4-f45a-474c-b4ab-6c7679f913dd");
		}
	};
	public CompletableFuture<MRefList_BH> A_Reval_Cal_Method(MAssetChange entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Reval_Cal_Method())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_REVAL_CAL_METHOD_UUIDS_BY_VALUE.get(entity.getA_Reval_Cal_Method()));
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.C_BPartner_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.C_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Location_ID());
	}


	/**
	 * Get Combination.
	 *
	 * @return Valid Account Combination
	 */
	public CompletableFuture<MAccount> C_ValidCombination(MAssetChange entity, DataFetchingEnvironment environment) {
		if (entity.getC_ValidCombination_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.C_ValidCombination_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ValidCombination_ID());
	}

	static Map<String, String> CHANGETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ADD", "9fc17658-0394-4c59-b877-c9bba645e713");
			put("BAL", "a2e3ca86-d4df-40bd-bf4c-3eb1487d2292");
			put("CRT", "ed3e9647-116f-4a6a-917d-2e203d078f03");
			put("DEP", "f8c5a40a-e6e5-45b9-8728-ab40f0c9511d");
			put("DIS", "f0619bd1-c178-4e3d-8f7b-74afb768921d");
			put("EXP", "b280f43c-b174-4d2e-9d7c-d9a4a243f9f2");
			put("FOR", "a8eab0c5-34e1-46c2-a104-69b0b5d38070");
			put("IMP", "6c83bad3-42c1-4948-8258-407f98b8a2fe");
			put("RVL", "5aedba15-9238-4c8a-9e33-6eb131ae027f");
			put("SET", "a8cc5d42-c2ad-4914-a386-1754d608e109");
			put("SPL", "b82f8e94-b5dd-4f1a-ab63-af2d92638ca3");
			put("TRN", "3e9e8557-098a-40a9-8823-facae98db8dc");
			put("UPD", "56d067a8-2414-4213-b5f9-02636051a723");
			put("USE", "a50cdeeb-65f2-4d05-b43c-efd5a39d0cdb");
		}
	};
	public CompletableFuture<MRefList_BH> ChangeType(MAssetChange entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getChangeType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CHANGETYPE_UUIDS_BY_VALUE.get(entity.getChangeType()));
	}

	public Boolean IsDepreciated(MAssetChange entity, DataFetchingEnvironment environment) {
		return entity.isDepreciated();
	}

	public Boolean IsDisposed(MAssetChange entity, DataFetchingEnvironment environment) {
		return entity.isDisposed();
	}

	public Boolean IsFullyDepreciated(MAssetChange entity, DataFetchingEnvironment environment) {
		return entity.isFullyDepreciated();
	}

	public Boolean IsInPosession(MAssetChange entity, DataFetchingEnvironment environment) {
		return entity.isInPosession();
	}

	public Boolean IsOwned(MAssetChange entity, DataFetchingEnvironment environment) {
		return entity.isOwned();
	}

	static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "3c9d051c-7b7b-459d-90c5-0925e26c1bcc");
			put("B", "07bbb012-66f2-4860-bd6d-dc511618bf4e");
			put("E", "c40ae7b1-be06-4291-ac88-59974f74a46d");
			put("S", "6011c5d4-edcc-48f6-ba32-8d820d42dbfb");
			put("R", "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5");
		}
	};
	public CompletableFuture<MRefList_BH> PostingType(MAssetChange entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

}
