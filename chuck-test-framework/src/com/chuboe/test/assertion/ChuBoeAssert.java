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

package com.chuboe.test.assertion;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.compiere.util.CLogger;
import org.compiere.util.DB;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*; 

public class ChuBoeAssert {
	private static final CLogger logger = CLogger.getCLogger(ChuBoeAssert.class);
	
	public static void executeSQLAsserts(List<String> assertionSQL, Properties ctx, String trx) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String response = "";
		for (String sql : assertionSQL) {
			try {
				//the below line uses a null transaction so that if an error happens, subsequent queries can execute without exception.
				ps = DB.prepareStatement(sql, null);
				rs = ps.executeQuery();
				while(rs.next()) {
					response = rs.getBoolean(2) 
							+ " - " 
							+ rs.getString(1) 
							+ ((!rs.getBoolean(2)) ? " - " + sql : "") //add sql in case of fail
							; 
				}
			} catch (SQLException e) {
				StringWriter stringWriter = new StringWriter();
				PrintWriter printWriter = new PrintWriter(stringWriter);
				e.printStackTrace(printWriter);
				logger.severe(stringWriter.toString());
			} finally {
				DB.close(rs, ps);
				rs = null; ps = null;
				//this line confirms a result was created - note: an exception will cause response to be ""
				assertThat("The following SQL did not throw an Exception. Look in logs for the exception if you see this failure: " + sql,
						response.length()>0);
				//this line confirms the result is actually true
				assertThat(sql, response.substring(0, 4), equalTo("true"));
				response = "";
			}
		}
	}


}
