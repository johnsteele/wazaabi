/**
 *  Copyright (c) 2008 Olivier Moises
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *    Olivier Moises- initial API and implementation
 */
package org.eclipse.wazaabi.mm.core.styles;

import org.eclipse.wazaabi.mm.core.Orientation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Orientation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.wazaabi.mm.core.styles.OrientationRule#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.wazaabi.mm.core.styles.CoreStylesPackage#getOrientationRule()
 * @model
 * @generated
 */
public interface OrientationRule extends StyleRule {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"HORIZONTAL"</code>.
	 * The literals are from the enumeration {@link org.eclipse.wazaabi.mm.core.Orientation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.wazaabi.mm.core.Orientation
	 * @see #setValue(Orientation)
	 * @see org.eclipse.wazaabi.mm.core.styles.CoreStylesPackage#getOrientationRule_Value()
	 * @model default="HORIZONTAL"
	 * @generated
	 */
	Orientation getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.wazaabi.mm.core.styles.OrientationRule#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see org.eclipse.wazaabi.mm.core.Orientation
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Orientation value);

} // OrientationRule
