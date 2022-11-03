package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageImpl;
import model.ImageTransformation;

/**
 * An implementation of the {@link ImageTransformation} interface representing a macro used to flip
 * the pixels of an image vertically.
 */
public class VerticalFlip implements ImageTransformation {


  /**
   * Constructs a new vertical flip transformation macro object.
   */
  public VerticalFlip() {
  }

  @Override
  public Image transform(Image image) {
    Color[][] newPixels = new Color[image.getHeight()][image.getWidth()];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Color pixel = image.getPixels()[i][j];
        int y = image.getWidth() - j - 1;
        newPixels[i][y] = pixel;
      }
    }
    return new ImageImpl(newPixels);
  }
}