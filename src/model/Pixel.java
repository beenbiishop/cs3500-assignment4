package model;

import java.awt.Color;
import java.awt.Point;

/**
 * Represents a pixel in an image.
 */
public class Pixel {

  private final Point position;
  private final Color color;

  /**
   * Constructs a new pixel with the given position and color.
   *
   * @param position the position of the pixel.
   * @param color    the color of the pixel.
   */
  public Pixel(Point position, Color color) {
    if (position == null) {
      throw new IllegalArgumentException("Position cannot be null");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }
    this.position = position;
    this.color = color;
  }

  /**
   * Gets the position of the pixel as a {@link Point}.
   *
   * @return the position of the pixel.
   */
  public Point getPosition() {
    return this.position;
  }

  /**
   * Gets the color of the pixel as a {@link Color}.
   *
   * @return the color of the pixel.
   */
  public Color getColor() {
    return this.color;
  }

  // TODO: Override equals and hashcode
}
