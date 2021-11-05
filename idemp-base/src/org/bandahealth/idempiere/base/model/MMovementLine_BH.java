package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MMovement;
import org.compiere.model.MMovementLine;

public class MMovementLine_BH extends MMovementLine {

	public MMovementLine_BH(MMovement parent) {
		super(parent);
	}

	public MMovementLine_BH(Properties context, int movementLineID, String transactionName) {
		super(context, movementLineID, transactionName);
	}

	public MMovementLine_BH(Properties context, ResultSet resultSet, String transactionName) {
		super(context, resultSet, transactionName);
	}

}
