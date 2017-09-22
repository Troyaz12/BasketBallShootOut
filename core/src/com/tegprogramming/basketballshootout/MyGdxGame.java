package com.tegprogramming.basketballshootout;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	Sound throwSound;
	Music backgroundMusic;
	private Texture img;
	private Sprite sprite;

	@Override
	public void create () {

		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);

		batch = new SpriteBatch();

		img = new Texture("basketball.jpg");
		sprite = new Sprite(img);

		throwSound = Gdx.audio.newSound(Gdx.files.internal("sounds/throw.wav"));
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/carnival.wav"));
		backgroundMusic.play();
		backgroundMusic.setLooping(true);

	}
	@Override
	public void pause() {

		super.pause();
	}

	@Override
	public void resume() {
		backgroundMusic.play();

		super.resume();
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		sprite.draw(batch);

		batch.end();
	}

	@Override
	public void dispose () {
		throwSound.dispose();
		backgroundMusic.dispose();
		batch.dispose();
		img.dispose();

	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {


		throwSound.play();


		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
