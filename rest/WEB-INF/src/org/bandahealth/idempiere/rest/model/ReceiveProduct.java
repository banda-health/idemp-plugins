package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "receiveproduct")
@JsonInclude(value = Include.NON_NULL)
public class ReceiveProduct extends Order {

	private static final long serialVersionUID = 1L;

	private Vendor vendor;

	public ReceiveProduct() {
		setIsSalesOrderTransaction(false);
	}

	public ReceiveProduct(MOrder_BH model, MBPartner_BH businessPartner, List<OrderLine> orderLines) {
		super(model, null, orderLines);

		this.vendor = new Vendor(businessPartner);
	}

	@XmlElement
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}
