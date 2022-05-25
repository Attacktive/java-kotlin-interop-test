package attacktive.jkit.nullability;

import java.security.SecureRandom;
import java.util.Random;

class NullableStringGenerator {
	public static final String TEXT = "It's not null.";
	private static final Random random = new SecureRandom();

	private NullableStringGenerator() { }

	public static String get() {
		return get(0.5F);
	}

	public static String get(double probability) {
		var randomDouble = random.nextDouble();
		return get(randomDouble <= probability);
	}

	public static String get(boolean nonNull) {
		return (nonNull? TEXT: null);
	}
}
