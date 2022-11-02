package model.transformations;

import model.Image;
import model.ImageTransformation;
import model.RGBPixel;

public abstract class Shade implements ImageTransformation {

  protected final int width;
  protected final int height;
  private Image image;

  private int posInt;

  /**
   * Constructs a shade transformation.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public Shade(Image image, int posInt) throws IllegalArgumentException {
    if (image == null || posInt < 0) {
      throw new IllegalArgumentException("Image cannot be null or integer must be positive.");
    }
    this.image = image;
    this.width = image.getWidth();
    this.height = image.getHeight();
    this.posInt = posInt;
  }

  /**
   * Applies this transformation to the given image.
   *
   * @param image  the image to be transformed
   * @param posInt the value that the image is shaded
   */
  @Override
  public void apply(Image image) {
    RGBPixel[][] oldPixels = image.getPixels();
    RGBPixel[][] newPixels = new RGBPixel[this.width][this.height];
    for (RGBPixel[] pixels : oldPixels) {
      for (RGBPixel pixel : pixels) {
        RGBPixel shaded = this.shadePixel(pixel, posInt);
        newPixels[pixel.getPosition().x][pixel.getPosition().y] = shaded;
      }
    }
    this.updateImage(newPixels);
  }

  /**
   * Shades the pixel of the image.
   */
  protected abstract RGBPixel shadePixel(RGBPixel pixel, int posInt);

  /**
   * Updates the image with the given pixels.
   *
   * @param pixels
   */
  protected abstract void updateImage(RGBPixel[][] pixels);

}


