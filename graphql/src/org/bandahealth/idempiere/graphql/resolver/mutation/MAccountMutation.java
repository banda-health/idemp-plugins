package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.compiere.model.M_Element;
import org.compiere.util.Env;

import java.util.Properties;

public class MAccountMutation extends X_C_ValidCombinationMutation {
	public MAccount C_ValidCombinationGetOrCreate(String AD_Org_UU, String C_AcctSchema_UU, String Account_UU,
			String C_SubAcct_UU, String M_Product_UU, String C_BPartner_UU, String AD_OrgTrx_UU, String C_LocFrom_UU,
			String C_LocTo_UU, String C_SalesRegion_UU, String C_Project_UU, String C_Campaign_UU, String C_Activity_UU,
			String User1_UU, String User2_UU, String UserElement1_UU, String UserElement2_UU,
			DataFetchingEnvironment environment) {
		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		int AD_Org_ID = 0;
		if (!StringUtil.isNullOrEmpty(AD_Org_UU)) {
			AD_Org_ID = Repository.getByUuid(idempiereProperties, MOrg.Table_Name, null, AD_Org_UU).get_ID();
		}
		int C_AcctSchema_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_AcctSchema_UU)) {
			C_AcctSchema_ID =
					Repository.getByUuid(idempiereProperties, MAcctSchema.Table_Name, null, C_AcctSchema_UU).get_ID();
		}
		int Account_ID = 0;
		if (!StringUtil.isNullOrEmpty(Account_UU)) {
			Account_ID = Repository.getByUuid(idempiereProperties, MElementValue.Table_Name, null, Account_UU).get_ID();
		}
		int C_SubAcct_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_SubAcct_UU)) {
			C_SubAcct_ID = Repository.getByUuid(idempiereProperties, MAccount.Table_Name, null, C_SubAcct_UU).get_ID();
		}
		int M_Product_ID = 0;
		if (!StringUtil.isNullOrEmpty(M_Product_UU)) {
			M_Product_ID = Repository.getByUuid(idempiereProperties, MProduct_BH.Table_Name, null, M_Product_UU).get_ID();
		}
		int C_BPartner_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_BPartner_UU)) {
			C_BPartner_ID = Repository.getByUuid(idempiereProperties, MBPartner_BH.Table_Name, null, C_BPartner_UU).get_ID();
		}
		int AD_OrgTrx_ID = 0;
		if (!StringUtil.isNullOrEmpty(AD_OrgTrx_UU)) {
			AD_OrgTrx_ID = Repository.getByUuid(idempiereProperties, MOrg.Table_Name, null, AD_OrgTrx_UU).get_ID();
		}
		int C_LocFrom_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_LocFrom_UU)) {
			C_LocFrom_ID = Repository.getByUuid(idempiereProperties, MLocation.Table_Name, null, C_LocFrom_UU).get_ID();
		}
		int C_LocTo_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_LocTo_UU)) {
			C_LocTo_ID = Repository.getByUuid(idempiereProperties, MLocation.Table_Name, null, C_LocTo_UU).get_ID();
		}
		int C_SalesRegion_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_SalesRegion_UU)) {
			C_SalesRegion_ID =
					Repository.getByUuid(idempiereProperties, MSalesRegion.Table_Name, null, C_SalesRegion_UU).get_ID();
		}
		int C_Project_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_Project_UU)) {
			C_Project_ID = Repository.getByUuid(idempiereProperties, MProject.Table_Name, null, C_Project_UU).get_ID();
		}
		int C_Campaign_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_Campaign_UU)) {
			C_Campaign_ID = Repository.getByUuid(idempiereProperties, MCampaign.Table_Name, null, C_Campaign_UU).get_ID();
		}
		int C_Activity_ID = 0;
		if (!StringUtil.isNullOrEmpty(C_Activity_UU)) {
			C_Activity_ID = Repository.getByUuid(idempiereProperties, MActivity.Table_Name, null, C_Activity_UU).get_ID();
		}
		int User1_ID = 0;
		if (!StringUtil.isNullOrEmpty(User1_UU)) {
			User1_ID = Repository.getByUuid(idempiereProperties, M_Element.Table_Name, null, User1_UU).get_ID();
		}
		int User2_ID = 0;
		if (!StringUtil.isNullOrEmpty(User2_UU)) {
			User2_ID = Repository.getByUuid(idempiereProperties, M_Element.Table_Name, null, User2_UU).get_ID();
		}
		int UserElement1_ID = 0;
		if (!StringUtil.isNullOrEmpty(UserElement1_UU)) {
			UserElement1_ID =
					Repository.getByUuid(idempiereProperties, M_Element.Table_Name, null, UserElement1_UU).get_ID();
		}
		int UserElement2_ID = 0;
		if (!StringUtil.isNullOrEmpty(UserElement2_UU)) {
			UserElement2_ID =
					Repository.getByUuid(idempiereProperties, M_Element.Table_Name, null, UserElement2_UU).get_ID();
		}
		return MAccount.get(BandaGraphQLContext.getCtx(environment),
				Env.getAD_Client_ID(BandaGraphQLContext.getCtx(environment)), AD_Org_ID, C_AcctSchema_ID, Account_ID,
				C_SubAcct_ID, M_Product_ID, C_BPartner_ID, AD_OrgTrx_ID, C_LocFrom_ID, C_LocTo_ID, C_SalesRegion_ID,
				C_Project_ID, C_Campaign_ID, C_Activity_ID, User1_ID, User2_ID, UserElement1_ID, UserElement2_ID, null);
	}
}
