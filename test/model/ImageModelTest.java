package model;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import model.transformations.Brightness;
import model.transformations.HorizontalFlip;
import model.transformations.VerticalFlip;
import model.transformations.Visualize;
import model.transformations.Visualize.Channel;
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
        newPixels[0][0] = new Color(105, 18, 222);
        newPixels[0][1] = new Color(114, 17, 219);
        newPixels[0][2] = new Color(128, 16, 216);

        newPixels[1][0] = new Color(84, 18, 227);
        newPixels[1][1] = new Color(97, 18, 224);
        newPixels[1][2] = new Color(114, 17, 219);

        newPixels[2][0] = new Color(61, 18, 231);
        newPixels[2][1] = new Color(84, 18, 227);
        newPixels[2][2] = new Color(105, 18, 222);


      }
    }

    assertEquals(newPixels, horFlip.transform(beforeFlipImage).getPixels());
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
        newPixels[0][0] = new Color(105, 18, 222);
        newPixels[0][1] = new Color(84, 18, 227);
        newPixels[0][2] = new Color(61, 18, 231);

        newPixels[1][0] = new Color(114, 17, 219);
        newPixels[1][1] = new Color(97, 18, 224);
        newPixels[1][2] = new Color(84, 18, 227);

        newPixels[2][0] = new Color(128, 16, 216);
        newPixels[2][1] = new Color(114, 17, 219);
        newPixels[2][2] = new Color(105, 18, 222);


      }
    }

    assertEquals(newPixels, verFlip.transform(beforeFlipImage).getPixels());
  }

  @Test
  public void testBrightness() {
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

    Image beforeTransformationImage = new ImageImpl(pixels);

    ImageTransformation brightness = new Brightness(10);
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(138, 26, 226);
        newPixels[0][1] = new Color(124, 27, 229);
        newPixels[0][2] = new Color(115, 28, 232);

        newPixels[1][0] = new Color(124, 27, 229);
        newPixels[1][1] = new Color(107, 28, 234);
        newPixels[1][2] = new Color(94, 28, 237);

        newPixels[2][0] = new Color(115, 28, 232);
        newPixels[2][1] = new Color(94, 28, 237);
        newPixels[2][2] = new Color(71, 28, 241);


      }
    }

    assertEquals(newPixels, brightness.transform(beforeTransformationImage).getPixels());
  }

  @Test
  public void testVisualizeRed() {
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

    Image beforeTransformationImage = new ImageImpl(pixels);

    ImageTransformation visualizeRed = new Visualize(Channel.Red);
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(128, 128, 128);
        newPixels[0][1] = new Color(114, 114, 114);
        newPixels[0][2] = new Color(105, 105, 105);

        newPixels[1][0] = new Color(114, 114, 114);
        newPixels[1][1] = new Color(97, 97, 97);
        newPixels[1][2] = new Color(84, 84, 84);

        newPixels[2][0] = new Color(105, 105, 105);
        newPixels[2][1] = new Color(84, 84, 84);
        newPixels[2][2] = new Color(61, 61, 61);


      }
    }

    assertEquals(newPixels, visualizeRed.transform(beforeTransformationImage).getPixels());
  }

  @Test
  public void testVisualizeGreen() {
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

    Image beforeTransformationImage = new ImageImpl(pixels);

    ImageTransformation visualizeGreen = new Visualize(Channel.Green);
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(16, 16, 16);
        newPixels[0][1] = new Color(17, 17, 17);
        newPixels[0][2] = new Color(18, 18, 18);

        newPixels[1][0] = new Color(17, 17, 17);
        newPixels[1][1] = new Color(18, 18, 18);
        newPixels[1][2] = new Color(18, 18, 18);

        newPixels[2][0] = new Color(18, 18, 18);
        newPixels[2][1] = new Color(18, 18, 18);
        newPixels[2][2] = new Color(18, 18, 18);


      }
    }

    assertEquals(newPixels, visualizeGreen.transform(beforeTransformationImage).getPixels());
  }

  @Test
  public void testVisualizeBlue() {
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

    Image beforeTransformationImage = new ImageImpl(pixels);

    ImageTransformation visualizeBlue = new Visualize(Channel.Blue);
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(216, 216, 216);
        newPixels[0][1] = new Color(219, 219, 219);
        newPixels[0][2] = new Color(222, 222, 222);

        newPixels[1][0] = new Color(219, 219, 219);
        newPixels[1][1] = new Color(224, 224, 224);
        newPixels[1][2] = new Color(227, 227, 227);

        newPixels[2][0] = new Color(222, 222, 222);
        newPixels[2][1] = new Color(227, 227, 227);
        newPixels[2][2] = new Color(231, 231, 231);


      }
    }

    assertEquals(newPixels, visualizeBlue.transform(beforeTransformationImage).getPixels());
  }

  @Test
  public void testVisualizeLuma() {
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

    Image beforeTransformationImage = new ImageImpl(pixels);

    ImageTransformation visualizeLuma = new Visualize(Channel.Luma);
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(54, 54, 54);
        newPixels[0][1] = new Color(52, 52, 52);
        newPixels[0][2] = new Color(51, 51, 51);

        newPixels[1][0] = new Color(52, 52, 52);
        newPixels[1][1] = new Color(49, 49, 49);
        newPixels[1][2] = new Color(47, 47, 47);

        newPixels[2][0] = new Color(51, 51, 51);
        newPixels[2][1] = new Color(47, 47, 47);
        newPixels[2][2] = new Color(42, 42, 42);


      }
    }

    assertEquals(newPixels, visualizeLuma.transform(beforeTransformationImage).getPixels());
  }

  @Test
  public void testVisualizeValue() {
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

    Image beforeTransformationImage = new ImageImpl(pixels);

    ImageTransformation visualizeValue = new Visualize(Channel.Value);
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(216, 216, 216);
        newPixels[0][1] = new Color(219, 219, 219);
        newPixels[0][2] = new Color(222, 222, 222);
        newPixels[1][0] = new Color(219, 219, 219);
        newPixels[1][1] = new Color(224, 224, 224);
        newPixels[1][2] = new Color(227, 227, 227);
        newPixels[2][0] = new Color(222, 222, 222);
        newPixels[2][1] = new Color(227, 227, 227);
        newPixels[2][2] = new Color(231, 231, 231);

      }
    }

    assertEquals(newPixels, visualizeValue.transform(beforeTransformationImage).getPixels());
  }

  @Test
  public void testVisualizeIntensity() {
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

    Image beforeTransformationImage = new ImageImpl(pixels);

    ImageTransformation visualizeIntensity = new Visualize(Channel.Intensity);
    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(120, 120, 120);
        newPixels[0][1] = new Color(116, 116, 116);
        newPixels[0][2] = new Color(115, 115, 115);
        newPixels[1][0] = new Color(116, 116, 116);
        newPixels[1][1] = new Color(113, 113, 113);
        newPixels[1][2] = new Color(109, 109, 109);
        newPixels[2][0] = new Color(115, 115, 115);
        newPixels[2][1] = new Color(109, 109, 109);
        newPixels[2][2] = new Color(103, 103, 103);


      }
    }

    assertEquals(newPixels, visualizeIntensity.transform(beforeTransformationImage).getPixels());
  }
}