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

package com.chuboe.test.populate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface IPopulateAnnotation {
	
	@Target(value = ElementType.METHOD)
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface CanRun {
	} 
	
	@Target(value = ElementType.METHOD)
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface CanRunBefore {
	} 

	@Target(value = ElementType.METHOD)
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface CanRunAfter {
	} 
	
	@Target(value = ElementType.METHOD)
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface CanRunBeforeClass {
	} 
	
	@Target(value = ElementType.METHOD)
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface CanRunAfterClass {
	} 

	@Target(value = ElementType.METHOD)
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface Skip {
	} 
}
