package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
    private	SpriteBatch batch;
    private Texture bongo;
    private Texture imgAte;
    private ShapeRenderer shapeRenderer;
    private Rectangle parteASerTocadaUm;
    private Rectangle parteASerTocadaDois;
    private Rectangle parteASerTocadaTres;

    private Rectangle parteASerTocadaQuatro;
    private Rectangle parteASerTocadaCinco;
    private Sound somBongo;
    private Sound somBongo1;
    private Sound somBongo2;
    private Sound somBongo3;
    private Sound somBongo4;

	@Override
	public void create () {
		parteASerTocadaUm     = new Rectangle(550,700, 200, 300);
		parteASerTocadaDois   = new Rectangle(751, 700, 200, 300);
		parteASerTocadaTres   = new Rectangle(961,700, 200, 300);
		parteASerTocadaQuatro = new Rectangle(1261,700, 200, 300);
		parteASerTocadaCinco  = new Rectangle(1461,700, 200, 300);

		somBongo = Gdx.audio.newSound(Gdx.files.internal("bongo1.mp3"));
		somBongo1 = Gdx.audio.newSound(Gdx.files.internal("bongo2.mp3"));
		somBongo2 = Gdx.audio.newSound(Gdx.files.internal("bongo3.mp3"));
        somBongo3 = Gdx.audio.newSound(Gdx.files.internal("bongo4.mp3"));
        somBongo4 = Gdx.audio.newSound(Gdx.files.internal("bongo5.mp3"));


		batch = new SpriteBatch();
		bongo = new Texture("bongo/bongo1.png");
        imgAte = new Texture("export.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		batch.begin();
        batch.draw(imgAte, 20, 500, 400, 600);
		batch.draw(bongo, 500, 75,1300,1000);
		batch.end();

		if (Gdx.input.justTouched()) {
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
            final int xAux = x;
            final int yAux = y;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    tocarPrimeiraParte(xAux,0);
                    tocarSegundaParte(xAux, yAux);
                }
            }).start();

            tocarTerceiraParte(x, y);
            tocarParteQuatro(x, y);
            tocarParteCinco(x, y);

        }

	}

	private void tocarPrimeiraParte(int largura, int altura) {
        if (largura >= parteASerTocadaUm.x && largura <= parteASerTocadaUm.y) {
            somBongo.play();
        }
    }

    private void tocarSegundaParte( int x, int y) {
        if ((x >= 744 && x <= 960) & (y >= parteASerTocadaDois.getHeight()- parteASerTocadaDois.y - y  && y <= 410 )) {
            somBongo1.play();
        }
    }

    private void tocarTerceiraParte(int x, int y) {
        if ((x >= parteASerTocadaTres.getX() && x <= 1150) & (y >= 50 && y <= 390 )) {
            somBongo2.play();
            somBongo1.play();
        }
    }

    private void tocarParteQuatro(int x, int y) {
        if ((x >= 1350 && x <= 1510 & y > 120 && y < parteASerTocadaQuatro.y - parteASerTocadaQuatro.getHeight())) {
            somBongo4.play();
        }
    }

    private void tocarParteCinco(int x, int y) {
        if ((x >= 1510 && x <= 1700 & y > 120 && y < parteASerTocadaCinco.y - parteASerTocadaCinco.getHeight() )) {
            somBongo3.play();
        }
    }

	@Override
	public void dispose () {
		batch.dispose();
		bongo.dispose();
        somBongo1.dispose();
        somBongo2.dispose();
        somBongo3.dispose();
        somBongo4.dispose();
	}
}
