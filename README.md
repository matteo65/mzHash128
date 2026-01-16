
# mzHash128: A Fast and Efficient Non-Cryptographic Hash Function
We are excited to present mzHash128 , the latest addition to the mzHash family of non-cryptographic hash functions. Building upon the success of its predecessors, mzHash32 and mzHash64, mzHash128 extends the family with a 128-bit output while maintaining the same principles of simplicity, speed, and high performance in minimizing collisions.

```C
void mzhash128(const void* data, size_t length, uint64_t* output)
{
	const int8_t *bytes = (const int8_t*)data;
	uint64_t hash0 = 0xB04C2438F4F7D8D1uLL;
	uint64_t hash1 = 0xA3B8FD0DF0836C0DuLL;
		
	while(length--) {
		uint64_t h = 0xD76F648260B0F9FDuLL * (*bytes ^ hash0 * 256 ^ hash0 / 256);
		hash0 = 0xD1DA2131A0C25299uLL * (*bytes++ ^ hash1 * 256 ^ hash1 / 256);
		hash1 = h;
	}
	
	output[0] = hash0;
	output[1] = hash1;
}
```
## Key Features of mzHash128
**128-Bit Output** : mzHash128 provides a larger hash space compared to mzHash64 and mzHash32, making it suitable for applications requiring higher entropy or reduced collision probabilities.  
**Simplicity** : Like its counterparts, mzHash128 employs a straightforward algorithm that is easy to implement and understand, ensuring minimal overhead and maximum efficiency.  
**Speed** : Designed for optimal performance, mzHash128 processes input data quickly, making it ideal for real-time or high-throughput applications where computational resources are limited.  
**Low Collision Rate** : mzHash128 demonstrates excellent distribution properties, closely approximating the behavior of a theoretical Universal Hash Function. This ensures a near-random distribution of hash values, reducing the likelihood of collisions even for large datasets.  

## Hash Value Distribution Analysis
For hashing functions with length greater than or equal to 128 bits, it is very difficult, if not impossible, to count collisions, therefore, in order to verify the quality of the result, statistical analysis on hashing samples is used. A quality hashing function must produce an output with a uniform distribution and indistinguishable from a random sequence of bytes.

In this case, the hash values ​​for all strings between the number **"zero"** and the number **"nine million nine hundred ninety-nine thousand nine hundred ninety-nine"** were concatenated for a total of 10,000,000 hashes. VisualRT was used to analyze the output and the result passed all randomness tests, confirming the quality of the mzHash family algorithm.

![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash128/main/Resource/mzhash128output.png)

**Length** = 160000000  
**Average byte frequency μ** = 625000.0  
**Minimum byte frequency** = 622348  
**Maximum byte frequency** = 627130  
**Variance σ<sup>2</sup>** = 659097.242 
**Standard Deviation σ** = 811.848  
**Coefficient of Variation <sup>σ</sup>/<sub>μ</sub>** = 0.1299%  
**Chi-Square 𝛘<sup>2</sup>** = 269.966  
**Average bytes value** = 127.498 (127.5 random)  
**Entropy** = 7.999999 bits (8 random)  
**Monte Carlo for π 2D** = 3.141788 (error = 0.006%)  
**Monte Carlo for π 3D** = 3.142216 (error = 0.0199%)  
**Average of Contiguous Byte Pairs** = 32766.802 (32767.5 random) (error 0.002%)  
**4 Bytes Collisions** = 185442 (expected collisions = 185687.6)  

## Applications
mzHash128 is well-suited for a variety of non-cryptographic use cases, including:

- Data indexing and lookup in hash tables
- Caching mechanisms
- Consistent hashing for distributed systems
- Data deduplication
- Fast checksums for integrity verification

## Place in the mzHash Family
The mzHash family consists of three members:

**mzHash32** : A 32-bit hash function optimized for lightweight applications.   
**mzHash64** : A 64-bit hash function offering a balance between speed and collision resistance.   
**mzHash128** : The newest member, providing a robust 128-bit output for demanding applications.   

Each function in the mzHash family adheres to the same design philosophy: simplicity, speed, and effectiveness. This consistency makes it easy for developers to choose the appropriate variant based on their specific requirements without compromising on quality.   

## Why Choose mzHash128?
For developers seeking a reliable, efficient, and easy-to-implement hash function, mzHash128 offers an attractive solution. Its combination of a large output size, low collision rate, and fast execution time makes it a strong contender in the realm of non-cryptographic hashing.

We invite you to explore mzHash128 and experience its capabilities firsthand. Whether you're building high-performance software or optimizing existing systems, mzHash128 is designed to meet your needs with elegance and efficiency.
