package org.jfm.controllers;

public class VersionController implements IController {
    @Override
    public void process() {
        System.out.println("Version 1.0");
    }
}
