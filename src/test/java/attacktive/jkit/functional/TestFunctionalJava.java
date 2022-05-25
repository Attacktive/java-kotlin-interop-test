package attacktive.jkit.functional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestFunctionalJava {
	@Test
	void testTransformArray() {
		byte[] expectedArray = { (byte)2, (byte)4, (byte)6 };

		short[] array = { (short)1, (short)2, (short)3 };
		byte[] transformedArray = transformArrayJava(array, s -> (byte)(s * 2));
		assertArrayEquals(expectedArray, transformedArray);

		transformedArray = transformArrayKotlin(array, s -> (byte)(s * 2));
		assertArrayEquals(expectedArray, transformedArray);
	}

	private byte[] transformArrayJava(short[] array, ShortToByteFunctionJava function) {
		byte[] transformedArray = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			transformedArray[i] = function.applyAsByte(array[i]);
		}

		return transformedArray;
	}

	private byte[] transformArrayKotlin(short[] array, ShortToByteFunctionKotlin function) {
		byte[] transformedArray = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			transformedArray[i] = function.applyAsByte(array[i]);
		}

		return transformedArray;
	}
}
