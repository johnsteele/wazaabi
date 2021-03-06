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
import org.eclipse.wazaabi.engine.edp.Identifiable;
import org.eclipse.wazaabi.mm.core.annotations.Annotation;

public interface AnnotationManagerFactory extends Identifiable{

	/**
	 * Returns the AnnotationManager corresponding to the given host. The host
	 * is given as a parameter instead of the model's annotation because
	 * sometimes the lack of annotations itself is an usable information.
	 * 
	 * @param host
	 * @return
	 */
	public AnnotationManager createAnnotationManager(Annotation annotation);

}
