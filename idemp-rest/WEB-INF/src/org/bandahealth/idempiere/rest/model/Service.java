package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "service")
@JsonInclude(value = Include.NON_NULL)
public class Service extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal sellingPrice;
	private String productCategoryUuid;

	public Service() {
	}

	public Service(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description, BigDecimal sellingPrice, String productCategoryUuid) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.sellingPrice = sellingPrice;
		this.setProductCategoryUuid(productCategoryUuid);
	}

	@XmlElement
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getProductCategoryUuid() {
		return productCategoryUuid;
	}

	public void setProductCategoryUuid(String productCategoryUuid) {
		this.productCategoryUuid = productCategoryUuid;
	}
}
