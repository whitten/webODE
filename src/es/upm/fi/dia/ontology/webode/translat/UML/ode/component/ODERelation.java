package es.upm.fi.dia.ontology.webode.translat.UML.ode.component;

/**
 * <p>Title: Sistema de Importaci�n y Exportaci�n de Ontolog�as a UML</p>
 * <p>Description: Trabajo Fin de Carrera</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Laboratorio de Inteligencia Artificial - Grupo de Ontolog�as</p>
 * @author Miguel Esteban Guti�rrez
 * @version 1.0
 */

public interface ODERelation extends ODEComponent {

  //----------------------------------------------------------------------------
  //-- Common bussiness logic --------------------------------------------------
  //----------------------------------------------------------------------------

  //-- Basic info management ---------------------------------------------------

  public String getActualName();
  public void   setActualName(String actualName);

}