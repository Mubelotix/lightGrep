package bench;

import java.io.IOException;
import java.io.StringReader;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import fr.insarouen.iti.compilation.lightgrep.expressionRationnelle.ExpressionRationnelle;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import fr.insarouen.iti.compilation.lightgrep.analyseurs.AnalyseurSyntaxique;

public class BenchExpressionRationnelle {
    @Benchmark
    public void testMethod2() throws Throwable {
        AnalyseurSyntaxique analyseurSyntaxique = new AnalyseurSyntaxique(new StringReader("(([a-b]|c)|[abc]|v|[cde]a[fdg]|.a|.|[e-p])"));
        fr.insarouen.iti.compilation.lightgrep.arbreSyntaxiqueAbstrait.ExpressionRationnelle ast = analyseurSyntaxique.expressionRationnelle();
    }
}
