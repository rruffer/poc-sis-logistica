/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 *
 * @author jcarlos
 */
public class DetectClass {

	@SuppressWarnings("rawtypes")
	public static Class getEntityClass(Class classe) {
		Type type = classe.getGenericSuperclass();

		if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) type;
			return (Class) paramType.getActualTypeArguments()[0];
		} else {
			type = classe.getSuperclass().getGenericSuperclass();
			ParameterizedType paramType = (ParameterizedType) type;
			if (paramType.getActualTypeArguments().length == 2) {
				// likely dealing with -> new
				// EntityHome<Person>().getEntityClass()
				if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
					throw new IllegalArgumentException("Could not guess entity class by reflection");
				} // likely dealing with -> new Home<EntityManager, Person>() {
					// ... }.getEntityClass()
				else {
					return (Class) paramType.getActualTypeArguments()[0];
				}
			} else {
				// likely dealing with -> new PersonHome().getEntityClass()
				// where PersonHome extends EntityHome<Person>
				return (Class) paramType.getActualTypeArguments()[0];
			}
		}
	}

	private DetectClass() {

	}
}
