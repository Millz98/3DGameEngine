package com.base.engine;
public class Game 
{
	private Mesh mesh;
	
	
	public Game()
	{
		mesh = new Mesh();
		Vertex[] data = new Vertex[] {new Vertex(new Vector3f(-1,-1,0)),
		                              new Vertex(new Vector3f(0,1,0)),
		                              new Vertex(new Vector3f(1,-1,0))};
		
		
		mesh.addVertices(data);
	}
	
	public void input()
	{
		//these 2 sections are to display when a key has been pressed or not in the console field.
		if(Input.getKeyDown(Input.KEY_UP))
			System.out.println("We've just pressed up!");
		if(Input.getKeyUp(Input.KEY_UP))
			System.out.println("We've just released up!");
		
		//these 2 sections are to display when the right mouse button has been clicked, where the click was positioned, and when released.
		if(Input.getMouseDown(1))
			System.out.println("We've just right clicked at " + Input.getMousePosition().toString());
		if(Input.getMouseUp(1))
			System.out.println("We've just released right mouse button!");
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		mesh.draw();
	}

}
