package model.transformations;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import model.Image;
import model.ImageTransformation;

/**
 * Applies a flip transformation to an image.
 */
public abstract class Flip implements ImageTransformation {

  protected final int width;
  protected final int height;
  protected final Color[][] pixels;
  protected final String logMessage;

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
    List<Pixel> pixels = image.getPixels();
    List<Pixel> newPixels = new ArrayList<>();
    for (Pixel pixel : pixels) {
      Pixel flipped = this.flipPixel(pixel);
      newPixels.add(flipped);
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
  protected abstract void updateImage(ArrayList<Pixel> pixels);

}
