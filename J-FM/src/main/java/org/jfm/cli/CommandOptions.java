package org.jfm.cli;

import org.kohsuke.args4j.Option;

public class CommandOptions {

    @Option(name = "-h", aliases = "--help", usage = "Print this help message", help = true)
    private boolean help;

    @Option(name = "-v", aliases = "--version", usage = "Print version information and exit", help = true)
    private boolean version;

    @Option(name = "-c", aliases = "--create", usage = "Create file", forbids = {"-r"}, depends = {"-f"})
    private boolean create;

    @Option(name = "-r", aliases = "--remove", usage = "Delete file", forbids = {"-c", "-d", "-o"}, depends = {"-f"})
    private boolean delete;

    @Option(name = "-o", aliases = "--override", usage = "Override file", depends = {"-c"})
    private boolean override;


    @Option(name = "-d", aliases = "--data", usage = "Content to write to file", forbids = {"-r"})
    private String content;

    @Option(name = "-f", aliases = "--file", usage = "File path", required = true)
    private String path;


    public boolean isHelp() {
        return help;
    }

    public boolean isVersion() {
        return version;
    }

    public boolean isCreate() {
        return create;
    }

    public boolean isDelete() {
        return delete;
    }

    public boolean isOverride() {
        return override;
    }

    public String getContent() {
        return content;
    }

    public String getPath() {
        return path;
    }
}