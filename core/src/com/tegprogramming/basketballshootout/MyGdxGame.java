package com.tegprogramming.basketballshootout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private BitmapFont font;
	private TextureAtlas explosionAtlas;
	private Animation animation;
	private float timePassed =0;
	private Texture img;
	private int screenWidth;
	private int screenHeight;
	private String message = "Touch me";
	private Sprite sprite;
	private static GlyphLayout glyphLayout = new GlyphLayout();

	@Override
	public void create () {

		batch = new SpriteBatch();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		font = new BitmapFont();
		font.setColor(com.badlogic.gdx.graphics.Color.GREEN);
		font.getData().scale(5);

		Gdx.input.setInputProcessor(this);


		//explosionAtlas = new TextureAtlas(Gdx.files.internal("explosion.atlas"));
		//animation = new Animation(1/10f,explosionAtlas.getRegions());


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		glyphLayout.setText(font,message);

		float x = screenWidth/2-glyphLayout.width/2;
		float y = screenHeight/2+glyphLayout.height/2;


		batch.begin();

	//	timePassed += Gdx.graphics.getDeltaTime();
	//	batch.draw((TextureRegion) animation.getKeyFrame(timePassed,true),300,500);

		font.draw(batch,message,x,y);


		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		//explosionAtlas.dispose();
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		message = "Touch down at " +screenX+", "+screenY;

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		message = "Touch up at " +screenX+", "+screenY;


		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

		//message = "Touch down at " +screenX+", "+screenY;


		return false;
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
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
