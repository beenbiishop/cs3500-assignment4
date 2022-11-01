package model.transformations;

import java.awt.Color;

import model.Image;
import model.ImageTransformation;
import model.Pixel;

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
    Pixel[][] oldPixels = image.getPixels();
    Pixel[][] newPixels = new Pixel[this.image.getWidth()][this.image.getHeight()];
    for (Pixel[] pixels : oldPixels) {
      for (Pixel pixel : pixels) {
        Pixel flipped = this.flipPixel(pixel);
        newPixels[pixel.getPosition().x][pixel.getPosition().y]= flipped;
      }
    }
    this.updateImage(newPixels);
  }

  /**
   * Flips the pixel of the image.
   */
  protected abstract Pixel flipPixel(Pixel pixel);

  /**
   * Updates the image with the given pixels.
   *
   * @param pixels
   */
  protected abstract void updateImage(Pixel[][] pixels);

}
