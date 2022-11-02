package model;

/**
 * Represents a pixel in an {@code Image}.
 */
public interface Pixel {

  /**
   * Gets the red value of the pixel.
   *
   * @return the pixel's red value as an integer
   */
  int getRed();

  /**
   * Gets the green value of the pixel.
   *
   * @return the pixel's green value as an integer
   */
  int getGreen();

  /**
   * Gets the blue value of the pixel.
   *
   * @return the pixel's blue value as an integer
   */
  int getBlue();

  /**
   * Gets the maximum value of a pixel's colors.
   *
   * @return the pixel's maximum color value as an integer
   */
  int getMaxValue();

}
