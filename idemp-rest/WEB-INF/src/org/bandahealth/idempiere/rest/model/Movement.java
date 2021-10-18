package org.bandahealth.idempiere.rest.model;

import java.util.List;

import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.util.Env;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Movement extends BaseMetadata {

	private Warehouse fromWarehouse;
	private Warehouse toWarehouse;
	private String docStatus;
	private String movementDate;
	private String description;
	private User user;

	private List<MovementLine> movementLines;

	public Movement() {
	}

	public Movement(MMovement_BH instance) {
		super(instance);

		if (instance.getBH_FromWarehouseID() > 0) {
			setFromWarehouse(new Warehouse(new MWarehouse_BH(Env.getCtx(), instance.getBH_FromWarehouseID(), null)));
		}

		if (instance.getBH_ToWarehouseID() > 0 ) {
			setToWarehouse(new Warehouse(new MWarehouse_BH(Env.getCtx(), instance.getBH_ToWarehouseID(), null)));
		}

		setDocStatus(instance.getDocStatus());
		setMovementDate(DateUtil.parseDateOnly(instance.getMovementDate()));
		setDescription(instance.getDescription());

		MUser_BH createdBy = new MUser_BH(Env.getCtx(), getCreatedBy(), null);
		if (createdBy != null) {
			setUser(new User(createdBy.getName(), createdBy.getAD_User_UU()));
		}
	}

	public Movement(MMovement_BH instance, List<MovementLine> movementLines) {
		this(instance);

		setMovementLines(movementLines);
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public String getMovementDate() {
		return movementDate;
	}

	public void setMovementDate(String movementDate) {
		this.movementDate = movementDate;
	}

	public List<MovementLine> getMovementLines() {
		return movementLines;
	}

	public void setMovementLines(List<MovementLine> movementLines) {
		this.movementLines = movementLines;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Warehouse getFromWarehouse() {
		return fromWarehouse;
	}

	public void setFromWarehouse(Warehouse fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}

	public Warehouse getToWarehouse() {
		return toWarehouse;
	}

	public void setToWarehouse(Warehouse toWarehouse) {
		this.toWarehouse = toWarehouse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
