package model;

/**
 * Represents a macro that can be applied to an {@link Image} to transform its pixels in some way.
 */
public interface ImageTransformation {

  /**
   * Applies this transformation to the given image.
   */
  void apply(Image image);
}
