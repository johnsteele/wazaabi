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
package org.eclipse.wazaabi.mm.core.widgets;

import org.eclipse.wazaabi.mm.core.Orientation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.wazaabi.mm.core.widgets.Slider#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.wazaabi.mm.core.widgets.CoreWidgetsPackage#getSlider()
 * @model annotation="http://www.wazaabi.org/style/property/definition name='orientation' type='package=http://www.wazaabi.org/core/styles\r\nEClass=OrientationRule' default='value=HORIZONTAL'"
 *        annotation="http://www.wazaabi.org/style/property/definition name='maximum' type='package=http://www.wazaabi.org/core/styles\r\nEClass=IntRule' default='value=100'"
 *        annotation="http://www.wazaabi.org/style/property/definition name='minimum' type='package=http://www.wazaabi.org/core/styles\r\nEClass=IntRule' default='value=0'"
 *        annotation="http://www.wazaabi.org/style/property/definition name='increment' type='package=http://www.wazaabi.org/core/styles\r\nEClass=IntRule' default='value=1'"
 *        annotation="http://www.wazaabi.org/style/property/definition name='pageIncrement' type='package=http://www.wazaabi.org/core/styles\r\nEClass=IntRule' default='value=10'"
 * @generated
 */
public interface Slider extends AbstractComponent {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see org.eclipse.wazaabi.mm.core.widgets.CoreWidgetsPackage#getSlider_Value()
	 * @model
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.wazaabi.mm.core.widgets.Slider#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.OrientationRule rule = (org.eclipse.wazaabi.mm.core.styles.OrientationRule) getFirstStyleRule(\r\n\t\t\"orientation\", //$NON-NLS-1$\r\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.ORIENTATION_RULE);\r\nif (rule != null)\r\n\treturn rule.getValue();\r\nreturn null;'"
	 * @generated
	 */
	Orientation getOrientation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.OrientationRule rule = (org.eclipse.wazaabi.mm.core.styles.OrientationRule) getFirstStyleRule(\r\n\t\t\"orientation\", //$NON-NLS-1$\r\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.ORIENTATION_RULE);\r\nif (rule == null) {\r\n\trule = org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory.eINSTANCE\r\n\t\t\t.createOrientationRule();\r\n\trule.setPropertyName(\"orientation\"); //$NON-NLS-1$\r\n\tgetStyleRules().add(rule);\r\n}\r\nrule.setValue(orientation);'"
	 * @generated
	 */
	void setOrientation(Orientation orientation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\r\n\t\t\"maximum\", //$NON-NLS-1$\r\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\r\nif (rule == null) {\r\n\trule = org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory.eINSTANCE\r\n\t\t\t.createIntRule();\r\n\trule.setPropertyName(\"maximum\"); //$NON-NLS-1$\r\n\tgetStyleRules().add(rule);\r\n}\r\nrule.setValue(maximum);'"
	 * @generated
	 */
	void setMaximum(int maximum);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\r\n\t\t\"maximum\", //$NON-NLS-1$\r\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\r\nif (rule != null)\r\n\treturn rule.getValue();\r\nreturn 100;'"
	 * @generated
	 */
	int getMaximum();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\r\n\t\t\"minimum\", //$NON-NLS-1$\r\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\r\nif (rule == null) {\r\n\trule = org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory.eINSTANCE\r\n\t\t\t.createIntRule();\r\n\trule.setPropertyName(\"minimum\"); //$NON-NLS-1$\r\n\tgetStyleRules().add(rule);\r\n}\r\nrule.setValue(minimum);'"
	 * @generated
	 */
	void setMinimum(int minimum);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\r\n\t\t\"minimum\", //$NON-NLS-1$\r\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\r\nif (rule != null)\r\n\treturn rule.getValue();\r\nreturn 0;'"
	 * @generated
	 */
	int getMinimum();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\n\t\t\"pageIncrement\", //$NON-NLS-1$\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\nif (rule != null)\n\treturn rule.getValue();\nreturn 10;'"
	 * @generated
	 */
	int getPageIncrement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\n\t\t\"pageIncrement\", //$NON-NLS-1$\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\nif (rule == null) {\n\trule = org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory.eINSTANCE\n\t\t\t.createIntRule();\n\trule.setPropertyName(\"pageIncrement\"); //$NON-NLS-1$\n\tgetStyleRules().add(rule);\n}\nrule.setValue(pageIncrement);'"
	 * @generated
	 */
	void setPageIncrement(int pageIncrement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\n\t\t\"pageIncrement\", //$NON-NLS-1$\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\nif (rule != null)\n\treturn rule.getValue();\nreturn 10;'"
	 * @generated
	 */
	int getIncrement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.wazaabi.mm.core.styles.IntRule rule = (org.eclipse.wazaabi.mm.core.styles.IntRule) getFirstStyleRule(\n\t\t\"increment\", //$NON-NLS-1$\n\t\torg.eclipse.wazaabi.mm.core.styles.CoreStylesPackage.Literals.INT_RULE);\nif (rule == null) {\n\trule = org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory.eINSTANCE\n\t\t\t.createIntRule();\n\trule.setPropertyName(\"increment\"); //$NON-NLS-1$\n\tgetStyleRules().add(rule);\n}\nrule.setValue(increment);'"
	 * @generated
	 */
	void setIncrement(int increment);

} // Slider
