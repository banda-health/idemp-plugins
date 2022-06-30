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
import java.util.Properties;

/**
 * @author Chuck Boecking
 * The purpose of this class is to persist population results/responses.
 * It also informs the class implementing MChuBoePopulate what Client it is running in.
 */
public class MChuBoePopulateResponse extends X_ChuBoe_PopulateResponse {
	
	public static final String NOTE_SEPARATOR = "\n";

	public MChuBoePopulateResponse(Properties ctx,
			int ChuBoe_PopulateResponse_ID, String trxName) {
		super(ctx, ChuBoe_PopulateResponse_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MChuBoePopulateResponse(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public void appendNote(String note)
	{
		setNote(getNote() + NOTE_SEPARATOR + note);
	}

}
