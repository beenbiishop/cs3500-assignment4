package controller;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import model.Image;
import model.ImageImpl;
import model.ImageTransformation;
import model.transformations.HorizontalFlip;
import model.transformations.VerticalFlip;
import org.junit.Test;

public class ImageControllerTest {

  @Test
  public void testPPMHandlerProcess() {
    String filePath = "C:/Users/sm1se/Documents/OOD/cs3500-assignment4/res/exampleImage.ppm";
    //this is what my file path is, i made 3 x 3 image for testing purposes

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

    Image expectedImage = new ImageImpl(pixels);

    ImageFileHandler ppmHandler = new ImagePPMHandler();

    assertEquals(expectedImage, ppmHandler.process(filePath));
  }

//  @Test
//  public void testPPMHandlerExport() {
//    String filePath = "C:/Users/sm1se/Documents/OOD/cs3500-assignment4/res/exampleImage.ppm";
//    //this is what my file path is, i made 3 x 3 image for testing purposes
//
//    ImageUtil util = new ImageUtil();
//    Color[][] pixels = new Color[3][3];
//    for (int i = 0; i < pixels.length; i++) {
//      for (int j = 0; j < pixels[0].length; j++) {
//        pixels[0][0] = new Color(128, 16, 216);
//        pixels[0][1] = new Color(114, 17, 219);
//        pixels[0][2] = new Color(105, 18, 222);
//        pixels[1][0] = new Color(114, 17, 219);
//        pixels[1][1] = new Color(97, 18, 224);
//        pixels[1][2] = new Color(84, 18, 227);
//        pixels[2][0] = new Color(105, 18, 222);
//        pixels[2][1] = new Color(84, 18, 227);
//        pixels[2][2] = new Color(61, 18, 231);
//
//      }
//    }
//
//    Image loadedImage = new ImageImpl(pixels);
//
//    ImageFileHandler ppmHandler = new ImagePPMHandler();
//
//    //idk why the imageUtil class here is not being recognized by java??
//
//    assertEquals(file.readPPM(), ppmHandler.export(loadedImage, filePath));
//  }

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
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[2][0] = new Color(128, 16, 216);
        pixels[2][1] = new Color(114, 17, 219);
        pixels[2][2] = new Color(105, 18, 222);

        pixels[1][0] = new Color(114, 17, 219);
        pixels[1][1] = new Color(97, 18, 224);
        pixels[1][2] = new Color(84, 18, 227);

        pixels[0][0] = new Color(105, 18, 222);
        pixels[0][1] = new Color(84, 18, 227);
        pixels[0][2] = new Color(61, 18, 231);

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
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[2][0] = new Color(128, 16, 216);
        pixels[2][1] = new Color(114, 17, 219);
        pixels[2][2] = new Color(105, 18, 222);

        pixels[1][0] = new Color(114, 17, 219);
        pixels[1][1] = new Color(97, 18, 224);
        pixels[1][2] = new Color(84, 18, 227);

        pixels[0][0] = new Color(105, 18, 222);
        pixels[0][1] = new Color(84, 18, 227);
        pixels[0][2] = new Color(61, 18, 231);

      }
    }

    Image afterHorFlip = new ImageImpl(newPixels);

    assertEquals(afterHorFlip, verFlip.transform(beforeFlipImage));
  }
}
