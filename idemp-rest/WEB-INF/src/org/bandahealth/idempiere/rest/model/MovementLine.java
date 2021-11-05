package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import org.bandahealth.idempiere.base.model.MMovementLine_BH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class MovementLine extends BaseEntity {

	private BigDecimal movementQuantity;
	private Product product;
	private String movementUuid;

	public MovementLine() {
	}

	public MovementLine(MMovementLine_BH entity) {
		super(entity, null, entity.getDescription(), entity.getValue());

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

	public String getMovementUuid() {
		return movementUuid;
	}

	public void setMovementId(String movementUuid) {
		this.movementUuid = movementUuid;
	}
}
