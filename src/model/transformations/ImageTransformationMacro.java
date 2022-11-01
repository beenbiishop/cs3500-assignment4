package model.transformations;

import model.Image;
import model.ImageTransformation;

public abstract class ImageTransformationMacro implements ImageTransformation {

  private final Image image;

  /**
   * Constructs a new image transformation macro.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public ImageTransformationMacro(Image image) throws IllegalArgumentException {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null");
    }
    this.image = image;
  }

  @Override
  public void apply(Image image) {
    this.applyMacro(image);
  }

  public abstract void a(Image image);
}