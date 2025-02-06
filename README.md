
# mzHash128: A Fast and Efficient Non-Cryptographic Hash Function
We are excited to present mzHash128 , the latest addition to the mzHash family of non-cryptographic hash functions. Building upon the success of its predecessors, mzHash32 and mzHash64, mzHash128 extends the family with a 128-bit output while maintaining the same principles of simplicity, speed, and high performance in minimizing collisions.

## Key Features of mzHash128:
**128-Bit Output** : mzHash128 provides a larger hash space compared to mzHash64 and mzHash32, making it suitable for applications requiring higher entropy or reduced collision probabilities.<br>
**Simplicity** : Like its counterparts, mzHash128 employs a straightforward algorithm that is easy to implement and understand, ensuring minimal overhead and maximum efficiency.<br>
**Speed** : Designed for optimal performance, mzHash128 processes input data quickly, making it ideal for real-time or high-throughput applications where computational resources are limited.<br>
**Low Collision Rate** : mzHash128 demonstrates excellent distribution properties, closely approximating the behavior of a theoretical Universal Hash Function. This ensures a near-random distribution of hash values, reducing the likelihood of collisions even for large datasets.<br>

## Applications:
mzHash128 is well-suited for a variety of non-cryptographic use cases, including:

- Data indexing and lookup in hash tables
- Caching mechanisms
- Consistent hashing for distributed systems
- Data deduplication
- Fast checksums for integrity verification

## Place in the mzHash Family:
The mzHash family consists of three members:

**mzHash32** : A 32-bit hash function optimized for lightweight applications.
**mzHash64** : A 64-bit hash function offering a balance between speed and collision resistance.
**mzHash128** : The newest member, providing a robust 128-bit output for demanding applications.
Each function in the mzHash family adheres to the same design philosophy: simplicity, speed, and effectiveness. This consistency makes it easy for developers to choose the appropriate variant based on their specific requirements without compromising on quality.

## Why Choose mzHash128?
For developers seeking a reliable, efficient, and easy-to-implement hash function, mzHash128 offers an attractive solution. Its combination of a large output size, low collision rate, and fast execution time makes it a strong contender in the realm of non-cryptographic hashing.

We invite you to explore mzHash128 and experience its capabilities firsthand. Whether you're building high-performance software or optimizing existing systems, mzHash128 is designed to meet your needs with elegance and efficiency.
