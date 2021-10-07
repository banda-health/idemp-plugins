package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MMovement;

public class MMovement_BH extends MMovement {

	public MMovement_BH(Properties context, int cOrderId, String transactionName) {
		super(context, cOrderId, transactionName);
	}

	public MMovement_BH(Properties contex, ResultSet resultSet, String transactionName) {
		super(contex, resultSet, transactionName);
	}
}
