package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the {@link ImageState} interface.
 */
public class ImageStateImpl {

  private final List<Pixel> pixels;
  private final String logMessage;

  public ImageStateImpl(List<Pixel> pixels, String changes) {
    if (pixels == null || pixels.isEmpty()) {
      throw new IllegalArgumentException("Pixels cannot be null");
    }
    if (changes == null || changes.length() == 0) {
      throw new IllegalArgumentException("Changes cannot be null");
    }
    this.pixels = pixels;
    this.logMessage = changes;
  }

  /**
   * Returns the pixels of this image state.
   * @return
   */
  public List<Pixel> getPixels() {
    return new ArrayList<>(this.pixels);
  }

  /**
   * Returns the log message of this image state.
   * @return
   */
  public String getLogMessage() {
    return this.logMessage;
  }


  /**
   * Gets the width of the Image.
   *
   * @return an integer representing the width.
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets the height of the Image.
   *
   * @return an integer representing the height.
   */
  @Override
  public int getHeight() {
    return this.height;
  }
}
