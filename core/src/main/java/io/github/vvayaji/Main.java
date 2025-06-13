package io.github.vvayaji;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    BitmapFont font;


    @Override
    public void create() {
        batch = new SpriteBatch();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/NotoSansJP-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        parameter.characters = "あのイーハトーヴォのすきとおった風、夏でも底に冷たさをもつ青いそら、うつくしい森で飾られたモリーオ市、郊外のぎらぎらひかる草の波。祇辻飴葛蛸鯖鰯噌庖箸ABCDEFGHIJKLMabcdefghijklm1234567890";

        font = generator.generateFont(parameter);
        font.setColor(Color.WHITE);
        generator.dispose();
        if (font == null) {
            System.out.println("Font generation failed. Please check the font file path and format.");
        } else {
            System.out.println("Font generated successfully.");
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        font.draw(batch, "あのイーハトーヴォの\n" +
            "すきとおった風、\n" +
            "夏でも底に冷たさをもつ青いそら、\n" +
            "うつくしい森で飾られたモリーオ市、\n" +
            "郊外のぎらぎらひかる草の波。\n" +
            "祇辻飴葛蛸鯖鰯噌庖箸\n" +
            "ABCDEFGHIJKLM\n" +
            "abcdefghijklm\n" +
            "1234567890", 100, Gdx.graphics.getHeight() - 100);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
