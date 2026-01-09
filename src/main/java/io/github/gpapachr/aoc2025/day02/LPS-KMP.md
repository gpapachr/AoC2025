# LPS and the KMP idea

The Knuth–Morris–Pratt (KMP) algorithm is a classic string-processing technique designed to search for a pattern inside
a larger text efficiently. Instead of restarting comparisons from scratch every time a mismatch occurs, KMP uses
information about the pattern itself to skip unnecessary work. The key idea is simple: when part of the pattern has
already matched, a mismatch does not mean we need to forget everything we’ve seen so far.

To achieve this, KMP relies on a preprocessing step that builds the LPS array (Longest Proper Prefix which is also a
Suffix). For each position in the pattern, the LPS value represents the length of the longest prefix of the pattern that
also appears as a suffix ending at that position. In other words, it measures how much the pattern “overlaps with
itself”. This information allows the algorithm to know how far it can safely shift the pattern when a mismatch happens,
without missing any possible matches.

## Using LPS to detect repeated patterns

The same LPS concept can be reused outside of pattern searching, for example to detect whether a string is made entirely
of repeated smaller blocks. If a string has a non-zero LPS value at its last position, it means that the beginning and
the end of the string share a common structure. From this, we can compute a candidate period (the length of the smallest
repeating block) as stringLength - lps. If the total length of the string is an exact multiple of this period, then the
string consists of that block repeated multiple times.

In this solution, the LPS array is used to check whether an ID is composed of a digit sequence repeated two or more
times. If such a repetition exists, the ID is considered invalid. This approach runs in linear time, avoids brute-force
substring checks, and works reliably even for long inputs. In short, KMP’s preprocessing step gives us a fast and
elegant way to reason about repetition patterns in strings, not just to search for them.

## Example: detecting repetition with LPS

Consider the string 123123123. As the LPS array is built from left to right, it records how much of the beginning of the
string matches the end at each position. By the time we reach the final character, the LPS value is 6, meaning the
longest prefix that is also a suffix is "123123". The total length of the string is 9, so the candidate repeating period
is 9 - 6 = 3. Since 9 is an exact multiple of 3, the string can be expressed as the block "123" repeated three times.
This confirms that the string is composed entirely of a smaller sequence repeated multiple times, and therefore it is
classified as invalid. If the length were not divisible by the computed period, the repetition would be partial and the
string would be considered valid.
