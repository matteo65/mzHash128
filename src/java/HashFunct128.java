/**
 * mzHash128
 * 
 * Strong, fast, simple, non-cryptographic 128-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2025
 * Licence: Public Domain
 * 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <https://unlicense.org>
 * 
 */
public class HashFunct128 {
	
	/** 
	 * Class to store 2 x 64 long = 128 bits  
	 */
	public static final class LongPair {
		public long val1;
		public long val2;
	}
	
	private HashFunct128() {}
	
	public static void mzHash128(byte[] data, int start, int length, long seed, LongPair out) {
		long hash1 = 0;
		long hash2 = 0x7F573AFD9B2368FDL ^ seed;
		
		for(int i = 0; i < length; i++) {
			hash1 = 0x7EECB951FC241210L * (i + data[start + i]) ^ (hash2 << 2) ^ (hash2 >>> 2);
			hash2 = 0x447239684A147E94L * (i + data[start + i]) ^ (hash1 << 2) ^ (hash1 >>> 2);
		}
		out.val1 = hash1;
		out.val2 = hash2;
	}
	
	public static void mzHash128(byte[] data, int start, int length, long seed, long[] out) {
		long hash1 = 0;
		long hash2 = 0x7F573AFD9B2368FDL ^ seed;
		
		for(int i = 0; i < length; i++) {
			hash1 = 0x7EECB951FC241210L * (i + data[start + i]) ^ (hash2 << 2) ^ (hash2 >>> 2);
			hash2 = 0x447239684A147E94L * (i + data[start + i]) ^ (hash1 << 2) ^ (hash1 >>> 2);
		}
		out[0] = hash1;
		out[1] = hash2;
	}
	
	public static long[] mzHash128(byte[] data, int start, int length, long seed) {
		long[] out = new long[2];
		mzHash128(data, start, length, seed, out);
		return out;
	}
	
	public static void mzHash128(byte[] data, LongPair out) {
		mzHash128(data, 0, data.length, 0, out);
	}
	
	public static void mzHash128(byte[] data, long[] out) {
		mzHash128(data, 0, data.length, 0, out);
	}
	
	public static long[] mzHash128(byte[] data) {
		long[] out = new long[2];
		mzHash128(data, 0, data.length, 0, out);
		return out;
	}

}
