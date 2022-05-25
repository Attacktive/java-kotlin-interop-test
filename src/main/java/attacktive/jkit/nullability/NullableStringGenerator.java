package attacktive.jkit.nullability;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class NullableStringGenerator {
	public static final String TEXT = "It's not null.";

	private NullableStringGenerator() { }

	public static String get(boolean nonNull) {
		return (nonNull? TEXT: null);
	}

	@Nullable
	public static String getNullable(boolean nonNull) {
		return (nonNull? TEXT: null);
	}

	/**
	 * It should never be annotated with {@link org.jetbrains.annotations.NotNull}, but I did that intentionally.
	 */
	@SuppressWarnings("ConstantConditions")
	@NotNull
	public static String getNotNull(boolean nonNull) {
		return (nonNull? TEXT: null);
	}
}
