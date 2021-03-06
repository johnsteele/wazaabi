/*******************************************************************************
 * Copyright (c) 2013 Olivier Moises
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Olivier Moises- initial API and implementation
 *******************************************************************************/

package org.eclipse.wazaabi.engine.swt.viewers;

import org.eclipse.swt.widgets.Control;
import org.eclipse.wazaabi.engine.swt.commons.viewers.AbstractCompatibilityToolkit;
import org.eclipse.wazaabi.engine.swt.commons.views.AbstractControlDecoration;

public class SWTCompatibilityToolkit extends AbstractCompatibilityToolkit {

	@Override
	public AbstractControlDecoration createControlDecoration(Control control,
			int position) {
		return new AbstractControlDecoration(control, position) {

			@Override
			public void updateDecoration() {
				super.update();
			}
		};
	}

	@Override
	public int getSWT_RIGHT_TO_LEFT_Value() {
		return org.eclipse.swt.SWT.RIGHT_TO_LEFT;
	}

}
