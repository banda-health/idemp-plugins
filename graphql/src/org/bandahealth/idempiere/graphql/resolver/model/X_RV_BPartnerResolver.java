package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LanguageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CountryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_GreetingDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxGroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBPartnerInfo;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MInvoiceSchedule;
import org.compiere.model.MLanguage;
import org.compiere.model.MLocation;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MRegion;
import org.compiere.model.MSalesRegion;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_Greeting;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxGroup;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_RV_BPartnerResolver extends POResolver<MBPartnerInfo> implements GraphQLResolver<MBPartnerInfo> {


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
	public CompletableFuture<MLanguage> AD_Language(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_Language())) {
			return null;
		}
		DataLoader<Integer, MLanguage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LanguageDataLoader.DATALOADER_AD_Language_BY_ID);
		return dataLoader.load(AD_LANGUAGE_IDS_BY_LANGUAGE.get(entity.getAD_Language()));
	}


	/**
	 * Get AD_User_C_BPartner_ID.
	 *
	 * @return AD_User_C_BPartner_ID
	 */
	public CompletableFuture<MBPartner_BH> AD_User_C_BPartner(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_C_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getAD_User_C_BPartner_ID());
	}


	/**
	 * Get AD_User_C_BPartner_Location_ID.
	 *
	 * @return AD_User_C_BPartner_Location_ID
	 */
	public CompletableFuture<MBPartnerLocation> AD_User_C_BPartner_Location(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_C_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getAD_User_C_BPartner_Location_ID());
	}

	public Timestamp ad_user_created(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getad_user_created();
	}


	/**
	 * Get ad_user_createdby.
	 *
	 * @return ad_user_createdby
	 */
	public CompletableFuture<MUser_BH> AD_User_Create(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_CreatedBy() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_CreatedBy());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean ad_user_isactive(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isad_user_isactive();
	}

	public Timestamp ad_user_updated(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getad_user_updated();
	}


	/**
	 * Get ad_user_updatedby.
	 *
	 * @return ad_user_updatedby
	 */
	public CompletableFuture<MUser_BH> AD_User_Update(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_UpdatedBy() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_UpdatedBy());
	}

	public String ad_user_value(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getad_user_value();
	}


	/**
	 * Get Partner Parent.
	 *
	 * @return Business Partner Parent
	 */
	public CompletableFuture<MBPartner_BH> BPartner_Parent(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getBPartner_Parent_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getBPartner_Parent_ID());
	}


	/**
	 * Get BP Contact Greeting.
	 *
	 * @return Greeting for Business Partner Contact
	 */
	public CompletableFuture<X_C_Greeting> BPContactGreet(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getBPContactGreeting() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Greeting> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_GreetingDataLoader.DATALOADER_C_Greeting_BY_ID);
		return dataLoader.load(entity.getBPContactGreeting());
	}


	/**
	 * Get c_bp_c_taxgroup_id.
	 *
	 * @return c_bp_c_taxgroup_id
	 */
	public CompletableFuture<X_C_TaxGroup> C_BP_C_TaxGroup(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_C_TaxGroup_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_TaxGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxGroupDataLoader.DATALOADER_C_TaxGroup_BY_ID);
		return dataLoader.load(entity.getC_BP_C_TaxGroup_ID());
	}

	public Timestamp c_bp_dunninggrace(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_dunninggrace();
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_ID);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}

	public Boolean c_bp_ismanufacturer(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_bp_ismanufacturer();
	}

	public Boolean c_bp_ispotaxexempt(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_bp_ispotaxexempt();
	}


	/**
	 * Get c_bpartner_location_c_bpartner_id.
	 *
	 * @return c_bpartner_location_c_bpartner_id
	 */
	public CompletableFuture<MBPartner_BH> C_BP_Location_C_BPartner(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Location_C_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BP_Location_C_BPartner_ID());
	}


	/**
	 * Get c_bp_location_c_location_id.
	 *
	 * @return c_bp_location_c_location_id
	 */
	public CompletableFuture<MLocation> C_BP_Location_C_Location(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Location_C_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_BP_Location_C_Location_ID());
	}

	public Timestamp c_bp_location_created(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_location_created();
	}


	/**
	 * Get c_bp_location_createdby.
	 *
	 * @return c_bp_location_createdby
	 */
	public CompletableFuture<MUser_BH> C_BP_Location_Create(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Location_CreatedBy() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getC_BP_Location_CreatedBy());
	}

	public String c_bp_location_fax(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_location_fax();
	}

	public Boolean c_bp_location_isactive(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_bp_location_isactive();
	}

	public Boolean c_bp_location_isbillto(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_bp_location_isbillto();
	}

	public String c_bp_location_isdn(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_location_isdn();
	}

	public Boolean c_bp_location_ispayfrom(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_bp_location_ispayfrom();
	}

	public Boolean c_bp_location_isremitto(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_bp_location_isremitto();
	}

	public Boolean c_bp_location_isshipto(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_bp_location_isshipto();
	}

	public String c_bp_location_name(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_location_name();
	}

	public String c_bp_location_phone(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_location_phone();
	}

	public String c_bp_location_phone2(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_location_phone2();
	}


	/**
	 * Get c_bp_location_salesregion_id.
	 *
	 * @return c_bp_location_salesregion_id
	 */
	public CompletableFuture<MSalesRegion> C_BP_Location_SalesRegion(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Location_SalesRegion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_BP_Location_SalesRegion_ID());
	}

	public Timestamp c_bp_location_updated(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_bp_location_updated();
	}


	/**
	 * Get c_bp_location_updatedby.
	 *
	 * @return c_bp_location_updatedby
	 */
	public CompletableFuture<MUser_BH> C_BP_Location_Update(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Location_UpdatedBy() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getC_BP_Location_UpdatedBy());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get City.
	 *
	 * @return City
	 */
	public CompletableFuture<MCity> C_City(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_City_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CityDataLoader.DATALOADER_C_City_BY_ID);
		return dataLoader.load(entity.getC_City_ID());
	}

	public String c_country_ad_language(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_country_ad_language();
	}


	/**
	 * Get c_country_c_currency_id.
	 *
	 * @return c_country_c_currency_id
	 */
	public CompletableFuture<MCurrency_BH> C_Country_C_Currency(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_C_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Country_C_Currency_ID());
	}

	public String c_country_description(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_country_description();
	}


	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public CompletableFuture<MCountry> C_Country(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Country_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCountry> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CountryDataLoader.DATALOADER_C_Country_BY_ID);
		return dataLoader.load(entity.getC_Country_ID());
	}

	public Boolean c_country_isactive(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_country_isactive();
	}


	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public CompletableFuture<MDunning> C_Dunning(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Dunning_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDunning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningDataLoader.DATALOADER_C_Dunning_BY_ID);
		return dataLoader.load(entity.getC_Dunning_ID());
	}


	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	public CompletableFuture<X_C_Greeting> C_Greeting(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Greeting_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Greeting> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_GreetingDataLoader.DATALOADER_C_Greeting_BY_ID);
		return dataLoader.load(entity.getC_Greeting_ID());
	}


	/**
	 * Get Invoice Schedule.
	 *
	 * @return Schedule for generating Invoices
	 */
	public CompletableFuture<MInvoiceSchedule> C_InvoiceSchedule(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceSchedule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceSchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceScheduleDataLoader.DATALOADER_C_InvoiceSchedule_BY_ID);
		return dataLoader.load(entity.getC_InvoiceSchedule_ID());
	}

	public Timestamp c_location_created(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_location_created();
	}


	/**
	 * Get c_location_createdby.
	 *
	 * @return c_location_createdby
	 */
	public CompletableFuture<MUser_BH> C_Location_Create(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_CreatedBy() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getC_Location_CreatedBy());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}

	public Boolean c_location_isactive(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_location_isactive();
	}

	public Timestamp c_location_updated(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_location_updated();
	}


	/**
	 * Get c_location_updatedby.
	 *
	 * @return c_location_updatedby
	 */
	public CompletableFuture<MUser_BH> C_Location_Update(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_UpdatedBy() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getC_Location_UpdatedBy());
	}


	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}

	public String c_region_description(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.getc_region_description();
	}


	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public CompletableFuture<MRegion> C_Region(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_Region_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_ID);
		return dataLoader.load(entity.getC_Region_ID());
	}

	public Boolean c_region_isactive(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isc_region_isactive();
	}

	static Map<String, String> DELIVERYRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("R", "20fd42a7-54c5-4a60-8e1a-4cda5c9856ee");
			put("A", "89125067-1315-434e-a112-2593bb681a9d");
			put("L", "613c2dee-60a6-46ea-8a0a-646cd4a10c61");
			put("O", "3f011d8d-6d3d-4d12-aa4c-c5adea40b464");
			put("F", "3db26d28-62ee-454c-b25b-5abbef460042");
			put("M", "d9b69f78-edb1-4179-a56e-33cbca133673");
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryRule(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYRULE_UUIDS_BY_VALUE.get(entity.getDeliveryRule()));
	}

	static Map<String, String> DELIVERYVIARULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "701ff061-98de-431b-b6ab-b14da4987285");
			put("D", "9d1b379c-84b1-43b1-b735-8c7467cb1b1a");
			put("S", "19951c20-3a06-4eb5-a0c2-fc8b27e408a7");
		}
	};
	public CompletableFuture<MRefList_BH> DeliveryViaRule(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDeliveryViaRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DELIVERYVIARULE_UUIDS_BY_VALUE.get(entity.getDeliveryViaRule()));
	}

	static Map<String, String> FREIGHTCOSTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "82df2976-c23f-43fb-91e9-b2b4ab27063f");
			put("F", "3c97df02-d8ed-4bca-91b2-c4ca115533c4");
			put("C", "43e070a0-f583-4b5d-a11c-6e5945a99272");
			put("L", "623c0263-3294-4073-9884-e5cb78edb1bd");
		}
	};
	public CompletableFuture<MRefList_BH> FreightCostRule(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFreightCostRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREIGHTCOSTRULE_UUIDS_BY_VALUE.get(entity.getFreightCostRule()));
	}


	/**
	 * Get Invoice Print Format.
	 *
	 * @return Print Format for printing Invoices
	 */
	public CompletableFuture<X_AD_PrintFormat> Invoice_PrintFormat(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getInvoice_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getInvoice_PrintFormat_ID());
	}

	static Map<String, String> INVOICERULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("O", "f0b52a34-6ff9-40b0-8668-cb458e21328e");
			put("D", "8d21d623-1f99-4510-aec4-6e475d587264");
			put("S", "f522d449-bea8-42aa-90e7-b5190db85b68");
			put("I", "1e030a09-94f2-4bd4-8810-d739aa9f25a6");
		}
	};
	public CompletableFuture<MRefList_BH> InvoiceRule(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(INVOICERULE_UUIDS_BY_VALUE.get(entity.getInvoiceRule()));
	}

	public Boolean IsCustomer(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isCustomer();
	}

	public Boolean IsDefault(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsDiscountPrinted(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isDiscountPrinted();
	}

	public Boolean IsEmployee(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isEmployee();
	}

	public Boolean IsOneTime(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isOneTime();
	}

	public Boolean IsProspect(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isProspect();
	}

	public Boolean IsSalesRep(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isSalesRep();
	}

	public Boolean IsSummary(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	public Boolean IsTaxExempt(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isTaxExempt();
	}

	public Boolean IsVendor(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isVendor();
	}

	public Boolean LDAPUser(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isLDAPUser();
	}


	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> M_DiscountSchema(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getM_DiscountSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getM_DiscountSchema_ID());
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}

	static Map<String, String> NOTIFICATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "e1ca3bcf-d8cb-451f-acd4-0a6773257650");
			put("N", "a85de9af-6e78-48e5-ae43-4f07734c2df3");
			put("X", "ca78475e-7191-402b-9d15-7244e87620f1");
			put("B", "aae5e850-38ca-4b15-9c9d-bee6402e7427");
		}
	};
	public CompletableFuture<MRefList_BH> NotificationType(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNotificationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(NOTIFICATIONTYPE_UUIDS_BY_VALUE.get(entity.getNotificationType()));
	}

	static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293");
			put("K", "68dda00d-c015-498e-b91c-811bab809dab");
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64");
			put("b", "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRule(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	static Map<String, String> PAYMENTRULEPO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293");
			put("K", "68dda00d-c015-498e-b91c-811bab809dab");
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64");
			put("b", "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRulePO(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRulePO())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULEPO_UUIDS_BY_VALUE.get(entity.getPaymentRulePO()));
	}


	/**
	 * Get PO Discount Schema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> PO_DiscountSchema(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getPO_DiscountSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getPO_DiscountSchema_ID());
	}


	/**
	 * Get PO Payment Term.
	 *
	 * @return Payment rules for a purchase order
	 */
	public CompletableFuture<MPaymentTerm> PO_PaymentTerm(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getPO_PaymentTerm_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getPO_PaymentTerm_ID());
	}


	/**
	 * Get Purchase Pricelist.
	 *
	 * @return Price List used by this Business Partner
	 */
	public CompletableFuture<MPriceList> PO_PriceList(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getPO_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getPO_PriceList_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	public Boolean SendEMail(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		return entity.isSendEMail();
	}

	static Map<String, String> SOCREDITSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "ebd6f716-efbe-4a4f-9d3a-e3848f4a3b75");
			put("H", "5801b69d-7f76-4cfc-98ea-5d5f8e1a9279");
			put("W", "562a254f-6346-4cc3-95a6-130edbe6dccc");
			put("X", "ce7efb85-ccc7-403d-b42f-e276bd9f2f06");
			put("O", "d2130138-c9f1-4314-a0c3-e46cecaae025");
		}
	};
	public CompletableFuture<MRefList_BH> SOCreditStatus(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSOCreditStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SOCREDITSTATUS_UUIDS_BY_VALUE.get(entity.getSOCreditStatus()));
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MBPartnerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}

}
