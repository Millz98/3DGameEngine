package com.base.engine;

//Our time system and how we manage time.
public class Time 
{
	public static final long SECOND = 1000000000L;
	private static double delta;
	
	public static long getTime()
	{
		return System.nanoTime();
		
	}
	
	//this method will return the amount of time that passes between frames.
	public static double getDelta()
	{
		return delta;
	}
	
	
	public static void setDelta(double delta)
	{
		Time.delta = delta;
	}
}
