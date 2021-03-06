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

package org.eclipse.wazaabi.engine.swt.commons.views.collections;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.wazaabi.engine.core.gef.EditPartViewer;
import org.eclipse.wazaabi.engine.edp.EDPUtils;
import org.eclipse.wazaabi.engine.edp.coderesolution.AbstractCodeDescriptor;

public class DynamicComparatorProvider extends ViewerComparator {

	private AbstractCodeDescriptor.MethodDescriptor getCategoryMethodDescriptor = null;
	private AbstractCodeDescriptor.MethodDescriptor getCompareMethodDescriptor = null;
	private AbstractCodeDescriptor.MethodDescriptor getIsSorterPropertyMethodDescriptor = null;
	private AbstractCodeDescriptor.MethodDescriptor getSortMethodDescriptor = null;
	// TODO : very bad and verbose code
	// we should be able to get the codeDescriptor from the methodDescriptor
	private AbstractCodeDescriptor getCategoryCodeDescriptor = null;
	private AbstractCodeDescriptor getCompareCodeDescriptor = null;
	private AbstractCodeDescriptor getIsSorterPropertyCodeDescriptor = null;
	private AbstractCodeDescriptor getSortCodeDescriptor = null;

	public void updateDynamicProviderURI(String uri,
			EditPartViewer editPartViewer, StructuredViewer viewer) {
		if (uri == null || uri.length() == 0)
			return;
		String baseURI = editPartViewer.getCodeLocatorBaseUri();
		if (baseURI != null && baseURI.length() != 0)
			uri = EDPUtils.normalizeURI(baseURI, uri);
		AbstractCodeDescriptor codeDescriptor = (AbstractCodeDescriptor) editPartViewer
				.createComponent(this, uri, null, AbstractCodeDescriptor.class);
		if (codeDescriptor != null) {
			AbstractCodeDescriptor.MethodDescriptor methodDescriptor = codeDescriptor
					.getMethodDescriptor(
							"category", new String[] { "element" }, new Class[] { Object.class }, int.class); //$NON-NLS-1$ //$NON-NLS-2$
			if (methodDescriptor != null) {
				getCategoryMethodDescriptor = methodDescriptor;
				getCategoryCodeDescriptor = codeDescriptor;
			}
			methodDescriptor = codeDescriptor
					.getMethodDescriptor(
							"compare", new String[] { "element1", "element2" }, new Class[] { Object.class, Object.class }, int.class); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (methodDescriptor != null) {
				getCompareMethodDescriptor = methodDescriptor;
				getCompareCodeDescriptor = codeDescriptor;
			}

			methodDescriptor = codeDescriptor
					.getMethodDescriptor(
							"isSorterProperty", new String[] { "element", "property" }, new Class[] { Object.class, String.class }, boolean.class); //$NON-NLS-1$ //$NON-NLS-2$
			if (methodDescriptor != null) {
				getIsSorterPropertyMethodDescriptor = methodDescriptor;
				getIsSorterPropertyCodeDescriptor = codeDescriptor;
			}
			methodDescriptor = codeDescriptor
					.getMethodDescriptor(
							"sort", new String[] { "elements" }, new Class[] { Object[].class }, null); //$NON-NLS-1$ //$NON-NLS-2$ 
			if (methodDescriptor != null) {
				getSortMethodDescriptor = methodDescriptor;
				getSortCodeDescriptor = codeDescriptor;
			}
		}
	}

	@Override
	public int category(Object element) {
		if (getCategoryMethodDescriptor != null
				&& getCategoryCodeDescriptor != null)
			return (Integer) getCategoryCodeDescriptor.invokeMethod(
					getCategoryMethodDescriptor, new Object[] { element });
		return super.category(element);
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (getCompareMethodDescriptor != null
				&& getCompareCodeDescriptor != null)
			return (Integer) getCompareCodeDescriptor.invokeMethod(
					getCompareMethodDescriptor, new Object[] { e1, e2 });
		return super.compare(viewer, e1, e2);
	}

	@Override
	public boolean isSorterProperty(Object element, String property) {
		if (getIsSorterPropertyMethodDescriptor != null
				&& getIsSorterPropertyCodeDescriptor != null)
			return (Boolean) getIsSorterPropertyCodeDescriptor.invokeMethod(
					getIsSorterPropertyMethodDescriptor, new Object[] {
							element, property });
		return super.isSorterProperty(element, property);
	}

	@Override
	public void sort(Viewer viewer, Object[] elements) {
		if (getSortMethodDescriptor != null && getSortCodeDescriptor != null)
			getSortCodeDescriptor.invokeMethod(getSortMethodDescriptor,
					new Object[] { elements });
		else
			super.sort(viewer, elements);
	}

}
