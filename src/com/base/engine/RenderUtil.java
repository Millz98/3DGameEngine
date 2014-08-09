package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil 
{
	// below is the method that clears the screen and everything on it. 
     public static void clearScreen()
     {
    	 //TODO: Stencil Buffer
    	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
     }
     
     // This method is to tell the code above that not only are you clearing the screen, but to clear it all black.
     public static void initGraphics()
     {
    	glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    	
    	glFrontFace(GL_CW);
    	glCullFace(GL_BACK);
    	glEnable(GL_CULL_FACE);
    	glEnable(GL_DEPTH_TEST); // this is to test how for the objects are away from the camera.
    	
    	//TODO: Depth clamp for later
    	
    	glEnable(GL_FRAMEBUFFER_SRGB); //this is enabled for free gamma correction.
     }
     
     //asking OpenGL for its current version.
     public static String getOpenGLVersion()
     {
    	 return glGetString(GL_VERSION);
     }
}
