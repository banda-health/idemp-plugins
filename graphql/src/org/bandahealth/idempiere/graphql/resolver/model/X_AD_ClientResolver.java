package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LanguageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PasswordRuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReplicationStrategyDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MPasswordRule;
import org.compiere.model.MReplicationStrategy;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientResolver extends POResolver<MClient_BH> implements GraphQLResolver<MClient_BH> {


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
	public CompletableFuture<MLanguage> AD_Language(MClient_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_Language())) {
			return null;
		}
		DataLoader<Integer, MLanguage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LanguageDataLoader.AD_Language_BY_ID_DATA_LOADER);
		return dataLoader.load(AD_LANGUAGE_IDS_BY_LANGUAGE.get(entity.getAD_Language()));
	}


	/**
	 * Get Password Policies.
	 *
	 * @return Password Policies
	 */
	public CompletableFuture<MPasswordRule> AD_PasswordRule(MClient_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PasswordRule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPasswordRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PasswordRuleDataLoader.AD_PasswordRule_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PasswordRule_ID());
	}


	/**
	 * Get Replication Strategy.
	 *
	 * @return Data Replication Strategy
	 */
	public CompletableFuture<MReplicationStrategy> AD_ReplicationStrategy(MClient_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReplicationStrategy_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReplicationStrategy> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReplicationStrategyDataLoader.AD_ReplicationStrategy_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_ReplicationStrategy_ID());
	}

	static Map<String, String> AUTOARCHIVE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "5be4ba0d-256b-48c6-bba5-e94d76c0b391");
			put("1", "001d29fb-a915-4660-ae36-406c9028610b");
			put("2", "17f95f60-8447-406e-89ce-becf0c7496a8");
			put("3", "c647f6d8-6c62-4f1d-95b7-9512e4e0af07");
		}
	};
	public CompletableFuture<MRefList_BH> AutoArchive(MClient_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAutoArchive())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(AUTOARCHIVE_UUIDS_BY_VALUE.get(entity.getAutoArchive()));
	}

	public Boolean IsMultiLingualDocument(MClient_BH entity, DataFetchingEnvironment environment) {
		return entity.isMultiLingualDocument();
	}

	public Boolean IsPostImmediate(MClient_BH entity, DataFetchingEnvironment environment) {
		return entity.isPostImmediate();
	}

	public Boolean IsSecureSMTP(MClient_BH entity, DataFetchingEnvironment environment) {
		return entity.isSecureSMTP();
	}

	public Boolean IsSmtpAuthorization(MClient_BH entity, DataFetchingEnvironment environment) {
		return entity.isSmtpAuthorization();
	}

	public Boolean IsUseASP(MClient_BH entity, DataFetchingEnvironment environment) {
		return entity.isUseASP();
	}

	public Boolean IsUseBetaFunctions(MClient_BH entity, DataFetchingEnvironment environment) {
		return entity.isUseBetaFunctions();
	}

	static Map<String, String> MMPOLICY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "80bfacfa-9e34-4d5c-8388-5cb45e52447a");
			put("F", "b1ed1550-7c2f-402b-b47a-b700929da0f6");
		}
	};
	public CompletableFuture<MRefList_BH> MMPolicy(MClient_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMMPolicy())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(MMPOLICY_UUIDS_BY_VALUE.get(entity.getMMPolicy()));
	}

}
