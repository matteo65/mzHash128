/**
 * mzhash128
 * 
 * Strong, fast, simple, non-cryptographic 128-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2026-01
 * Release: 5
 *
 * SPDX-FileCopyrightText: 2026 Matteo Zapparoli <zapparoli.matteo@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file in project root.
 * 
 */
public class HashFunct128 {
	
	/** 
	 * Class to store 2 x 64 long = 128 bits  
	 */
	public static final class LongPair {
		public long val0;
		public long val1;
	}
	
	private HashFunct128() {}
	
	public static void mzHash128(byte[] data, int start, int length, LongPair out) {
		long hash0 = 0xB04C2438F4F7D8D1L;
		long hash1 = 0xA3B8FD0DF0836C0DL;
		
		for(int i = 0; i < length; i++) {
			byte b = data[start + i];
			long h = 0xD76F648260B0F9FDL * (b ^ (hash0 << 8) ^ (hash0 >>> 8));
			hash0 = 0xD1DA2131A0C25299L * (b ^ (hash1 << 8) ^ (hash1 >>> 8));
			hash1 = h;
		}
		out.val0 = hash0;
		out.val1 = hash1;
	}
	
	public static void mzHash128(byte[] data, int start, int length, long[] out) {
        long hash0 = 0xB04C2438F4F7D8D1L;
        long hash1 = 0xA3B8FD0DF0836C0DL;
        
        for(int i = 0; i < length; i++) {
            byte b = data[start + i];
            long h = 0xD76F648260B0F9FDL * (b ^ (hash0 << 8) ^ (hash0 >>> 8));
            hash0 = 0xD1DA2131A0C25299L * (b ^ (hash1 << 8) ^ (hash1 >>> 8));
            hash1 = h;
        }
		out[0] = hash0;
		out[1] = hash1;
	}
	
	public static long[] mzHash128(byte[] data, int start, int length) {
		long[] out = new long[2];
		mzHash128(data, start, length, out);
		return out;
	}
	
	public static void mzHash128(byte[] data, LongPair out) {
		mzHash128(data, 0, data.length, out);
	}
	
	public static void mzHash128(byte[] data, long[] out) {
		mzHash128(data, 0, data.length, out);
	}
	
	public static long[] mzHash128(byte[] data) {
		long[] out = new long[2];
		mzHash128(data, 0, data.length, out);
		return out;
	}

}


