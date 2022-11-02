package model.transformations;

import model.Image;
import model.ImageTransformation;
import model.RGBPixel;

/**
 * Applies a flip transformation to an image.
 */
public abstract class Flip implements ImageTransformation {

  protected final int width;
  protected final int height;
  private Image image;

  /**
   * Constructs a flip transformation.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public Flip(Image image) throws IllegalArgumentException {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null");
    }
    this.image = image;
    this.width = image.getWidth();
    this.height = image.getHeight();
  }

  @Override
  public void apply(Image image) {
    RGBPixel[][] oldPixels = image.getPixels();
    RGBPixel[][] newPixels = new RGBPixel[this.width][this.height];
    for (RGBPixel[] pixels : oldPixels) {
      for (RGBPixel pixel : pixels) {
        RGBPixel flipped = this.flipPixel(pixel);
        newPixels[pixel.getPosition().x][pixel.getPosition().y] = flipped;
      }
    }
    this.updateImage(newPixels);
  }

  /**
   * Flips the pixel of the image.
   */
  protected abstract RGBPixel flipPixel(RGBPixel pixel);

  /**
   * Updates the image with the given pixels.
   *
   * @param pixels
   */
  protected abstract void updateImage(RGBPixel[][] pixels);

}
