package benchRunner;

import java.io.IOException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import fr.insarouen.iti.compilation.lightgrep.expressionRationnelle.ExpressionRationnelle;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import bench.BenchExpressionRationnelle;

public class BenchRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(BenchExpressionRationnelle.class.getSimpleName())
            .build();

        new Runner(opt).run();
    }
}
