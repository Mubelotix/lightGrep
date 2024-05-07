package bench;

import java.io.IOException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import fr.insarouen.iti.compilation.lightgrep.expressionRationnelle.ExpressionRationnelle;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchExpressionRationnelle {
    @Benchmark
    public void testMethod() throws Throwable {
        ExpressionRationnelle eR;
        eR = new ExpressionRationnelle("(([a-b]|c)|[abc]|v|[cde]a[fdg]|.a|.|[e-p])");
    }
}
