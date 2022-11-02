package model.transformations;

import model.Image;
import model.RGBPixel;

public class Brighten extends Shade {

  private Image image;

  /**
   * Constructs a new "Brighten" transformation with the given image.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public Brighten(Image image, int posInt) throws IllegalArgumentException {
    super(image, posInt);
    this.image = image;
  }

  /**
   * Brightens the pixel of the image.
   *
   * @param pixel  the pixel to be modified.
   * @param posInt the value that the pixel gets brightened.
   */
  protected RGBPixel shadePixel(RGBPixel pixel, int posInt) {
    int red = pixel.getRed();
    int green = pixel.getGreen();
    int blue = pixel.getBlue();

    red += posInt;
    green += posInt;
    blue += posInt;

    return new RGBPixel(pixel.getPosition().x, pixel.getPosition().y, red, green, blue);
  }

  /**
   * Applies this transformation to the given image.
   *
   * @param pixels the new pixels to add to the image stack.
   */
  @Override
  protected void updateImage(RGBPixel[][] pixels) {
    this.image.update(pixels, "Image brightened.");
  }
}
