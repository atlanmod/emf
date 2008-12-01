/**
 * <copyright>
 * </copyright>
 *
 * $Id: Cafeteria.java,v 1.1 2006/02/08 21:30:38 marcelop Exp $
 */
package lib;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cafeteria</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link lib.Cafeteria#getName <em>Name</em>}</li>
 *   <li>{@link lib.Cafeteria#getLibrary <em>Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see lib.LibPackage#getCafeteria()
 * @model
 * @generated
 */
public interface Cafeteria extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see lib.LibPackage#getCafeteria_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link lib.Cafeteria#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Library</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link lib.Library#getCafeteria <em>Cafeteria</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Library</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Library</em>' container reference.
   * @see #setLibrary(Library)
   * @see lib.LibPackage#getCafeteria_Library()
   * @see lib.Library#getCafeteria
   * @model opposite="cafeteria" required="true"
   * @generated
   */
  Library getLibrary();

  /**
   * Sets the value of the '{@link lib.Cafeteria#getLibrary <em>Library</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Library</em>' container reference.
   * @see #getLibrary()
   * @generated
   */
  void setLibrary(Library value);

} // Cafeteria