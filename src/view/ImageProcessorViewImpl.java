package view;

import java.io.IOException;

public class ImageProcessorViewImpl implements ImageProcessorView {

  private Appendable appendable;

  /**
   * Constructs a new ImageProcessorViewImpl object with the given appendable.
   *
   * @param appendable the appendable to append the text to
   */
  public ImageProcessorViewImpl(Appendable appendable) {
    this.appendable = appendable;
  }

  @Override
  public void renderMessage(String message) throws IllegalStateException {
    try {
      this.appendable.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("Unable to render message");
    }
  }


  @Override
  public void renderMenu() throws IOException {
    this.appendable.append("load <filename> - loads the image from the given file\n");
    this.appendable.append("save <filename> - saves the image to the given file\n");
    this.appendable.append("menu - displays the menu of commands\n");
    this.appendable.append("brighten - brightens the image\n");
    this.appendable.append("darken - darkens the image\n");
    this.appendable.append("horizontal-flip - flips the image horizontally\n");
    this.appendable.append("vertical-flip - flips the image vertically\n");
    this.appendable.append("red-component - displays the red component of the image\n");
    this.appendable.append("blue-component - displays the blue component of the image\n");
    this.appendable.append("green-component - displays the green component of the image\n");
    this.appendable.append("sharpen - sharpens the image\n");
    this.appendable.append("sepia - applies a sepia filter to the image\n");
    this.appendable.append("greyscale - converts the image to greyscale\n");
    this.appendable.append("dither - dithers the image\n");
    this.appendable.append("mosaic - mosaics the image\n");
    this.appendable.append("generate - generates a new image\n");
    this.appendable.append("pattern - applies a pattern to the image\n");
    this.appendable.append("flag - applies a flag to the image\n");
    this.appendable.append("quit - quits the program\n");
  }

  @Override
  public void welcomeMessage() throws IOException {
    this.appendable.append("Welcome! Please load an image.");
  }

}
