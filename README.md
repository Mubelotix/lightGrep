# Lightgrep

This project was made by my teacher N. Delestre and completed by me. It is a simple grep-like program that searches for a pattern in a file and prints matching lines. The goal was to learn about parsing in Java using javacc.

## Rewriting in Rust

I have found javacc unsatisfactory for this task. Thus, I have decided to [rewrite it in Rust](https://github.com/Mubelotix/faster-pest/blob/master/faster-pest/examples/lightgrep/main.rs) using [Pest](https://pest.rs/) through my highly overoptimized [faster-pest](https://github.com/Mubelotix/faster-pest) crate. I have been working on this Pest alternative implementation after being unsatisfied with the performance of the original Pest crate, and have managed to make it 7 times faster.

### User-friendliness

The first observation is that the Pest grammar file is only 21 lines long, while the javacc file is almost 200 lines. Pest can describe the same syntax while beeing 90% less verbose. Pest's syntax and errors are also much more user-friendly.

### Performance

I have then benchmarked the two programs for performance on an i7-6700HQ:

Java with JavaCC:
```
Result "bench.BenchExpressionRationnelle.testMethod":
  1898.902 ±(99.9%) 65.348 ops/s [Average]
  (min, avg, max) = (1742.973, 1898.902, 2067.058), stdev = 87.238
  CI (99.9%): [1833.554, 1964.250] (assumes normal distribution)
```

Rust with Faster-Pest:
```
running 2 tests
test lightgrep_as_is   ... bench:         697 ns/iter (+/- 36)
test lightgrep_to_rust ... bench:       2,383 ns/iter (+/- 273)
```

The java version runs 1899 iterations per second, while the Rust version runs 419639 iterations per second. Faster-Pest is 221 times faster than JavaCC, or 22097% faster.

### Further improvements

I could have used faster collections types like `hashbrown` and `smallvec` rather than those provided in the standard library. I guess the same could have been done in Java.

### Conclusion

This example once again shows the superiority of Rust and its ecosystem.
