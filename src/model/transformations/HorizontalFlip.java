package model.transformations;

import java.awt.Point;
import model.Image;
import model.RGBPixel;

public class HorizontalFlip extends Flip {

  private Image image;

  /**
   * Constructs a new horizontal flip transformation with the given image.
   *
   * @param image the image to apply the transformation to
   * @throws IllegalArgumentException if the image is null
   */
  public HorizontalFlip(Image image) throws IllegalArgumentException {
    super(image);
    this.image = image;
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
