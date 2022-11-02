package model.transformations;

import model.Image;
import model.Pixel;

public class Darken extends Shade {

  private Image image;

  /**
   * Darkens the pixel of the image.
   *
   * @param pixel the pixel to be modified.
   * @param posInt the value that the pixel gets darkened.
   */
  @Override
  protected Pixel shadePixel(Pixel pixel, int posInt) {
    int red = pixel.getRed();
    int green = pixel.getGreen();
    int blue = pixel.getBlue();

    red -= posInt;
    green -= posInt;
    blue -= posInt;

    return new Pixel(pixel.getPosition().x, pixel.getPosition().y, red, green, blue);
  }

  /**
   * Updates the image with the given pixels.
   *
   * @param pixels
   */

  @Override
  protected void updateImage(Pixel[][] pixels) {
    this.image.update(pixels, "Image darkened.");
  }
}
