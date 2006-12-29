/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: JavaResourceImpl.java,v 1.3 2006/12/29 18:27:41 marcelop Exp $
 */
package org.eclipse.emf.java.util;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.java.JCompilationUnit;
import org.eclipse.emf.java.JavaFactory;


/**
 */
public class JavaResourceImpl extends ResourceImpl 
{
  /**
   * The factory used to create JDOM.
   */
  @SuppressWarnings("deprecation")
  protected static org.eclipse.jdt.core.jdom.DOMFactory jdomFactory = new org.eclipse.jdt.core.jdom.DOMFactory();

  public JavaResourceImpl(URI uri)
  {
    super(uri);
  }

  @Override
  protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException
  {
    try
    {
      BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
      byte [] input = new byte [bufferedInputStream.available()];
      bufferedInputStream.read(input);
      bufferedInputStream.close();
      @SuppressWarnings("deprecation")
      org.eclipse.jdt.core.jdom.IDOMCompilationUnit jdomCompilationUnit = jdomFactory.createCompilationUnit(new String(input), uri.lastSegment());
      JCompilationUnit jCompilationUnit = JavaFactory.eINSTANCE.createJCompilationUnit();
      getContents().add(jCompilationUnit);
      jCompilationUnit.setJNode(jdomCompilationUnit);
      // jCompilationUnit.resolveIdentifiers();
    }
    catch (IOException exception)
    {
      exception.printStackTrace();
    }
  }

  @Override
  protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException
  {
    throw new UnsupportedOperationException();
  }
}
