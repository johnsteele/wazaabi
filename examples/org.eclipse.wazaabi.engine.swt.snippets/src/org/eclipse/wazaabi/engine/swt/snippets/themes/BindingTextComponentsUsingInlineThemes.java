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

package org.eclipse.wazaabi.engine.swt.snippets.themes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wazaabi.engine.core.themes.nonosgi.CoreThemesHelper;
import org.eclipse.wazaabi.engine.swt.nonosgi.SWTHelper;
import org.eclipse.wazaabi.engine.swt.viewers.SWTControlViewer;
import org.eclipse.wazaabi.locationpaths.nonosgi.LocationPathsHelper;
import org.eclipse.wazaabi.locator.urn.java.nonosgi.URNJavaLocatorHelper;
import org.eclipse.wazaabi.mm.core.styles.ColorRule;
import org.eclipse.wazaabi.mm.core.styles.CoreStylesFactory;
import org.eclipse.wazaabi.mm.core.themes.Themes.CoreThemesFactory;
import org.eclipse.wazaabi.mm.core.themes.Themes.Theme;
import org.eclipse.wazaabi.mm.core.widgets.Container;
import org.eclipse.wazaabi.mm.core.widgets.CoreWidgetsFactory;
import org.eclipse.wazaabi.mm.core.widgets.Spinner;
import org.eclipse.wazaabi.mm.core.widgets.TextComponent;
import org.eclipse.wazaabi.mm.edp.events.EDPEventsFactory;
import org.eclipse.wazaabi.mm.edp.events.Event;
import org.eclipse.wazaabi.mm.edp.handlers.Binding;
import org.eclipse.wazaabi.mm.edp.handlers.EDPHandlersFactory;
import org.eclipse.wazaabi.mm.edp.handlers.StringParameter;
import org.eclipse.wazaabi.mm.edp.handlers.Validator;
import org.eclipse.wazaabi.mm.swt.styles.GridLayoutRule;
import org.eclipse.wazaabi.mm.swt.styles.SWTStylesFactory;

public class BindingTextComponentsUsingInlineThemes {

	public static void main(String[] args) {


		// create the shell
		Display display = new Display();
		Shell mainShell = new Shell(display, SWT.SHELL_TRIM);
		mainShell.setLayout(new FillLayout());
		mainShell.setSize(300, 300);

		// create the viewer
		SWTControlViewer viewer = new SWTControlViewer(mainShell);

		// init SWT Engine in standalone mode
		SWTHelper.init(viewer);

		// init the 'urn:java' resolver
		URNJavaLocatorHelper.init(viewer);
		LocationPathsHelper.init(viewer);
		CoreThemesHelper.init(viewer);
		
		Container container = CoreWidgetsFactory.eINSTANCE.createContainer();
		container.setAnnotation("http://www.wazaabi.org/core/themes",
				"class", "containerClass1");

		GridLayoutRule layoutRule = SWTStylesFactory.eINSTANCE
				.createGridLayoutRule();
		layoutRule.setPropertyName("layout");
		container.getStyleRules().add(layoutRule);

		layoutRule.setMarginLeft(1);
		layoutRule.setNumColumns(2);

		// create a TextComponent
		TextComponent text0 = CoreWidgetsFactory.eINSTANCE
				.createTextComponent();

		text0.setAnnotation("http://www.wazaabi.org/core/themes",
				"class", "class1");
		text0.setAnnotation("http://www.wazaabi.org/core/themes",
				"variable", "value='../TextComponent[1]/@text'");

		text0.setText("Hello World"); //$NON-NLS-1$

		TextComponent text1 = CoreWidgetsFactory.eINSTANCE
				.createTextComponent();

		Spinner spinner = CoreWidgetsFactory.eINSTANCE.createSpinner();

		TextComponent text2 = CoreWidgetsFactory.eINSTANCE
				.createTextComponent();

		container.getChildren().add(text0);
		container.getChildren().add(text1);
		container.getChildren().add(spinner);
		container.getChildren().add(text2);

		Binding spinnerToText = EDPHandlersFactory.eINSTANCE.createBinding();
		StringParameter source2 = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		StringParameter target2 = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		source2.setName("source");
		source2.setValue("@value");
		target2.setName("target");
		target2.setValue("../TextComponent[2]/@text");
		spinnerToText.getParameters().add(source2);
		spinnerToText.getParameters().add(target2);

		spinner.getHandlers().add(spinnerToText);

		Validator validator = EDPHandlersFactory.eINSTANCE.createValidator();
		validator.setId("bundledIsIntValidator");

		Event event2 = EDPEventsFactory.eINSTANCE.createEvent();
		spinnerToText.getEvents().add(event2);
		spinnerToText.getExecutables().add(validator);
		event2.setId("core:ui:focus:out");

		container.setAnnotation(
				"http://www.wazaabi.org/core/themes", "inline",
				createThemeDeclaration());

		viewer.setContents(container);

		Resource res = new XMIResourceImpl();
		res.getContents().add(container);
		try {
			res.save(System.out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainShell.open();

		while (!mainShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	protected static String createThemeDeclaration() {

		Container themedContainer = CoreWidgetsFactory.eINSTANCE
				.createContainer();
		GridLayoutRule layoutRule = SWTStylesFactory.eINSTANCE
				.createGridLayoutRule();
		layoutRule.setPropertyName("layout");
		themedContainer.getStyleRules().add(layoutRule);
		layoutRule.setMarginTop(50);

		layoutRule.setMarginLeft(50);
		themedContainer.setAnnotation(
				"http://www.wazaabi.org/core/themes", "class",
				"containerClass1");

		TextComponent themedTextComponent = CoreWidgetsFactory.eINSTANCE
				.createTextComponent();

		ColorRule colorRule = CoreStylesFactory.eINSTANCE.createColorRule();
		colorRule.setPropertyName("background-color");
		colorRule.setBlue(20);
		colorRule.setGreen(200);
		colorRule.setRed(100);

		themedTextComponent.getStyleRules().add(colorRule);

		Binding binding = EDPHandlersFactory.eINSTANCE.createBinding();

		StringParameter source = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		StringParameter target = EDPHandlersFactory.eINSTANCE
				.createStringParameter();
		source.setName("source");
		source.setValue("@text");
		target.setName("target");
		target.setValue("${value}");
		binding.getParameters().add(source);
		binding.getParameters().add(target);

		Event event = EDPEventsFactory.eINSTANCE.createEvent();
		event.setId("core:ui:focus:out");
		binding.getEvents().add(event);

		themedTextComponent.getHandlers().add(binding);
		themedTextComponent.setAnnotation(
				"http://www.wazaabi.org/core/themes", "class", "class1");

		Spinner themedSpinner = CoreWidgetsFactory.eINSTANCE.createSpinner();
		ColorRule colorRule2 = CoreStylesFactory.eINSTANCE.createColorRule();
		colorRule2.setPropertyName("background-color");
		colorRule2.setGreen(20);
		colorRule2.setBlue(200);
		colorRule2.setRed(100);
		themedSpinner.getStyleRules().add(colorRule2);
		
		Theme theme = CoreThemesFactory.eINSTANCE.createTheme();
		theme.getChildren().add(themedContainer);
		theme.getChildren().add(themedTextComponent);
		theme.getChildren().add(themedSpinner);

		Resource r0 = new XMIResourceImpl();
		r0.getContents().add(theme);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try {
			r0.save(bout, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			r0.save(System.out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			return new String(bout.toByteArray(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}

		return null;

	}
}
