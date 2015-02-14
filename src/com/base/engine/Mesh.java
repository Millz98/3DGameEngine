package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class Mesh 
{
     private int vbo; // the vbo is a pointer
     private int ibo;
     private int size; // how much data we have from this pointer
     
     public Mesh()
     {
    	 vbo = glGenBuffers();
    	 ibo = glGenBuffers();
    	 size = 0;
     }
     
     public void addVertices(Vertex[] vertices, int[] indicies)
     {
    	 size = indicies.length;
    	 
    	glBindBuffer(GL_ARRAY_BUFFER,vbo);
    	glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
    	
    	glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
    	glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedBuffer(indicies), GL_STATIC_DRAW);
     }
     
     public void draw()
     {
    	 glEnableVertexAttribArray(0);
    	 
    	 glBindBuffer(GL_ARRAY_BUFFER,vbo);
    	 glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
    	 
    	 glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
    	 glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);
    	 
    	 glDisableVertexAttribArray(0);
     }
}
