/**********************************************************************
* This file is part of iDempiere ERP Open Source and ERP Academy      *
* http://www.idempiere.org                                            *
* http://www.chuckboecking.com                                        *
*                                                                     *
* Copyright (C) Contributors                                          *
*                                                                     *
* This program is provided to current and former participants of      *
* ERP Academy (erp-academy.chuckboecking.com). Once you have joined   *
* the ERP Academy, you may use and modify it under the terms of       *
* the GNU General Public License as published by the Free Software    *
* Foundation; either version 2 of the License, or (at your option)    *
* any later version.                                                  *
*                                                                     *
* This program is distributed in the hope that it will be useful,     *
* but WITHOUT ANY WARRANTY; without even the implied warranty of      *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
* GNU General Public License for more details.                        *
*                                                                     *
* You should have received a copy of the GNU General Public License   *
* along with this program; if not, write to the Free Software         *
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
* MA 02110-1301, USA.                                                 *
*                                                                     *
* Contributors:                                                       *
* - Chuck Boecking                                                    *
**********************************************************************/

package com.chuboe.test.model;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

public class MyModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (tableName.equals(MChuBoePopulateResponse.Table_Name))
			return MChuBoePopulateResponse.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (tableName.equals(MChuBoePopulateResponse.Table_Name))
			return new MChuBoePopulateResponse(Env.getCtx(), Record_ID, trxName);
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (tableName.equals(MChuBoePopulateResponse.Table_Name))
			return new MChuBoePopulateResponse(Env.getCtx(), rs, trxName);
		return null;
	}

}
