package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;

/**
 * Representation of iDempiere's MOrderLineItem (C_Order_line).
 *
 * @author andrew
 */
@XmlRootElement(name = "orderline")
@JsonInclude(value = Include.NON_NULL)
public class OrderLine extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private ExpenseCategory expenseCategory;
	@JsonIgnore
	private Integer orderId;
	@JsonIgnore
	private Integer productId;
	private Product product;
	private BigDecimal price;
	private BigDecimal quantity;
	private BigDecimal lineNetAmount;
	private String instructions;
	@JsonIgnore
	private int chargeId;
	private Charge charge;
	private List<OrderLineChargeInformation> chargeInformationList = new ArrayList<>();
	private String description;
	@JsonIgnore
	private MOrder_BH order;
	@JsonIgnore
	private Integer attributeSetInstanceId;
	private AttributeSetInstance attributeSetInstance;

	public OrderLine() {
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Integer orderId, Product product, BigDecimal price, BigDecimal quantity, BigDecimal lineNetAmount,
			String instructions, MOrderLine_BH entity) {
		super(entity);

		this.orderId = orderId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.lineNetAmount = lineNetAmount;
		this.instructions = instructions;
		setChargeId(entity.getC_Charge_ID());
		setDescription(entity.getDescription());
		this.attributeSetInstanceId = entity.getM_AttributeSetInstance_ID();
		setProductId(entity.getM_Product_ID());
	}

	public OrderLine(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			ExpenseCategory expenseCategory, Integer orderId, BigDecimal price, BigDecimal quantity,
			BigDecimal lineNetAmount, MOrderLine_BH entity) {
		super(entity);

		this.expenseCategory = expenseCategory;
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
		this.lineNetAmount = lineNetAmount;
		setChargeId(entity.getC_Charge_ID());
		setDescription(entity.getDescription());
		this.attributeSetInstanceId = entity.getM_AttributeSetInstance_ID();
		setProductId(entity.getM_Product_ID());
	}

	@XmlElement
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(ExpenseCategory charge) {
		this.expenseCategory = charge;
	}

	@XmlElement
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@XmlElement
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@XmlElement
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@XmlElement
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@XmlElement
	public BigDecimal getLineNetAmount() {
		return lineNetAmount;
	}

	public void setLineNetAmount(BigDecimal lineNetAmount) {
		this.lineNetAmount = lineNetAmount;
	}

	@XmlElement
	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	@XmlElement
	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public List<OrderLineChargeInformation> getChargeInformationList() {
		return chargeInformationList;
	}

	public void setChargeInformationList(List<OrderLineChargeInformation> chargeInformationList) {
		this.chargeInformationList = chargeInformationList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MOrder_BH getOrder() {
		return order;
	}

	public void setOrder(MOrder_BH order) {
		this.order = order;
	}

	public AttributeSetInstance getAttributeSetInstance() {
		return attributeSetInstance;
	}

	public void setAttributeSetInstance(AttributeSetInstance attributeSetInstance) {
		this.attributeSetInstance = attributeSetInstance;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
