package attacktive.jkit.nullability;

import java.security.SecureRandom;
import java.util.Random;

import org.jetbrains.annotations.Nullable;

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

	@Nullable
	public static String getNullable() {
		return getNullable(0.5F);
	}

	@Nullable
	public static String getNullable(double probability) {
		var randomDouble = random.nextDouble();
		return getNullable(randomDouble <= probability);
	}

	@Nullable
	public static String getNullable(boolean nonNull) {
		return (nonNull? TEXT: null);
	}
}
