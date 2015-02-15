package com.base.engine;

public class MainComponent 
{
	// these 4 methods set the size of the window and the title that will be shown at the top border, and fps cap.
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "Jericho Engine";
	public static final double FRAME_CAP = 5000.0;
	
	//this variable is to tell us if our engine is actually running.
	private boolean isRunning;
	private Game game;
	
	public MainComponent()
	{
		System.out.println(RenderUtil.getOpenGLVersion());
		RenderUtil.initGraphics();
		isRunning = false;
		game = new Game();
	}
	
	//this is to start the game 
	public void start()
	{
		if(isRunning)
			return;
		
		run();
	}
	
	//this is to stop the game
	public void stop()
	{
		if(!isRunning)
			return;
				
		isRunning = false;		
	}
	
	//this is for while the game is running
	private void run()
	{
		isRunning = true; 
		
		int frames =0;
		long frameCounter = 0;
		
		//method below asks how long one frame takes.
		final double frameTime = 1.0 / FRAME_CAP;
		
		long lastTime = Time.getTime();
		double unprocessedTime = 0; 
		 
		
		while(isRunning)
		{
			boolean render = false;
			//all of the code below is to make time move between frames. 
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)Time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessedTime > frameTime)
			{
				render = true;
				unprocessedTime -= frameTime;
				
				//basically says if the X button is hit the game engine will stop running
				if(Window.isClosedRequested())
					stop();
				
				Time.setDelta(frameTime);
				Input.update();
				
				
				game.input();
				Input.update();
				
				game.update();
				
				if(frameCounter >= Time.SECOND)
				{
					//adding a FPS counter on screen
					System.out.println(frames);
					frames = 0;
					frameCounter = 0;
				}
			}
			if(render)
			{
			    render();
			    frames++;
			}
			else
			{
				try 
				{
					Thread.sleep(1);
				} 
				catch (InterruptedException e) 
				{
					
					e.printStackTrace();
				}
			}
		}
		
		cleanUp();
	}
	
	//this is for when we render
	private void render()
	{
		RenderUtil.clearScreen();
		game.render();
		Window.render();
	}
	
	//this is for when the game is finished running and we want to delete everything. 
	private void cleanUp()
	{
		Window.dispose();
	}
	
	public static void main(String[] args)
	{
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		MainComponent game = new MainComponent();
		
		game.start();
		
			
		
	}
}
