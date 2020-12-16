package org.bandahealth.idempiere.rest.repository;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.compiere.model.MTaxCategory;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends BaseRepository<MProduct_BH> {

	private final String productCategoryJoin = " JOIN " + MProductCategory_BH.Table_Name + " ON " +
			MProductCategory_BH.Table_Name + "." + MProductCategory_BH.COLUMNNAME_M_Product_Category_ID + "=" +
			MProduct_BH.Table_Name + "." + MProduct_BH.COLUMNNAME_M_Product_Category_ID;

	@Override
	protected MProduct_BH createModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}

	public List<MProduct_BH> getItems(String filterJson, String sort, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Item);

		return super.get(filterJson, sort, pagingInfo, MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters,
				productCategoryJoin);
	}

	public Paging getItemsPagingInfo(String filterJson, String sort, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Item);

		return super.getPagingInfo(filterJson, sort, pagingInfo, MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters,
				productCategoryJoin);
	}

	public List<MProduct_BH> getServices(String filterJson, String sort, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Service);

		return super.get(filterJson, sort, pagingInfo, MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters,
				productCategoryJoin);
	}

	public Paging getServicesPagingInfo(String filterJson, String sort, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Service);

		return super.getPagingInfo(filterJson, sort, pagingInfo, MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters,
				productCategoryJoin);
	}

//	@Override
//	public Map<String, String> getDynamicJoins() {
//		String storageOnHandBaseSql = storageOnHandRepository.getBaseQuery(idempiereContext, null)
//				.getSQL();
//		int storageOnHandBaseIndexOfFrom = storageOnHandBaseSql.indexOf("FROM");
//		int storageOnHandBaseIndexOfWhere = storageOnHandBaseSql.indexOf("WHERE");
//		return new HashMap<>() {{
//			put(MStorageOnHand.Table_Name, "LEFT JOIN (" + "SELECT " + MStorageOnHand.Table_Name + "." +
//					MStorageOnHand.COLUMNNAME_M_Product_ID + "," + StorageOnHandRepository.COLUMNSELECT_QtyOnHand + " AS " +
//					MStorageOnHand.COLUMNNAME_QtyOnHand + " " + storageOnHandBaseSql
//					.substring(storageOnHandBaseIndexOfFrom, storageOnHandBaseIndexOfWhere) + " GROUP BY " +
//					MStorageOnHand.Table_Name + "." + MStorageOnHand.COLUMNNAME_M_Product_ID + ") AS " +
//					MStorageOnHand.Table_Name + " ON " + MStorageOnHand.Table_Name + "." +
//					MStorageOnHand.COLUMNNAME_M_Product_ID + "=" + MProduct_BH.Table_Name + "." +
//					MProduct_BH.COLUMNNAME_M_Product_ID);
//		}};
//	}

	@Override
	public MProduct_BH mapInputModelToModel(MProduct_BH entity) {
		try {
			MProduct_BH product = getByUuid(entity.getM_Product_UU());
			if (product == null) {
				product = createModelInstance();
				product.setProductType(MProduct_BH.PRODUCTTYPE_Item);

//				// set default uom (unit of measure).
//				MUOM uom = uomRepository.getBaseQuery(idempiereContext, MUOM.COLUMNNAME_Name + "=?",
//						"Each").first();
//				if (uom != null) {
//					product.setC_UOM_ID(uom.get_ID());
//				}

//				// set product category.
//				MProductCategory productCategory = productCategoryRepository.getBaseQuery(idempiereContext,
//						MProductCategory.COLUMNNAME_Name + "=?", "Pharmacy").first();
//				if (productCategory != null) {
//					product.setM_Product_Category_ID(productCategory.get_ID());
//				}

				// set tax category
				MTaxCategory taxCategory = new Query(Env.getCtx(), MTaxCategory.Table_Name,
						MTaxCategory.COLUMNNAME_Name + "=?", null)
						.setParameters("Standard").setClient_ID().first();
				if (taxCategory != null) {
					product.setC_TaxCategory_ID(taxCategory.get_ID());
				}
			}

			ModelUtil.setPropertyIfPresent(entity.getName(), product::setName);
			ModelUtil.setPropertyIfPresent(entity.getDescription(), product::setDescription);
			ModelUtil.setPropertyIfPresent(entity.isBH_HasExpiration(), product::setBH_HasExpiration);
			ModelUtil.setPropertyIfPresent(entity.getbh_reorder_level(), product::setbh_reorder_level);
			ModelUtil.setPropertyIfPresent(entity.getbh_reorder_quantity(), product::setbh_reorder_quantity);
			ModelUtil.setPropertyIfPresent(entity.getBH_BuyPrice(), product::setBH_BuyPrice);
			ModelUtil.setPropertyIfPresent(entity.getBH_SellPrice(), product::setBH_SellPrice);

//			if (entity.getProductCategory() != null) {
//				MProductCategory_BH productCategory = productCategoryRepository
//						.getByUuid(entity.getProductCategory().getM_Product_Category_UU(), idempiereContext);
//				if (productCategory != null) {
			product.setM_Product_Category_ID(entity.getM_Product_Category_ID());
//				}
//			}

			// calculate price margin
			if (entity.getBH_BuyPrice() != null && entity.getBH_SellPrice() != null) {
				product.setBH_PriceMargin(entity.getBH_SellPrice().subtract(entity.getBH_BuyPrice()));
			}

			product.setIsActive(entity.isActive());

			return product;
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}
}
