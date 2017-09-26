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
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor, GestureDetector.GestureListener {
	private SpriteBatch batch;
	Sound throwSound;
	Music backgroundMusic;
	private Texture basketBallImg;
	private Texture goalImg;
	private Sprite ballSprite;
	private Sprite goalSprite;
	private int screenWidth;
	private int screenHeight;
	private float ballX, ballY, goalX,goalY;
	private float velocityBallx =0;
	private float velocityBally =0;
	private float velocityBallGlobaly =0;
	private boolean throwBall = false;

	@Override
	public void create () {

		batch = new SpriteBatch();
		GestureDetector input = new GestureDetector(this);
		Gdx.input.setInputProcessor(input);

		batch = new SpriteBatch();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();


		basketBallImg = new Texture("basketball.png");
		goalImg = new Texture("basketballGoal.png");

		ballSprite = new Sprite(basketBallImg);
		goalSprite = new Sprite(goalImg);
		goalSprite.setRotation(90);			//rotate image 90 degrees
		goalSprite.setSize(screenWidth/4,screenHeight/4);  //change size of the image according to screen size

		throwSound = Gdx.audio.newSound(Gdx.files.internal("sounds/throw.wav"));
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/carnival.wav"));
		backgroundMusic.play();
		backgroundMusic.setLooping(true);

		ballX = screenWidth- ballSprite.getWidth();
		ballY = screenHeight/2- ballSprite.getHeight()/2;
		goalX = 0-screenWidth/3;
		goalY = screenHeight/4- goalSprite.getHeight()/4;

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

		goalSprite.setX(goalX);
		goalSprite.setY(goalY);

		if(throwBall==true) {		//if ball was thrown, move it

			if(ballX -velocityBallx>0) {
				velocityBallx += 55;
				velocityBally = velocityBallGlobaly / 55;

				ballSprite.setX(ballX - velocityBallx);
				ballSprite.setY(ballY - velocityBally);
				ballY = ballY - velocityBally;
			}else{
				throwBall=false;
				ballY = screenHeight/2- ballSprite.getHeight()/2;
				velocityBallx=0;
				velocityBally=0;

			}


		}else{			//ball was not thrown, ball remains in place
			ballSprite.setX(ballX - velocityBallx);
			ballSprite.setY(ballY - velocityBally);
		}

		ballSprite.draw(batch);
		goalSprite.draw(batch);

		batch.end();
	}

	@Override
	public void dispose () {
		throwSound.dispose();
		backgroundMusic.dispose();
		basketBallImg.dispose();
		goalImg.dispose();
		batch.dispose();

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
