package view;

import java.io.IOException;

/**
 * Implements the {@link ImageProcessorView} interface and handles the appending of messages sent to
 * the user by the controller.
 */
public class ImageProcessorViewImpl implements ImageProcessorView {

  private Appendable appendable;

  /**
   * Constructs a new ImageProcessorViewImpl object with the given appendable.
   *
   * @param appendable the appendable to append the text to
   */
  public ImageProcessorViewImpl(Appendable appendable) {
    this.appendable = appendable;
  }

  @Override
  public void renderMessage(String message) throws IllegalStateException {
    try {
      this.appendable.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("Unable to render message");
    }
  }

  @Override
  public void renderMenu() throws IllegalStateException {
    this.renderMessage("quit - quits the program" + System.lineSeparator());
    this.renderMessage(
        "load <path> <filename> - loads an image (identified by given name) into the processor"
            + System.lineSeparator());
    this.renderMessage(
        "save <path> <filename> - saves an image to an output file" + System.lineSeparator());
    this.renderMessage("menu - displays the menu of commands" + System.lineSeparator());
    this.renderMessage(
        "visualize-<component> <filename> <new filename> - transforms an image to a new image"
            + " greyscaled using a chosen component" + System.lineSeparator());
    this.renderMessage("brighten <amount> <filename> <new filename> - transforms an image to a "
        + "new image brightened by an amount" + System.lineSeparator());
    this.renderMessage("darken <amount> <filename> <new filename> - transforms an image to a "
        + "new image darkened by an amount" + System.lineSeparator());
    this.renderMessage("horizontal-flip <filename> <new filename> - horizontally flips an image"
        + " to a new image" + System.lineSeparator());
    this.renderMessage(
        "vertical-flip <filename> <new filename> - vertically flips an image" + " to a new image"
            + System.lineSeparator());
  }

}
