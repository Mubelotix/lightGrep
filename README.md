# Lightgrep

This project was made by my teacher N. Delestre and completed by me. It is a simple grep-like program that searches for a pattern in a file and prints matching lines. The goal was to learn about parsing in Java using javacc.

## Rewriting in Rust

I have found javacc unsatisfactory for this task. Thus, I have decided to [rewrite it in Rust](https://github.com/Mubelotix/faster-pest/blob/master/faster-pest/examples/lightgrep) using [Pest](https://pest.rs/) through my highly overoptimized [faster-pest](https://github.com/Mubelotix/faster-pest) crate. I have been working on this Pest alternative implementation after being unsatisfied with the performance of the original Pest crate, and have managed to make it 7 times faster.

### User-friendliness

The first observation is that the Pest grammar file is only 21 lines long, while the javacc file is almost 200 lines. Pest can describe the same syntax while being 90% less verbose. It is partly due to the fact that JavaCC requires instantiating classes right in the grammar file, while it is done separately in Rust (80 lines). I have found Pest's syntax and errors to be much more user-friendly.

### Performance

I have then benchmarked the two programs for performance on an i7-6700HQ:

Java with JavaCC:
```
Result "bench.BenchExpressionRationnelle.testMethod2":
  53223.161 ±(99.9%) 2795.012 ops/s [Average]
  (min, avg, max) = (40068.623, 53223.161, 57760.994), stdev = 3731.260
  CI (99.9%): [50428.150, 56018.173] (assumes normal distribution)
```

Rust with Faster-Pest:
```
running 2 tests
test lightgrep_as_is   ... bench:         697 ns/iter (+/- 36)
test lightgrep_to_rust ... bench:       2,383 ns/iter (+/- 273)
```

The first benchmark only accounts for tokenization and parsing. The second benchmark also includes instantiating the `ExpressionRationnelle` struct. In order to have a fair comparison with JavaCC, I am going to consider the results of the second benchmark.

The java version runs 53223 iterations per second, while the Rust version runs at 419639 iterations per second. **Faster-Pest is 788% faster than JavaCC**.

### Further improvements

I could have used faster collections types like `hashbrown` and `smallvec` rather than those provided in the standard library. I guess the same could have been done in Java.

### Conclusion

This example once again shows the superiority of Rust and its ecosystem.

*See also: [Rust vs Rust: performance comparison of different blazing fast crates on JSON parsing](https://github.com/Mubelotix/pestvsnom)*
