package attacktive.jkit.nullability

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

internal class TestNullability {
	@Test
	fun testNonNullString() {
		val nonNullString = NullableStringGenerator.get(true)

		println("nonNullString: $nonNullString")
		assertEquals(NullableStringGenerator.TEXT, nonNullString)
	}

	@Test
	fun testNullableNullString() {
		val nullableNullString: String? = NullableStringGenerator.get(false)

		println("nullableNullString: $nullableNullString")
		assertEquals(null as String?, nullableNullString)
	}

	@Test
	fun testNonNullNullString() {
		assertThrows<NullPointerException> {
			/**
			 * The return type of [NullableStringGenerator.get] is "ambiguous".
			 *
			 * [NullableStringGenerator.get] could actually return `null` but the very fact can't be acknowledged from the Java method signature without the appropriate annotation.
			 * As a result, Kotlin compiler cannot complain that [NullableStringGenerator.get] is nullable.
			 */
			@Suppress("UNUSED_VARIABLE")
			val nonNullNullString: String = NullableStringGenerator.get(false)
		}
	}
}
