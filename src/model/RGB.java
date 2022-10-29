package model;

/**
 * Represents the RGB values of a pixel.
 */
public class RGB {

  private final int red;
  private final int green;
  private final int blue;

  /**
   * Constructs a new RGB object with the given red, green, and blue values.
   *
   * @param red   the red value
   * @param green the green value
   * @param blue  the blue value
   * @throws IllegalArgumentException if the red, green, or blue values are not in the range [0,
   *                                  255]
   */
  public RGB(int red, int green, int blue) {
    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Red value must be between 0 and 255");
    }
    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Green value must be between 0 and 255");
    }
    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Blue value must be between 0 and 255");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Get the red value of this RGB object.
   *
   * @return the red value
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Get the green value of this RGB object.
   *
   * @return the green value
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Get the blue value of this RGB object.
   *
   * @return the blue value
   */
  public int getBlue() {
    return this.blue;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof RGB) {
      RGB other = (RGB) o;
      return this.red == other.red && this.green == other.green && this.blue == other.blue;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return this.red + this.green + this.blue;
  }
}
