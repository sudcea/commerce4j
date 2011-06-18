/**
 * Copyright 2010 Commerce4J.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.commerce4j.storefront.test;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.commerce4j.model.dao.jdbc.HelpDAOImpl;
import com.commerce4j.model.dto.HelpDTO;

/**
 *
 * @author Ignatiues
 */
public class HelpDaoImplTest extends AbstractSpringDaoTest
	{

		private HelpDAOImpl helpDaoImpl;

		public HelpDaoImplTest()
			{
				ApplicationContext ac = null;
				try
					{
						ac = new ClassPathXmlApplicationContext(
								"applicationContextTest.xml");
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				helpDaoImpl = (HelpDAOImpl) ac.getBean("HelpDaoImpl");

			}

		/**
		 * @return the helpDaoImpl
		 */
		public HelpDAOImpl getHelpDaoImpl()
			{
				return helpDaoImpl;
			}

		/**
		 * @param helpDaoImpl
		 *            the helpDaoImpl to set
		 */
		public void setHelpDaoImpl(HelpDAOImpl helpDaoImpl)
			{
				this.helpDaoImpl = helpDaoImpl;
			}

		@Test
		public void testAddHelp()
			{


				org.junit.Assert.assertEquals(
						true,
						helpDaoImpl
								.insertHelp(
										10,
										"Cmo puedo recibir?",
										"usted puede recibir su compra de artculos que se paga por paypal, antes de que finalice el da comprado."));
				HelpDTO help = helpDaoImpl.findById(10);
				org.junit.Assert.assertEquals("Cmo puedo recibir?", help.getQuestion());
			}

		@Test
		public void testGetAllFaq()
			{
				helpDaoImpl
						.insertHelp(
								1,
								"Cómo proteger su privacidad en línea?",
								"Nunca des tu contraseña a nadie en línea. Realiza tus contraseñas de al menos ocho caracteres de longitud y un máximo de 20. Crear una contraseña que incluye una combinación de números y letras. Si han caído en una estafa en línea y dio a conocer su contraseña, cambiar su contraseña de inmediato. Usted puede hacer esto entrando en la sección \"Mi cuenta\" y modificar la información de usuario. Una vez que haya terminado de navegar a través commerce4j, no deje el sitio Web abierto. La única manera de cerrar la sesión en el sitio es para cerrar la ventana.");

				helpDaoImpl
						.insertHelp(
								3,
								"Cómo commerce4j cuidar de su privacidad?",
								"Estamos comprometidos a proteger su privacidad personal. commerce4j no dar a conocer su número de teléfono o dirección de correo electrónico, excepto cuando sea necesario para entregar un producto o servicio a su solicitud. No vamos a dar a conocer su número de tarjeta de crédito o cualquier información de la cuenta a menos que usted lo autorice, por ejemplo, procesar un pago con tarjeta de crédito. En otras palabras, no vamos a alquilar o vender su nombre, dirección, dirección de correo electrónico, información de tarjeta de crédito o detalles personales a ninguna tercera parte sin su permiso. Esta información se recoge, fundamentalmente, que somos capaces de satisfacer sus necesidades y para ofrecer una experiencia de compra verdaderamente personalizada. Sin embargo, debemos cooperar plenamente, debería surgir una situación, donde se nos requiere por ley o por obligación legal o proceso legal para proporcionar información sobre un cliente. Si usted ha comprado de nuestra tienda o suscrito a uno de nuestros boletines de noticias, de vez en cuando puede actualizar a través de e-mail de la llegada de nuevos productos especiales, características o sistemas de nuestro sitio.");

				helpDaoImpl
						.insertHelp(
								2,
								"¿Cómo inscribirse?",
								"Antes de comenzar a comprar, tiene que darse de alta con nosotros y nos dan la información que nos permitirá comunicarnos con usted acerca de sus transacciones. El registro es muy fácil con commerce4j. Tres de nuestras secciones es decir, la cesta de compra, lista de la compra y Mi cuenta están protegidos por contraseña. Al hacer clic en cualquiera de estos enlaces se llega a una página de acceso. Un nuevo usuario puede registrarse aquí o los miembros pueden acceder a su cuenta directamente.");

				List<HelpDTO> faqs = helpDaoImpl.findAllFaqs();

				sortByProperty(faqs, "question_id");

				// assertions
				org.junit.Assert.assertEquals("All faqs returned", 3, faqs.size());
				HelpDTO helpDto1 = (HelpDTO) faqs.get(0);
				org.junit.Assert.assertEquals("Cómo proteger su privacidad en línea?", helpDto1
						.getQuestion());
				HelpDTO helpDto2 = (HelpDTO) faqs.get(1);
				org.junit.Assert.assertEquals("¿Cómo inscribirse?", helpDto2.getQuestion());
				HelpDTO helpDto3 = (HelpDTO) faqs.get(2);
				org.junit.Assert.assertEquals("Cómo commerce4j cuidar de su privacidad?",
						helpDto3.getQuestion());
			}

		// ========================================= Helper Methods
		// =================================================

		private void sortByProperty(List list, String propertyName)
			{
				Collections
						.sort(list, new BeanPropertyComparator(propertyName));
			}

		private class BeanPropertyComparator implements Comparator
			{

				private String propertyName;

				private Comparator comparator;

				public BeanPropertyComparator(String propertyName)
					{
						this(propertyName, null);
					}

				public BeanPropertyComparator(String propertyName,
						Comparator comparator)
					{
						this.propertyName = propertyName;
						this.comparator = comparator;
					}

				public int compare(Object o1, Object o2)
					{

						BeanWrapper wrapper1 = new BeanWrapperImpl(o1);
						Object value1 = wrapper1.getPropertyValue(propertyName);

						BeanWrapper wrapper2 = new BeanWrapperImpl(o2);
						Object value2 = wrapper2.getPropertyValue(propertyName);

						if (comparator != null)
							{
								return comparator.compare(value1, value2);
							}

						if ((value1 instanceof Comparable)
								&& (value2 instanceof Comparable))
							{
								return ((Comparable) value1).compareTo(value2);
							}

						// if the two values are not comparable then trying to
						// compare their
						// string representations.
						String str1;
						String str2;
						PropertyEditor editor = PropertyEditorManager
								.findEditor(wrapper1
										.getPropertyType(propertyName));
						if (editor != null)
							{
								editor.setValue(value1);
								str1 = editor.getAsText();
								editor.setValue(value2);
								str2 = editor.getAsText();
							} else
							{
								str1 = String.valueOf(value1);
								str2 = String.valueOf(value2);
							}
						return str1.compareTo(str2);

					}
			}

	}
