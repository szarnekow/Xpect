/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.parameter;

import org.xpect.state.StateContainer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ParameterProvider implements IParameterProvider {

	private Object value;

	public ParameterProvider(Object value) {
		super();
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType, StateContainer context) {
		if (expectedType.isInstance(value))
			return (T) value;
		return null;
	}

	public boolean canProvide(Class<?> expectedType) {
		return expectedType.isInstance(value);
	}

}
