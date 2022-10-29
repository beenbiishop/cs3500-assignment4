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
   * Gets the width of the Image.
   *
   * @return an integer representing the width.
   */
  int getWidth();

  /**
   * Gets the height of the Image.
   *
   * @return an integer representing the height.
   */
  int getHeight();

}
