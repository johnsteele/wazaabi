/*******************************************************************************
 * Copyright (c) 2008 Olivier Moises
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Olivier Moises- initial API and implementation
 *******************************************************************************/

package org.eclipse.wazaabi.engine.swt.snippets.converters;

public class Int2StringConverter {

	public Int2StringConverter() {
		System.out.println("creating " + getClass().getName());
	}

	public String convert(Integer input) {
		System.out.println("Int2String converter executed");
		System.out.println(input.getClass());
		return Integer.toString(input);
		
	}

	public void dispose() {
		System.out.println("disposing " + getClass().getName());
	}
}
