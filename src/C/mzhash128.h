#ifndef _MZHASH128_H
#define _MZHASH128_H

#include <stddef.h> // size_t
#include <stdint.h> // uint64_t

#ifdef __cplusplus
extern "C" {
#endif

#define MZ_HASH_128_DEFAULT_SEED		0;

void mzhash128(const char* data, size_t length, uint64_t seed, uint64_t* output);
void mzhash128_noseed(const char* data, size_t length, uint64_t* output);
void mzhash128_str(const char* str, uint64_t seed, uint64_t* output);
void mzhash128_str_noseed(const char* str, uint64_t* output);

#ifdef __cplusplus
}
#endif

#endif
