package model;

public interface Image {

  /**
   * Returns a map containing the pixels of this image.
   *
   * <p>A pixel contains two values: it's position in the image, and it's color in RGB format.</p>
   *
   * @return a copy of the pixels.
   */
  ArrayList<Pixel> getPixels();

  /**
   * Transforms an image to visualize a given color channel.
   *
   * <p>To visualize a color channel in an image, </p>
   *
   * @param channel the {@link ColorChannel} to visualize in the image
   */
  void visualize(ColorChannel channel);

  // TODO: Smita work on flip/shade
  void flip(FlipType type);

  void shade(int val);

  /**
   * Represents available color channels to visualize in an image.
   */
  enum ColorChannel {
    RED, GREEN, BLUE, VALUE, INTENSITY, LUMA
  }

  /**
   * Represents available axis to flip an image.
   */
  enum FlipType {
    HORIZONTAL, VERTICAL
  }
}
