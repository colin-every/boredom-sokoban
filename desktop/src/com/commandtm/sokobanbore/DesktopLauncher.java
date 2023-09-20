package com.commandtm.sokobanbore;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.commandtm.sokobanbore.sokobanBore;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Boredom Sokoban");
		config.setWindowedMode(630, 630);
		new Lwjgl3Application(new sokobanBore(), config);
	}
}
