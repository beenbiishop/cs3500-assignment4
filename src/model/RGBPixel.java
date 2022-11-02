package model;

/**
 * Represents a pixel in an {@link Image}.
 */
public class RGBPixel implements Pixel {

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
   * @throws IllegalArgumentException if any of the given values are negative or greater than the
   *                                  given maximum value
   */
  public RGBPixel(int red, int green, int blue, int maxValue) throws IllegalArgumentException {
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

  @Override
  public int getRed() {
    return this.red;
  }

  @Override
  public int getGreen() {
    return this.green;
  }

  @Override
  public int getBlue() {
    return this.blue;
  }

  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

}
