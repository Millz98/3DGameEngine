package com.base.engine;

import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_CW;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_VERSION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glFrontFace;
import static org.lwjgl.opengl.GL11.glGetString;

public class RenderUtil 
{
	private static final int GL_DEPTH_CLAMP = 0;

	// below is the method that clears the screen and everything on it. 
     public static void clearScreen()
     {
    	 //TODO: Stencil Buffer
    	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
     }
     
     // a method for me to enable or disable textures without importing OpenGL
     public static void setTextures(boolean enabled)
     {
    	 if(enabled)
    		glEnable(GL_TEXTURE_2D);
    	 else
    		 glDisable(GL_TEXTURE_2D);
     }
     
     public static void setClearColor(Vector3f color)
     {
         glClearColor(color.getX(), color.getY(), color.getZ(), 1.0f);
     }
    
    
     // This method is to tell the code above that not only are you clearing the screen, but to clear it all black.
     public static void initGraphics()
     {
    	glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    	
    	glFrontFace(GL_CW);
    	glCullFace(GL_BACK);
    	glEnable(GL_CULL_FACE);
    	glEnable(GL_DEPTH_TEST); // this is to test how for the objects are away from the camera.
    	
    	glEnable(GL_DEPTH_CLAMP);
    	
    	glEnable(GL_TEXTURE_2D);
    	
     }
     
     //asking OpenGL for its current version.
     public static String getOpenGLVersion()
     {
    	 return glGetString(GL_VERSION);
     }

	public static void unbindTextures() 
	{
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	private static void glBindTexture(int glTexture2d, int i) {
		// TODO Auto-generated method stub
		
	}

	public static void setClearColor1(Vector3f color)
	{
		glClearColor(color.getX(), color.getY(), color.getZ(), 1.0f);
	}
}

// another test of my own stupidity
