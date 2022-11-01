package model;

import java.awt.Color;


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
   * Returns a 2D array of pixels for the image in its current state.
   *
   * <p>The pixels of an image are stored as a 2D array of {@link Color}s.</p>
   *
   * @return a copy of the pixels of the image
   */
  Pixel[][] getPixels();

  /**
   * Updates the image with the given pixels.
   *
   * @param pixels     the 2D array pixels of the updated image
   * @param logMessage the log message documenting the changes made to the image
   * @throws IllegalArgumentException if there is not at least one pixel in the given array
   */
  void update(Pixel[][] pixels, String logMessage) throws IllegalArgumentException;

  /**
   * Transforms the image using the given {@link ImageTransformation} macro.
   *
   * @param transformation the transformation to apply to the image
   * @throws IllegalArgumentException if the transformation is null
   */
  void transform(ImageTransformation transformation) throws IllegalArgumentException;

}
