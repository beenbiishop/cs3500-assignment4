package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageImpl;
import model.ImageTransformation;

/**
 * An implementation of the {@link ImageTransformation} interface representing a macro used to flip
 * the pixels of an image horizontally.
 */
public class HorizontalFlip implements ImageTransformation {


  /**
   * Constructs a new horizontal flip transformation macro object.
   */
  public HorizontalFlip() {
  }

  @Override
  public Image transform(Image image) {
    Color[][] newPixels = new Color[image.getHeight()][image.getWidth()];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Color pixel = image.getPixels()[i][j];
        int x = image.getHeight() - i - 1;
        newPixels[x][j] = pixel;
      }
    }
    return new ImageImpl(newPixels);
  }
}
