package model.transformations;

import java.awt.Point;
import model.Image;
import model.RGBPixel;

public class VerticalFlip extends Flip {

  private Image image;

  /**
   * Constructs a new horizontal flip transformation with the given image.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public VerticalFlip(Image image) throws IllegalArgumentException {
    super(image);
    this.image = image;
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
