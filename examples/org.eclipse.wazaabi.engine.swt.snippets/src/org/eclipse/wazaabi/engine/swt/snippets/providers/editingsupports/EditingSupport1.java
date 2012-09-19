/*******************************************************************************
 * Copyright (c) 2012 Olivier Moises
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Olivier Moises- initial API and implementation
 *******************************************************************************/

package org.eclipse.wazaabi.engine.swt.snippets.providers.editingsupports;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.wazaabi.mm.core.styles.collections.ColumnDescriptor;

public class EditingSupport1 {

	// if not present, returns always true
	// column Descriptor is optional
	public Boolean canEdit(Object element, ColumnDescriptor columnDescriptor) {
		return true;
	}

	// returns the value passed to the cell editor for a given element
	public Object getValue(Object element, ColumnDescriptor columnDescriptor) {
		if (element instanceof ENamedElement) {
			return ((ENamedElement) element).getName();
		}
		return "";
	}

	//
	public void setValue(Object element, Object value,
			ColumnDescriptor columnDescriptor) {
		if (element instanceof ENamedElement && value instanceof String) {
			((ENamedElement) element).setName((String) value);
		}
	}

}
