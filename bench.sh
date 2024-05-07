#!/bin/bash
java -cp build/classes/:build/bench/classes:lib/jmh-core-1.37.jar:lib/jmh-generator-annprocess-1.37.jar:lib/commons-math3-3.6.1.jar  benchRunner.BenchRunner
