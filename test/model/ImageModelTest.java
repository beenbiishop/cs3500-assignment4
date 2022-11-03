package model;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import model.transformations.HorizontalFlip;
import model.transformations.VerticalFlip;
import org.junit.Test;

/**
 * Contains the testers for all the interfaces, classes, and methods contained in the model package.
 * This includes testing whether each of the {@code ImageTransformations} are correctly transforming
 * the images.
 */
public class ImageModelTest {

  @Test
  public void testHorizontalFlip() {
    Color[][] pixels = new Color[3][3];
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[0][0] = new Color(128, 16, 216);
        pixels[0][1] = new Color(114, 17, 219);
        pixels[0][2] = new Color(105, 18, 222);
        pixels[1][0] = new Color(114, 17, 219);
        pixels[1][1] = new Color(97, 18, 224);
        pixels[1][2] = new Color(84, 18, 227);
        pixels[2][0] = new Color(105, 18, 222);
        pixels[2][1] = new Color(84, 18, 227);
        pixels[2][2] = new Color(61, 18, 231);

      }
    }

    Image beforeFlipImage = new ImageImpl(pixels);

    ImageTransformation horFlip = new HorizontalFlip();
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[2][0] = new Color(128, 16, 216);
        newPixels[2][1] = new Color(114, 17, 219);
        newPixels[2][2] = new Color(105, 18, 222);

        newPixels[1][0] = new Color(114, 17, 219);
        newPixels[1][1] = new Color(97, 18, 224);
        newPixels[1][2] = new Color(84, 18, 227);

        newPixels[0][0] = new Color(105, 18, 222);
        newPixels[0][1] = new Color(84, 18, 227);
        newPixels[0][2] = new Color(61, 18, 231);

      }
    }

    Image afterHorFlip = new ImageImpl(newPixels);

    assertEquals(afterHorFlip, horFlip.transform(beforeFlipImage));
  }

  @Test
  public void testVerticalFlip() {
    Color[][] pixels = new Color[3][3];
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[0][0] = new Color(128, 16, 216);
        pixels[0][1] = new Color(114, 17, 219);
        pixels[0][2] = new Color(105, 18, 222);
        pixels[1][0] = new Color(114, 17, 219);
        pixels[1][1] = new Color(97, 18, 224);
        pixels[1][2] = new Color(84, 18, 227);
        pixels[2][0] = new Color(105, 18, 222);
        pixels[2][1] = new Color(84, 18, 227);
        pixels[2][2] = new Color(61, 18, 231);

      }
    }

    Image beforeFlipImage = new ImageImpl(pixels);

    ImageTransformation verFlip = new VerticalFlip();
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][2] = new Color(128, 16, 216);
        newPixels[0][1] = new Color(114, 17, 219);
        newPixels[0][0] = new Color(105, 18, 222);

        newPixels[1][2] = new Color(114, 17, 219);
        newPixels[1][1] = new Color(97, 18, 224);
        newPixels[1][0] = new Color(84, 18, 227);

        newPixels[2][2] = new Color(105, 18, 222);
        newPixels[2][1] = new Color(84, 18, 227);
        newPixels[2][0] = new Color(61, 18, 231);

      }
    }

    Image afterHorFlip = new ImageImpl(newPixels);

    assertEquals(afterHorFlip, verFlip.transform(beforeFlipImage));
  }

}
