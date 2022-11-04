package controller;

import static org.junit.Assert.assertEquals;

import controller.commands.BrightnessCmd;
import controller.commands.HorizontalFlipCmd;
import controller.commands.VerticalFlipCmd;
import controller.commands.VisualizeCmd;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import model.Image;
import model.ImageImpl;
import model.StoredImages;
import model.StoredImagesImpl;
import model.transformations.Visualize.Channel;
import org.junit.Test;
import view.ImageProcessorView;
import view.ImageProcessorViewImpl;

/**
 * Contains all the testers for the controller and related classes. Tests each of the commands and
 * whether the controller parses and runs the program correctly.
 */
public class ImageControllerTest {

  @Test
  public void testPPMHandlerProcess() {
    String filePath = "res/ExampleImage.ppm";
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

  @Test
  public void testPPMHandlerExport() {
    String filePath = "res/ExampleImage.ppm";

    ImageUtil util = new ImageUtil();
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

    Image loadedImage = new ImageImpl(pixels);

    ImageFileHandler ppmHandler = new ImagePPMHandler();

    //idk why the imageUtil class here is not being recognized by java??
    assertEquals(util.readPPM(filePath), ppmHandler.export(loadedImage, filePath));
  }

  @Test
  public void testBrightnessCmd() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "BrightenedImage.ppm";
    ImageProcessorCmd brightened = new BrightnessCmd(view, store, 10, fileName, newFileName);
    brightened.execute();

    Color[][] pixels = new Color[3][3];
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[0].length; j++) {
        pixels[0][0] = new Color(138, 26, 226);
        pixels[0][1] = new Color(124, 27, 229);
        pixels[0][2] = new Color(115, 28, 232);
        pixels[1][0] = new Color(124, 27, 229);
        pixels[1][1] = new Color(107, 28, 234);
        pixels[1][2] = new Color(94, 28, 237);
        pixels[2][0] = new Color(115, 28, 232);
        pixels[2][1] = new Color(94, 28, 237);
        pixels[2][2] = new Color(71, 28, 241);

      }
    }

    Image brightenedImage = new ImageImpl(pixels);

    assertEquals(brightenedImage, store.retrieve(newFileName));
  }

  @Test
  public void testHorizontalFlip() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "HorizontalFlippedImage.ppm";
    ImageProcessorCmd horFlip = new HorizontalFlipCmd(view, store, fileName, newFileName);
    horFlip.execute();

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
    Image horizontalFLippedImage = new ImageImpl(newPixels);

    assertEquals(horizontalFLippedImage, store.retrieve(newFileName));
  }

  @Test
  public void testVerticalFlip() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "VerticallyFlippedImage.ppm";

    ImageProcessorCmd verFlip = new VerticalFlipCmd(view, store, fileName, newFileName);
    verFlip.execute();

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
    Image verticalFLippedImage = new ImageImpl(newPixels);

    assertEquals(verticalFLippedImage, store.retrieve(newFileName));
  }

  @Test
  public void testVisualizeCmd() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "RedVisualizedImage.ppm";

    ImageProcessorCmd visualizeRed = new VisualizeCmd(view, store, Channel.Red, fileName,
        newFileName);
    visualizeRed.execute();

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
    Image visualizedImage = new ImageImpl(newPixels);

    assertEquals(visualizedImage, store.retrieve(newFileName));
  }

  @Test
  public void testVisualizeGreen() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "GreenVisualizedImage.ppm";

    ImageProcessorCmd visualizeGreen = new VisualizeCmd(view, store, Channel.Green, fileName,
        newFileName);
    visualizeGreen.execute();

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
    Image visualizedImage = new ImageImpl(newPixels);

    assertEquals(visualizedImage, store.retrieve(newFileName));
  }

  @Test
  public void testVisualizeBlue() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "BlueVisualizedImage.ppm";

    ImageProcessorCmd visualizeBlue = new VisualizeCmd(view, store, Channel.Blue, fileName,
        newFileName);
    visualizeBlue.execute();

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
    Image visualizedImage = new ImageImpl(newPixels);

    assertEquals(visualizedImage, store.retrieve(newFileName));
  }

  @Test
  public void testVisualizeLuma() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "LumaVisualizedImage.ppm";

    ImageProcessorCmd visualizeLuma = new VisualizeCmd(view, store, Channel.Luma, fileName,
        newFileName);
    visualizeLuma.execute();

    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(54, 54, 54);
        newPixels[0][1] = new Color(52, 52, 52);
        newPixels[0][2] = new Color(51, 51, 51);

        newPixels[1][0] = new Color(52, 52, 52);
        newPixels[1][1] = new Color(50, 50, 50);
        newPixels[1][2] = new Color(47, 47, 47);

        newPixels[2][0] = new Color(51, 51, 51);
        newPixels[2][1] = new Color(47, 47, 47);
        newPixels[2][2] = new Color(43, 43, 43);

      }
    }
    Image visualizedImage = new ImageImpl(newPixels);

    assertEquals(visualizedImage, store.retrieve(newFileName));
  }

  @Test
  public void testVisualizeValue() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "ValueVisualizedImage.ppm";

    ImageProcessorCmd visualizeValue = new VisualizeCmd(view, store, Channel.Value, fileName,
        newFileName);
    visualizeValue.execute();

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
    Image visualizedImage = new ImageImpl(newPixels);

    assertEquals(visualizedImage, store.retrieve(newFileName));
  }

  @Test
  public void testVisualizeIntensity() {
    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);
    StoredImages store = new StoredImagesImpl();
    String fileName = "ExampleImage.ppm";
    String newFileName = "IntensityVisualizedImage.ppm";

    ImageProcessorCmd visualizeIntensity = new VisualizeCmd(view, store, Channel.Intensity,
        fileName, newFileName);
    visualizeIntensity.execute();

    Color[][] newPixels = new Color[3][3];
    for (int i = 0; i < newPixels.length; i++) {
      for (int j = 0; j < newPixels[0].length; j++) {
        newPixels[0][0] = new Color(120, 120, 120);
        newPixels[0][1] = new Color(117, 117, 117);
        newPixels[0][2] = new Color(115, 115, 115);
        newPixels[1][0] = new Color(117, 117, 117);
        newPixels[1][1] = new Color(113, 113, 113);
        newPixels[1][2] = new Color(110, 110, 110);
        newPixels[2][0] = new Color(115, 115, 115);
        newPixels[2][1] = new Color(110, 110, 110);
        newPixels[2][2] = new Color(104, 104, 104);

      }
    }
    Image visualizedImage = new ImageImpl(newPixels);

    assertEquals(visualizedImage, store.retrieve(newFileName));
  }


  //checks if the inputs are being parsed correctly
  @Test
  public void testControllerInput() {
    String userCommand = "brighten 10 koala koala-brighter";
    InputStream targetStream = new ByteArrayInputStream(userCommand.getBytes());
    Readable input = new InputStreamReader(targetStream);

    Appendable appendable = new StringBuilder();
    ImageProcessorView view = new ImageProcessorViewImpl(appendable);

    StoredImages store = new StoredImagesImpl();

    ImageProcessorController controller = new ImageProcessorControllerImpl(input, view, store);

    controller.run();

    assertEquals()

    //not too sure how to check this

    // make two tests here, one that checks that the script is being parsed correctly
    // another than checks that if the given input has an error, we handle it
  }


}
