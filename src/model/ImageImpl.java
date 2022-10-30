package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Implements the {@link Image} interface.
 */
public class ImageImpl implements Image {

  private final Stack<ImageState> revisions;

  /**
   * Constructs a new image with the given list of pixels.
   *
   * @param pixels the pixels of the image
   */
  public ImageImpl(List<Pixel> pixels) {
    // TODO: We might need to check if there is a pixel in every slot when constructing the image
    if (pixels == null || pixels.isEmpty()) {
      throw new IllegalArgumentException("Pixels cannot be null");
    }
    this.revisions = new Stack<>();
    this.revisions.push(new ImageStateImpl(pixels, "Initial image"));
  }

  @Override
  public ArrayList<Pixel> getPixels() {
    return new ArrayList<Pixel>(this.state().getPixels());
  }

  @Override
  public void visualize(ColorChannel channel) {
    List<Pixel> current = this.state().getPixels();
    List<Pixel> pixels = new ArrayList<Pixel>();

    for (Pixel p : current) {
      Color color = p.getColor();
      int red = color.getRed();
      int blue = color.getGreen();
      int green = color.getBlue();
      switch (channel) {
        case RED:
          blue = red;
          green = red;
          break;
        case GREEN:
          red = green;
          blue = green;
          break;
        case BLUE:
          red = blue;
          green = blue;
          break;
        case VALUE:
          int max = Math.max(red, Math.max(green, blue));
          red = max;
          green = max;
          blue = max;
          break;
        case INTENSITY:
          int avg = (red + green + blue) / 3;
          red = avg;
          green = avg;
          blue = avg;
          break;
        case LUMA:
          int lum = (int) (0.212 * red + 0.7152 * green + 0.0722 * blue);
          red = lum;
          green = lum;
          blue = lum;
          break;
        default:
          throw new IllegalArgumentException("Invalid ColorChannel");
      }
      pixels.add(new Pixel(p.getPosition(), new Color(red, green, blue)));
    }
    this.addRevision(pixels, "Visualize " + channel.toString().toLowerCase());
  }

  @Override
  public void shade(int val) {
    // TODO: Implement shade method
  }

  @Override
  public void flip(FlipType type) {
    // TODO: Implement flip method
    if (type == FlipType.HORIZONTAL) {

    }
  }

  /**
   * Returns the most recent state of the image.
   *
   * @return the current state of the image
   */
  private ImageState state() {
    return this.revisions.peek();
  }

  /**
   * Adds a new {@link ImageState} to the stack of revisions.
   *
   * @param pixels     the pixels of the new state
   * @param logMessage the log message of the changes
   */
  private void addRevision(List<Pixel> pixels, String logMessage) {
    this.revisions.push(new ImageStateImpl(pixels, logMessage));
  }

}
