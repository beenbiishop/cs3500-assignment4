package model;

import java.awt.Color;

/**
 * Implements the {@link ImageTransformation} interface as an abstract class.
 *
 * <p>To implement a new image transformation, extend this class and implement the
 * {@link #changePixel(Pixel)} (Pixel)} method, and this parent class will apply that
 * transformation to each pixel of the given image.</p>
 */
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
    Pixel[][] newPixels = this.changePixels();
    String logMessage = this.changeMessage();
    this.image.update(newPixels, logMessage);
  }

  /**
   * Changes each pixel of this {@code ImageTransformationMacro}'s image to a new color, based on
   * the specifications of the macro's subclass.
   *
   * @return an array of colors representing the new pixels of the image
   */
  private Pixel[][] changePixels() {
    Pixel[][] pixels = this.image.getPixels();
    int width = this.image.getWidth();
    int height = this.image.getHeight();
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        pixels[i][j] = this.changePixel(pixels[i][j]);
      }
    }
    return pixels;
  }

  /**
   * Changes the given pixel to a new {@link Color}, based on the specifications of the macro's
   * subclass.
   *
   * @param pixel  the pixel to change
   * @return the new color of the pixel
   */
  protected abstract Pixel changePixel(Pixel pixel);

  /**
   * Returns a message for this {@code ImageTransformationMacro}'s image documenting the changes
   * made by the macro. Based on the specifications of the macro's subclass.
   *
   * @return the log message as a string
   */
  protected abstract String changeMessage();
}