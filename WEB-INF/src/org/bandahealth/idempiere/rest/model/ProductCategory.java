package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

@JsonInclude(value = Include.NON_NULL)
public class ProductCategory extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String productCategoryType;
	private Integer id;

	public ProductCategory(MProductCategory_BH entity) {
		setId(entity.getM_Product_Category_ID());
		setUuid(entity.getM_Product_Category_UU());
		setName(entity.getName());
		setCreated(DateUtil.parseDateOnly(entity.getCreated()));
		setIsActive(entity.isActive());
		setProductCategoryType(entity.getBH_Product_Category_Type());
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getProductCategoryType() {
		return productCategoryType;
	}

	public void setProductCategoryType(String productCategoryType) {
		this.productCategoryType = productCategoryType;
	}
}
