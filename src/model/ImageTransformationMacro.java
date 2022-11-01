package model;

import java.awt.Color;

public abstract class ImageTransformationMacro implements ImageTransformation {

  private final Image image;

  /**
   * Constructs a new image transformation macro.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public ImageTransformationMacro(Image image) throws IllegalArgumentException {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null");
    }
    this.image = image;
  }

  @Override
  public void apply(Image image) {
    Color[][] newPixels = this.changePixels();
    String logMessage = this.changeMessage();
    this.image.update(newPixels, logMessage);
  }

  /**
   * Changes each pixel of this {@code ImageTransformationMacro}'s image to a new color, based on
   * the specifications of the macro's subclass.
   *
   * @return an array of colors representing the new pixels of the image
   */
  private Color[][] changePixels() {
    Color[][] pixels = this.image.getPixels();
    int width = this.image.getWidth();
    int height = this.image.getHeight();
    for (int i = 0; i < pixels.length; i++) {
      for (int j = 0; j < pixels[i].length; j++) {
        pixels[i][j] = this.changePixel(pixels[i][j], width, height);
      }
    }
    return pixels;
  }

  /**
   * Changes the given pixel to a new {@link Color}, based on the specifications of the macro's
   * subclass.
   *
   * @param pixel  the pixel to change
   * @param width  the width of the image
   * @param height the height of the image
   * @return the new color of the pixel
   */
  protected abstract Color changePixel(Color pixel, int width, int height);

  /**
   * Returns a message for this {@code ImageTransformationMacro}'s image documenting the changes
   * made by the macro. Based on the specifications of the macro's subclass.
   *
   * @return the log message as a string
   */
  protected abstract String changeMessage();
}