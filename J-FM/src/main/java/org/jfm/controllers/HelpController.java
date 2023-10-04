package org.jfm.controllers;

public class HelpController implements IController{


    @Override
    public void process() {
        System.out.println("""
                Usage: jfm [options] -f <file path>
                Program arguments:
                -h, --help: show this help message and exit
                -v, --version: show program's version number and exit
                -c, --create: create a file
                -d, --delete: delete a file
                -o, --override: override a file
                -f, --file: file path (required)
                -d, --data: content to write to file
                """);
    }
}
