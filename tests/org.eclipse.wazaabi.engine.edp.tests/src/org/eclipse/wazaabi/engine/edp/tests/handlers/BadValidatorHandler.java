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

import org.eclipse.wazaabi.engine.edp.exceptions.OperationAborted;


public class BadValidatorHandler {
	
	boolean disposed = true;

	public BadValidatorHandler() {
		System.out.println("creating " + getClass().getName());
		disposed = false;
	}

	public boolean isValid(int a, int b) {
		System.out.println("validation ongoing");
		throw new OperationAborted("This is not valid");
	}

	public void dispose() {
		System.out.println("disposing " + getClass().getName());
		disposed = true;
	}
	
	public boolean isDisposed() {
		return disposed;
	}
}
