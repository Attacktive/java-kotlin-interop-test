package attacktive.jkit.functional

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class TestFunctionalKotlin {
	@Test
	fun testTransformArray() {
		val expectedArray = byteArrayOf(2.toByte(), 4.toByte(), 6.toByte())

		val array = shortArrayOf(1.toShort(), 2.toShort(), 3.toShort())
		var transformedArray = transformArrayJava(array) { s: Short -> (s * 2).toByte() }
		Assertions.assertArrayEquals(expectedArray, transformedArray)

		transformedArray = transformArrayKotlin(array) { s: Short -> (s * 2).toByte() }
		Assertions.assertArrayEquals(expectedArray, transformedArray)
	}

	private fun transformArrayJava(array: ShortArray, function: ShortToByteFunctionJava): ByteArray {
		val transformedArray = ByteArray(array.size)
		for (i in array.indices) {
			transformedArray[i] = function.applyAsByte(array[i])
		}

		return transformedArray
	}

	private fun transformArrayKotlin(array: ShortArray, function: ShortToByteFunctionKotlin): ByteArray {
		val transformedArray = ByteArray(array.size)
		for (i in array.indices) {
			transformedArray[i] = function.applyAsByte(array[i])
		}

		return transformedArray
	}
}
