package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Charge_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxCategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTaxCategory;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChargeResolver extends POResolver<MCharge_BH> implements GraphQLResolver<MCharge_BH> {


	public Boolean BH_Locked(MCharge_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_Locked();
	}

	static Map<String, String> BH_SUBTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "d8547f6d-5ad0-4025-b8f8-0f4796cf9d0f");
			put("W", "406d22a4-b3ee-48e4-9bba-7031f653aa06");
			put("D", "4782b135-a84e-4eb9-ae3d-88c872a030ce");
		}
	};
	public CompletableFuture<MRefList_BH> BH_SubType(MCharge_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_SubType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_SUBTYPE_UUIDS_BY_VALUE.get(entity.getBH_SubType()));
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MCharge_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Charge Type.
	 *
	 * @return Charge Type
	 */
	public CompletableFuture<MChargeType_BH> C_ChargeType(MCharge_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_ChargeType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChargeType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeTypeDataLoader.DATALOADER_C_ChargeType_BY_ID);
		return dataLoader.load(entity.getC_ChargeType_ID());
	}


	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public CompletableFuture<MTaxCategory> C_TaxCategory(MCharge_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxCategory_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTaxCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxCategoryDataLoader.DATALOADER_C_TaxCategory_BY_ID);
		return dataLoader.load(entity.getC_TaxCategory_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MCharge_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Charge_TrlDataLoader.DATALOADER_C_Charge_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MCharge_BH.COLUMNNAME_Description));
	}

	public Boolean IsSameCurrency(MCharge_BH entity, DataFetchingEnvironment environment) {
		return entity.isSameCurrency();
	}

	public Boolean IsSameTax(MCharge_BH entity, DataFetchingEnvironment environment) {
		return entity.isSameTax();
	}

	public Boolean IsTaxIncluded(MCharge_BH entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MCharge_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Charge_TrlDataLoader.DATALOADER_C_Charge_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MCharge_BH.COLUMNNAME_Name));
	}

}
