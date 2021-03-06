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

package org.eclipse.wazaabi.engine.edp.tests.handlers;


public class BasicConditionHandler {
	
	boolean disposed = true;

	public BasicConditionHandler() {
		System.out.println("creating " + getClass().getName());
		disposed = false;
	}

	public boolean canExecute(int a, int b) {
		System.out.println("condition checking");
		if (a == b)
			return true;
		else
			return false;
	}

	public void dispose() {
		System.out.println("disposing " + getClass().getName());
		disposed = true;
	}
	
	public boolean isDisposed() {
		return disposed;
	}
}
