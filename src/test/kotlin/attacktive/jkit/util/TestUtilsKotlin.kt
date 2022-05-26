package attacktive.jkit.util

import EmptyClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TestUtilsKotlin {
	@Test
	fun test() {
		val instance1 = EmptyClass()
		val instance2 = EmptyClass()
		val instance3 = EmptyClass()

		val kotlinList = listOf(instance1, instance2, instance3)

		val javaArrayList: java.util.ArrayList<EmptyClass> = java.util.ArrayList()
		javaArrayList.add(instance1)
		javaArrayList.add(instance2)
		javaArrayList.add(instance3)

		kotlinList.forEachIndexed { index, instance ->
			assertEquals(instance, javaArrayList[index])
		}

		// in order to ensure the test above is correct:
		assertEquals(instance1, instance1)
		assertEquals(instance2, instance2)
		assertEquals(instance3, instance3)
		assertNotEquals(instance1, instance2)
		assertNotEquals(instance2, instance3)
		assertNotEquals(instance3, instance1)
	}
}
