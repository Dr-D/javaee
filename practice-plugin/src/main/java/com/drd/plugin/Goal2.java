package com.drd.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Created by dr-d on 14/10/15
 */
@Mojo( name = "goal2")
public class Goal2 extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info( "Executing goal2" );
        getLog().info( "stringParameter: " + stringParameter );
    }

    @Parameter(property = "goal2.stringParameter", defaultValue = "Goal2 String Parameter")
    private String stringParameter;

}
