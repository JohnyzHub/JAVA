package com.corejava.reflection.test.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author johnybasha
 *
 */
public class ExecutableUtil {

	public static String getParameters(Executable exec) {
		Parameter[] execParameters = exec.getParameters();

		int paramSize = execParameters.length;
		List<String> parameters = new ArrayList<String>(paramSize);

		for (Parameter parameter : execParameters) {
			int mod = parameter.getModifiers() & Modifier.parameterModifiers();
			String modifier = Modifier.toString(mod);
			String paramName = parameter.getName();
			String paramType = parameter.getType().getSimpleName();
			String temp = modifier + " " + paramType + " " + paramName;
			parameters.add(temp.trim());
		}
		String params =fromArrayToString(parameters, ","); 
		return "(" + params + ") ";
	}

	public static String getModifiers(Executable exec) {
		int mod = exec.getModifiers();

		if (exec instanceof Method) {
			mod = mod & Modifier.methodModifiers();
		} else if (exec instanceof Constructor) {
			mod = mod & Modifier.constructorModifiers();
		}
		return Modifier.toString(mod);
	}

	public static String getThrowsClause(Executable exec) {
		List<String> exceptionsList = getExceptionList(exec);
		String exceptions = fromArrayToString(exceptionsList, ", ");
		String throwsClause = "";
		if (!exceptions.isEmpty()) {
			throwsClause = "throws " + exceptions;
		}
		return throwsClause;
	}

	private static List<String> getExceptionList(Executable exec) {
		Class<?>[] exceptionTypes = exec.getExceptionTypes();
		int size = exceptionTypes.length;
		List<String> exceptionsList = new ArrayList<String>(size);

		for (Class<?> c : exceptionTypes) {
			exceptionsList.add(c.getSimpleName());
		}
		return exceptionsList;
	}

	public static String fromArrayToString(List<String> list, String separator) {
		String[] stringArray = new String[list.size()];
		stringArray = list.toArray(stringArray);
		String stringFormat = String.join(separator, stringArray);
		return stringFormat;
	}
}
