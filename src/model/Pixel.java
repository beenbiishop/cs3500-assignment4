package model;

import java.awt.Color;
import java.awt.Point;

/**
 * Represents a pixel in an image.
 */
public class Pixel {

  private final Point position;
  private final Color color;

  private int red;

  private int green;
  private int blue;


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
    this.red = color.getRed();
    this.green = color.getGreen();
    this.blue = color.getBlue();
  }

  /**
   * Constructs a new pixel with the given position and color as
   * @param x
   * @param y
   * @param r
   * @param g
   * @param b
   */
  public Pixel(int x, int y, int r, int g, int b) {
    this(new Point(x, y), new Color(r, g, b));
    this.red = r;
    this.green = g;
    this.blue = b;
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

  /**
   * Gets the color of the pixel as a {@link Color}.
   *
   * @return the color of the pixel.
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Gets the color of the pixel as a {@link Color}.
   *
   * @return the color of the pixel.
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Gets the color of the pixel as a {@link Color}.
   *
   * @return the color of the pixel.
   */
  public int getBlue() {
    return this.blue;
  }

  // TODO: Override equals and hashcode
}
