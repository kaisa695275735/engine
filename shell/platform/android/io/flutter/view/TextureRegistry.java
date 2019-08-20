// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;

/**
 * Registry of backend textures used with a single {@link FlutterView} instance.
 * Entries may be embedded into the Flutter view using the
 * <a href="https://docs.flutter.io/flutter/widgets/Texture-class.html">Texture</a>
 * widget.
 */
public interface TextureRegistry {
   /**
    * Creates and registers a SurfaceTexture managed by the Flutter engine.
    *
    * @return A SurfaceTextureEntry.
    */
    SurfaceTextureEntry createSurfaceTexture();

    /**
     * A registry entry for a managed SurfaceTexture.
     */
    interface SurfaceTextureEntry {
        /**
         * @return The managed SurfaceTexture.
         */
        SurfaceTexture surfaceTexture();

        /**
         * @return The identity of this SurfaceTexture.
         */
        long id();

        /**
         * Deregisters and releases this SurfaceTexture.
         */
        void release();
    }
  
   /**
   * inform flutter engine that an new frame is render,  start an  new render pipeline
   */
    void onShareFrameAvaliable(int textureIndex);
  
   /**
   * get flutter's opengl context
   */
    EGLContext getShareContext();
  
   /**
   * Creates a Share Texture which use a texture create by native
   *
   * @return A SurfaceTextureEntry.
   */
    ShareTextureEntry createShareTexture(long shareTextureID);
  
    /**
     * A registry entry for a managed ShareTexture.
     */
    interface ShareTextureEntry {
      
        /**
         * @return The identity of this ShareTexture.
         */
        long id();
      
        /**
         * Deregisters and releases this ShareTexture.
         */
        void release();
    }
}
