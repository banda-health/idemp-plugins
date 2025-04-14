package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LanguageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Country_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MLanguage;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CountryResolver extends POResolver<MCountry> implements GraphQLResolver<MCountry> {


	static Map<String, Integer> AD_LANGUAGE_IDS_BY_LANGUAGE = new HashMap<>() {
		{
			put("ar_AE", 100);
			put("ar_BH", 101);
			put("ar_DZ", 102);
			put("ar_EG", 103);
			put("ar_IQ", 104);
			put("ar_JO", 105);
			put("ar_KW", 106);
			put("ar_LB", 107);
			put("ar_LY", 108);
			put("ar_MA", 109);
			put("ar_OM", 110);
			put("ar_QA", 111);
			put("ar_SA", 112);
			put("ar_SD", 113);
			put("ar_SY", 114);
			put("ar_TN", 115);
			put("ar_YE", 116);
			put("be_BY", 117);
			put("bg_BG", 118);
			put("ca_ES", 119);
			put("cs_CZ", 120);
			put("da_DK", 121);
			put("de_AT", 122);
			put("de_CH", 123);
			put("de_DE", 191);
			put("de_LU", 124);
			put("el_CY", 50004);
			put("el_GR", 125);
			put("en_AU", 126);
			put("en_CA", 127);
			put("en_GB", 128);
			put("en_IE", 129);
			put("en_IN", 130);
			put("en_KE", 50017);
			put("en_MT", 50005);
			put("en_NZ", 131);
			put("en_PH", 50006);
			put("en_SG", 50007);
			put("en_US", 192);
			put("en_ZA", 132);
			put("es_AR", 133);
			put("es_BO", 134);
			put("es_CL", 135);
			put("es_CO", 136);
			put("es_CR", 137);
			put("es_DO", 138);
			put("es_EC", 139);
			put("es_ES", 140);
			put("es_GT", 141);
			put("es_HN", 142);
			put("es_MX", 143);
			put("es_NI", 144);
			put("es_PA", 145);
			put("es_PE", 146);
			put("es_PR", 147);
			put("es_PY", 148);
			put("es_SV", 149);
			put("es_US", 50008);
			put("es_UY", 150);
			put("es_VE", 151);
			put("et_EE", 152);
			put("fa_IR", 193);
			put("fi_FI", 153);
			put("fr_BE", 154);
			put("fr_CA", 155);
			put("fr_CH", 156);
			put("fr_FR", 190);
			put("fr_LU", 157);
			put("ga_IE", 50009);
			put("hi_IN", 158);
			put("hr_HR", 159);
			put("hu_HU", 160);
			put("in_ID", 50010);
			put("is_IS", 161);
			put("it_CH", 162);
			put("it_IT", 163);
			put("iw_IL", 164);
			put("ja_JP", 165);
			put("ko_KR", 166);
			put("lt_LT", 167);
			put("lv_LV", 168);
			put("mk_MK", 169);
			put("ms_MY", 50003);
			put("mt_MT", 50011);
			put("nl_BE", 170);
			put("nl_NL", 171);
			put("no_NO", 172);
			put("pl_PL", 173);
			put("pt_BR", 174);
			put("pt_PT", 175);
			put("ro_RO", 176);
			put("ru_RU", 177);
			put("sh_YU", 178);
			put("sk_SK", 179);
			put("sl_SI", 180);
			put("sq_AL", 181);
			put("sr_BA", 50012);
			put("sr_CS", 50013);
			put("sr_ME", 50014);
			put("sr_RS", 50015);
			put("sr_YU", 182);
			put("sv_SE", 183);
			put("th_TH", 184);
			put("tr_TR", 185);
			put("uk_UA", 186);
			put("vi_VN", 194);
			put("zh_CN", 187);
			put("zh_HK", 188);
			put("zh_SG", 50016);
			put("zh_TW", 189);
		}
	};

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	public CompletableFuture<MLanguage> AD_Language(MCountry entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_Language())) {
			return null;
		}
		DataLoader<Integer, MLanguage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LanguageDataLoader.DATALOADER_AD_Language_BY_ID);
		return dataLoader.load(AD_LANGUAGE_IDS_BY_LANGUAGE.get(entity.getAD_Language()));
	}

	public Boolean AllowCitiesOutOfList(MCountry entity, DataFetchingEnvironment environment) {
		return entity.isAllowCitiesOutOfList();
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MCountry entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_Description) :
						entity.getDescription());
	}

	public Boolean HasPostal_Add(MCountry entity, DataFetchingEnvironment environment) {
		return entity.isHasPostal_Add();
	}

	public Boolean HasRegion(MCountry entity, DataFetchingEnvironment environment) {
		return entity.isHasRegion();
	}

	public Boolean IsAddressLinesLocalReverse(MCountry entity, DataFetchingEnvironment environment) {
		return entity.isAddressLinesLocalReverse();
	}

	public Boolean IsAddressLinesReverse(MCountry entity, DataFetchingEnvironment environment) {
		return entity.isAddressLinesReverse();
	}

	public Boolean IsPostcodeLookup(MCountry entity, DataFetchingEnvironment environment) {
		return entity.isPostcodeLookup();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_Name) :
						entity.getName());
	}

	/**
	 * Get Placeholder for Address 1.
	 *
	 * @return Placeholder for Address 1
	 */
	public CompletableFuture<String> PlaceholderAddress1(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderAddress1);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderAddress1) :
						entity.getPlaceholderAddress1());
	}

	/**
	 * Get Placeholder for Address 2.
	 *
	 * @return Placeholder for Address 2
	 */
	public CompletableFuture<String> PlaceholderAddress2(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderAddress2);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderAddress2) :
						entity.getPlaceholderAddress2());
	}

	/**
	 * Get Placeholder for Address 3.
	 *
	 * @return Placeholder for Address 3
	 */
	public CompletableFuture<String> PlaceholderAddress3(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderAddress3);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderAddress3) :
						entity.getPlaceholderAddress3());
	}

	/**
	 * Get Placeholder for Address 4.
	 *
	 * @return Placeholder for Address 4
	 */
	public CompletableFuture<String> PlaceholderAddress4(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderAddress4);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderAddress4) :
						entity.getPlaceholderAddress4());
	}

	/**
	 * Get Placeholder for Address 5.
	 *
	 * @return Placeholder for Address 5
	 */
	public CompletableFuture<String> PlaceholderAddress5(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderAddress5);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderAddress5) :
						entity.getPlaceholderAddress5());
	}

	/**
	 * Get Placeholder for city.
	 *
	 * @return Placeholder for city
	 */
	public CompletableFuture<String> PlaceholderCity(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderCity);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderCity) :
						entity.getPlaceholderCity());
	}

	/**
	 * Get Placeholder for comments.
	 *
	 * @return Placeholder for comments
	 */
	public CompletableFuture<String> PlaceholderComments(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderComments);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderComments) :
						entity.getPlaceholderComments());
	}

	/**
	 * Get Placeholder for postal.
	 *
	 * @return Placeholder for postal
	 */
	public CompletableFuture<String> PlaceholderPostal(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderPostal);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderPostal) :
						entity.getPlaceholderPostal());
	}

	/**
	 * Get Placeholder for additional zip.
	 *
	 * @return Placeholder for additional zip
	 */
	public CompletableFuture<String> PlaceholderPostal_Add(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPlaceholderPostal_Add);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_PlaceholderPostal_Add) :
						entity.getPlaceholderPostal_Add());
	}

	/**
	 * Get Region.
	 *
	 * @return Name of the Region
	 */
	public CompletableFuture<String> RegionName(MCountry entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getRegionName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Country_TrlDataLoader.DATALOADER_C_Country_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MCountry.COLUMNNAME_RegionName) :
						entity.getRegionName());
	}

}
