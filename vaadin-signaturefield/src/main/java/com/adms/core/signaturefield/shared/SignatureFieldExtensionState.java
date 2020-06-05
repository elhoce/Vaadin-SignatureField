/*
 * Copyright 2014 Max Schuster
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adms.core.signaturefield.shared;

import com.vaadin.shared.JavaScriptExtensionState;
import com.adms.core.signaturefield.SignatureFieldExtension;

/**
 * Shared state for {@link SignatureFieldExtension}
 *
 * @author Max Schuster
 */
public class SignatureFieldExtensionState extends JavaScriptExtensionState {

    private static final long serialVersionUID = 1L;
    
    /**
     * Extension is read only.
     */
    public boolean readOnly;
    
    /**
     * Extension is immediate.
     */
    public boolean immediate = false;

    /**
     * Radius of a single dot.
     */
    public Double dotSize;

    /**
     * Minimum width of a line. Defaults to 0.5.
     */
    public double minWidth = .5f;

    /**
     * Maximum width of a line. Defaults to 2.5.
     */
    public double maxWidth = 2.5f;

    /**
     * Color used to clear the background. Can be any color format
     * accepted by context.fillStyle. Defaults to "rgba(0,0,0,0)" (transparent
     * black). Use a non-transparent color e.g. "rgb(255,255,255)" (opaque
     * white) if you'd like to save signatures as JPEG images.
     */
    public String backgroundColor = "rgba(0,0,0,0)";

    /**
     * Color used to draw the lines. Can be any color format accepted
     * by context.fillStyle. Defaults to "black".
     */
    public String penColor = "black";

    /**
     * Weight used to modify new velocity based on the previous
     * velocity. Defaults to 0.7.
     */
    public double velocityFilterWeight = .7f;

    /**
     * MIME-Type used to create dataURLs
     */
    public String mimeType = MimeType.PNG.getMimeType();

    /**
     * Show a clear button in the signaturefield
     */
    public boolean clearButtonEnabled = false;

}
