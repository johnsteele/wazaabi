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

package org.eclipse.wazaabi.engine.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wazaabi.engine.core.editparts.TextComponentEditPart;
import org.eclipse.wazaabi.engine.swt.nonosgi.SWTHelper;
import org.eclipse.wazaabi.engine.swt.viewers.SWTControlViewer;
import org.eclipse.wazaabi.mm.core.styles.BooleanRule;
import org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory;
import org.eclipse.wazaabi.mm.core.widgets.Container;
import org.eclipse.wazaabi.mm.core.widgets.CoreWidgetsFactory;
import org.eclipse.wazaabi.mm.core.widgets.TextComponent;
import org.eclipse.wazaabi.mm.swt.styles.RowLayoutRule;
import org.eclipse.wazaabi.mm.swt.styles.SWTStylesFactory;

public class TextComponentInAContainer {

	public static void main(String[] args) {

		// init SWT Engine in standalone mode
		SWTHelper.init();

		// create the shell
		Display display = new Display();
		Shell mainShell = new Shell(display, SWT.SHELL_TRIM);
		mainShell.setLayout(new FillLayout());
		mainShell.setSize(300, 300);

		// create the viewer
		SWTControlViewer viewer = new SWTControlViewer(mainShell);

		// create a container and set its layout
		Container container = CoreWidgetsFactory.eINSTANCE.createContainer();
		RowLayoutRule layoutRule = SWTStylesFactory.eINSTANCE
				.createRowLayoutRule();
		layoutRule.setPropertyName("layout");
		container.getStyleRules().add(layoutRule);

		TextComponent text = CoreWidgetsFactory.eINSTANCE.createTextComponent();
		text.setText("Hello World"); //$NON-NLS-1$
		container.getChildren().add(text);
		
//		BooleanRule readonly = CoreStylesFactory.eINSTANCE.createBooleanRule();
//		readonly.setValue(true);
//		readonly.setPropertyName(TextComponentEditPart.READ_ONLY_PROPERTY_NAME);
//		text.getStyleRules().add(readonly);
		
//		StringRule echoChar = CoreStylesFactory.eINSTANCE.createStringRule();
//		echoChar.setPropertyName(TextComponentEditPart.ECHO_CHAR_PROPERTY_NAME);
//		echoChar.setValue("T");
//		text.getStyleRules().add(echoChar);
		
		BooleanRule wrap = CoreStylesFactory.eINSTANCE.createBooleanRule();
		wrap.setPropertyName(TextComponentEditPart.WRAP_PROPERTY_NAME);
		wrap.setValue(true);
		text.getStyleRules().add(wrap);
		
		BooleanRule multi = CoreStylesFactory.eINSTANCE.createBooleanRule();
		multi.setPropertyName(TextComponentEditPart.MULTI_LINE_PROPERTY_NAME);
		multi.setValue(true);
		text.getStyleRules().add(multi);
		
		// inject the container into the viewer
		viewer.setContents(container);
		
		


		mainShell.open();

		while (!mainShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}