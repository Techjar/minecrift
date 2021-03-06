package com.mtbs3d.minecrift.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Utils
{
	public static Field getDeclaredField(Class clazz, String unObfuscatedName, String obfuscatedName, String srgName)
	{
		Field field = null;
		String s = clazz.getName();

		try
		{
			field = clazz.getDeclaredField(unObfuscatedName);
		}
		catch (NoSuchFieldException e)
		{
			try
			{
				field = clazz.getDeclaredField(obfuscatedName);
			}
			catch (NoSuchFieldException e1)
			{
				try
				{
					field = clazz.getDeclaredField(srgName);
				}
				catch (NoSuchFieldException e2)
				{
					System.out.println("[Vivecraft] WARNING: could not reflect field :" + unObfuscatedName + "," + srgName + "," + obfuscatedName + " in " + clazz.toString());
				};
			};
		}

		return field;
	}
	
    /* With thanks to http://ramblingsrobert.wordpress.com/2011/04/13/java-word-wrap-algorithm/ */
    public static void wordWrap(String in, int length, ArrayList<String> wrapped)
    {
        String newLine = "\n";
        String wrappedLine;
        boolean quickExit = false;

        // Remove carriage return
        in = in.replace("\r", "");

        if(in.length() < length)
        {
            quickExit = true;
            length = in.length();
        }

        // Split on a newline if present
        if(in.substring(0, length).contains(newLine))
        {
            wrappedLine = in.substring(0, in.indexOf(newLine)).trim();
            wrapped.add(wrappedLine);
            wordWrap(in.substring(in.indexOf(newLine) + 1), length, wrapped);
            return;
        }
        else if (quickExit)
        {
            wrapped.add(in);
            return;
        }

        // Otherwise, split along the nearest previous space / tab / dash
        int spaceIndex = Math.max(Math.max( in.lastIndexOf(" ", length),
                in.lastIndexOf("\t", length)),
                in.lastIndexOf("-", length));

        // If no nearest space, split at length
        if(spaceIndex == -1)
            spaceIndex = length;

        // Split!
        wrappedLine = in.substring(0, spaceIndex).trim();
        wrapped.add(wrappedLine);
        wordWrap(in.substring(spaceIndex), length, wrapped);
    }
}
