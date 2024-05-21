package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Tax_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MCountryGroup;
import org.compiere.model.MRegion;
import org.compiere.model.MRule;
import org.compiere.model.MTax;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MTaxProvider;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxResolver extends POResolver<MTax> implements GraphQLResolver<MTax> {



	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	public CompletableFuture<MRule> AD_Rule(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Rule_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RuleDataLoader.DATALOADER_AD_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Rule_ID());
	}


	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.DATALOADER_C_Country_BY_ID);
		return dataLoader.load(entity.getC_Country_ID());
	}


	/**
	 * Get Country Group From.
	 *
	 * @return Country Group From
	 */
	public CompletableFuture<MCountryGroup> C_CountryGroupFrom(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_CountryGroupFrom_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCountryGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryGroupDataLoader.DATALOADER_C_CountryGroup_BY_ID);
		return dataLoader.load(entity.getC_CountryGroupFrom_ID());
	}


	/**
	 * Get Country Group To.
	 *
	 * @return Country Group To
	 */
	public CompletableFuture<MCountryGroup> C_CountryGroupTo(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_CountryGroupTo_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCountryGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryGroupDataLoader.DATALOADER_C_CountryGroup_BY_ID);
		return dataLoader.load(entity.getC_CountryGroupTo_ID());
	}


	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public CompletableFuture<MRegion> C_Region(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Region_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_ID);
		return dataLoader.load(entity.getC_Region_ID());
	}


	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public CompletableFuture<MTaxCategory> C_TaxCategory(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxCategory_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTaxCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxCategoryDataLoader.DATALOADER_C_TaxCategory_BY_ID);
		return dataLoader.load(entity.getC_TaxCategory_ID());
	}


	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	public CompletableFuture<MTaxProvider> C_TaxProvider(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxProvider_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTaxProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxProviderDataLoader.DATALOADER_C_TaxProvider_BY_ID);
		return dataLoader.load(entity.getC_TaxProvider_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MTax entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Tax_TrlDataLoader.DATALOADER_C_Tax_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MTax.COLUMNNAME_Description) :
						entity.getDescription());
	}

	public Boolean IsDefault(MTax entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsDocumentLevel(MTax entity, DataFetchingEnvironment environment) {
		return entity.isDocumentLevel();
	}

	public Boolean IsSalesTax(MTax entity, DataFetchingEnvironment environment) {
		return entity.isSalesTax();
	}

	public Boolean IsSummary(MTax entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	public Boolean IsTaxExempt(MTax entity, DataFetchingEnvironment environment) {
		return entity.isTaxExempt();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MTax entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Tax_TrlDataLoader.DATALOADER_C_Tax_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MTax.COLUMNNAME_Name) :
						entity.getName());
	}


	/**
	 * Get Parent Tax.
	 *
	 * @return Parent Tax indicates a tax that is made up of multiple taxes
	 */
	public CompletableFuture<MTax> Parent_Tax(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getParent_Tax_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getParent_Tax_ID());
	}

	public Boolean RequiresTaxCertificate(MTax entity, DataFetchingEnvironment environment) {
		return entity.isRequiresTaxCertificate();
	}

	static Map<String, String> SOPOTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "4d7e51ff-cf6b-401d-b70b-fa87ba05a913");
			put("S", "178a8145-a858-4705-9feb-d2428b7c2427");
			put("P", "5d8aad9d-36bf-4f30-bbb2-639726c133f5");
		}
	};
	public CompletableFuture<MRefList_BH> SOPOType(MTax entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSOPOType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SOPOTYPE_UUIDS_BY_VALUE.get(entity.getSOPOType()));
	}

	/**
	 * Get Tax Indicator.
	 *
	 * @return Short form for Tax to be printed on documents
	 */
	public CompletableFuture<String> TaxIndicator(MTax entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getTaxIndicator);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Tax_TrlDataLoader.DATALOADER_C_Tax_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MTax.COLUMNNAME_TaxIndicator) :
						entity.getTaxIndicator());
	}

	static Map<String, String> TAXPOSTINGINDICATOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "e84b618c-a8b3-47cf-89a6-dd674e52d3e4");
			put("1", "3e8e0d29-29ac-4c67-ae2c-92c0ee43d2e6");
		}
	};
	public CompletableFuture<MRefList_BH> TaxPostingIndicator(MTax entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTaxPostingIndicator())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TAXPOSTINGINDICATOR_UUIDS_BY_VALUE.get(entity.getTaxPostingIndicator()));
	}


	/**
	 * Get To.
	 *
	 * @return Receiving Region
	 */
	public CompletableFuture<MRegion> To_Region(MTax entity, DataFetchingEnvironment environment) {
		if (entity.getTo_Region_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_ID);
		return dataLoader.load(entity.getTo_Region_ID());
	}

}
