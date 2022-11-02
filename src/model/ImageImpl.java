package model;

import java.awt.Color;
import java.util.Stack;


/**
 * Implements the {@link Image} interface.
 */
public class ImageImpl implements Image {

  private final Stack<ImageState> revisions;

  /**
   * Constructs a new image with the given pixels.
   *
   * @param pixels the pixels of the image as a 2D array {@code Pixel[width][height]}
   * @throws IllegalArgumentException if there is not at least one pixel in the given array
   */
  public ImageImpl(RGBPixel[][] pixels) throws IllegalArgumentException {
    if (pixels == null || pixels.length == 0 || pixels[0].length == 0) {
      throw new IllegalArgumentException("Image must start with at least one pixel");
    }
    this.revisions = new Stack<>();
    this.update(pixels, "Initial image");
  }

  @Override
  public int getWidth() {
    return this.getCurrentState().getWidth();
  }

  @Override
  public int getHeight() {
    return this.getCurrentState().getHeight();
  }

  @Override
  public RGBPixel[][] getPixels() {
    return this.getCurrentState().getPixels();
  }


  @Override
  public void update(RGBPixel[][] pixels, String logMessage) throws IllegalArgumentException {
    if (pixels == null || pixels.length == 0 || pixels[0].length == 0) {
      throw new IllegalArgumentException("Image must have at least one pixel");
    }
    ImageState newState = new ImageState(pixels, logMessage);
    this.revisions.push(newState);
  }

  @Override
  public void transform(ImageTransformation transformation) throws IllegalArgumentException {
    if (transformation == null) {
      throw new IllegalArgumentException("Transformation cannot be null");
    }
    transformation.apply(this);
  }

  /**
   * Gets the {@link ImageState} of this image's current state.
   *
   * @return the current state of the image
   */
  private ImageState getCurrentState() {
    return this.revisions.peek();
  }

  /**
   * Represents a state of this image.
   *
   * <p>Each state of the image is represented by a 2D array of {@link Color}s. By storing pixels
   * as {@code ImageState}s rather than a stack of pixels, this ensures that changes made to an
   * image are never permanently overridden when transformations are made. Though not instructed to
   * support undoing/redoing transformations in this assignment, this allows for implementing this
   * in the future.</p>
   */
  private class ImageState {

    private final int width;
    private final int height;
    private final RGBPixel[][] pixels;
    private final String logMessage;

    /**
     * Constructs a new {@link ImageState} with the given pixels and log message.
     *
     * @param pixels     the pixels of this image state as a 2D array {@code Pixel[width][height]}
     * @param logMessage a log message that represents the transformation applied when this state
     *                   was created
     * @throws IllegalArgumentException if there is not at least one pixel in the given array, or if
     *                                  the log message is null or empty
     */
    public ImageState(RGBPixel[][] pixels, String logMessage) throws IllegalArgumentException {
      if (pixels == null || pixels.length == 0 || pixels[0].length == 0) {
        throw new IllegalArgumentException("The pixels array must contain at least one pixel");
      }
      if (logMessage == null || logMessage.length() == 0) {
        throw new IllegalArgumentException("The log message cannot be null or empty");
      }
      this.width = pixels.length;
      this.height = pixels[0].length;
      this.pixels = pixels;
      this.logMessage = logMessage;
    }

    /**
     * Gets the width of this image state.
     *
     * @return the width of the image state as an integer
     */
    public int getWidth() {
      return this.width;
    }

    /**
     * Gets the height of this image state.
     *
     * @return the height of the image state as an integer
     */
    public int getHeight() {
      return this.height;
    }

    /**
     * Gets a copy of this image state's pixels.
     *
     * @return the pixels of the image state as a 2D array of {@link Color}s in the format
     * {@code Color[width][height]}
     */
    public RGBPixel[][] getPixels() {
      RGBPixel[][] ret = this.pixels.clone();
      return ret;
    }

    /**
     * Gets the log message of changes made to create this image state.
     *
     * @return the log message as a string
     */
    public String getLogMessage() {
      return this.logMessage;
    }
  }

}
