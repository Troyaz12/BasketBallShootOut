package com.tegprogramming.basketballshootout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private BitmapFont font;
	private TextureAtlas explosionAtlas;
	private Animation animation;
	private float timePassed =0;
	private Texture img;
	private Sprite sprite;
	@Override
	public void create () {

		batch = new SpriteBatch();

		explosionAtlas = new TextureAtlas(Gdx.files.internal("explosion.atlas"));
		animation = new Animation(1/10f,explosionAtlas.getRegions());


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		timePassed += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion) animation.getKeyFrame(timePassed,true),300,500);



		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		explosionAtlas.dispose();
	}
}
