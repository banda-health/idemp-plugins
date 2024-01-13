package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_ReportLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MLocation;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.compiere.model.X_PA_ReportLine;
import org.compiere.model.X_PA_ReportSource;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_ReportSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportSourceResolver extends POResolver<X_PA_ReportSource> implements GraphQLResolver<X_PA_ReportSource> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public CompletableFuture<MElementValue> C_ElementValue(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValue_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	public CompletableFuture<MSalesRegion> C_SalesRegion(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_SalesRegion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_SalesRegion_ID());
	}

	static Map<String, String> ELEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("AC", "1ce3db23-ba22-4658-a7a3-388e2b83e4ec");
			put("AY", "4cebe278-4b2d-4430-97e2-cb07a3da2065");
			put("BP", "e0862e7f-7c5c-4f1f-9afd-156bb18d1344");
			put("LF", "11413fc0-e7e2-4d37-b47d-4e485f2a51c7");
			put("LT", "9de1cf83-3e27-41f7-b5c6-63906d847d5c");
			put("MC", "5be39ed1-223b-46ca-99c4-3d7c56b1b306");
			put("OO", "0c36bf24-5a35-4859-9006-279a917b0d7e");
			put("OT", "3de1fe8f-4130-492a-9426-ccff9f1ef9da");
			put("PJ", "086db93e-bbd8-4ef4-80db-c91f6b6cea77");
			put("PR", "9e1a15f5-26c2-4732-b323-dc171adc0b59");
			put("SA", "2f271ee7-7a2c-427c-83aa-e44a597aa6dd");
			put("SR", "e9a47662-936e-4a12-93bb-5c2156522beb");
			put("U1", "cde38a17-a4b9-48a5-a4fb-12618a9d1590");
			put("U2", "fb11ce5c-4908-4079-88f9-f4b8a4d1c4d7");
			put("X1", "94eaf88d-d638-4910-92d6-b966d899e13c");
			put("X2", "12ddef97-4164-4434-8874-495cba0b8ec7");
			put("CO", "a852a154-ddbe-43a6-b753-c247521d6bf7");
		}
	};
	public CompletableFuture<MRefList_BH> ElementType(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getElementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ELEMENTTYPE_UUIDS_BY_VALUE.get(entity.getElementType()));
	}

	public Boolean IsIncludeNullsActivity(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsActivity();
	}

	public Boolean IsIncludeNullsBPartner(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsBPartner();
	}

	public Boolean IsIncludeNullsCampaign(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsCampaign();
	}

	public Boolean IsIncludeNullsElementValue(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsElementValue();
	}

	public Boolean IsIncludeNullsLocation(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsLocation();
	}

	public Boolean IsIncludeNullsOrg(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsOrg();
	}

	public Boolean IsIncludeNullsOrgTrx(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsOrgTrx();
	}

	public Boolean IsIncludeNullsProduct(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsProduct();
	}

	public Boolean IsIncludeNullsProject(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsProject();
	}

	public Boolean IsIncludeNullsSalesRegion(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsSalesRegion();
	}

	public Boolean IsIncludeNullsUserElement1(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsUserElement1();
	}

	public Boolean IsIncludeNullsUserElement2(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		return entity.isIncludeNullsUserElement2();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Report Line.
	 *
	 * @return Report Line
	 */
	public CompletableFuture<X_PA_ReportLine> PA_ReportLine(X_PA_ReportSource entity, DataFetchingEnvironment environment) {
		if (entity.getPA_ReportLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PA_ReportLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_ReportLineDataLoader.DATALOADER_PA_ReportLine_BY_ID);
		return dataLoader.load(entity.getPA_ReportLine_ID());
	}

}
