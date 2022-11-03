package model.transformations;

import java.awt.Color;
import model.Image;
import model.ImageImpl;
import model.ImageTransformation;

/**
 * An implementation of the {@link ImageTransformation} interface representing a macro used to
 * transform images to visualize one color component – red, green, blue, luma, value, or intensity.
 */
public class Visualize implements ImageTransformation {

  private final Channel channel;

  /**
   * Constructs a new Visualize transformation macro object with the given channel to visualize.
   *
   * @param channel the channel to visualize in the transformed image
   */
  public Visualize(Channel channel) {
    this.channel = channel;
  }

  @Override
  public Image transform(Image image) {
    Color[][] newPixels = new Color[image.getHeight()][image.getWidth()];
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Color pixel = image.getPixels()[i][j];
        Integer newValue = null;
        switch (this.channel) {
          case Red:
            newValue = pixel.getRed();
            break;
          case Green:
            newValue = pixel.getGreen();
            break;
          case Blue:
            newValue = pixel.getBlue();
            break;
          case Luma:
            newValue = (int) (0.2126 * pixel.getRed() + 0.7152 * pixel.getGreen()
                + 0.0722 * pixel.getBlue());
            break;
          case Value:
            newValue = Math.max(pixel.getRed(), Math.max(pixel.getBlue(), pixel.getGreen()));
            break;
          case Intensity:
            newValue = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
            break;
          default:
            throw new IllegalArgumentException("Invalid color channel.");
        }
        Color newPixel = new Color(newValue, newValue, newValue);
        newPixels[i][j] = newPixel;
      }
    }
    return new ImageImpl(newPixels);
  }

  /**
   * Represents a channel that can be visualized in the image with this transformation macro.
   */
  public enum Channel {
    Red, Green, Blue, Luma, Value, Intensity
  }
}