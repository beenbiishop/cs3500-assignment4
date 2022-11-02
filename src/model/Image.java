package model;

/**
 * Represents an image and it's pixels.
 */
public interface Image {

  /**
   * Gets the width of the current state of the image.
   *
   * @return the width of the image as an integer
   */
  int getWidth();

  /**
   * Gets the height of the current state of the image.
   *
   * @return the height of the image as an integer
   */
  int getHeight();

  /**
   * Returns a 2D array of pixels {@code Pixel[width][height]} for the image in its current state.
   *
   * @return a copy of the 2D array of pixels for the image
   */
  RGBPixel[][] getPixels();

  /**
   * Updates the image with the given 2D array of pixels.
   *
   * @param pixels     the 2D array pixels of the updated image
   * @param logMessage the log message documenting the changes made to the image
   * @throws IllegalArgumentException if there is not at least one pixel in the given array
   */
  void update(RGBPixel[][] pixels, String logMessage) throws IllegalArgumentException;

  /**
   * Transforms the image using the given {@link ImageTransformation} macro.
   *
   * @param transformation the transformation to apply to the image
   * @throws IllegalArgumentException if the transformation is null
   */
  void transform(ImageTransformation transformation) throws IllegalArgumentException;

}
