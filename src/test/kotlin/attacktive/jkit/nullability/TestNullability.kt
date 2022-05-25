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
			 * As a result, the Kotlin compiler cannot complain that [NullableStringGenerator.get] is nullable.
			 */
			@Suppress("UNUSED_VARIABLE")
			val nonNullNullString: String = NullableStringGenerator.get(false)
		}
	}

	@Test
	fun testAnnotatedNonNullString() {
		val annotatedNonNullString = NullableStringGenerator.getNullable(true)

		println("annotatedNonNullString: $annotatedNonNullString")
		assertEquals(NullableStringGenerator.TEXT, annotatedNonNullString)
	}

	@Test
	fun testAnnotatedNullableNullString() {
		/**
		 * [NullableStringGenerator.getNullable] is annotated with [org.jetbrains.annotations.Nullable], so `val x: String = NullableStringGenerator.getNullable(false)` now doesn't compile.
		 */
		val annotatedNullableNullString: String? = NullableStringGenerator.getNullable(false)

		println("annotatedNullableNullString: $annotatedNullableNullString")
		assertEquals(null as String?, annotatedNullableNullString)
	}

	@Test
	fun testImproperlyAnnotatedNonNullString() {
		val improperlyAnnotatedNonNullString = NullableStringGenerator.getNotNull(true)

		println("improperlyAnnotatedNonNullString: $improperlyAnnotatedNonNullString")
		assertEquals(NullableStringGenerator.TEXT, improperlyAnnotatedNonNullString)
	}

	@Test
	fun testImproperlyAnnotatedNullableNullString() {
		@Suppress("RedundantNullableReturnType")
		val improperlyAnnotatedNullableNullString: String? = NullableStringGenerator.getNotNull(false)

		println("improperlyAnnotatedNullableNullString: $improperlyAnnotatedNullableNullString")
		assertEquals(null as String?, improperlyAnnotatedNullableNullString)
	}

	@Test
	fun testImproperlyAnnotatedNonNullNullString() {
		assertThrows<NullPointerException> {
			@Suppress("UNUSED_VARIABLE")
			val nonNullNullString: String = NullableStringGenerator.getNotNull(false)
		}
	}
}
