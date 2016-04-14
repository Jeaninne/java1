package reflection.hometask.service;

import java.util.HashSet;
import java.util.Set;

import org.reflections.Reflections;

import reflection.hometask.annotations.Example;

public class ObjectKeeper {

	Set<Object> objects = new HashSet<Object>();

	public void parseDirrectory() {
		Reflections reflection = new Reflections("reflection.hometask");
		Set<Class<?>> classes = reflection.getTypesAnnotatedWith(Example.class);

		for (Class customClass : classes) {
			try {
				Object example = customClass.newInstance();
				objects.add(example);
			}
			catch (InstantiationException e) {
				//nobody cares
			}
			catch (IllegalAccessException e) {
				//nobody cares
			}
		}
	}

	public ObjectKeeper() {
		parseDirrectory();
	}
}