package pawtropolis.gdr.util;

import pawtropolis.gdr.game.GameController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ClassLoaderUtils {
	private ClassLoaderUtils() {
	}

	@SuppressWarnings("unchecked")
	public static <T> Set<Class<? extends T>> findAllClassesInPackageBySuperType(String packageName, Class<T> superType) {
		InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
		if (stream == null) {
			return Collections.emptySet();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		return reader.lines()
				.filter(line -> line.endsWith(".class"))
				.map(line -> makeClassByName(line, packageName))
				.filter(Predicate.not(Objects::isNull))
				.filter(superType::isAssignableFrom)
				.map(c -> (Class<T>) c)
				.collect(Collectors.toSet());
	}

	public static <T> T makeInstanceFromClass(Class<T> clazz, Object... args) {
		try {
			return clazz.getConstructor(GameController.class).newInstance(args);
		} catch (Exception e) {
			return null;
		}
	}

	private static Class<?> makeClassByName(String className, String packageName) {
		try {
			return Class.forName(packageName + "."
					+ className.substring(0, className.lastIndexOf('.')));
		} catch (Exception e) {
			// log error
		}
		return null;
	}
}
