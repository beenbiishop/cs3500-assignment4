package model.transformations;

import model.Image;
import model.RGBPixel;

public class Darken extends Shade {

  private Image image;

  /**
   * Constructs a shade (darkens the image) transformation.
   *
   * @param image  the image to apply the transformation to
   * @param posInt
   * @throws IllegalArgumentException if the image is null
   */
  public Darken(Image image, int posInt) throws IllegalArgumentException {
    super(image, posInt);
  }

  /**
   * Darkens the pixel of the image.
   *
   * @param pixel  the pixel to be modified.
   * @param posInt the value that the pixel gets darkened.
   */
  @Override
  protected RGBPixel shadePixel(RGBPixel pixel, int posInt) {
    int red = pixel.getRed();
    int green = pixel.getGreen();
    int blue = pixel.getBlue();

    red -= posInt;
    green -= posInt;
    blue -= posInt;

    return new RGBPixel(pixel.getPosition().x, pixel.getPosition().y, red, green, blue);
  }

  /**
   * Updates the image with the given pixels.
   *
   * @param pixels
   */

  @Override
  protected void updateImage(RGBPixel[][] pixels) {
    this.image.update(pixels, "Image darkened.");
  }
}
