package model;

/**
 * Represents a pixel in an {@link Image}.
 */
public class Pixel {

  private final int red;
  private final int green;
  private final int blue;
  private final int maxValue;

  /**
   * Construct a pixel with the given red, blue, and green values, as well as the maximum value of a
   * color in the pixel's image.
   *
   * @param red      the red value of the pixel
   * @param green    the green value of the pixel
   * @param blue     the blue value of the pixel
   * @param maxValue the maximum value of all colors in the pixel
   */
  public Pixel(int red, int green, int blue, int maxValue) {
    if (maxValue < 0) {
      throw new IllegalArgumentException("Max value cannot be negative");
    }
    if (red < 0 || red > maxValue) {
      throw new IllegalArgumentException("Red value must be between 0 and " + maxValue);
    }
    if (green < 0 || green > maxValue) {
      throw new IllegalArgumentException("Green value must be between 0 and " + maxValue);
    }
    if (blue < 0 || blue > maxValue) {
      throw new IllegalArgumentException("Blue value must be between 0 and " + maxValue);
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.maxValue = maxValue;
  }


  /**
   * Gets the red value of the pixel.
   *
   * @return the pixel's red value as an integer
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Gets the green value of the pixel.
   *
   * @return the pixel's green value as an integer
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Gets the blue value of the pixel.
   *
   * @return the pixel's blue value as an integer
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * Gets the maximum value of a pixel's colors.
   *
   * @return the pixel's maximum color value as an integer
   */
  public int getMaxValue() {
    return this.maxValue;
  }

}
