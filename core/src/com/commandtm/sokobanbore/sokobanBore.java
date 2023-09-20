package com.commandtm.sokobanbore;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class sokobanBore extends ApplicationAdapter {
	SpriteBatch batch;
	Texture blank;
	Texture wall;
	Texture player;
	OrthographicCamera camera;
	board board = new board();
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 630, 630);
		board.boardMake();
		batch = new SpriteBatch();
		blank = new Texture("blank.png");
		wall = new Texture("wall.png");
		player = new Texture("player.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.06f, 0.67f, 0.16f, 1);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (int k = 0; k < board.length; k++){
			for (int i = 0; i < 10; i++){
				switch (board[k][i]){
					case 0:
						batch.draw(blank, 20+(60*i), 20+(60*k));
						break;
					case 1:
						batch.draw(wall, 20+(60*i), 20+(60*k));
						break;
					case 2:
						batch.draw(player, 20+(60*i), 20+(60*k));
						break;
				}
			}
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		blank.dispose();
	}
}
