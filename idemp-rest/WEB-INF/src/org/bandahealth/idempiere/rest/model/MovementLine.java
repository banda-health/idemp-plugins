package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.compiere.model.MProduct;
import org.compiere.util.Env;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class MovementLine extends BaseEntity {

	private BigDecimal movementQuantity;
	private Product product;
	private int movementId;

	public MovementLine() {
	}

	public MovementLine(MMovementLine_BH entity) {
		super(entity, null, entity.getDescription(), entity.getValue());

		MProduct mProduct = entity.getProduct();
		setProduct(new Product(mProduct.getName(), mProduct.getM_Product_UU(), mProduct.getProductType(),
				new MProduct_BH(Env.getCtx(), mProduct.get_ID(), null)));

		setMovementId(entity.getM_Movement_ID());

		setMovementQuantity(entity.getMovementQty());
	}

	public BigDecimal getMovementQuantity() {
		return movementQuantity;
	}

	public void setMovementQuantity(BigDecimal movementQuantity) {
		this.movementQuantity = movementQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getMovementId() {
		return movementId;
	}

	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}
}
