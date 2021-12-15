package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.MProductCategory;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.bandahealth.idempiere.rest.model.Service;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * All Service DB Operations
 */
@Component
public class ServiceDBService extends BaseDBService<Service, MProduct_BH> {

	@Autowired
	private ProductCategoryDBService productCategoryDBService;

	// retrieve a list of paginated services.
	public BaseListResponse<Service> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(MProduct_BH.PRODUCTTYPE_Service);

		return super.getAll(MProduct_BH.COLUMNNAME_ProductType + " = ?", parameters, pagingInfo, sortJson, filterJson);
	}

	public BaseListResponse<Service> search(String value, Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add(constructSearchValue(value));
		parameters.add(MProduct_BH.PRODUCTTYPE_Service);

		return this.search(this.DEFAULT_SEARCH_CLAUSE + AND_OPERATOR + MProduct_BH.COLUMNNAME_ProductType + " = ?",
				parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	public Service saveEntity(Service entity) {
		try {
			MProduct_BH service = getEntityByUuidFromDB(entity.getUuid());
			if (service == null) {
				service = getModelInstance();
				service.setProductType(MProduct_BH.PRODUCTTYPE_Service);

				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					service.setM_Product_UU(entity.getUuid());
				}

				// set default uom (unit of measure).
				MUOM uom = new Query(Env.getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_Name + "=?", null)
						.setParameters("Each").first();
				if (uom != null) {
					service.setC_UOM_ID(uom.get_ID());
				}

				// set product category.
				MProductCategory productCategory = new Query(Env.getCtx(), MProductCategory.Table_Name,
						MProductCategory.COLUMNNAME_Name + "=?", null).setParameters("Standard").setClient_ID().first();
				if (productCategory != null) {
					service.setM_Product_Category_ID(productCategory.get_ID());
				}

				// set tax category
				MTaxCategory taxCategory = new Query(Env.getCtx(), MTaxCategory.Table_Name,
						MTaxCategory.COLUMNNAME_Name + "=?", null).setParameters("Standard").setClient_ID().first();
				if (taxCategory != null) {
					service.setC_TaxCategory_ID(taxCategory.get_ID());
				}
			}

			if (StringUtil.isNotNullAndEmpty(entity.getName())) {
				service.setName(entity.getName());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				service.setDescription(entity.getDescription());
			}

			if (entity.getSellingPrice() != null) {
				service.setBH_SellPrice(entity.getSellingPrice());
			}

			if (entity.getProductCategoryUuid() != null) {
				MProductCategory_BH productCategory = productCategoryDBService
						.getEntityByUuidFromDB(entity.getProductCategoryUuid());
				if (productCategory != null) {
					service.setM_Product_Category_ID(productCategory.getM_Product_Category_ID());
				}
			}

			service.setIsActive(entity.getIsActive());

			service.saveEx();

			return createInstanceWithAllFields(getEntityByUuidFromDB(service.getM_Product_UU()));

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Service createInstanceWithDefaultFields(MProduct_BH service) {
		try {
			MProductCategory_BH productCategory = productCategoryDBService
					.getEntityByIdFromDB(service.getM_Product_Category_ID());
			return new Service(service.getAD_Client_ID(), service.getAD_Org_ID(), service.getM_Product_UU(),
					service.isActive(), DateUtil.parseDateOnly(service.getCreated()), service.getCreatedBy(), service.getName(),
					null, service.getBH_SellPrice(), productCategory.getM_Product_Category_UU());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Service createInstanceWithAllFields(MProduct_BH service) {
		try {
			MProductCategory_BH productCategory = productCategoryDBService
					.getEntityByIdFromDB(service.getM_Product_Category_ID());
			return new Service(service.getAD_Client_ID(), service.getAD_Org_ID(), service.getM_Product_UU(),
					service.isActive(), DateUtil.parseDateOnly(service.getCreated()), service.getCreatedBy(), service.getName(),
					service.getDescription(), service.getBH_SellPrice(), productCategory.getM_Product_Category_UU());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Service createInstanceWithSearchFields(MProduct_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MProduct_BH getModelInstance() {
		return new MProduct_BH(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
