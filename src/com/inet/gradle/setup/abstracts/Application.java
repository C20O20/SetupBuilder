/*
 * Copyright 2015 i-net software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.inet.gradle.setup.abstracts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.inet.gradle.setup.image.ImageFactory;

/**
 * Generic application wrapper
 *
 * @author gamma
 */
public class Application {
    protected final AbstractSetupBuilder setup;

    private String                       displayName, mainJar, mainClass, executable, description, workDir, startArguments;

    private ArrayList<String>            javaVMArguments = new ArrayList<String>();

    private Object                       icons;

    /**
     * Create a new DesktopStarter
     *
     * @param setup current SetupBuilder
     */
    public Application( AbstractSetupBuilder setup ) {
        this.setup = setup;
    }

    /**
     * get the displayName of the application.
     *
     * @return the display name
     */
    public String getDisplayName() {
        if( displayName != null ) {
            return displayName;
        }
        return setup.getApplication();
    }

    /**
     * Set the displayName of the application.
     *
     * @param displayName the name to set
     */
    public void setDisplayName( String displayName ) {
        this.displayName = displayName;
    }

    /**
     * Returns the description
     *
     * @return the description
     */
    public String getDescription() {
        if( description != null ) {
            return description;
        }
        return setup.getDescription();
    }

    /**
     * Sets the description.
     *
     * @param description the description to set
     */
    public void setDescription( String description ) {
        this.description = description;
    }

    /**
     * Get an executable
     *
     * @return the executable
     */
    public String getExecutable() {
        return executable;
    }

    /**
     * Set the executable file. If this is a relative path then it is relative to the install directory.
     *
     * @param executable Set the executable file.
     */
    public void setExecutable( String executable ) {
        this.executable = executable;
    }

    /**
     * Get the main jar file.
     *
     * @return the main jar
     */
    public String getMainJar() {
        if( mainJar != null ) {
            return mainJar;
        }
        return setup.getMainJar();
    }

    /**
     * Set the jar which contains the main class. This jar must contains all references to all other needed jar files in the manifest.
     *
     * @param mainJar the main jar file
     */
    public void setMainJar( String mainJar ) {
        this.mainJar = mainJar;
    }

    /**
     * Get the main class.
     *
     * @return the class name
     */
    public String getMainClass() {
        if( mainClass != null ) {
            return mainClass;
        }
        return setup.getMainClass();
    }

    /**
     * Set the main class of the Java application.
     *
     * @param mainClass the class name
     */
    public void setMainClass( String mainClass ) {
        this.mainClass = mainClass;
    }

    /**
     * Get the icons for this desktop/shortcut entry.
     *
     * @return the icons
     */
    public Object getIcons() {
        if( icons != null ) {
            return icons;
        }
        return setup.getIcons();
    }

    /**
     * Retrieve a specific icon from the icons set for the setup
     *
     * @param buildDir directory in which to put the icon
     * @param type of the icon to retrieve
     * @return the icon file
     * @throws IOException if an error occurs on reading the image files
     */
    public File getIconForType( File buildDir, String type ) throws IOException {
        return ImageFactory.getImageFile( setup.getProject(), getIcons(), buildDir, type );
    }

    /**
     * Set the icons for desktop/shortcut entry. This can be one or multiple images in different size. The usage depends on the
     * platform. This can be an *.ico file, *.icns file or an list of Java readable image files like *.png or *.jpeg.
     *
     * @param icons the icons
     */
    public void setIcons( Object icons ) {
        this.icons = icons;
    }

    /**
     * Get the working directory of this desktop/shortcut entry.
     *
     * @return the working directory
     */
    public String getWorkDir() {
        return workDir;
    }

    /**
     * Set the working directory. If not set then the installation directory is used.
     *
     * @param workDir the work directory.
     */
    public void setWorkDir( String workDir ) {
        this.workDir = workDir;
    }

    /**
     * Returns the command-line arguments for starting.
     *
     * @return the command-line arguments for starting
     */
    public String getStartArguments() {
        if( startArguments == null ) {
            return "";
        }
        return startArguments;
    }

    /**
     * Sets the command-line arguments for starting .
     *
     * @param startArguments the command-line arguments for starting
     */
    public void setStartArguments( String startArguments ) {
        this.startArguments = startArguments;
    }

    /**
     * Returns the Java VM Arguments for starting java
     *
     * @return the Java VM Arguments for starting java
     */
    public ArrayList<String> getJavaVMArguments() {
        return javaVMArguments;
    }

    /**
     * Sets the Java VM Arguments for starting java
     *
     * @param vmArguments the Java VM Arguments for starting java
     */
    public void setJavaVMArguments( ArrayList<String> vmArguments ) {
        this.javaVMArguments = vmArguments;
    }
}
