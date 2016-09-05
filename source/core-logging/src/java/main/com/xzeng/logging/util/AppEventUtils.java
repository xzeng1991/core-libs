package com.xzeng.logging.util;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xzeng.logging.enums.AppEvent;

public class AppEventUtils {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppEventUtils.class);

	public static void logInfo(AppEvent appEvent, Object... args) {
		String msg = buildMessage(appEvent);
		LOGGER.info(msg, args);
	}

	public static void logWarn(AppEvent appEvent, Object... args) {
		String msg = buildMessage(appEvent);
		LOGGER.warn(msg, args);
	}

	public static void logError(AppEvent appEvent, Object... args) {
		String msg = buildMessage(appEvent);
		LOGGER.error(msg, args);
	}

	public static void logError(Throwable t, AppEvent appEvent, Object... args) {
		String msg = buildMessage(appEvent);

		Object[] logArgs = addThrowableToMessageParameters(args, t);
		LOGGER.error(msg, logArgs);
	}

	private static String buildMessage(AppEvent appEvent) {
		StringBuilder messageBuilder = new StringBuilder(appEvent.getMessage()
				.length() + 50);
		messageBuilder.append(appEvent.getId());
		messageBuilder.append("---");
		messageBuilder.append(appEvent.getMessage());

		return messageBuilder.toString();
	}

	private static Object[] addThrowableToMessageParameters(Object[] args,
			Throwable t) {
		if (ArrayUtils.isEmpty(args)) {
			return new Object[] { t };
		} else {
			Object[] argsCopy = Arrays.copyOf(args, args.length + 1);
			argsCopy[args.length] = t;
			return argsCopy;
		}
	}
}
