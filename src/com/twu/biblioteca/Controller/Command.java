
package com.twu.biblioteca.Controller;

import java.io.IOException;


public interface Command {
    public void execute() throws IOException;

    public String description();
}