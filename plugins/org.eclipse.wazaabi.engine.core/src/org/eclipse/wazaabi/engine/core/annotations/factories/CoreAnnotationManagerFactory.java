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

package org.eclipse.wazaabi.engine.core.annotations.factories;

import org.eclipse.wazaabi.engine.core.annotations.managers.AnnotationManager;
import org.eclipse.wazaabi.engine.core.annotations.managers.SetFeatureAnnotationManager;
import org.eclipse.wazaabi.mm.core.annotations.Annotation;

public class CoreAnnotationManagerFactory implements AnnotationManagerFactory {

	public final static String FACTORY_ID = CoreAnnotationManagerFactory.class
			.getName();

	public AnnotationManager createAnnotationManager(Annotation annotation) {
		if (annotation != null
				&& SetFeatureAnnotationManager.SET_FEATURE_ANNOTATION_SOURCE
						.equals(annotation.getSource()))
			return new SetFeatureAnnotationManager(annotation);
		return null;
	}

	@Override
	public String getFactoryID() {
		return FACTORY_ID;
	}

}
