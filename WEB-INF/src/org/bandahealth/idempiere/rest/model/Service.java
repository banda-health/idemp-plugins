package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service")
public class Service extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal sellingPrice;

	public Service(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy, String name,
			String description, BigDecimal sellingPrice) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.sellingPrice = sellingPrice;
	}

	@XmlElement
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
}
