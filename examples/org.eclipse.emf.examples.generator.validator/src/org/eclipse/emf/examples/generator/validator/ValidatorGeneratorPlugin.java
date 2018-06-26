/**
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 */
package org.eclipse.emf.examples.generator.validator;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;


/**
 * The <b>Plugin</b> for the Validator Generator Extension plug-in.
 */
public final class ValidatorGeneratorPlugin extends EMFPlugin
{
  /**
   * The singleton instance of the plugin.
   */
  public static final ValidatorGeneratorPlugin INSTANCE = new ValidatorGeneratorPlugin();

  /**
   * The one instance of this class.
   */
  private static Implementation plugin;

  public static final String ID = "org.eclipse.emf.examples.generator.validator";

  /**
   * Creates the singleton instance.
   */
  private ValidatorGeneratorPlugin()
  {
    super(new ResourceLocator [] { });
  }

  /*
   * Javadoc copied from base class.
   */
  @Override
  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * @return the singleton instance.
   */
  public static Implementation getPlugin()
  {
    return plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   */
  public static class Implementation extends EclipsePlugin
  {
    /**
     * Creates an instance.
     */
    public Implementation()
    {
      super();

      // Remember the static instance.
      //
      plugin = this;
    }
  }
}
