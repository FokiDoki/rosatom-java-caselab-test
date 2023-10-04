package org.jfm.cli;

import org.kohsuke.args4j.CmdLineParser;

public class OptionsFactory {
    public static CommandOptions getOptions(String[] args) {
        CommandOptions options = new CommandOptions();
        CmdLineParser parser = new CmdLineParser(options);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            return null;
        }
        return options;
    }
}
