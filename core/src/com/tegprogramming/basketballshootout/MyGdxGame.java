package com.tegprogramming.basketballshootout;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor, GestureDetector.GestureListener {
	private SpriteBatch batch;
	Sound throwSound;
	Music backgroundMusic;
	private Texture img;
	private Sprite sprite;
	private static GlyphLayout glyphLayout = new GlyphLayout();
	private int screenWidth;
	private int screenHeight;
	private float x,y;
	private float velocityBallx =0;
	private float velocityBally =0;
	private float velocityBallGlobaly =0;
	private boolean throwBall = false;
	private float volocityBall = 0;

	@Override
	public void create () {

		batch = new SpriteBatch();
	//	Gdx.input.setInputProcessor(this);
		GestureDetector input = new GestureDetector(this);
		Gdx.input.setInputProcessor(input);

		batch = new SpriteBatch();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		img = new Texture("basketball.png");
		sprite = new Sprite(img);

		throwSound = Gdx.audio.newSound(Gdx.files.internal("sounds/throw.wav"));
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/carnival.wav"));
		backgroundMusic.play();
		backgroundMusic.setLooping(true);

		x = screenWidth-sprite.getWidth();
		y = screenHeight/2-sprite.getHeight()/2;



	}
	@Override
	public void pause() {

		super.pause();
	}

	@Override
	public void resume() {
	//	backgroundMusic.play();

		super.resume();
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		batch.begin();

		if(throwBall==true) {		//if ball was thrown, move it

			if(x-velocityBallx>0) {
				velocityBallx += 55;
				velocityBally = velocityBallGlobaly / 55;

				sprite.setX(x - velocityBallx);
				sprite.setY(y - velocityBally);
				y = y - velocityBally;
			}else{
				throwBall=false;
				y= screenHeight/2-sprite.getHeight()/2;
				velocityBallx=0;
				velocityBally=0;

			}


		}else{
			sprite.setX(x- velocityBallx);
			sprite.setY(y- velocityBally);
		}



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

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {


		return true;
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

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {

		throwBall = true;		//ball was just thrown
		velocityBallGlobaly = velocityY;

		return true;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {		//find swipe angle


		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {





		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public void pinchStop() {

	}
}
