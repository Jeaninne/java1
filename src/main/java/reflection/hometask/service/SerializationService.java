package reflection.hometask.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import reflection.hometask.annotations.CustomDateFormat;
import reflection.hometask.annotations.JsonValue;

public class SerializationService {

	private JSONObject toJson(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, JSONException {
		JSONObject jo = new JSONObject();
		Class objClass = object.getClass();

		for (Field field : objClass.getDeclaredFields()) {
			field.setAccessible(true);
			String key = field.getName();
			Object value = field.get(object);


			for(Annotation annotation : field.getAnnotations()) {
				if (annotation.annotationType().equals(JsonValue.class)) {
					key = annotation.annotationType().getDeclaredMethod("name").invoke(annotation, (Object[]) null).toString();
				}
				if (annotation.annotationType().equals(CustomDateFormat.class)) {
					LocalDate date = LocalDate.parse(field.get(object).toString(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					String format = annotation.annotationType().getDeclaredMethod("format").invoke(annotation, (Object[]) null).toString();
					value = date.format(DateTimeFormatter.ofPattern(format));
				}
			}

			jo.put(key, value);

			field.setAccessible(false);
		}
		return jo;
	}

	public void testService() {
		ObjectKeeper objectKeeper = new ObjectKeeper();
		Set<Object> objectSet = objectKeeper.objects;
		for (Object object : objectSet) {
			try {
				System.out.println(toJson(object));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
