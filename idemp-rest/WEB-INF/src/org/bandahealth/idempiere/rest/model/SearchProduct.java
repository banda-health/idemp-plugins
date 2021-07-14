package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "searchproduct")
@JsonInclude(value = Include.NON_NULL)
public class SearchProduct extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private BigDecimal price;
	private BigDecimal totalQuantity;
	private List<SearchProductAttribute> attributes;

	public SearchProduct() {
	}

	public SearchProduct(String name, String type, BigDecimal price, BigDecimal totalQuantity,
			List<SearchProductAttribute> attributes) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.totalQuantity = totalQuantity;
		this.attributes = attributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(BigDecimal totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public List<SearchProductAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<SearchProductAttribute> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(SearchProductAttribute attribute) {
		if (attributes == null) {
			attributes = new ArrayList<>();
		}

		this.attributes.add(attribute);
	}

}
