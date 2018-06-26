/**
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */
package org.eclipse.emf.edit.provider.resource;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.Disposable;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;


/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * @generated
 */
public class ResourceItemProviderAdapterFactory 
  extends AdapterFactoryImpl 
  implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
  protected static Package resourcePackage = Resource.class.getPackage();

  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IDisposable}.
   */
  protected Disposable disposable = new Disposable();

  /**
   * This constructs an instance.
   * @generated
   */
  public ResourceItemProviderAdapterFactory()
  {
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemPropertySource.class);
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(ITableItemLabelProvider.class);
  }

  @Override
  public Adapter createAdapter(Notifier target)
  {
    if (target instanceof Resource)
    {
      return createResourceAdapter();
    }
    else
    {
      return createResourceSetAdapter();
    }
  }

  /**
   * This creates an adapter for a {@link org.eclipse.emf.ecore.resource.Resource}.
   * @generated
   */
  public Adapter createResourceAdapter()
  {
    return new ResourceItemProvider(this);
  }

  /**
   * This creates an adapter for a {@link org.eclipse.emf.ecore.resource.ResourceSet}.
   * @generated
   */
  public Adapter createResourceSetAdapter()
  {
    return new ResourceSetItemProvider(this);
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory()
  {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * @generated
   */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
  {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type)
  {
    return type == resourcePackage || type instanceof Resource || type instanceof ResourceSet || supportedTypes.contains(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter.
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type)
  {
    synchronized (notifier)
    {
      return super.adapt(notifier, this);
    }
  }

  /**
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type)
  {
    // This is a kludge to deal with enumerators, which crash the doSwitch.
    //
    if (object instanceof EObject && ((EObject)object).eClass() == null)
    {
      return null;
    }

    if (isFactoryForType(type))
    {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
      {
        return adapter;
      }
    }

    return null;
  }

  /**
   * This adds a listener.
   * @generated
   */
  public void addListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * @generated
   */
  public void fireNotifyChanged(Notification notification)
  {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null)
    {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  @Override
  protected void associate(Adapter adapter, Notifier target)
  {
    super.associate(adapter, target);
    if (adapter instanceof IDisposable)
    {
      disposable.add(adapter);
    }
  }
  
  public void dispose()
  {
    disposable.dispose();
  }
}
