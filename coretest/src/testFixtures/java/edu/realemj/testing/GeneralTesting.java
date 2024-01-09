package edu.realemj.testing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class GeneralTesting {

    // Class for holding output strings
    public static class OutPack {
        private String o = "";
        private String e = "";

        public OutPack(String out, String err) {
            o = out;
            e = err;
            o = o.replaceAll("\r", "");
            e = e.replaceAll("\r", "");
        }

        public String getStdOut() {
            return o;
        }

        public String getStdErr() {
            return e;
        }

        public boolean equals(Object other) {
            if(other instanceof OutPack) {
                OutPack otherPack = (OutPack)other;
                return o.equals(otherPack.o) && e.equals(otherPack.e);
            }
            else {
                return false;
            }
        }

        public String toString() {
            return "OUT:\n" + o + "ERR:\n" + e;
        }

        public void trimData() {
            o = o.trim();
            e = e.trim();
        }
    }

    // Singleton class for setting up / tearing down stream redirection
    public static class StreamPack {
        private static StreamPack singleInstance = new StreamPack();

        private ByteArrayOutputStream outStream;
        private ByteArrayOutputStream errStream;
        private ByteArrayInputStream inStream;

        private PrintStream oldOut;
        private PrintStream oldErr;
        private InputStream oldIn;

        private boolean started = false;

        private StreamPack() {}

        public static StreamPack getInstance() {
            return singleInstance;
        }

        public void start(String inputData) {
            // If not already started...
            if(!started) {
                started = true;

                // Grab old streams
                oldOut = System.out;
                oldErr = System.err;
                oldIn = System.in;

                // Reset streams to our streams
                outStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outStream));

                errStream = new ByteArrayOutputStream();
                System.setErr(new PrintStream(errStream));

                inStream = new ByteArrayInputStream(inputData.getBytes());
                System.setIn(inStream);
            }
        }

        public OutPack stop() {
            OutPack p = null;

            if(started) {
                // Grab stream data
                p = new OutPack(outStream.toString(), errStream.toString());

                // Reset system out
                System.setOut(oldOut);
                System.setErr(oldErr);
                System.setIn(oldIn);

                started = false;
            }

            return p;
        }
    }
}
