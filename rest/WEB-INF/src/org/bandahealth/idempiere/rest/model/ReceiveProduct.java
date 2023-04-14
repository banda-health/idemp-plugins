package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;

@XmlRootElement(name = "receiveproduct")
@JsonInclude(value = Include.NON_NULL)
public class ReceiveProduct extends Order {

	private static final long serialVersionUID = 1L;

	private Vendor vendor;

	public ReceiveProduct() {
		setIsSalesOrderTransaction(false);
	}

	public ReceiveProduct(MOrder_BH model, MBPartner_BH businessPartner, List<OrderLine> orderLines) {
		super(model, null, orderLines, null);

		this.vendor = new Vendor(businessPartner);
	}

	public ReceiveProduct(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Vendor vendor, String dateOrdered, List<OrderLine> orderLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, false, orderLines, docStatus);

		this.vendor = vendor;
	}

	public ReceiveProduct(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Vendor vendor, String dateOrdered, String docStatus, BigDecimal grandTotal) {
		super(clientId, orgId, uuid, isActive, created, createdBy, null, dateOrdered, false, docStatus, grandTotal);

		this.vendor = vendor;
	}

	@XmlElement
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}
