package model;

import java.awt.Color;


/**
 * Implements the {@link Image} interface.
 *
 * <p>Each image is represented by a 2D array of colors {@code Color[height][width]} that
 * represents its pixels. A pixel's x value is it's column (width) index in the 2D array, and a
 * pixel's y value it it's row (height) index in the 2D array.</p>
 */
public class ImageImpl implements Image {

    private final int width;
    private final int height;
    private final RGBPixel[][] pixels;
    private final String logMessage;

  /**
   * Constructs a new {@link ImageImpl} with the given pixels.
   *
   * @param pixels the pixels of this image state as a 2D array {@code Color[height][width]}
   * @throws IllegalArgumentException if there is not at least one color in the given array.
   */
  public ImageImpl(Color[][] pixels) throws IllegalArgumentException {
    if (pixels == null || pixels.length == 0 || pixels[0].length == 0) {
      throw new IllegalArgumentException("The pixels array must contain at least one pixel");
    }
    this.pixels = pixels;
  }

  /**
   * Gets the width of this image.
   *
   * @return the width of the image as an integer
   */
  public int getWidth() {
    int width = this.pixels.length;
    return width;
  }

  /**
   * Gets the height of this image.
   *
   * @return the height of the image as an integer
   */
  public int getHeight() {
    int height = this.pixels[0].length;
    return height;
  }

  /**
   * Gets a copy of this image state's pixels.
   *
   * @return the pixels of the image state as a 2D array of {@link Color}s in the format
   * {@code Color[height][width]}
   */
  public Color[][] getPixels() {
    return this.pixels.clone();
  }
}


