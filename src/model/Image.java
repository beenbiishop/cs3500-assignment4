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
   * Updates the image with the given pixels and log message.
   *
   * @param pixels     the pixels to update the image with
   * @param logMessage a message with changes made to the image
   */
  void update(List<Pixel> pixels, String logMessage);

  // TODO: Ben work on visualize
  void visualize(VisualizeType type);

  // TODO: Smita work on flip/shade
  void flip(FlipType type);

  void shade(int val);

  enum VisualizeType {
    RED, GREEN, BLUE, VALUE, INTENSITY, LUMA
  }

  enum FlipType {
    HORIZONTAL, VERTICAL
  }
}
