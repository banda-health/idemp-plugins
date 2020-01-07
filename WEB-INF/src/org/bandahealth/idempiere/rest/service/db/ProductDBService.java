package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.Service;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

public class ProductDBService {

	private CLogger log = CLogger.getCLogger(ProductDBService.class);

	public ProductDBService() {}
	
//	@Override
	protected Product createInstance(MProduct_BH product) {
		
		try {
			return new Product(product.getAD_Client_ID(), product.getAD_Org_ID(), product.getM_Product_UU(),
					product.isActive(), DateUtil.parse(product.getCreated()), product.getCreatedBy(),
					product.getName(), product.getDescription(), product.getValue(),
					product.isStocked(), product.getBH_BuyPrice(), product.getBH_SellPrice(), product.getProductType());
		} catch (Exception exception) {
			log.severe("Error creating product: " + exception);
			return null;
		}
			
	}

	public Product getEntity(String uuid) {
		String whereClause = MProduct_BH.COLUMNNAME_ProductType + " = ? AND " + MProduct_BH.COLUMNNAME_M_Product_UU
				+ " = ?";

		MProduct_BH entity = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause,
				MProduct_BH.COLUMNNAME_Name + " IS NOT NULL").setClient_ID().setOnlyActiveRecords(true)
						.setParameters("I", uuid).setOrderBy(MProduct_BH.COLUMNNAME_Created + " DESC").first();

		return createInstance(entity);
	}


	public BaseListResponse<Product> getAll(Paging pagingInfo) {
		try {
			List<Product> results = new ArrayList<>();

			String whereClause = MProduct_BH.COLUMNNAME_ProductType + " = ?";

			Query query = new Query(Env.getCtx(), MProduct_BH.Table_Name, whereClause,
					MProduct_BH.COLUMNNAME_Name + " IS NOT NULL").setClient_ID().setOnlyActiveRecords(true)
							.setParameters("S").setOrderBy(MProduct_BH.COLUMNNAME_Created + " DESC");

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MProduct_BH> products = query.list();

			if (!products.isEmpty()) {
				for (MProduct_BH product : products) {
					if (product != null) {
						results.add(createInstance(product));
					}
				}
			}

			return new BaseListResponse<Product>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

}
